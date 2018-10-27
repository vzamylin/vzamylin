package ru.job4j.chess.firuges;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
import ru.job4j.chess.firuges.black.RookBlack;
import ru.job4j.chess.firuges.white.RookWhite;

/**
 * Тесты для фигуры ладья.
 * @author vzamylin
 * @version 1
 * @since 27.10.2018
 */
public class RookTest {

    /**
     * Проверка хода по вертикали.
     */
    @Test
    public void whenWalkingVertically() throws ImpossibleMoveException {
        AbstractRook rook;
        rook = new RookBlack(Cell.A8);
        assertThat(
                rook.way(rook.position(), Cell.A1),
                is(new Cell[]{Cell.A7, Cell.A6, Cell.A5, Cell.A4, Cell.A3, Cell.A2, Cell.A1})
        );
        rook = new RookWhite(Cell.F3);
        assertThat(
                rook.way(rook.position(), Cell.F8),
                is(new Cell[]{Cell.F4, Cell.F5, Cell.F6, Cell.F7, Cell.F8})
        );
    }

    /**
     * Проверка хода по горизонтали.
     */
    @Test
    public void whenWalkingHorizontally() throws ImpossibleMoveException {
        AbstractRook rook;
        rook = new RookBlack(Cell.A5);
        assertThat(
                rook.way(rook.position(), Cell.H5),
                is(new Cell[]{Cell.B5, Cell.C5, Cell.D5, Cell.E5, Cell.F5, Cell.G5, Cell.H5})
        );
        rook = new RookWhite(Cell.E7);
        assertThat(
                rook.way(rook.position(), Cell.A7),
                is(new Cell[]{Cell.D7, Cell.C7, Cell.B7, Cell.A7})
        );
    }
}