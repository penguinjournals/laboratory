# laboratory

## Book 1, The setup

### Chapter 1, "Hello world" Rest API in SpringBoot

[Following this guide](https://spring.io/guides/gs/rest-service/)

Will be using Java 8.

Generate jar file:

```
mvn clean package
```

**Output:** runnable .jar file.

### Chapter 2, Vue.js as standalone frontend

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

### Chapter 3, Rest API call from Vue.js

Get greeting from HTTP API and display it on frontend.

The API will be queried using axios and front rendered by Vue.

**Output:** frontend loading the content of the greeting from server

### Chapter 4, Vue.js dist integrated into springboot .jar file to serve as static

Integrate Vue development (frontend) with backend development with the aim of distributing an standalone .jar file which includes both frontend and backend inside it.

As a result:

- Node and npm binaries are setup at a level project avoiding problems between setups on development teams.
- During development stage frontend code is run with `npm run serve` on localhost:8181 and proxy-passes all traffic pointing to /api to port localhost:8080 (Springboot backend).
- On build and packaging stage, frontend is built first, then backend copies all code from frontends build output to the resources folder and packages.

**Output:** output jar file serves both backend and frontend

### Chapter 5, Database migrations with Flyway

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

### Chapter 6, Database to object mapping using jOOQ

- Setup [jOOQ](https://www.jooq.org/) as object-database mapping tool.
- API call that returns all predictions from database.
- Front renders all predictions.

Tip:

Sample prediction to insert to database:

```
INSERT INTO prediction (title, body, deadline) VALUES ('Hello world', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec rutrum pellentesque tortor, vitae porta turpis rutrum non. Sed elit mi, aliquam vitae ullamcorper ac, rutrum sed lacus. In finibus lectus bibendum, efficitur nisi sit amet, eleifend dui. Lorem ipsum dolor sit amet, consectetur adipiscing elit.', '2020-12-31');
```

**Output:** on build database tables related objects are generated. Use of those objects is out of scope.

### Chapter 7, Security with Springboot (Spring Security) and JWT

Enable security using [JWT](https://jwt.io/)

Following [this guide](https://bezkoder.com/spring-boot-security-postgresql-jwt-authentication/)

**Output:** `/profile` will be displayed only if user is logged in (login and then using token).

### Chapter 8, Security integration in frontend, Springboot security, JWT and Vue (Vuex)

Make Vue display a `/user` page with dummy content but which can be only seen if the user is logged in.

Post a prediction and register it asociated with the user.

Following [this guide](https://bezkoder.com/spring-boot-vue-js-authentication-jwt-spring-security/)

Also [this guide](https://bezkoder.com/jwt-vue-vuex-authentication/)

Included migration to Vuex4 + Vue Router 4.

**Output:** `/user` displays dummy content if the user is logged in, if not redirects to `/login`

### [TODO] Chapter 9, Server setup using Ansible for standalone .jar file

### [TODO] Chapter 10, Server setup using Ansible for static + API approach

### [TODO] Chapter 11, Serverless deployment on Google App Engine

To be done in the future.

## [TODO] Book 2, Adding value

### [TODO] Chapter 1, Prediction CRUD

### [TODO] List all predictions

## [TODO] Book 3, Performance tales

### [TODO] Chapter 1, Serve static content outside the .jar

### [TODO] Chapter 2, Multiple frontends

### [TODO] Chapter 3, SQL performance basics

### [TODO] Chapter 4, Cache

### [TODO] Chapter 5, Static content performance minify, cache, CDN

### [TODO] Chapter 6, Read database - Write database

