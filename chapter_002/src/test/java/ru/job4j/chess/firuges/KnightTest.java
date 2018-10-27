package ru.job4j.chess.firuges;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
import ru.job4j.chess.firuges.black.KnightBlack;
import ru.job4j.chess.firuges.white.KnightWhite;

/**
 * Тесты для фигуры конь.
 * @author vzamylin
 * @version 1
 * @since 26.10.2018
 */
public class KnightTest {

    /**
     * Проверка хода буквой «Г» с более длинным перемещением по координате x.
     */
    @Test
    public void whenWalkingLongDeltaX() throws ImpossibleMoveException {
        AbstractKnight knight;
        knight = new KnightBlack(Cell.D7);
        assertThat(knight.way(knight.position(), Cell.F6), is(new Cell[]{Cell.F6}));
        assertThat(knight.way(knight.position(), Cell.B8), is(new Cell[]{Cell.B8}));
        knight = new KnightWhite(Cell.E4);
        assertThat(knight.way(knight.position(), Cell.C3), is(new Cell[]{Cell.C3}));
        assertThat(knight.way(knight.position(), Cell.G5), is(new Cell[]{Cell.G5}));
    }

    /**
     * Проверка хода буквой «Г» с более длинным перемещением по координате y.
     */
    @Test
    public void whenWalkingLongDeltaY() throws ImpossibleMoveException {
        AbstractKnight knight;
        knight = new KnightBlack(Cell.C6);
        assertThat(knight.way(knight.position(), Cell.D4), is(new Cell[]{Cell.D4}));
        assertThat(knight.way(knight.position(), Cell.D8), is(new Cell[]{Cell.D8}));
        knight = new KnightWhite(Cell.B4);
        assertThat(knight.way(knight.position(), Cell.A2), is(new Cell[]{Cell.A2}));
        assertThat(knight.way(knight.position(), Cell.A6), is(new Cell[]{Cell.A6}));
    }
}