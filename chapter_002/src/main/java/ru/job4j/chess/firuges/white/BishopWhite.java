package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.AbstractBishop;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Фигура белый слон.
 * @author vzamylin
 * @version 1
 * @since 17.10.2018
 */
public class BishopWhite extends AbstractBishop {

    public BishopWhite(final Cell position) {
        super(position);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}