package ru.job4j.chess.firuges;

import org.junit.Test;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.BishopWhite;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты для фигуры слон.
 * @author vzamylin
 * @version 1
 * @since 19.10.2018
 */
public class BishopTest {

    /**
     * Проверка хода вверх влево.
     */
    @Test
    public void whenWalkingUpLeft() throws ImpossibleMoveException {
        AbstractBishop bishop;
        // Черный слон
        bishop = new BishopBlack(Cell.C8);
        assertThat(bishop.way(bishop.position(), Cell.A6), is(new Cell[]{Cell.B7, Cell.A6}));
        // Белый слон
        bishop = new BishopWhite(Cell.H8);
        assertThat(bishop.way(bishop.position(), Cell.A1), is(new Cell[]{Cell.G7, Cell.F6, Cell.E5, Cell.D4, Cell.C3, Cell.B2, Cell.A1}));
    }

    /**
     * Проверка хода вверх вправо.
     */
    @Test
    public void whenWalkingUpRight() throws ImpossibleMoveException {
        AbstractBishop bishop;
        // Черный слон
        bishop = new BishopBlack(Cell.A8);
        assertThat(bishop.way(bishop.position(), Cell.B7), is(new Cell[]{Cell.B7}));
        // Белый слон
        bishop = new BishopWhite(Cell.C7);
        assertThat(bishop.way(bishop.position(), Cell.F4), is(new Cell[]{Cell.D6, Cell.E5, Cell.F4}));
    }

    /**
     * Проверка хода вниз влево.
     */
    @Test
    public void whenWalkingDownLeft() throws ImpossibleMoveException {
        AbstractBishop bishop;
        // Черный слон
        bishop = new BishopBlack(Cell.G1);
        assertThat(bishop.way(bishop.position(), Cell.A7), is(new Cell[]{Cell.F2, Cell.E3, Cell.D4, Cell.C5, Cell.B6, Cell.A7}));
        // Белый слон
        bishop = new BishopWhite(Cell.F6);
        assertThat(bishop.way(bishop.position(), Cell.D8), is(new Cell[]{Cell.E7, Cell.D8}));
    }

    /**
     * Проверка хода вниз вправо.
     */
    @Test
    public void whenWalkingDownRight() throws ImpossibleMoveException {
        AbstractBishop bishop;
        // Черный слон
        bishop = new BishopBlack(Cell.A1);
        assertThat(bishop.way(bishop.position(), Cell.H8), is(new Cell[]{Cell.B2, Cell.C3, Cell.D4, Cell.E5, Cell.F6, Cell.G7, Cell.H8}));
        // Белый слон
        bishop = new BishopWhite(Cell.D3);
        assertThat(bishop.way(bishop.position(), Cell.G6), is(new Cell[]{Cell.E4, Cell.F5, Cell.G6}));
    }
}