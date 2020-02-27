package com.thoughtworks.output;

public class OutputG implements OutputCheck{
    private String input;
    private String output;

    public OutputG() {
    }

    public OutputG(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public String getInstruction() {
        return "Wrong input";
    }

    @Override
    public String getInput() {
        return input;
    }

    @Override
    public String getOutput() {
        return output;
    }
}
