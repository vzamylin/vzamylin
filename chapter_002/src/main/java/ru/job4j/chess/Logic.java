package ru.job4j.chess;

import ru.job4j.chess.firuges.*;


/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public void move(Cell source, Cell dest) throws FigureNotFoundException, ImpossibleMoveException, OccupiedWayException {
        int index = this.findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException("В выбранной клетке нет фигуры!");
        }
        Cell[] steps = this.figures[index].way(source, dest);
        if (!(steps.length > 0 && steps[steps.length - 1].equals(dest))) {
            throw new ImpossibleMoveException("Фигура не может пойти на указанную клетку!");
        }
        for (Cell step : steps) {
            if (this.findBy(step) != -1) {
                throw new OccupiedWayException("Выбранный путь фигуры занят другими фигурами!");
            }
        }
        this.figures[index] = this.figures[index].copy(dest);
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}