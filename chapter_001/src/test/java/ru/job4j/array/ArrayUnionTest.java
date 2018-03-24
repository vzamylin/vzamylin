package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты объединения массивов.
 * @author vzamylin
 * @version 1
 * @since 11.03.2018
 */
public class ArrayUnionTest {

    /**
     * Проверка, что массив отсортирован.
     */
    @Test
    public void whenArrayIsSorted() {
        ArrayUnion arrayUnion = new ArrayUnion();
        assertThat(arrayUnion.isArraySorted(new int[]{}), is(true));
        assertThat(arrayUnion.isArraySorted(new int[]{-1, -1, 0, 1, 2, 2, 5, 7}), is(true));
    }

    /**
     * Проверка, что массив не отсортирован.
     */
    @Test
    public void whenArrayIsNotSorted() {
        assertThat(new ArrayUnion().isArraySorted(new int[]{-1, -1, 0, 1, 2, 2, 5, 4, 7}), is(false));
    }

    /**
     * Проверка объединения двух отсортированных массивов, хотя бы один из которых пустой.
     */
    @Test
    public void whenOneOrBothArraysAreEmpty() {
        ArrayUnion arrayUnion = new ArrayUnion();
        assertThat(arrayUnion.unionSorted(
                       new int[]{},
                       new int[]{-1, -1, -1, 0, 1, 3, 4, 4, 5, 7, 7}
                   ),
                   is(new int[]{-1, -1, -1, 0, 1, 3, 4, 4, 5, 7, 7})
        );
        assertThat(arrayUnion.unionSorted(
                       new int[]{-78, -1, -1, -1, 0, 1, 1, 1, 3, 4, 4, 5, 6, 7, 7},
                       new int[]{}
                   ),
                   is(new int[]{-78, -1, -1, -1, 0, 1, 1, 1, 3, 4, 4, 5, 6, 7, 7})
        );
        assertThat(arrayUnion.unionSorted(new int[]{}, new int[]{}), is(new int[]{}));
    }

    /**
     * Проверка объединения двух отсортированных массивов, когда все элементы 2-ого меньше всех элементов 1-ого.
     */
    @Test
    public void whenAllElementsOfSecondLessThanAllElementsOfFirst() {
        assertThat(new ArrayUnion().unionSorted(
                       new int[]{-1, -1, 0, 1, 3, 4, 4, 5, 6, 7},
                       new int[]{-10, -10, -8, -7, -7, -2}
                   ),
                   is(new int[]{-10, -10, -8, -7, -7, -2, -1, -1, 0, 1, 3, 4, 4, 5, 6, 7})
        );
    }

    /**
     * Проверка объединения двух отсортированных массивов, когда максимальный элемент 2-ого равен минимальному элементу 1-ого.
     */
    @Test
    public void whenMaxElementOfSecondIsEqualMinElementOfFirst() {
        ArrayUnion arrayUnion = new ArrayUnion();
        assertThat(arrayUnion.unionSorted(
                       new int[]{-2, -1, 0, 1, 3, 4, 4, 5, 6, 7},
                       new int[]{-10, -10, -8, -7, -7, -2}
                   ),
                   is(new int[]{-10, -10, -8, -7, -7, -2, -2, -1, 0, 1, 3, 4, 4, 5, 6, 7})
        );
        assertThat(arrayUnion.unionSorted(
                       new int[]{-2, -2, -1, 0, 1, 3, 4, 4, 5, 6, 7},
                       new int[]{-10, -10, -8, -7, -7, -2}
                   ),
                   is(new int[]{-10, -10, -8, -7, -7, -2, -2, -2, -1, 0, 1, 3, 4, 4, 5, 6, 7})
        );
    }

