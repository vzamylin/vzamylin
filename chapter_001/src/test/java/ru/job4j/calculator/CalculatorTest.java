package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты для класса Calculator
 * @author vzamylin
 * @version 1
 * @since 08.02.2018
*/
public class CalculatorTest {

    /**
     * Тест сложения двух чисел.
    */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Тест вычитания двух чисел.
    */
    @Test
    public void whenFiveMinusOneThenFour() {
        Calculator calc = new Calculator();
        calc.subtract(5D, 4D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Тест умножения двух чисел.
    */
    @Test
    public void whenTwoMultiplyThreeThenSix() {
        Calculator calc = new Calculator();
        calc.multiple(2D, 3D);
        double result = calc.getResult();
        double expected = 6D;
        assertThat(result, is(expected));
    }

    /**
     * Тест деления двух чисел.
    */
    @Test
    public void whenThreeDivOneAndHalfThenTwo() {
        Calculator calc = new Calculator();
        calc.div(3D, 1.5D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

}
