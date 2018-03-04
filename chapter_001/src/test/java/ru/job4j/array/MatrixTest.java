package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты для матрицы.
 * @author vzamylin
 * @version 1
 * @since 05.03.2018
 */
public class MatrixTest {

    /**
     * Проверка возврата пустой матрицы при неверно заданной размерности (<=0)
     */
    @Test
    public void whenSizeIsNotNatural() {
        Matrix matrix = new Matrix();
        assertThat(matrix.multiple(-1), is(new int[][]{}));
        assertThat(matrix.multiple(0), is(new int[][]{}));
    }

    /**
     * Проверка получения таблицы умножения для единственного числа 1.
     */
    @Test
    public void whenSizeIsOne() {
        assertThat(new Matrix().multiple(1), is(new int[][]{{1}}));
    }

    /**
     * Проверка получения таблицы умножения для чисел с 1 по 3.
     */
    @Test
    public void whenSizeIsThree() {
        assertThat(new Matrix().multiple(3),
                   is(new int[][]{
                          {1, 2, 3},
                          {2, 4, 6},
                          {3, 6, 9}
                      }
                   )
        );
    }

    /**
     * Проверка получения таблицы умножения для чисел с 1 по 9.
     */
    @Test
    public void whenSizeIsNine() {
        assertThat(new Matrix().multiple(9),
                   is(new int[][]{
                          {1, 2,  3,  4,  5,  6,  7,  8,  9},
                          {2, 4,  6,  8,  10, 12, 14, 16, 18},
                          {3, 6,  9,  12, 15, 18, 21, 24, 27},
                          {4, 8,  12, 16, 20, 24, 28, 32, 36},
                          {5, 10, 15, 20, 25, 30, 35, 40, 45},
                          {6, 12, 18, 24, 30, 36, 42, 48, 54},
                          {7, 14, 21, 28, 35, 42, 49, 56, 63},
                          {8, 16, 24, 32, 40, 48, 56, 64, 72},
                          {9, 18, 27, 36, 45, 54, 63, 72, 81}
                      }
                   )
        );
    }
}