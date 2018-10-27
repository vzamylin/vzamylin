package ru.job4j.chess.firuges;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
import ru.job4j.chess.firuges.black.KingBlack;
import ru.job4j.chess.firuges.white.KingWhite;

/**
 * Тесты для фигуры король.
 * @author vzamylin
 * @version 1
 * @since 26.10.2018
 */
public class KingTest {

    /**
     * Проверка хода по диагонали.
     */
    @Test
    public void whenWalkingDiagonally() throws ImpossibleMoveException {
        AbstractKing king;
        king = new KingBlack(Cell.F6);
        assertThat(king.way(king.position(), Cell.E5), is(new Cell[]{Cell.E5}));
        assertThat(king.way(king.position(), Cell.G5), is(new Cell[]{Cell.G5}));
        king = new KingWhite(Cell.E1);
        assertThat(king.way(king.position(), Cell.D2), is(new Cell[]{Cell.D2}));
        assertThat(king.way(king.position(), Cell.F2), is(new Cell[]{Cell.F2}));
    }

    /**
     * Проверка хода по прямой.
     */
    @Test
    public void whenWalkingLine() throws ImpossibleMoveException {
        AbstractKing king;
        king = new KingBlack(Cell.E7);
        assertThat(king.way(king.position(), Cell.E6), is(new Cell[]{Cell.E6}));
        assertThat(king.way(king.position(), Cell.F7), is(new Cell[]{Cell.F7}));
        king = new KingWhite(Cell.F1);
        assertThat(king.way(king.position(), Cell.F2), is(new Cell[]{Cell.F2}));
        assertThat(king.way(king.position(), Cell.E1), is(new Cell[]{Cell.E1}));
    }
}