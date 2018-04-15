package ru.job4j.pseudo;

/**
 * Класс для вывода на консоль фигур в псевдографике.
 * @author vzamylin
 * @version 1
 * @since 14.04.2018
 */
public class Paint {

    /**
     * Вывести фигуру на консоль.
     * @param shape Выводимая фигура.
     */
    public void print(Shape shape) {
        System.out.println(shape.draw());
    }

    /**
     * Запуск программы.
     * Выводит на консоль фигуры треугольник и квадрат.
     * @param args Аргументы.
     */
    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.print(new Triangle());
        paint.print(new Square());
    }
}