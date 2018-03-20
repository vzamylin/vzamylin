package ru.job4j.professions;

/**
 * Профессия доктор.
 * @author vzamylin
 * @version 1
 * @since 21.03.2018
 */
public class Doctor extends Profession {
    /**
     * Конструктор.
     * @param name Название профессии.
     */
    public Doctor(String name) {
        super(name);
    }

    /**
     * Вылечить пациента.
     * @param patient Пациент.
     */
    public void heal(Patient patient) {
    }
}