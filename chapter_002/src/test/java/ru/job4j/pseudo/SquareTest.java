package ru.job4j.pseudo;

import java.util.StringJoiner;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты для квадрата.
 * @author vzamylin
 * @version 1
 * @since 15.04.2018
 */
public class SquareTest {

    /**
     * Проверка отрисовки квадрата.
     */
    @Test
    public void whenDrawSquare() {
        assertThat(
                new Square().draw(),
                is(new StringJoiner(System.lineSeparator())
                        .add("++++")
                        .add("+  +")
                        .add("+  +")
                        .add("++++")
                        .toString()
                )
        );
    }
}