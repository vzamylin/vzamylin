package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.AbstractRook;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Фигура белая ладья.
 * @author vzamylin
 * @version 1
 * @since 27.10.2018
 */
public class RookWhite extends AbstractRook {

    public RookWhite(final Cell position) {
        super(position);
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookWhite(dest);
    }
}