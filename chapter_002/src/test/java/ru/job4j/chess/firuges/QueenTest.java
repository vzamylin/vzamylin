package ru.job4j.chess.firuges;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
import ru.job4j.chess.firuges.black.QueenBlack;
import ru.job4j.chess.firuges.white.QueenWhite;

/**
 * Тесты для фигуры ферзь.
 * @author vzamylin
 * @version 1
 * @since 27.10.2018
 */
public class QueenTest {

    /**
     * Проверка хода по вертикали.
     */
    @Test
    public void whenWalkingVertically() throws ImpossibleMoveException {
        AbstractQueen queen;
        queen = new QueenBlack(Cell.A8);
        assertThat(
                queen.way(queen.position(), Cell.A1),
                is(new Cell[]{Cell.A7, Cell.A6, Cell.A5, Cell.A4, Cell.A3, Cell.A2, Cell.A1})
        );
        queen = new QueenWhite(Cell.F3);
        assertThat(
                queen.way(queen.position(), Cell.F8),
                is(new Cell[]{Cell.F4, Cell.F5, Cell.F6, Cell.F7, Cell.F8})
        );
    }

    /**
     * Проверка хода по горизонтали.
     */
    @Test
    public void whenWalkingHorizontally() throws ImpossibleMoveException {
        AbstractQueen queen;
        queen = new QueenBlack(Cell.A5);
        assertThat(
                queen.way(queen.position(), Cell.H5),
                is(new Cell[]{Cell.B5, Cell.C5, Cell.D5, Cell.E5, Cell.F5, Cell.G5, Cell.H5})
        );
        queen = new QueenWhite(Cell.E7);
        assertThat(
                queen.way(queen.position(), Cell.A7),
                is(new Cell[]{Cell.D7, Cell.C7, Cell.B7, Cell.A7})
        );
    }

    /**
     * Проверка хода по диагонали.
     */
    @Test
    public void whenWalkingDiagonally() throws ImpossibleMoveException {
        AbstractQueen queen;
        queen = new QueenBlack(Cell.A8);
        assertThat(
                queen.way(queen.position(), Cell.H1),
                is(new Cell[]{Cell.B7, Cell.C6, Cell.D5, Cell.E4, Cell.F3, Cell.G2, Cell.H1})
        );
        queen = new QueenWhite(Cell.F7);
        assertThat(
                queen.way(queen.position(), Cell.C4),
                is(new Cell[]{Cell.E6, Cell.D5, Cell.C4})
        );
    }
}