package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты поиска элементов в массиве.
 * @author vzamylin
 * @version 1
 * @since 01.03.2018
 */
public class FindLoopTest {

    /**
     * Проверка поиска индекса несуществующего элемента массива.
     */
    @Test
    public void whenElementNotExists() {
        FindLoop findLoop = new FindLoop();
        assertThat(findLoop.indexOf(new int[0], 3), is(-1));
        assertThat(findLoop.indexOf(new int[]{2, 4, 6}, 3), is(-1));
    }

    /**
     * Проверка поиска индекса существующего элемента массива.
     */
    @Test
    public void whenElementExists() {
        FindLoop findLoop = new FindLoop();
        assertThat(findLoop.indexOf(new int[]{2}, 2), is(0));
        assertThat(findLoop.indexOf(new int[]{2, 4, -6, 8}, -6), is(2));
    }
}