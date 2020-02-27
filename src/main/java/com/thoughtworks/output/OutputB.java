package com.thoughtworks.output;

public class OutputB implements OutputCheck {
    private String input;
    private String output;

    public OutputB() {
    }

    public OutputB(String input, String output) {
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
        return "4 numbers position wrong";
    }
}
