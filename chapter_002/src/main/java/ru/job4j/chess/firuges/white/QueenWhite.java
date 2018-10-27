package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.AbstractQueen;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Фигура белый ферзь.
 * @author vzamylin
 * @version 1
 * @since 27.10.2018
 */
public class QueenWhite extends AbstractQueen {

    public QueenWhite(final Cell position) {
        super(position);
    }

    @Override
    public Figure copy(Cell dest) {
        return new QueenWhite(dest);
    }
}