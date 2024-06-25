package org.example;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

/**
 * Calculator class for performing basic arithmetic operations and maintaining a history of calculations.
 */
public class Calculator {
    @Getter
    @Setter
    private double result;
    @Getter
    @Setter
    private double numberActual;
    @Getter
    @Setter
    private String operation;
    @Getter
    @Setter
    private List<HistoryEntry> history = new ArrayList<>();

    /**
     * Performs the calculation based on the current operation and numberActual.
     *
     * @return the result of the calculation
     * @throws ArithmeticException if division by zero is attempted
     */
    public double calculate() {
        switch (operation) {
            case "add":
                result += numberActual;
                break;
            case "subtract":
                result -= numberActual;
                break;
            case "multiply":
                result *= numberActual;
                break;
            case "divide":
                if (numberActual != 0) {
                    result /= numberActual;
                } else {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                break;
        }
        return result;
    }

    /**
     * Adds a new entry to the history list.
     *
     * @param result the result of the calculation to be added to the history
     */
    public void addHistoryEntry(double result) {
        history.add(new HistoryEntry(operation, numberActual, result));
    }

    /**
     * Inner class representing a history entry of a calculation.
     */
    public static class HistoryEntry {
        @Getter
        @Setter
        private String operation;
        @Getter
        @Setter
        private double number;
        @Getter
        @Setter
        private double result;

        /**
         * Constructs a new HistoryEntry.
         *
         * @param operation the arithmetic operation performed
         * @param number the operand used in the calculation
         * @param result the result of the calculation
         */
        public HistoryEntry(String operation, double number, double result) {
            this.operation = operation;
            this.number = number;
            this.result = result;
        }
    }
}
