package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.AbstractKnight;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Фигура белый конь.
 * @author vzamylin
 * @version 1
 * @since 26.10.2018
 */
public class KnightWhite extends AbstractKnight {

    public KnightWhite(final Cell position) {
        super(position);
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightWhite(dest);
    }
}