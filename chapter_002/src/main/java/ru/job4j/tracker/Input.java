package ru.job4j.tracker;

/**
 * Интерфейс ввода данных.
 * @author vzamylin
 * @version 1
 * @since 01.04.2018
 */
public interface Input {

    /**
     * Задать вопрос пользователю и получить ответ.
     * @param question Вопрос.
     * @return Ответ.
     */
    String ask(String question);
}