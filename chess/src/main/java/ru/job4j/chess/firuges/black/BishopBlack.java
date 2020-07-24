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
     *
     *
     * Пользователь может перетащить слона на клетку, которая отличается от диагонали.
     * В этом случае наш код не будет работать. Давайте добавим в метод BishopBlack проверку.
     *  if (!isDiagonal(source, dest)) //оператор логического «НЕ» будет делать false
     */
    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
        throw new IllegalStateException(
                String.format("Could not way by diagonal from %s to %s", source, dest)
        );
    }
        int size = Math.abs(dest.getX() - source.getX());
        Cell[] steps = new Cell[size];
        int deltaX = source.getX() < dest.getX() ? 1 : -1;
        int deltaY = source.getY() < dest.getY() ? 1 : -1;
        int x = source.getX();
        int y = source.getY();
        for (int index = 0; index < size; index++) {
            x += deltaX;
            y += deltaY; //int y = deltaY * (index + 1) + source.getY();
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return (Math.abs(dest.getX() - source.getX()) == Math.abs(dest.getY() - source.getY()));
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
