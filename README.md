# products-api

This project is a sample REST JSON API made in Java 8 using Spring Boot, PostgreSQL, JPA and Flyway. It's a CRUD API of Products. It allows you to create Products, mark them with tags and sets their prices in different currencies.

## Getting Started

Let's make the project up and running.

### Configurations

To run the API we have some prerequisites:

```
Java 8
Maven
PostgreSQL Database Environment
```

Once you have all installed you must create a database at PostgreSQL and configure it at the application. Let's say we've created a database called 'store' in a local PostgreSQL server. Now edit the file /srs/main/resources/application.properties with the following information:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/store
spring.datasource.username=pg_username
spring.datasource.password=pg_password
spring.datasource.driver-class-name=org.postgresql.Driver
```

### Run

After configuring the database, to get the API running just type:

```
mvn spring-boot:run
```

### Running the tests

To build the application and run it's unit tests type:

```
mvn clean install -U
```

## Usage

This section explains how to use the API describing the available calls and giving some examples of how to use them.

This API has 3 main entities called **Product**, **Tag** and **Currency**. For all of them you can make CRUD operations using the following calls:

### Create an entity
```
http://localhost:8080/{entity}  HTTP Method: POST

The entity's JSON must be at the body.
```

### Create a batch of entities
```
http://localhost:8080/{entity}/batchCreate  HTTP Method: POST

The JSON with an Array of entities must be at the body.
```


### Update an entity
```
http://localhost:8080/{entity}  HTTP Method: PUT

The entity's JSON, including it's id, with the changed data must be at the body
```

### Delete an entity
```
http://localhost:8080/{entity}/{id}  HTTP Method: DELETE
```

### Query all entities
```
http://localhost:8080/{entity}/findAll  HTTP Method: GET
```

## Test case

Let's see an example of how the API works. We will create some Currencies, Tags and Products.

### Creating currencies

```
localhost:8080/currency/batchCreate  HTTP Method: POST

Body:

[
  {
    "name": "dollar",
    "symbol": "USD"
  },
  {
    "name": "euro",
    "symbol": "EUR"
  },
  {
    "name": "british pound",
    "symbol": "GBP"
  }
]
```

Try to make this request using cURL:

```
echo '[{"name":"dollar","symbol":"USD"},{"name":"euro","symbol":"EUR"},{"name":"british pound","symbol":"GBP"}]' | curl -d @- http://localhost:8080/currency/batchCreate --header "Content-Type:application/json"
```

### Creating tags

```
localhost:8080/tag/batchCreate  HTTP Method: POST

Body:

[
  {
    "name": "bmw"
  },
  {
    "name": "fiat"
  },
  {
    "name": "ford"
  },
  {
    "name": "subcompact"
  },
  {
    "name": "two-door"
  }
]
```

Try to make this request using cURL:

```
echo '[{"name":"bmw"},{"name":"fiat"},{"name":"ford"},{"name":"subcompact"},{"name":"two-door"}]' | curl -d @- http://localhost:8080/tag/batchCreate --header "Content-Type:application/json"
```

### Creating products

Let's create two products and set their prices in two currencies. Also we will tag these products with some tags. To identify the **Tag** we can specify it's id or it's name and to identify the **Currency** we can specify it's id or it's symbol. For simplicity we will use name and symbol to identify them respectively.

```
localhost:8080/product  HTTP Method: POST

Request Body:
{
  "name": "Fiesta",
  "description": "The Ford Fiesta is a subcompact car manufactured by Ford since 1976, lasting seven generations.",
  "tags": [
    {
      "name": "ford"
    },
    {
      "name": "subcompact"
    }
  ],
  "pricePoints": [
    {
      "currency": {
        "symbol": "USD"
      },
      "productValue": 14000
    },
    {
      "currency": {
        "symbol": "EUR"
      },
      "productValue": 12500
    }
  ]
}
```


```
localhost:8080/product  HTTP Method: POST

Request Body:
{
  "name": "FIAT 500",
  "description": "The Fiat 500 is a two-door four-passenger car.",
  "tags": [
    {
      "name": "fiat"
    },
    {
      "name": "two-door"
    }
  ],
  "pricePoints": [
    {
      "currency": {
        "symbol": "USD"
      },
      "productValue": 16000
    },
    {
      "currency": {
        "symbol": "EUR"
      },
      "productValue": 14300
    }
  ]
}
```

Try to make these requests using cURL:
```
echo '{"name":"Fiesta","description":"The Ford Fiesta is a subcompact car manufactured by Ford since 1976, lasting seven generations.","tags":[{"name":"ford"},{"name":"subcompact"}],"pricePoints":[{"currency":{"symbol":"USD"},"productValue":14000},{"currency":{"symbol":"EUR"},"productValue":12500}]}' | curl -d @- http://localhost:8080/product --header "Content-Type:application/json"
```

```
echo '{"name":"FIAT 500","description":"The Fiat 500 is a two-door four-passenger car.","tags":[{"name":"fiat"},{"name":"two-door"}],"pricePoints":[{"currency":{"symbol":"USD"},"productValue":16000},{"currency":{"symbol":"EUR"},"productValue":14300}]}' | curl -d @- http://localhost:8080/product --header "Content-Type:application/json"
```

## Querying all the products

```
curl http://localhost:8080/product/findAll
```

## Querying an specific product by name

```
curl http://localhost:8080/product/findByName?name=Fiesta
```

## Updating a product

Let's update the description of the product named Fiesta. Note that for update operation we need to identify all the entities with their ids, so you would need to make a find before.

```
http://localhost:8080/product  HTTP Method: PUT

Request Body:
{
  "id": 71,
  "name": "Fiesta",
  "description": "Changed Description.",
  "tags": [
    {
      "id": 68,
      "name": "ford"
    },
    {
      "id": 69,
      "name": "subcompact"
    }
  ],
  "pricePoints": [
    {
      "id": 72,
      "currency": {
        "id": 63,
        "name": "dollar",
        "symbol": "USD"
      },
      "productValue": 14000
    },
    {
      "id": 73,
      "currency": {
        "id": 64,
        "name": "euro",
        "symbol": "EUR"
      },
      "productValue": 12500
    }
  ]
}
```

Try to make this request using cURL:

```
echo '{"id":71,"name":"Fiesta","description":"Changed Description.","tags":[{"id":68,"name":"ford"},{"id":69,"name":"subcompact"}],"pricePoints":[{"id":72,"currency":{"id":63,"name":"dollar","symbol":"USD"},"productValue":14000},{"id":73,"currency":{"id":64,"name":"euro","symbol":"EUR"},"productValue":12500}]}' | curl -X PUT -d @- http://localhost:8080/product --header "Content-Type:application/json"
```
 
