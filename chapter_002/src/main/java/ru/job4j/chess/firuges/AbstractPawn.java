package ru.job4j.chess.firuges;

import ru.job4j.chess.InternalErrorException;
import ru.job4j.chess.firuges.black.PawnBlack;
import ru.job4j.chess.firuges.white.PawnWhite;

/**
 * Абстрактная фигура пешка (с реализацией только общих методов для черной и белой пешки).
 * @author vzamylin
 * @version 1
 * @since 19.10.2018
 */
public abstract class AbstractPawn extends AbstractFigure {

    /**
     * Конструктор.
     * @param position Позиция фигуры на шахматной доске.
     */
    public AbstractPawn(final Cell position) {
        super(position);
    }

    /**
     * Путь из ячеек шахматной доски, который проходит фигура из заданной исходной позиции
     * в заданную конечную позицию (исключая исходную позицию).<br/>
     * В данной логике для пешки предполагается,
     * что отсчет координат (x, y) шахматной доски идет с верхнего левого угла от 0 до 7.<br/>
     * При этом белые фигуры располагаются сверху, а черные снизу.<br/>
     * Исходя из этого определяется признак нахождения черной или белой пешки на начальной позиции isInitPosition
     * и направление ее движения по оси Y directionY (1 - с увеличением координаты y, -1 - с уменьшением).
     * @param source Исходная позиция.
     * @param dest Конечная позиция.
     * @return Массив ячеек, содержащий путь фигуры (кроме ее исходной позиции),
     *         если переход фигуры из исходной в заданную позицию возможен.
     * @throws ImpossibleMoveException Если переход фигуры из исходной в заданную позицию невозможен.
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps = new Cell[0];
        boolean isInitPosition;
        int directionY;
        if (this instanceof PawnBlack) {
            directionY = -1;
            isInitPosition = source.y == 6;
        } else if (this instanceof PawnWhite) {
            directionY = 1;
            isInitPosition = source.y == 1;
        } else {
            throw new InternalErrorException("Невозможно определить цвет пешки!");
        }
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        if (deltaX == 0 && (deltaY == directionY || isInitPosition && deltaY == 2 * directionY)) {
            steps = new Cell[Math.abs(deltaY)];
            for (int i = 0; i < steps.length; i++) {
                steps[i] = Cell.findByXY(source.x, source.y + directionY * (i + 1));
            }
        }
        if (steps.length == 0) {
            throw new ImpossibleMoveException("Пешка не может пойти на указанную клетку!");
        }
        return steps;
    }
}