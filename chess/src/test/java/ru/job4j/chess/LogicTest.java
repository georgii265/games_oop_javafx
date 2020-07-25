package ru.job4j.chess;


import org.junit.Test;
import ru.job4j.chess.firuges.black.BishopBlack;

import static ru.job4j.chess.firuges.Cell.*;

/**
 *  имитируем ситуацию - клетка куда ходим - занята - мы туда поместили фигуру - соответственно мы получаем исклчение
 *  OccupiedCellException - ячейка занята это унас клетка D2.
 *  FigureNotFoundException - фигуры нет на клетке. это у нас например клетка B2.
 *  ImpossibleMoveException - пользователь двигает фигуру не по правилам шахмат. это например клетка C3.
 */
public class LogicTest {

    @Test(expected = OccupiedCellException.class)
    public void cellIsBusyMove()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(C1));
        logic.add(new BishopBlack(D2));
        logic.move(C1, D2);
    }

    @Test(expected = FigureNotFoundException.class)
    public void noFigureOnTheCageMove()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(C1));
        logic.move(C1, B2);
    }

    @Test(expected =IllegalStateException.class)
    public void notСorrectMove()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(C1));
        logic.move(C1, C3);
    }
}

