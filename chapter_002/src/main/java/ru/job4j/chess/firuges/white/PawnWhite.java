package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.AbstractPawn;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Фигура белая пешка.
 * @author vzamylin
 * @version 1
 * @since 19.10.2018
 */
public class PawnWhite extends AbstractPawn {

    public PawnWhite(final Cell position) {
        super(position);
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnWhite(dest);
    }
}