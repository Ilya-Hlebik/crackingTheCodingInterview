package Ch_07_Object_Oriented_Design.Q7_10_Minesweeper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Board {
    private int nRows;
    private int nColumns;
    private int nBombs = 0;
    private Cell[][] cells;
    private final List<Cell> shuffledCells = new ArrayList<>();
    private int numUnexposedRemaining;
    private boolean initialized;

    public Board(int nRows, int nColumns, int nBombs) {
        this.nRows = nRows;
        this.nColumns = nColumns;
        this.nBombs = nBombs;
        numUnexposedRemaining = nRows * nColumns - nBombs;
    }

    public void init(int i, int j){
        initializeBoard();
        shuffleBoard(i, j);
        setNumberedCells();
        initialized = true;
    }

    private void setNumberedCells() {
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nColumns; j++) {
                Cell cell = cells[i][j];
                if (cell.isBomb()) {
                    continue;
                }
                int numberOfBombsAround = numberOfBombsAround(i, j);
                if (numberOfBombsAround > 0) {
                    cell.setCellType(CellType.NUMBER);
                    cell.setNumber(numberOfBombsAround);
                }
            }
        }
    }

    private int numberOfBombsAround(int i, int j) {
        int numberOfBombs = 0;
        if (i - 1 >= 0 && j - 1 >= 0) {
            //checkTopLeftDiagonal
            numberOfBombs = updateNumberOfBombs(numberOfBombs, i - 1, j - 1);
        }
        if (i - 1 >= 0) {
            //checkTop
            numberOfBombs = updateNumberOfBombs(numberOfBombs, i - 1, j);
        }
        if (i - 1 >= 0 && j + 1 < nColumns) {
            //checkTopRightDiagonal
            numberOfBombs = updateNumberOfBombs(numberOfBombs, i - 1, j + 1);
        }
        if (j + 1 < nColumns) {
            //checkRight
            numberOfBombs = updateNumberOfBombs(numberOfBombs, i, j + 1);
        }
        if (i + 1 < nRows && j + 1 < nColumns) {
            //checkBottomRightDiagonal
            numberOfBombs = updateNumberOfBombs(numberOfBombs, i + 1, j + 1);
        }
        if (i + 1 < nRows) {
            //checkBottom
            numberOfBombs = updateNumberOfBombs(numberOfBombs, i + 1, j);
        }
        if (i + 1 < nRows && j - 1 >= 0) {
            //checkLeftBottomDiagonal
            numberOfBombs = updateNumberOfBombs(numberOfBombs, i + 1, j - 1);
        }
        if (j - 1 >= 0) {
            //checkLeft
            numberOfBombs = updateNumberOfBombs(numberOfBombs, i, j - 1);
        }
        return numberOfBombs;
    }

    private int updateNumberOfBombs(int numberOfBombs, int i, int j) {
        Cell cell = cells[i][j];
        if (cell.isBomb()) {
            numberOfBombs++;
        }
        return numberOfBombs;
    }

    private void shuffleBoard(int rowToEscape, int columnToEscape) {
        do {
            Collections.shuffle(shuffledCells);
        } while (shuffledCells.get(rowToEscape * nRows + columnToEscape).isBomb());
        Iterator<Cell> iterator = shuffledCells.iterator();
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nColumns; j++) {
                cells[i][j] = iterator.next(); //?
                cells[i][j].setColumn(i);
                cells[i][j].setRow(j);
            }
        }
    }

    private void initializeBoard() {
        cells = new Cell[nRows][nColumns];
        int tempBombs = 0;
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nColumns; j++) {
                if (tempBombs != nBombs) {
                    shuffledCells.add(new Cell(i, j, CellType.BOMB));
                    tempBombs++;
                } else {
                    shuffledCells.add(new Cell(i, j, CellType.BLANK));
                }
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

    public void printBoard(boolean showUnderside) {
        System.out.println();
        System.out.print("   ");
        for (int i = 0; i < nColumns; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < nColumns; i++) {
            System.out.print("--");
        }
        System.out.println();
        for (int r = 0; r < nRows; r++) {
            System.out.print(r + "| ");
            for (int c = 0; c < nColumns; c++) {
                if (showUnderside) {
                    System.out.print(cells[r][c].getUndersideState());
                } else {
                    System.out.print(cells[r][c].getSurfaceState());
                }
            }
            System.out.println();
        }
    }

    public void printInitialBoard() {
        System.out.println();
        System.out.print("   ");
        for (int i = 0; i < nColumns; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < nColumns; i++) {
            System.out.print("--");
        }
        System.out.println();
        for (int r = 0; r < nRows; r++) {
            System.out.print(r + "| ");
            for (int c = 0; c < nColumns; c++) {
                System.out.print("? ");
            }
            System.out.println();
        }
    }

    public int getNumUnexposedRemaining() {
        return numUnexposedRemaining;
    }

    public void decreaseNumUnexposedRemaining() {
        numUnexposedRemaining--;
    }

    public boolean isInitialized() {
        return initialized;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }
}
