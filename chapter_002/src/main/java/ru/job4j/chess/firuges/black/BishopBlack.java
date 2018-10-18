package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.AbstractBishop;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Фигура черный слон.
 * @author vzamylin
 * @version 1
 * @since 17.10.2018
 */
public class BishopBlack extends AbstractBishop {

    public BishopBlack(final Cell position) {
        super(position);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}