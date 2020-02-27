package com.thoughtworks.output;

public class OutputF implements OutputCheck {
    private String input;
    private String output;

    public OutputF() {
    }

    public OutputF(String input, String output) {
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
        int numberA = Integer.parseInt(this.output.charAt(0) + "");
        int numberB = Integer.parseInt(this.output.charAt(2) + "");
        //return String.format("%d correct, %d and %d wrong position", 555, numberB, (4 - numberA));
        return "wwwww";
    }
}
