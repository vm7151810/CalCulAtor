package com.example.calculator;

public class historyView {
    // variables for our coursename,
    // description, tracks and duration, id.
    private String calculation;
    private String result;
    private int id;

    // creating getter and setter methods
    public String getCalculation() {
        return calculation;
    }

    public void setCalculation(String calculation) {
        this.calculation = calculation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    // constructor
    public historyView(String calculation, String result) {
        this.calculation = calculation;
        this.result = result;
    }
}
