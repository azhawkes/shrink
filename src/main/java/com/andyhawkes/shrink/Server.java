package com.andyhawkes.shrink;

import com.andyhawkes.shrink.execution.ExecutionRequest;
import com.andyhawkes.shrink.execution.ExecutionResponse;
import com.andyhawkes.shrink.execution.ExecutionService;
import com.google.gson.Gson;

import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

/**
 * Really simple web server powered by Spark. Exposes an /execute endpoint that you can post
 * execution requests to and have them executed on the server.
 *
 * There is no security whatsoever built into this, so use with caution.
 */
public class Server {
    public static void main(String[] args) {
        ExecutionService executionService = new ExecutionService();

        staticFileLocation("/web");

        post("/execute", (req, res) -> {
            Gson gson = new Gson();
            ExecutionRequest request = gson.fromJson(req.body(), ExecutionRequest.class);
            ExecutionResponse response = executionService.execute(request);

            return gson.toJson(response);
        });
    }
}
