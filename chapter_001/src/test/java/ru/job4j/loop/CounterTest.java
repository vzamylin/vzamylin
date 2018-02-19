package ru.job4j.loop;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты для вычислений в циклах.
 * @author vzamylin
 * @version 1
 * @since 20.02.2018
 */
public class CounterTest {

    /**
     * Проверка суммы четных чисел в диапазоне от 1 до 10.
     */
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        assertThat(new Counter().add(1, 10), is(30));
    }

    /**
     * Проверка суммы четных чисел в диапазоне от -3 до 13.
     */
    @Test
    public void whenSumEvenNumbersFromMinusThreeToThirteenThenForty() {
        assertThat(new Counter().add(-3, 13), is(40));
    }

    /**
     * Проверка суммы четных чисел в диапазоне от -5 до -5.
     */
    @Test
    public void whenSumEvenNumbersFromMinusFiveToMinusFiveThenZero() {
        assertThat(new Counter().add(-5, -5), is(0));
    }
}