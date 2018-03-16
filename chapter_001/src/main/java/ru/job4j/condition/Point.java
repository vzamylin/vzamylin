package ru.job4j.condition;

import static java.lang.Math.*;

/**
 * Класс для работы с точкой в системе координат
 * @author vzamylin
 * @version 1
 * @since 10.02.2018
*/
public class Point {
    private int x;
    private int y;

    /**
     * Конструктор для инициализации координат точки
     * @param x координата x
     * @param y координата y
    */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Расстояние от текущей точки до другой переданной на вход точки.
     * @param that Точка, до которой рассчитывается расстояние от текущей точки.
     * @return Расстояние между указанными выше точками.
    */
    public double distanceTo(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }

    /**
     * Запуск программы - расчет и вывод на консоль расстояния между двумя заданными точками.
     * @param args Параметры запуска (не используются).
    */
    public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(3, -4);
        System.out.println("x1 = " + a.x + "; y1 = " + a.y);
        System.out.println("x2 = " + b.x + "; y2 = " + b.y);
        System.out.println("Расстояние между точками A и B: " + String.valueOf(a.distanceTo(b)));
    }
}