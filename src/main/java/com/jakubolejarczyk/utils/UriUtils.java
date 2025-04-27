package com.jakubolejarczyk.utils;

import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class UriUtils {
    public URI create(@NonNull String api) {
        return URI.create("https://jsonplaceholder.typicode.com/" + api);
    }
}