    /**
     * Проверка объединения двух отсортированных частично пересекающихся массивов,
     * когда минимальный элемент 1-ого лежит между минимальным и максимальным элементом 2-ого,
     * а максимальный 1-ого больше максимального 2-ого.
     */
    @Test
    public void whenMin1BetweenMin2AndMax2AndMax1MoreThanMax2() {
        assertThat(new ArrayUnion().unionSorted(
                       new int[]{-2, -1, 0, 1, 3, 4, 4, 5, 6, 7},
                       new int[]{-10, -10, -8, -7, -7, -2, 2, 2, 4}
                   ),
                   is(new int[]{-10, -10, -8, -7, -7, -2, -2, -1, 0, 1, 2, 2, 3, 4, 4, 4, 5, 6, 7})
        );
    }

    /**
     * Проверка объединения двух отсортированных массивов,
     * когда 2-ой по диапазонам значений лежит целиком внутри 1-ого.
     */
    @Test
    public void whenSecondInsideFirst() {
        assertThat(new ArrayUnion().unionSorted(
                       new int[]{-2, -1, 0, 1, 5, 5, 10, 13, 20},
                       new int[]{-1, 2, 2, 5, 7, 7, 19}
                   ),
                   is(new int[]{-2, -1, -1, 0, 1, 2, 2, 5, 5, 5, 7, 7, 10, 13, 19, 20})
        );
    }

    /**
     * Проверка объединения двух отсортированных массивов,
     * когда 1-ый по диапазонам значений лежит целиком внутри 2-ого.
     */
    @Test
    public void whenFirstInsideSecond() {
        assertThat(new ArrayUnion().unionSorted(
                       new int[]{-1, 2, 2, 5, 7, 7, 19},
                       new int[]{-2, -1, 0, 1, 5, 5, 10, 13, 20}
                   ),
                   is(new int[]{-2, -1, -1, 0, 1, 2, 2, 5, 5, 5, 7, 7, 10, 13, 19, 20})
        );
    }

    /**
     * Проверка объединения двух отсортированных частично пересекающихся массивов,
     * когда минимальный элемент 2-ого лежит между минимальным и максимальным элементом 1-ого,
     * а максимальный 2-ого больше максимального 1-ого.
     */
    @Test
    public void whenMin2BetweenMin1AndMax1AndMax2MoreThanMax1() {
        assertThat(new ArrayUnion().unionSorted(
                       new int[]{-10, -10, -8, -7, -7, -2, 2, 2, 4},
                       new int[]{-2, -1, 0, 1, 3, 4, 4, 5, 6, 7}
                   ),
                   is(new int[]{-10, -10, -8, -7, -7, -2, -2, -1, 0, 1, 2, 2, 3, 4, 4, 4, 5, 6, 7})
        );
    }

    /**
     * Проверка объединения двух отсортированных массивов, когда максимальный элемент 1-ого равен минимальному элементу 2-ого.
     */
    @Test
    public void whenMaxElementOfFirstIsEqualMinElementOfSecond() {
        ArrayUnion arrayUnion = new ArrayUnion();
        assertThat(arrayUnion.unionSorted(
                       new int[]{-10, -10, -8, -7, -7, -2},
                       new int[]{-2, -1, 0, 1, 3, 4, 4, 5, 6, 7}
                   ),
                   is(new int[]{-10, -10, -8, -7, -7, -2, -2, -1, 0, 1, 3, 4, 4, 5, 6, 7})
        );
        assertThat(arrayUnion.unionSorted(
                       new int[]{-10, -10, -8, -7, -7, -2},
                       new int[]{-2, -2, -1, 0, 1, 3, 4, 4, 5, 6, 7}
                   ),
                   is(new int[]{-10, -10, -8, -7, -7, -2, -2, -2, -1, 0, 1, 3, 4, 4, 5, 6, 7})
        );
    }

    /**
     * Проверка объединения двух отсортированных массивов, когда все элементы 2-ого больше всех элементов 1-ого.
     */
    @Test
    public void whenAllElementsOfSecondMoreThanAllElementsOfFirst() {
        assertThat(new ArrayUnion().unionSorted(
                       new int[]{-10, -10, -8, -7, -7, -2},
                       new int[]{-1, -1, 0, 1, 3, 4, 4, 5, 6, 7}
                   ),
                   is(new int[]{-10, -10, -8, -7, -7, -2, -1, -1, 0, 1, 3, 4, 4, 5, 6, 7})
        );
    }
}