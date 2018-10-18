package ru.job4j.chess.firuges;

/**
 * Исключение "Неверный ход фигуры".
 * @author vzamylin
 * @version 1
 * @since 18.10.2018
 */
public class ImpossibleMoveException extends Exception {

    /**
     * Конструктор.
     * @param message Сообщение об ошибке.
     */
    public ImpossibleMoveException(String message) {
        super(message);
    }
}