package com.example.client.springgraphql.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookInfo {

    private String id;

    private Integer pageCount;

    private Author author;
}
