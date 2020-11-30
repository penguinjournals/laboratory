# laboratory

## Chapter 1

"Hello world" Rest API in SpringBoot

[Following this guide](https://spring.io/guides/gs/rest-service/)

Will be using Java 8.

Generate jar file:

```
mvn clean package
```

**Output:** runnable .jar file.

## Chapter 2

Vue.js front managed using webpack which consumes the greeting API defined on Chapter-1.

[Install node and npm](https://nodejs.org/en/download/package-manager/)

[Install vue-cli](https://cli.vuejs.org/guide/installation.html)

[Use Sass](https://cli.vuejs.org/guide/css.html#pre-processors)

Run server during development (available on localhost:8181):

```
npm run serve
```

Generate frontend files:

```
cd frontend
npm run build
```

**Output:** frontend ready files on frontend/dist

## Chapter 3

Get greeting from HTTP API and display it on frontend.

The API will be queried using axios and front rendered by Vue.

**Output:** frontend loading the content of the greeting from server

## Chapter 4

Integrate Vue development (frontend) with backend development with the aim of distributing an standalone .jar file which includes both frontend and backend inside it.

As a result:

- Node and npm binaries are setup at a level project avoiding problems between setups on development teams.
- During development stage frontend code is run with `npm run serve` on localhost:8181 and proxy-passes all traffic pointing to /api to port localhost:8080 (Springboot backend).
- On build and packaging stage, frontend is built first, then backend copies all code from frontends build output to the resources folder and packages.

**Output:** output jar file serves both backend and frontend

## Chapter 5

Setup a PostgreSQL database for persistence and manage schema migrations with Flyway.

- [Flyway doc about including the dependency](https://flywaydb.org/documentation/usage/plugins/springboot)
- [Springboot doc about setup](https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto-execute-flyway-database-migrations-on-startup)

Important note, remember to add to your pom.xml jpa dependecy:
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

**Output:** docker file with the database definition and first migration for a table run on project build. 

## Chapter 6

- Setup [jOOQ](https://www.jooq.org/) as object-database mapping tool.
- API call that returns all predictions from database.
- Front renders all predictions.

Tip:

Sample prediction to insert to database:

```
INSERT INTO prediction (title, body, deadline) VALUES ('Hello world', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec rutrum pellentesque tortor, vitae porta turpis rutrum non. Sed elit mi, aliquam vitae ullamcorper ac, rutrum sed lacus. In finibus lectus bibendum, efficitur nisi sit amet, eleifend dui. Lorem ipsum dolor sit amet, consectetur adipiscing elit.', '2020-12-31');
```

**Output:** on build database tables related objects are generated. Use of those objects is out of scope.


