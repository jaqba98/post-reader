package com.jakubolejarczyk.utils;

import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class UriUtils {
    public URI create(String api) {
        return URI.create("https://jsonplaceholder.typicode.com/" + api);
    }
}
