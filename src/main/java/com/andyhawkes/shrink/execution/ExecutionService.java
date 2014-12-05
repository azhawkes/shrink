package com.andyhawkes.shrink.execution;

import com.andyhawkes.straightjacket.Straightjacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.Invocable;
import javax.script.ScriptEngine;

/**
 * Simple service that executes a script.
 */
public class ExecutionService {
    private static final Logger log = LoggerFactory.getLogger(ExecutionService.class);

    public ExecutionResponse execute(ExecutionRequest request) {
        long startTime = System.currentTimeMillis();
        ExecutionResponse response = new ExecutionResponse();
        Straightjacket straightjacket = new Straightjacket();
        ScriptEngine engine = straightjacket.createJavaScriptEngine();

        if (request.getExposedJavaClasses() != null) {
            for (int i = 0; i < request.getExposedJavaClasses().length; i++) {
                straightjacket.exposeJavaClass(request.getExposedJavaClasses()[i]);
            }
        }

        try {
            engine.eval(request.getScript());

            response.setResult(((Invocable) engine).invokeFunction(request.getFunction(), request.getArguments()));
            response.setExecutionTime(System.currentTimeMillis() - startTime);
            response.setStatus("success");
        } catch (Exception e) {
            log.error("script execution failed!", e);

            response.setStatus("error");
            response.setMessage(e.getMessage());
        }

        return response;
    }
}
