package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.AbstractKing;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Фигура белый король.
 * @author vzamylin
 * @version 1
 * @since 26.10.2018
 */
public class KingWhite extends AbstractKing {

    public KingWhite(final Cell position) {
        super(position);
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingWhite(dest);
    }
}