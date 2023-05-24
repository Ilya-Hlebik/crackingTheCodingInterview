package Ch_07_Object_Oriented_Design.Q7_10_Minesweeper;

import java.util.Collections;
import java.util.List;

public class Board {
    private int nRows;
    private int nColumns;
    private int nBombs = 0;
    private Cell[][] cells;
    private List<Cell> shuffledCells;
    private int numUnexposedRemaining;

    public Board(int nRows, int nColumns, int nBombs) {
        this.nRows = nRows;
        this.nColumns = nColumns;
        this.nBombs = nBombs;

        initializeBoard();
        shuffleBoard();
        setNumberedCells();

        numUnexposedRemaining = nRows * nColumns - nBombs;
    }

    private void setNumberedCells() {

    }

    private void shuffleBoard() {
        Collections.shuffle(shuffledCells);
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nColumns; j++) {
                cells[i][j] = shuffledCells.iterator().next(); //?
            }
        }
    }

    private void initializeBoard() {
        cells = new Cell[nRows][nColumns];
        int tempBombs = 0;
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nColumns; j++) {
                if (tempBombs != nBombs) {
                    cells[i][j] = new Cell(i, j, CellType.BOMB);
                    tempBombs++;
                } else {
                    cells[i][j] = new Cell(i, j, CellType.BLANK);
                }
                shuffledCells.add(cells[i][j]);
            }
        }
    }

    public int getnRows() {
        return nRows;
    }

    public void setnRows(int nRows) {
        this.nRows = nRows;
    }

    public int getnColumns() {
        return nColumns;
    }

    public void setnColumns(int nColumns) {
        this.nColumns = nColumns;
    }

    public int getnBombs() {
        return nBombs;
    }

    public void setnBombs(int nBombs) {
        this.nBombs = nBombs;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}
