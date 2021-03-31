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
        String res = "";
        for (Cell c : cells) {
            res += "" + c.getX() + c.getY();
        }
        assertEquals(res, "" + Cell.D2.getX() + Cell.D2.getY() + Cell.E3.getX() + Cell.E3.getY() + Cell.F4.getX() + Cell.F4.getY() + Cell.G5.getX() + Cell.G5.getY());
    }

    @Test
    public void isDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        boolean res = bishopBlack.isDiagonal(Cell.G5, Cell.G6);
        assertEquals(res, false);
    }
}