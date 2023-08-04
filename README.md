# spring-boot-with-graphql-client

# How to run

1. mvn spring-boot:run

```
Mutation:
   Request: POST http://localhost:8090/book
   {
   "name": "book-3",
   "pageCount": 200,
   "firstName": "author-firstName",
   "lastName": "author-lastName"
   }
   
Query:
   Request: GET http://localhost:8090/book/2

```
