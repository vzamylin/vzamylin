package ru.job4j.chess.firuges;

/**
 * Абстрактная фигура ферзь (с реализацией только общих методов для черного и белого ферзей).
 * @author vzamylin
 * @version 1
 * @since 27.10.2018
 */
public abstract class AbstractQueen extends AbstractFigure implements WalkingLinearly, WalkingDiagonally {

    /**
     * Конструктор.
     * @param position Позиция фигуры на шахматной доске.
     */
    public AbstractQueen(final Cell position) {
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
            steps = this.wayDiagonal(source, dest);
        }
        if (steps.length == 0) {
            throw new ImpossibleMoveException(
                    "Ферзь может ходить только по прямой линии или по диагонали!"
            );
        }
        return steps;
    }
}