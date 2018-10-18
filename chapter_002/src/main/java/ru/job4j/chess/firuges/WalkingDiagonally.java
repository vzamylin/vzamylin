package ru.job4j.chess.firuges;

/**
 * Фигуры, ходящие по диагонали (слон, ферзь, король).
 * @author vzamylin
 * @version 1
 * @since 17.10.2018
 */
interface WalkingDiagonally {

    /**
     * Путь по диагонали между заданными позициями шахматной доски.
     * @param source Исходная позиция фигуры на шахматной доске.
     * @param dest Конечная позиция фигуры на шахматной доске.
     * @return 1. Если исходная и конечная позиции лежат на одной диагонали, то возвращается массив ячеек, лежащих на диагонали между этими позициями (исключая исходную позицию, на которой изначально стоит фигура).<br/>
     *         2. Если исходная и конечная позиции НЕ лежат на одной диагонали (либо совпадают), то возвращается пустой массив ячеек нулевой размерности.
     */
    default Cell[] wayDiagonal(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (source.x != dest.x
            && source.y != dest.y
            && Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y)
        ) {
            steps = new Cell[Math.abs(dest.x - source.x)];
            for (int i = 0; i < steps.length; i++) {
                int x = source.x + (int) Math.signum(dest.x - source.x) * (i + 1);
                int y = source.y + (int) Math.signum(dest.y - source.y) * (i + 1);
                steps[i] = Cell.findByXY(x, y);
            }

        }
        return steps;
    }
}