package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.AbstractKnight;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Фигура черный конь.
 * @author vzamylin
 * @version 1
 * @since 26.10.2018
 */
public class KnightBlack extends AbstractKnight {

    public KnightBlack(final Cell position) {
        super(position);
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }
}