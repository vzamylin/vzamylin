package ru.job4j.pseudo;

import java.util.StringJoiner;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты для треугольника.
 * @author vzamylin
 * @version 1
 * @since 15.04.2018
 */
public class TriangleTest {

    /**
     * Проверка отрисовки треугольника.
     */
    @Test
    public void whenDrawTriangle() {
        assertThat(
                new Triangle().draw(),
                is(new StringJoiner(System.lineSeparator())
                        .add("  +  ")
                        .add(" + + ")
                        .add("+++++")
                        .toString()
                )
        );
    }
}