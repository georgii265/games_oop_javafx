package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * Движение слона происходит по диагонали.
     * Мы знаем начальную и конечную точку движения фигуры.
     * По этим координатам мы можем понять, движется ли слон по диагонали.
     * Если он находится на диагонали, то мы можем вычислить дельты шагов.
     * Слон может двигаться в четыре стороны. Эти движения можно описать двумя дельтами +1 -1.
     * Например, если слон двигается вниз влево, то дельты будут -1 -1.
     */
    @Override
    // Cell source - это начальная клетка а Cell dest это конечная клетка
    public Cell[] way(Cell source, Cell dest) { //этот метод расчитывает путь движения слона
        if (!isDiagonal(source, dest)) { // Если условие имеет значение true, то оператор логического «НЕ» будет делать false
        throw new IllegalStateException(
                String.format("Could not way by diagonal from %s to %s", source, dest)
        );
    }
        int size =  //Если он находится на диагонали, то мы можем вычислить дельты шагов.
        Cell[] steps = new Cell[size];
        int deltaX =  -1; //если слон двигается вниз влево, то дельты будут -1 -1.
        int deltaY =  -1;
        for (int index = 0; index < size; index++) {
            int x = // вычислить ячейку через index + deltaX
            int y = // вычистить ячейку через index + deltaY
             steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
