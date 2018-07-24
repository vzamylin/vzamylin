package ru.job4j.tracker;

/**
 * Исключение "Введенный пункт меню вне допустимого списка значений".
 * @author vzamylin
 * @version 1
 * @since 24.07.2018
 */
class MenuOutException extends RuntimeException {

    /**
     * Конструктор.
     * @param message Сообщение об ошибке.
     */
    MenuOutException(String message) {
        super(message);
    }
}