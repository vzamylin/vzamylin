package ru.job4j.condition;

import static java.lang.Math.*;

/**
 * Треугольник по трем точкам в системе координат.
 * @author vzamylin
 * @version 1
 * @since 16.02.2018
 */
public class Triangle {
    // Точки в системе координат для определения треугольника
    private Point a;
    private Point b;
    private Point c;

    /**
     * Конструктор для определения треугольника по трем заданным точкам.
     * @param a 1-ая точка a.
     * @param b 2-ая точка b.
     * @param c 3-я точка c.
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Полупериметр треугольника, построенного по точкам a, b и c.
     * @param ab Сторона ab.
     * @param ac Сторона ac.
     * @param bc Сторона bc.
     * @return Полупериметр.
     */
    public double halfMeter(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    /**
     * Проверка возможности построения треугольника abc с заданными длинами сторон.
     * @param ab Сторона ab.
     * @param ac Сторона ac.
     * @param bc Сторона bc.
     * @return true, если треугольник построить возможно, в противном случае false.
     */
    private boolean exists(double ab, double ac, double bc) {
        return ab > 0 && ac > 0 && bc > 0
               && ab < ac + bc
               && ac < ab + bc
               && bc < ab + ac;
    }

    /**
     * Вычисление площади треугольника.
     * @return Площадь треугольника, если его возможно построить по заданным при инициализации точкам, в противном случае -1.
     */
    public double area() {
        double result = -1D;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        if (this.exists(ab, ac, bc)) {
            double halfMeter = this.halfMeter(ab, ac, bc);
            result = sqrt(halfMeter * (halfMeter - ab) * (halfMeter - ac) * (halfMeter - bc));
        }
        return result;
    }
}