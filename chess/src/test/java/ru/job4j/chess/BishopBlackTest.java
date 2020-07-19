package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BishopBlackTest {

    /**
     * Проверка метода position.
     * Создайте объект и вызовите у него метод position.
     * Проверьте, что он занимает ту же ячейку, что и при создании объекта.
     */
    @Test
    public void position() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.position(),is(Cell.C1));
    }

    /**
     * Проверка метода copy.
     * Создайте объект и вызовите у него метод copy.
     * Проверьте, что, возвращенный объект имеет правильную позицию.
     */
    @Test
    public void copy() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        assertThat(new BishopBlack(Cell.C1).position(),is(bishopBlack.position()));
    }

    /**
     * Для этого создайте объект с начальным положением C1.
     * Вызовите метод way с указанием C1 и G5.
     * Метод должен вернуть массив из 4 клеток. D2, E3, F4, G5.
     */
    @Test
    public void way() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.way(Cell.C1,Cell.G5), is(new Cell[]{ Cell.D2,Cell.E3,Cell.F4,Cell.G5}));
    }
}
