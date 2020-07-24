package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

/**
 * Этот класс будет проверять, можно двигаться так фигурам или нет.
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    /**
     * он работает от передвижений фигур перетаскиванием, передаёт точку начала и точку окончания
     * потом по точке начала определяется фигура, и через её метод way определяется, может ли она пройти этот путь,
     * поклеточно проверяется,
     * есть ли в точках её пути другие фигуры, если ок,
     * то фигура копируется в новое место, если нет, то ничего не происходит.
     */
    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = this.findBy(source);
        Cell[] steps = this.figures[index].way(source, dest);
        if (!isFree(steps)) {
            throw new OccupiedCellException();
        }
        this.figures[index] = this.figures[index].copy(dest);
    }

    /**
     * в цикле перебрать массива клеток, на каждой итерации кидаем на проверку в метод findBy
     * если вернул значение от 0 и выше - значит клетка занята и мы возвращаем false
     */
    private boolean isFree(Cell[] steps) throws FigureNotFoundException {
        boolean rsl = true;
        for (Cell cell : steps) {
            if (findBy(cell) >= 0) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public void clean() {
        Arrays.fill(this.figures, null);
        this.index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                return index;
            }
        }
        throw new FigureNotFoundException();
    }
}
