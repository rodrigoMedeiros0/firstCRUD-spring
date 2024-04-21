package com.youtube.springboot.controllers;

import com.youtube.springboot.dtos.ProductModelDto;
import com.youtube.springboot.dtos.ProductRecordDto;
import com.youtube.springboot.models.ProductModel;
import com.youtube.springboot.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/products")
    public ResponseEntity<ProductModelDto> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        var productSaved =  productRepository.save(productModel);
        var returnDto = new ProductModelDto(productSaved.getId(), productSaved.getName(), productSaved.getValue());
        return ResponseEntity.status(HttpStatus.CREATED).body(returnDto);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductModelDto>> getAllProducts() {
        var products = productRepository.findAll();
        var returnDtos = products.stream().map(
                product -> new ProductModelDto(product.getId(), product.getName(), product.getValue())
        ).toList();
        return ResponseEntity.status(HttpStatus.OK).body(returnDtos);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductModelDto> getOneProduct(@PathVariable(value="id") Long id) throws Exception {
        Optional<ProductModel> product0 = productRepository.findById(id);
        if (!product0.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        var returnDto = new ProductModelDto(product0.get().getId(), product0.get().getName(), product0.get().getValue());
        return ResponseEntity.status(HttpStatus.OK).body(returnDto);

    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductModelDto> updateProduct(@PathVariable(value="id") Long id,
                                                @RequestBody @Valid ProductRecordDto productRecordDto) {
        Optional<ProductModel> product0 = productRepository.findById(id);
        if (!product0.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        var productModel = product0.get();
        BeanUtils.copyProperties(productRecordDto, productModel);
        var productSaved =  productRepository.save(productModel);
        var returnDto = new ProductModelDto(productSaved.getId(), productSaved.getName(), productSaved.getValue());
        return ResponseEntity.status(HttpStatus.OK).body(returnDto);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<ProductModelDto> deleteProduct(@PathVariable(value="id") Long id) {
        Optional<ProductModel> product0 = productRepository.findById(id);
        if (!product0.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        var returnDto = new ProductModelDto(product0.get().getId(), product0.get().getName(), product0.get().getValue());
        productRepository.delete(product0.get());
        return ResponseEntity.status(HttpStatus.OK).body(returnDto);
    }

}
