package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты переворачивания массива.
 * @author vzamylin
 * @version 1
 * @since 02.03.2018
 */
public class TurnTest {

    /**
     * Проверка отсутствия переворота пустого массива или массива с одним элементом.
     */
    @Test
    public void whenLengthIsZeroOrOne() {
        Turn turn = new Turn();
        assertThat(turn.back(new int[0]), is(new int[0]));
        assertThat(turn.back(new int[]{-2}), is(new int[]{-2}));
    }

    /**
     * Проверка переворота массива нечетной размерности (>1).
     */
    @Test
    public void whenLengthIsOdd() {
        Turn turn = new Turn();
        assertThat(turn.back(new int[]{-2, 5, -9}), is(new int[]{-9, 5, -2}));
        assertThat(turn.back(new int[]{0, -2, 3, 8, -11}), is(new int[]{-11, 8, 3, -2, 0}));
    }

    /**
     * Проверка переворота массива четной размерности (>0).
     */
    @Test
    public void whenLengthIsEven() {
        Turn turn = new Turn();
        assertThat(turn.back(new int[]{1, -4}), is(new int[]{-4, 1}));
        assertThat(turn.back(new int[]{-1, 15, 5, -7}), is(new int[]{-7, 5, 15, -1}));
    }
}