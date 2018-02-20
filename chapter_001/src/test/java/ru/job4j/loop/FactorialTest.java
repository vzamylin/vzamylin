package ru.job4j.loop;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты вычисления факториала.
 * @author vzamylin
 * @version 1
 * @since 21.02.2018
 */
public class FactorialTest {

    /**
     * Проверка отсутствия факториала отрицательного числа -3.
     */
    @Test
    public void whenMinusThreeThenMinusOne() {
        assertThat(new Factorial().calc(-3), is(-1));
    }

    /**
     * Проверка факториала числа 0.
     */
    @Test
    public void whenZeroThenOne() {
        assertThat(new Factorial().calc(0), is(1));
    }

    /**
     * Проверка факториала числа 5.
     */
    @Test
    public void whenFiveThenOneHundredTwenty() {
        assertThat(new Factorial().calc(5), is(120));
    }
}