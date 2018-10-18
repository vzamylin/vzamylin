package ru.job4j.chess.firuges;

/**
 * Исключение "Ячейка не найдена".
 * @author vzamylin
 * @version 1
 * @since 17.10.2018
 */
class CellNotFoundException extends RuntimeException {

    /**
     * Конструктор
     * @param message Сообщение об ошибке.
     */
    CellNotFoundException(String message) {
        super(message);
    }
}