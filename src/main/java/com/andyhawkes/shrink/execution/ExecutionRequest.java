package com.andyhawkes.shrink.execution;

/**
 * An execution request, containing the script to be run and other instructions about what to execute.
 */
public class ExecutionRequest {
    private String script;
    private String function;
    private Object[] arguments;
    private String[] exposedJavaClasses;

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }

    public String[] getExposedJavaClasses() {
        return exposedJavaClasses;
    }

    public void setExposedJavaClasses(String[] exposedJavaClasses) {
        this.exposedJavaClasses = exposedJavaClasses;
    }
}
