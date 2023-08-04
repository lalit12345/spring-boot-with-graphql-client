package com.example.client.springgraphql.controller;

import com.example.client.springgraphql.domain.Book;
import com.example.client.springgraphql.domain.BookInfo;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/book")
public class BookController {

    private final WebClient webClient = WebClient.create();

    private final HttpGraphQlClient httpGraphQlClient = HttpGraphQlClient.builder(webClient)
            .url("http://localhost:8080/graphql")
            .build();

    @PostMapping
    public String addBook(@RequestBody Book book) {
        String addBookTemplate = """
                mutation {
                  addBook(book: {
                    name: "%s",
                    pageCount: %d
                    author: {
                      firstName: "%s",
                      lastName: "%s"
                    }
                  })
                }
                """;

        String document = String.format(addBookTemplate, book.getName(), 200, book.getFirstName(), book.getLastName());

        return httpGraphQlClient
                .document(document)
                .retrieve("addBook")
                .toEntity(String.class)
                .block();
    }

    @GetMapping("/{id}")
    public BookInfo getBook(@PathVariable String id) {
        String getBookTemplate = """
                query{
                  getBook(id: %s) {
                    id
                    pageCount
                    author {
                      id
                      firstName
                      lastName
                    }
                  }
                }
                """;

        String document = String.format(getBookTemplate, id);

        return httpGraphQlClient
                .document(document)
                .retrieve("getBook")
                .toEntity(BookInfo.class)
                .block();
    }
}
