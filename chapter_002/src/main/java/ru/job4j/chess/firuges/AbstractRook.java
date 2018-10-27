package ru.job4j.chess.firuges;

/**
 * Абстрактная фигура ладья (с реализацией только общих методов для черной и белой ладьи).
 * @author vzamylin
 * @version 1
 * @since 27.10.2018
 */
public abstract class AbstractRook extends AbstractFigure implements WalkingLinearly {

    /**
     * Конструктор.
     * @param position Позиция фигуры на шахматной доске.
     */
    public AbstractRook(final Cell position) {
        super(position);
    }

    /**
     * Путь из ячеек шахматной доски, который проходит фигура из заданной исходной позиции
     * в заданную конечную позицию (исключая исходную позицию).
     * @param source Исходная позиция.
     * @param dest Конечная позиция.
     * @return Массив ячеек, содержащий путь фигуры (кроме ее исходной позиции),
     *         если переход фигуры из исходной в заданную позицию возможен.
     * @throws ImpossibleMoveException Если переход фигуры из исходной в заданную позицию невозможен.
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps = this.wayLine(source, dest);
        if (steps.length == 0) {
            throw new ImpossibleMoveException("Ладья может ходить только по прямой линии!");
        }
        return steps;
    }
}