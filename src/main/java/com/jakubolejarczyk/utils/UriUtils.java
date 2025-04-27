package com.jakubolejarczyk.utils;

import java.net.URI;

public class UriUtils {
    public URI create(String api) {
        return URI.create("https://jsonplaceholder.typicode.com/" + api);
    }
}
