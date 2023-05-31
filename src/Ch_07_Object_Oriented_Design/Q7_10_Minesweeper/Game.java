package Ch_07_Object_Oriented_Design.Q7_10_Minesweeper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {

    private GameStatus gameStatus = GameStatus.IN_PLAY;

    public void openCell(Board board, int i, int j) {
        if (i < 0 || i >= board.getnRows() || j < 0 || j >= board.getnColumns() || (board.isInitialized() && !board.getCells()[i][j].isHidden())) {
            System.out.println("Out of range or already open");
            return;
        }
        if (!board.isInitialized()) {
            board.init(i, j);
        }
        Cell cell = board.getCells()[i][j];
        if (cell.isBomb()) {
            System.out.println("You hit the bomb!");
            gameStatus = GameStatus.LOSE;
        }
        if (cell.getCellType() == CellType.NUMBER) {
            cell.setHidden(false);
            System.out.println("Open " + i + " " + j);
            board.printBoard(false);
            board.decreaseNumUnexposedRemaining();
        } else {
            openAllBlankCells(board, cell);
            board.printBoard(false);
        }
    }

    private void openAllBlankCells(Board board, Cell cell) {
        Queue<Cell> cells = new LinkedList<>();
        List<Cell> openedCells = new ArrayList<>();
        cells.add(cell);
        openedCells.add(cell);
        while (!cells.isEmpty()) {
            Cell poll = cells.poll();
            int i = poll.getColumn();
            int j = poll.getRow();
            poll.setHidden(false);
            board.decreaseNumUnexposedRemaining();
            if (poll.isBlank()) {
                checkOtherSpots(board, i, j, cells, openedCells);
            }
        }
    }

    private void checkOtherSpots(Board board, int i, int j, Queue<Cell> cells, List<Cell> openedCells) {
        if (i - 1 >= 0) {
            //checkTop
            checkCellOnBlank(board, i - 1, j, cells, openedCells);
        }
        if (j + 1 < board.getnColumns()) {
            //checkRight
            checkCellOnBlank(board, i, j + 1, cells, openedCells);
        }
        if (i + 1 < board.getnRows()) {
            //checkBottom
            checkCellOnBlank(board, i + 1, j, cells, openedCells);
        }
        if (j - 1 >= 0) {
            //checkLeft
            checkCellOnBlank(board, i, j - 1, cells, openedCells);
        }
    }

    private void checkCellOnBlank(Board board, int i, int j, Queue<Cell> cells, List<Cell> openedCells) {
        Cell cell = board.getCells()[i][j];
        if (!openedCells.contains(cell) && (cell.isBlank() || !cell.isBomb())) {
            cells.add(cell);
            openedCells.add(cell);
        }
    }

    public void playGame() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Set number of rows (>1):");
        int numberOfRows = Integer.parseInt(reader.readLine());

        System.out.println("Set number of columns (>1):");
        int numberOfColumns = Integer.parseInt(reader.readLine());

        int maxNumberOfBombs = (numberOfColumns * numberOfColumns) / 6;
        System.out.println("Set number of bombs (from 1 to " + maxNumberOfBombs + "):");
        int numberOfBombs = Integer.parseInt(reader.readLine());

        Board board = new Board(numberOfRows, numberOfColumns, numberOfBombs);
        board.printInitialBoard();
        while (board.getNumUnexposedRemaining() > 0 && gameStatus != GameStatus.LOSE) {
            System.out.println("NumUnexposedRemaining: " + board.getNumUnexposedRemaining());
            System.out.println("Chose row to open. From:0 To:" + numberOfRows);
            int row = Integer.parseInt(reader.readLine());
            System.out.println("Chose column to open. From:0 To:" + numberOfColumns);
            int column = Integer.parseInt(reader.readLine());
            openCell(board, row, column);
        }
        if (gameStatus != GameStatus.LOSE) {
            System.out.println("You win!");
            board.printBoard(true);
        } else {
            System.out.println("You lose!");
            board.printBoard(true);
        }
    }

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.playGame();
    }
}
