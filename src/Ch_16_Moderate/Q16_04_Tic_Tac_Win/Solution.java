package Ch_16_Moderate.Q16_04_Tic_Tac_Win;

import CtCILibrary.AssortedMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        int N = 3;
        int[][] board_t = AssortedMethods.randomMatrix(N, N, 0, 2);
        Piece[][] board = new Piece[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int x = board_t[i][j];
                board[i][j] = convertIntToPiece(x);
            }
        }

        Piece p1 = hasWon(board);

        System.out.println(p1);
        AssortedMethods.printMatrix(board_t);
    }

    private static Piece hasWon(Piece[][] board) {
        List<Piece> horizontal = new ArrayList<>();
        List<Piece> vertical = new ArrayList<>();
        List<Piece> mainDiagonal = new ArrayList<>();
        List<Piece> secondDiagonal = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            mainDiagonal.add(board[i][i]);
            secondDiagonal.add(board[i][board.length - 1 - i]);
            for (int j = 0; j < board.length; j++) {
                horizontal.add(board[i][j]);
                vertical.add(board[j][i]);
            }
            horizontal.add(Piece.Empty);
            vertical.add(Piece.Empty);
        }
        mainDiagonal.add(Piece.Empty);
        secondDiagonal.add(Piece.Empty);
        List<List<Piece>> fullList = List.of(horizontal, vertical, mainDiagonal, secondDiagonal);
        for (List<Piece> pieces : fullList) {
            Piece piece = analiseLine(pieces, board.length);
            if (piece != Piece.Empty) {
                return piece;
            }
        }
        return Piece.Empty;
    }

    private static Piece analiseLine(List<Piece> line, int boardSize) {
        String fullLine = line.stream()
                .map(Enum::toString)
                .collect(Collectors.joining());

        String redLine = IntStream.range(0, boardSize).mapToObj(value -> Piece.Red.toString()).collect(Collectors.joining());
        String blueLine = IntStream.range(0, boardSize).mapToObj(value -> Piece.Blue.toString()).collect(Collectors.joining());
        if (fullLine.contains(redLine)) {
            return Piece.Red;
        } else if (fullLine.contains(blueLine)) {
            return Piece.Blue;
        }
        return Piece.Empty;
    }


    public static Piece convertIntToPiece(int i) {
        if (i == 1) {
            return Piece.Blue;
        } else if (i == 2) {
            return Piece.Red;
        } else {
            return Piece.Empty;
        }
    }

}

enum Piece {
    Blue, Red, Empty
}
