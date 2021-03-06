package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.AbstractPawn;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Фигура черная пешка.
 * @author vzamylin
 * @version 1
 * @since 19.10.2018
 */
public class PawnBlack extends AbstractPawn {

    public PawnBlack(final Cell position) {
        super(position);
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }
}