# products-api

This project is a simple REST JSON API made in Java 8 using Spring Boot, PostgreSQL, JPA and Flyway. It's a CRUD API of Products. It allows you to create Products, mark them with tags and sets their prices in different currencies.

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

