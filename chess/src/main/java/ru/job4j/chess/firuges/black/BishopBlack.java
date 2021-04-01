package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = position.getX() - dest.getX() > 0 ? -1 : 1;
        int deltaY = position.getY() - dest.getY() > 0 ? -1 : 1;
        steps[0] = Cell.findBy(position.getX() + deltaX, position.getY() + deltaY);
        for (int index = 1; index < size; index++) {
            steps[index] = Cell.findBy(steps[index - 1].getX() + deltaX, steps[index - 1].getY() + deltaY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(Math.abs(source.getX()) - Math.abs(dest.getX()))
                == Math.abs(Math.abs(source.getY()) - Math.abs(dest.getY()));
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    public static void main(String[] args) {
        BishopBlack b = new BishopBlack(Cell.C1);
        Cell[] cells = b.way(Cell.G5);
        for (Cell cell : cells) {
            System.out.println(cell);
        }
    }
}
