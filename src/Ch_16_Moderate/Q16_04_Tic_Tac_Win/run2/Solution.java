package Ch_16_Moderate.Q16_04_Tic_Tac_Win.run2;

import CtCILibrary.AssortedMethods;

public class Solution {
    public static void main(String[] args) {
        int N = 3;
        int[][] board_t = AssortedMethods.randomMatrix(N, N, 0, 2);
        AssortedMethods.printMatrix(board_t);
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
        for (int i = 0; i < board.length; i++) {
            boolean allEqualsHorizontal = true;
            boolean allEqualsVertical = true;
            Piece currentHorizontal = null;
            Piece currentVertical = null;
            for (int j = 0; j < board[board.length - 1].length; j++) {
                if (currentHorizontal == null) {
                    currentHorizontal = board[i][j];
                } else if (!currentHorizontal.equals(board[i][j]) || board[i][j] == Piece.Empty) {
                    allEqualsHorizontal = false;
                }
                if (currentVertical == null) {
                    currentVertical = board[j][i];
                } else if (!currentVertical.equals(board[j][i]) || board[j][i] == Piece.Empty) {
                    allEqualsVertical = false;
                }
            }
            if (allEqualsHorizontal) {
                return currentHorizontal;
            }
            if (allEqualsVertical) {
                return currentHorizontal;
            }
        }
        Piece currentMain = null;
        boolean allEqualsMain = true;

        for (int i = 0; i < board.length; i++) {
            if (currentMain == null) {
                currentMain = board[i][i];

            } else if (!currentMain.equals(board[i][i]) || board[i][i] == Piece.Empty) {
                allEqualsMain = false;
                break;
            }
        }
        if (allEqualsMain) {
            return currentMain;
        }
        boolean allEqualsSecond = true;
        Piece currentSecond = null;
        for (int i = 0, j = board.length - 1; i < board.length; i++, j--) {
            if (currentSecond == null) {
                currentSecond = board[i][j];
            } else if (!currentMain.equals(board[i][j]) || board[i][j] == Piece.Empty) {
                allEqualsSecond = false;
                break;
            }
        }
        if (allEqualsSecond) {
            return currentMain;
        }


        return null;
    }

    private static Piece convertIntToPiece(int x) {
        switch (x) {
            case 0:
                return Piece.Empty;
            case 1:
                return Piece.Red;
            case 2:
                return Piece.Blue;
            default:
                throw new RuntimeException();
        }
    }
}


    enum Piece {
        Blue, Red, Empty
    }

