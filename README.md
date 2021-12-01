# Kotlin Spring Boot Starter App

Inspired by [this repository](https://github.com/Noozen/Spring-Boot-Project) for it's Java equivalent, my attempt to document my way through the [Spring Boot Tutorial](https://spring.io/guides/tutorials/spring-boot-kotlin/).

I ended up not getting very far, and this turned into my own boilerplate Spring PoC with some common plugins.

It comes with a couple extra goodies because of my use case. Also requires an instance of Postgres:

```
$ docker run -p 5432:5432 --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres
``` 

(or however else you want to provision a DB. Doesn't matter)

**Additional Plugins:**

0. Spring Web - Serving REST requests
0. PostgreSQL Driver - DB Driver
0. Flyway Migration - DB migration management
0. Testcontainers - Testing
0. Spring Boot DevTools - QoL improvements
