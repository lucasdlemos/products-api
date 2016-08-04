# products-api

This project is a simple web service made in Java 8 using Spring Boot, PostgreSQL, JPA and Flyway. It's a CRUD API of Products. It allows you to create Products, mark them with tags and sets their prices in different currencies.

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



