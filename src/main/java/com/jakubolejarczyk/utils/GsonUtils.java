package com.jakubolejarczyk.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

@Service
public class GsonUtils<TDomain> {
    public Gson create() {
        return new GsonBuilder().setPrettyPrinting().create();
    }

    public String toJson(Gson gson, TDomain domain) {
        return gson.toJson(domain);
    }
}
