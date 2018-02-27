package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты для возведения чисел массива в квадрат.
 * @author vzamylin
 * @version 1
 * @since 28.02.2018
 */
public class SquareTest {

    /**
     * Проверка возврата фиктивного массива с единственным элементом -1 в случае неверной размерности (<=0).
     */
    @Test
    public void whenBoundIsNotNatural() {
        Square square = new Square();
        for (int i = -1; i <= 0; i++) {
            int[] arrayActual = square.calculate(i);
            assertThat(arrayActual.length, is(1));
            assertThat(arrayActual[0], is(-1));
        }
    }

    /**
     * Проверка заполнения массива квадратами чисел при его размерности 1.
     */
    @Test
    public void whenBoundIsOne() {
        int[] arrayActual = new Square().calculate(1);
        assertThat(arrayActual.length, is(1));
        assertThat(arrayActual[0], is(1));
    }

    /**
     * Проверка заполнения массива квадратами чисел при его размерности 3.
     */
    @Test
    public void whenBoundIsThree() {
        int[] arrayActual = new Square().calculate(3);
        assertThat(arrayActual.length, is(3));
        assertThat(arrayActual[0], is(1));
        assertThat(arrayActual[1], is(4));
        assertThat(arrayActual[2], is(9));
    }
}