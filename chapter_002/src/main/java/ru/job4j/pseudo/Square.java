package ru.job4j.pseudo;

import java.util.StringJoiner;

/**
 * Реализация фигуры квадрат.
 * @author vzamylin
 * @version 1
 * @since 14.04.2018
 */
public class Square implements Shape {
    /**
     * Реализация отрисовки для фигуры квадрат.
     * @return Строкое представление квадрата в псевдографике.
     */
    @Override
    public String draw() {
        return new StringJoiner(System.lineSeparator())
                .add("++++")
                .add("+  +")
                .add("+  +")
                .add("++++")
                .toString();
    }
}