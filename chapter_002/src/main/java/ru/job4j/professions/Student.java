package ru.job4j.professions;

/**
 * Студент.
 * @author vzamylin
 * @version 1
 * @since 21.03.2018
 */
public class Student {
    private String name;

    /**
     * Конструктор.
     * @param name Имя студента.
     */
    public Student(String name) {
        this.name = name;
    }

    /**
     * Получить имя студента.
     * @return Имя студента.
     */
    public String getName() {
        return this.name;
    }
}