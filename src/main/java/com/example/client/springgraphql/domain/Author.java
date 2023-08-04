package com.example.client.springgraphql.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    private String id;

    private String firstName;

    private String lastName;
}
