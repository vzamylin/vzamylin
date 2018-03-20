package ru.job4j.professions;

/**
 * Профессия учитель.
 * @author vzamylin
 * @version 1
 * @since 21.03.2018
 */
public class Teacher extends Profession {
    /**
     * Конструктор.
     * @param name Название профессии.
     */
    public Teacher(String name) {
        super(name);
    }

    /**
     * Обучить студента.
     * @param student Студент.
     */
    public void teach(Student student) {
    }
}