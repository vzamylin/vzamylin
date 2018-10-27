package ru.job4j.chess.firuges;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
import ru.job4j.chess.firuges.black.PawnBlack;
import ru.job4j.chess.firuges.white.PawnWhite;

/**
 * Тесты для фигуры пешка.
 * @author vzamylin
 * @version 1
 * @since 25.10.2018
 */
public class PawnTest {

    /**
     * Проверка хода с начальной позиции.
     */
    @Test
    public void whenWalkingFromInitPosition() throws ImpossibleMoveException {
        AbstractPawn pawn;
        pawn = new PawnBlack(Cell.B7);
        assertThat(pawn.way(pawn.position(), Cell.B5), is(new Cell[]{Cell.B6, Cell.B5}));
        pawn = new PawnWhite(Cell.D2);
        assertThat(pawn.way(pawn.position(), Cell.D3), is(new Cell[]{Cell.D3}));
    }

    /**
     * Проверка хода не с начальной позиции.
     */
    @Test
    public void whenWalkingFromNotInitPosition() throws ImpossibleMoveException {
        AbstractPawn pawn;
        pawn = new PawnBlack(Cell.C6);
        assertThat(pawn.way(pawn.position(), Cell.C5), is(new Cell[]{Cell.C5}));
        pawn = new PawnWhite(Cell.H5);
        assertThat(pawn.way(pawn.position(), Cell.H6), is(new Cell[]{Cell.H6}));
    }
}