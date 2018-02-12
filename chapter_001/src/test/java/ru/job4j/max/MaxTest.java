package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты нахождения максимальных чисел.
 * @author vzamylin
 * @version 1
 * @since 13.02.2018
 */
public class MaxTest {

    /**
     * Проверка максимума из двух чисел, когда 1-ое больше 2-ого.
    */
    @Test
    public void whenFirstGreaterSecond() {
        Max maximum = new Max();
        assertThat(maximum.max(-2, -3), is(-2));
    }

    /**
     * Проверка максимума из двух чисел, когда 1-ое меньше 2-ого.
    */
    @Test
    public void whenFirstLessSecond() {
        Max maximum = new Max();
        assertThat(maximum.max(1, 5), is(5));
    }

    /**
     * Проверка максимума из двух чисел, когда эти числа равны.
    */
    @Test
    public void whenFirstEqualsSecond() {
        Max maximum = new Max();
        assertThat(maximum.max(7, 7), is(7));
    }
}