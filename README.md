
# Criando RESTful API com Java, Spring e PostgreSQL

Uma breve descrição sobre o que esse projeto faz e para quem ele é


## Deploy

Para fazer o deploy desse projeto rode

```bash
. Copie https://github.com/rodrigoMedeiros0/firstCRUD-spring.git
. Abra o git e no seu pc e de git clone com no link acima 
. Abra a pasta do arquivo com sua IDE de preferencia e de start na apliacação
```


## Aprendizados

O que você aprendeu construindo esse projeto? Quais desafios você enfrentou e como você superou-os?

Foi minha primeira experiência com Java, Spring e Postgre, mesmo tendo passado por vários erros e me falta ainda aprender sobre padrões de projeto, consegui realizar meu objetivo final que era aprender e praticar fazendo um projeto proprio criando uma RestFul APi. 

## API

- POST 
![App Screenshot](https://github.com/rodrigoMedeiros0/firstCRUD-spring/assets/97979883/22d993fe-de0f-4db5-be89-c5fb91041240)

- Get all 
![App Screenshot](https://github.com/rodrigoMedeiros0/firstCRUD-spring/assets/97979883/5cb99242-99cc-46b3-8982-951a440ede8a)

- Get one
![App Screenshot](https://github.com/rodrigoMedeiros0/firstCRUD-spring/assets/97979883/2ae9dadd-8281-4c4c-9135-014ceefcff95)

- Update
![App Screenshot](https://github.com/rodrigoMedeiros0/firstCRUD-spring/assets/97979883/bb901687-7ffe-42ad-892b-ed5d3de5c1bf)

- Delete
![App Screenshot](https://github.com/rodrigoMedeiros0/firstCRUD-spring/assets/97979883/e1797622-a1fe-4fc0-a564-ed6756b3e6bf)
## Documentação da API

#### Criação do produto no banco de dados

```http
  POST http://localhost:8080/products
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `name` | `String` | **Obrigatório**. Nome do produto |
| `value` | `BigDecimal` | **Obrigatório**. Valor do produto |

#### Retorna um item

#### Retorna todos os produtos salvos no banco de dados

```http
  GET http://localhost:8080/products
```

#### Retorna um produto de acordo com o id fornecido 

```http
  GET http://localhost:8080/products/3/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do produto que você quer |


#### Atualiza o produto de acordo com o id 

```http
  PUT http://localhost:8080/products/3
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `name` | `String` | **Obrigatório**. Nome do produto |
| `value` | `BigDecimal` | **Obrigatório**. Valor do produto |

#### Delete o produto de acordo com o id 

```http
  DELETE http://localhost:8080/products/3
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do produto que você quer |

