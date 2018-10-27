package ru.job4j.chess;

/**
 * Исключение "внутренняя ошибка программы".<br/>
 * В диагностических целях может подниматься в различных некорректных ситуациях,
 * которых при нормальной работе программы возникать не должно.
 * @author vzamylin
 * @version 1
 * @since 20.10.2018
 */
public class InternalErrorException extends RuntimeException {

    /**
     * Конструктор.
     * @param message Сообщение об ошибке.
     */
    public InternalErrorException(String message) {
        super(message);
    }
}