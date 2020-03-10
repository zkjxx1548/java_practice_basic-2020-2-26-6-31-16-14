package com.thoughtworks.output;

public class OutputE implements OutputCheck {
    private String input;
    private String output;

    public OutputE() {
    }

    public OutputE(String input, String output) {
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
        int numberA = Integer.parseInt(String.valueOf(this.output.charAt(0)));
        return String.format("%d correct", numberA);
    }
}
