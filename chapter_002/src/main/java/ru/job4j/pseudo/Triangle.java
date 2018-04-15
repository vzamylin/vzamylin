package ru.job4j.pseudo;

import java.util.StringJoiner;

/**
 * Реализация фигуры треугольник.
 * @author vzamylin
 * @version 1
 * @since 14.04.2018
 */
public class Triangle implements Shape {

    /**
     * Реализация отрисовки для фигуры треугольник.
     * @return Строкое представление треугольника в псевдографике.
     */
    @Override
    public String draw() {
        return new StringJoiner(System.lineSeparator())
                .add("  +  ")
                .add(" + + ")
                .add("+++++")
                .toString();
    }
}