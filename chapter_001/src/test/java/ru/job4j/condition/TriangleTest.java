package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Тесты для треугольника.
 * @author vzamylin
 * @version 1
 * @since 17.02.2018
 */
public class TriangleTest {

    /**
     * Проверка площади треугольника, когда его возможно построить по трем заданным точкам.
     */
    @Test
    public void whenTriangleExistsThenArea() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(3, 0), new Point(3, -4));
        assertThat(triangle.area(), closeTo(5.9999999999777, 1E-10));
    }

    /**
     * Проверка возврата -1 вместо площади треугольника,
     * когда его нельзя построить по заданным трем точкам (точки лежат на одной линии).
     */
    @Test
    public void whenTriangleNotExistsThenMinusOne() {
        Triangle triangle = new Triangle(new Point(-9, 12), new Point(6, -8), new Point(3, -4));
        assertThat(triangle.area(), is(-1D));
    }
}