package com.jakubolejarczyk.infrastructure;

import com.jakubolejarczyk.utils.UriUtils;
import lombok.AllArgsConstructor;
import lombok.val;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@AllArgsConstructor
public class FetchApiService {
    private final UriUtils uriUtils;

    public String fetch(String api) {
        try(HttpClient client = HttpClient.newHttpClient()) {
            val request = createRequest(api);
            val response = createResponse(client, request);
            return getResponse(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private HttpRequest createRequest(String api) {
        return HttpRequest.newBuilder()
            .uri(uriUtils.create(api))
            .build();
    }

    private HttpResponse<String> createResponse(HttpClient client, HttpRequest request) {
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getResponse(HttpResponse<String> response) {
        if (response.statusCode() == 200) {
            return response.body();
        }
        throw new Error("Failed to read posts: " + response.statusCode());
    }
}
