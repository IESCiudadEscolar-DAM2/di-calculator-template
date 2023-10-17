package com.dam.di.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @Test
    public void missing_operand_throws_exception() {
        Calculator calculator = new Calculator();
        calculator.setOperand("1");
        calculator.setOperator(Calculator.Operators.ADD);
        assertThrows(Calculator.MissingOperandException.class, calculator::calculate);
    }

    @Test
    public void simple_addition() {
        Calculator calculator = new Calculator();
        calculator.setOperand("1");
        calculator.setOperator(Calculator.Operators.ADD);
        calculator.setOperand("1");
        assertEquals(2, calculator.calculate());
    }

    @Test
    public void simple_subtraction() {
        Calculator calculator = new Calculator();
        calculator.setOperand("8");
        calculator.setOperator(Calculator.Operators.SUBTRACT);
        calculator.setOperand("3");
        assertEquals(5, calculator.calculate());
    }

    @Test
    public void simple_multiplication() {
        Calculator calculator = new Calculator();
        calculator.setOperand("2");
        calculator.setOperator(Calculator.Operators.MULTIPLY);
        calculator.setOperand("2");
        assertEquals(4, calculator.calculate());
    }

    @Test
    public void simple_division() {
        Calculator calculator = new Calculator();
        calculator.setOperand("8");
        calculator.setOperator(Calculator.Operators.DIVIDE);
        calculator.setOperand("2");
        assertEquals(4, calculator.calculate());
    }

    @Test
    public void decimal_division() {
        Calculator calculator = new Calculator();
        calculator.setOperand("9");
        calculator.setOperator(Calculator.Operators.DIVIDE);
        calculator.setOperand("2");
        assertEquals(4.5f, calculator.calculate());
    }

    @Test
    public void division_by_zero_throws_exception() {
        Calculator calculator = new Calculator();
        calculator.setOperand("9");
        calculator.setOperator(Calculator.Operators.DIVIDE);
        calculator.setOperand("0");
        assertThrows(Calculator.DivisionByZeroException.class, calculator::calculate);
    }

    @Test
    public void consecutive_operations() {
        Calculator calculator = new Calculator();
        calculator.setOperand("1");
        calculator.setOperator(Calculator.Operators.ADD);
        calculator.setOperand("1");
        assertEquals(2, calculator.calculate());
        calculator.setOperand("1");
        calculator.setOperator(Calculator.Operators.ADD);
        calculator.setOperand("1");
        assertEquals(2, calculator.calculate());
    }

    @Test
    public void chained_operations() {
        Calculator calculator = new Calculator();
        calculator.setOperand("1");
        calculator.setOperator(Calculator.Operators.ADD);
        calculator.setOperand("1");
        calculator.setOperator(Calculator.Operators.ADD);
        calculator.setOperand("1");
        assertEquals(3, calculator.calculate());
    }

    @Test
    public void clear() {
        Calculator calculator = new Calculator();
        calculator.setOperand("1");
        calculator.setOperator(Calculator.Operators.ADD);
        calculator.clear();
        calculator.setOperand("1");
        calculator.setOperator(Calculator.Operators.ADD);
        calculator.setOperand("1");
        assertEquals(2, calculator.calculate());
    }
}