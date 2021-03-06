package ru.job4j.chess.firuges;

/**
 * Абстрактная фигура конь (с реализацией только общих методов для черного и белого коней).
 * @author vzamylin
 * @version 1
 * @since 26.10.2018
 */
public abstract class AbstractKnight extends AbstractFigure {

    /**
     * Конструктор.
     * @param position Позиция фигуры на шахматной доске.
     */
    public AbstractKnight(final Cell position) {
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
        Cell[] steps = new Cell[0];
        int absDeltaX = Math.abs(dest.x - source.x);
        int absDeltaY = Math.abs(dest.y - source.y);
        if (absDeltaX == 2 && absDeltaY == 1 || absDeltaY == 2 && absDeltaX == 1) {
            steps = new Cell[]{dest};
        }
        if (steps.length == 0) {
            throw new ImpossibleMoveException("Конь может ходить только буквой \"Г\"!");
        }
        return steps;
    }
}