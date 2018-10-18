package ru.job4j.chess.firuges;

/**
 * Абстрактная фигура шахматной доски (с частичной реализацией только общих для всех фигур методов).
 * @author vzamylin
 * @version 1
 * @since 17.10.2018
 */
public abstract class AbstractFigure implements Figure {
    private final Cell position;

    /**
     * Конструктор.
     * @param position Позиция фигуры на шахматной доске.
     */
    public AbstractFigure(final Cell position) {
        this.position = position;
    }

    /**
     * Получить позицию фигуры.
     * @return Позиция фигуры.
     */
    @Override
    public Cell position() {
        return this.position;
    }
}