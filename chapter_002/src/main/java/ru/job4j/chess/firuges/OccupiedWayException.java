package ru.job4j.chess.firuges;

/**
 * Исключение "Путь фигуры занят другими фигурами".
 * @author vzamylin
 * @version 1
 * @since 18.10.2018
 */
public class OccupiedWayException extends Exception {

    /**
     * Конструктор.
     * @param message Сообщение об ошибке.
     */
    public OccupiedWayException(String message) {
        super(message);
    }
}