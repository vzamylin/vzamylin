package ru.job4j.chess.firuges;

/**
 * Абстрактная фигура слон (с реализацией только общих методов для черного и белого слонов).
 * @author vzamylin
 * @version 1
 * @since 17.10.2018
 */
public abstract class AbstractBishop extends AbstractFigure implements WalkingDiagonally {

    /**
     * Конструктор.
     * @param position Позиция фигуры на шахматной доске.
     */
    public AbstractBishop(final Cell position) {
        super(position);
    }

    /**
     * Путь из ячеек шахматной доски, который проходит фигура из заданной исходной позиции в заданную конечную позицию (исключая исходную позицию).
     * @param source Исходная позиция.
     * @param dest Конечная позиция.
     * @return Массив ячеек, содержащий путь фигуры (кроме ее исходной позиции), если переход фигуры из исходной в заданную позицию возможен.
     * @throws ImpossibleMoveException Если переход фигуры из исходной в заданную позицию невозможен.
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] way = this.wayDiagonal(source, dest);
        if (way.length == 0) {
            throw new ImpossibleMoveException("Слон может ходить только по диагонали!");
        }
        return way;
    }
}