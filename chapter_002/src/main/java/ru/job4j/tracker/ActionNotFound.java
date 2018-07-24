package ru.job4j.tracker;

/**
 * Исключение "Действие не найдено".
 * @author vzamylin
 * @version 1
 * @since 25.07.2018
 */
class ActionNotFound extends RuntimeException {

    /**
     * Конструктор.
     * @param message Сообщение об ошибке.
     */
    ActionNotFound(String message) {
        super(message);
    }
}