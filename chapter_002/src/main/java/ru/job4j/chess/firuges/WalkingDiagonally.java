package ru.job4j.chess.firuges;

/**
 * Фигуры, ходящие по диагонали (слон, ферзь).
 * @author vzamylin
 * @version 1
 * @since 17.10.2018
 */
interface WalkingDiagonally {

    /**
     * Путь по диагонали между заданными позициями шахматной доски.
     * @param source Исходная позиция фигуры на шахматной доске.
     * @param dest Конечная позиция фигуры на шахматной доске.
     * @return 1. Если исходная и конечная позиции лежат на одной диагонали,
     *            то возвращается массив ячеек, лежащих на диагонали между этими позициями
     *            (исключая исходную позицию, на которой изначально стоит фигура).<br/>
     *         2. Если исходная и конечная позиции НЕ лежат на одной диагонали (либо совпадают),
     *         то возвращается пустой массив ячеек нулевой размерности.
     */
    default Cell[] wayDiagonal(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (source.x != dest.x
            && source.y != dest.y
            && Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y)
        ) {
            steps = new Cell[Math.abs(dest.x - source.x)];
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