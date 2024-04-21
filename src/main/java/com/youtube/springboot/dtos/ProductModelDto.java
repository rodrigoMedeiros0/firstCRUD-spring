package com.youtube.springboot.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductModelDto(@NotNull Long id, @NotBlank String name, @NotNull BigDecimal value) {
}
