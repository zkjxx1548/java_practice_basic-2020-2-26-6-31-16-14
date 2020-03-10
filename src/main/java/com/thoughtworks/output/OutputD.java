package com.thoughtworks.output;

public class OutputD implements OutputCheck {
    private String input;
    private String output;

    public OutputD() {
    }

    public OutputD(String input, String output) {
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
        int numberB = Integer.parseInt(String.valueOf(this.output.charAt(2)));
        return String.format("%d and %d wrong position", numberB, (4 - numberA));
    }
}
