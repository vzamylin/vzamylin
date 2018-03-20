package ru.job4j.professions;

/**
 * Профессия инженер.
 * @author vzamylin
 * @version 1
 * @since 21.03.2018
 */
public class Engineer extends Profession {
    /**
     * Конструктор.
     * @param name Название профессии.
     */
    public Engineer(String name) {
        super(name);
    }

    /**
     * Построить дом.
     * @param house Дом.
     */
    public void build(House house) {
    }
}