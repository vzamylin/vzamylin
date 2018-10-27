package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.AbstractRook;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Фигура черная ладья.
 * @author vzamylin
 * @version 1
 * @since 27.10.2018
 */
public class RookBlack extends AbstractRook {

    public RookBlack(final Cell position) {
        super(position);
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }
}