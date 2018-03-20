package ru.job4j.professions;

/**
 * Пациент.
 * @author vzamylin
 * @version 1
 * @since 21.03.2018
 */
public class Patient {
    private String name;

    /**
     * Конструктор.
     * @param name Имя пациента.
     */
    public Patient(String name) {
        this.name = name;
    }

    /**
     * Получить имя пациента.
     * @return Имя пациента.
     */
    public String getName() {
        return this.name;
    }
}