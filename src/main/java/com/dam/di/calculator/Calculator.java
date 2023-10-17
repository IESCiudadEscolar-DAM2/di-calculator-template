package com.dam.di.calculator;

public class Calculator {

    public void setOperand(String number) {
        throw new UnsupportedOperationException();
    }

    public void setOperator(Operators operator) {
        throw new UnsupportedOperationException();
    }

    public Float calculate() throws MissingOperandException, DivisionByZeroException {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public enum Operators {
        ADD("+"),
        SUBTRACT("-"),
        MULTIPLY("*"),
        DIVIDE("/");

        private final String _operator;

        Operators(String operator) {
            _operator = operator;
        }

        public static Operators from(String operator) {
            return switch (operator) {
                case "+" -> Operators.ADD;
                case "-" -> Operators.SUBTRACT;
                case "/" -> Operators.DIVIDE;
                case "*" -> Operators.MULTIPLY;
                default -> throw new IllegalArgumentException(String.format("Unknown operator %s", operator));
            };
        }

        @Override
        public String toString() {
            return _operator;
        }
    }

    public static class DivisionByZeroException extends RuntimeException {
    }

    public static class MissingOperandException extends RuntimeException {
    }

}