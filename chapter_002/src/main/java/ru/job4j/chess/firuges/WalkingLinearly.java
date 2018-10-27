package ru.job4j.chess.firuges;

import static java.lang.Math.abs;
import static java.lang.Math.max;

/**
 * Фигуры, ходящие по прямой горизонтально или вертикально (ладья, ферзь).
 * @author vzamylin
 * @version 1
 * @since 27.10.2018
 */
interface WalkingLinearly {

    /**
     * Путь по прямой горизонтально или вертикально между заданными позициями шахматной доски.
     * @param source Исходная позиция фигуры на шахматной доске.
     * @param dest Конечная позиция фигуры на шахматной доске.
     * @return 1. Если исходная и конечная позиции лежат на одной прямой,
     *            то возвращается массив ячеек, лежащих на прямой между этими позициями
     *            (исключая исходную позицию, на которой изначально стоит фигура).<br/>
     *         2. Если исходная и конечная позиции НЕ лежат на одной прямой (либо совпадают),
     *         то возвращается пустой массив ячеек нулевой размерности.
     */
    default Cell[] wayLine(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (dest.x != source.x && dest.y == source.y
            || dest.y != source.y && dest.x == source.x
        ) {
            steps = new Cell[max(abs(dest.x - source.x), abs(dest.y - source.y))];
            int directionX = Integer.compare(dest.x, source.x);
            int directionY = Integer.compare(dest.y, source.y);
            for (int i = 0; i < steps.length; i++) {
                int x = source.x + directionX * (i + 1);
                int y = source.y + directionY * (i + 1);
                steps[i] = Cell.findByXY(x, y);
            }
        }
        return steps;
    }
}