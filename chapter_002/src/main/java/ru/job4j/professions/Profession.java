package ru.job4j.professions;

/**
 * Общий класс для всех профессий.
 * @author vzamylin
 * @version 1
 * @since 20.03.2018
 */
public class Profession {
    private String name;

    /**
     * Конструктор.
     * @param name Название профессии.
     */
    public Profession(String name) {
        this.name = name;
    }

    /**
     * Получить название профессии.
     * @return Название профессии.
     */
    public String getName() {
        return this.name;
    }
}