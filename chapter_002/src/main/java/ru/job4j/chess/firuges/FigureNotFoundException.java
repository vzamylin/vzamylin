package ru.job4j.chess.firuges;

/**
 * Исключение "Нет фигуры в указанной клетке шахматной доски".
 * @author vzamylin
 * @version 1
 * @since 18.10.2018
 */
public class FigureNotFoundException extends Exception {

    /**
     * Конструктор.
     * @param message Сообщение об ошибке.
     */
    public FigureNotFoundException(String message) {
        super(message);
    }
}