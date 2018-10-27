package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.AbstractKing;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Фигура черный король.
 * @author vzamylin
 * @version 1
 * @since 26.10.2018
 */
public class KingBlack extends AbstractKing {

    public KingBlack(final Cell position) {
        super(position);
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingBlack(dest);
    }
}