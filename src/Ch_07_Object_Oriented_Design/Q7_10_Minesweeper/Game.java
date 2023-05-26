package Ch_07_Object_Oriented_Design.Q7_10_Minesweeper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

    private GameStatus gameStatus = GameStatus.IN_PLAY;

    public void openCell(Board board, int i, int j) {
        if (i < 0 || i >= board.getnRows() || j < 0 || j >= board.getnColumns() || !board.getCells()[i][j].isHidden()) {
            System.out.println("Out of range or already open");
            return;
        }
        Cell cell = board.getCells()[i][j];
        if (cell.isBomb()) {
            System.out.println("You hit the bomb!");
            board.printBoard(true);
            gameStatus = GameStatus.LOSE;
        }
        if (cell.getCellType() == CellType.NUMBER) {
            cell.setHidden(false);
            board.printBoard(true);
            board.decreaseNumUnexposedRemaining();
        } else {
            openAllBlankCells(board, i, j);
        }
    }

    private void openAllBlankCells(Board board, int i, int j) {

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
        board.printBoard(true);

        while (board.getNumUnexposedRemaining() > 0 && gameStatus != GameStatus.LOSE) {
            System.out.println("Chose row to open. From:0 To:" + numberOfRows);
            int row = Integer.parseInt(reader.readLine());
            System.out.println("Chose column to open. From:0 To:" + numberOfColumns);
            int column = Integer.parseInt(reader.readLine());
            openCell(board, row, column);
        }
        if (gameStatus == GameStatus.WIN) {
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
