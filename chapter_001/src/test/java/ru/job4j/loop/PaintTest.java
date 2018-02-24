package ru.job4j.loop;

import java.util.StringJoiner;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты для рисования фигур в псевдографике.
 * @author vzamylin
 * @version 1
 * @since 25.02.2018
 */
public class PaintTest {

    /**
     * Проверка отсутствия отрисованной пирамиды при неверно заданных высотах 0 и -1.
     */
    @Test
    public void whenPyramidHeightIsNotNatural() {
        Paint paint = new Paint();
        assertThat(paint.pyramid(0), is("-1"));
        assertThat(paint.pyramid(-1), is("-1"));
    }

    /**
     * Проверка отрисовки пирамиды высотой 2.
     */
    @Test
    public void whenPyramidHeightIs2() {
        String actual = new Paint().pyramid(2);
        System.out.println(actual);
        String expected = new StringJoiner(System.lineSeparator())
                                .add(" ^ ")
                                .add("^^^")
                                .toString();
        assertThat(actual, is(expected));
    }

    /**
     * Проверка отрисовки пирамиды высотой 3.
     */
    @Test
    public void whenPyramidHeightIs3() {
        String actual = new Paint().pyramid(3);
        System.out.println(actual);
        String expected = new StringJoiner(System.lineSeparator())
                                .add("  ^  ")
                                .add(" ^^^ ")
                                .add("^^^^^")
                                .toString();
        assertThat(actual, is(expected));
    }
}