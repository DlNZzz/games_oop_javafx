package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.assertEquals;

public class BishopBlackTest {

    @Test
    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Cell cell = bishopBlack.position();
        assertEquals(cell.getX() + cell.getY(), Cell.F8.getX() + Cell.F8.getY());
    }

    @Test
    public void testCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        Figure figure = bishopBlack.copy(Cell.F8);
        assertEquals(figure.position().getX() + figure.position().getY(), Cell.F8.getX() + Cell.F8.getY());
    }

    @Test
    public void testWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] cells = bishopBlack.way(Cell.G5);
        Cell[] actual = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertEquals(cells, actual);
    }

    @Test
    public void isDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        boolean res = bishopBlack.isDiagonal(Cell.G5, Cell.G6);
        assertEquals(res, false);
    }
}