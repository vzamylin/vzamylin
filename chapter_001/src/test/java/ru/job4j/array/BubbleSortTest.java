package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты сортировки массива методом пузырька.
 * @author vzamylin
 * @version 1
 * @since 03.03.2018
 */
public class BubbleSortTest {

    /**
     * Проверка отсутствия сортировки пустого массива или массива с одним элементом.
     */
    @Test
    public void whenLengthIsZeroOrOne() {
        BubbleSort bubbleSort = new BubbleSort();
        assertThat(bubbleSort.sort(new int[0]), is(new int[0]));
        assertThat(bubbleSort.sort(new int[]{7}), is(new int[]{7}));
    }

    /**
     * Проверка сортировки массива из 2-х элементов.
     */
    @Test
    public void whenLengthIsTwo() {
        assertThat(new BubbleSort().sort(new int[]{2, -5}), is(new int[]{-5, 2}));
    }

    /**
     * Проверка сортировки массива из 10-ти элементов.
     */
    @Test
    public void whenLengthIsTen() {
        assertThat(new BubbleSort().sort(new int[]{1, 5, 4, 2, 3, 1, 7, 8, 0, -5}), is(new int[]{-5, 0, 1, 1, 2, 3, 4, 5, 7, 8}));
    }
}