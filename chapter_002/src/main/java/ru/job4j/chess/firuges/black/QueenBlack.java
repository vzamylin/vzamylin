package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.AbstractQueen;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Фигура черный ферзь.
 * @author vzamylin
 * @version 1
 * @since 27.10.2018
 */
public class QueenBlack extends AbstractQueen {

    public QueenBlack(final Cell position) {
        super(position);
    }

    @Override
    public Figure copy(Cell dest) {
        return new QueenBlack(dest);
    }
}