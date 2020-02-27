package com.thoughtworks.output;

public class OutputA implements OutputCheck {
    private String input;
    private String output;

    public OutputA() {
    }

    public OutputA(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    @Override
    public String getInput() {
        return input;
    }

    @Override
    public String getInstruction() {
        return "all wrong";
    }
}
