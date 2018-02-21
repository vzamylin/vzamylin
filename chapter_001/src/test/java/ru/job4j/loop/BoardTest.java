package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты для шахматной доски в псевдографике.
 * @author vzamylin
 * @version 1
 * @since 22.02.2018
 */
public class BoardTest {

    /**
     * Проверка отсутствия отрисованной доски при заданной неверной размерности 0x3.
     */
    @Test
    public void when0x3() {
        assertThat(new Board().paint(0, 3), is("-1"));
    }

    /**
     * Проверка отрисовки доски размерностью 3x3.
     */
    @Test
    public void when3x3() {
        String ln = System.lineSeparator();
        String expected = String.format("X X%s X %sX X", ln, ln);
        assertThat(new Board().paint(3, 3), is(expected));
    }

    /**
     * Проверка отрисовки доски размерностью 5x4.
     */
    @Test
    public void when5x4() {
        String ln = System.lineSeparator();
        String expected = String.format("X X X%s X X %sX X X%s X X ", ln, ln, ln);
        assertThat(new Board().paint(5, 4), is(expected));
    }
}