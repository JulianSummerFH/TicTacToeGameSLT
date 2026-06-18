package tictactoe;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean playing = true;
        while (playing) {
            playing = playRound(scanner);
        }
        scanner.close();
    }

    private boolean playRound(Scanner scanner) {
        board.print();
        System.out.println("Current Player: " + currentPlayer.getMarker());
        System.out.print("Enter a number (1-9): ");
        int number = scanner.nextInt();
        int row = (number - 1) / 3;
        int col = (number - 1) % 3;
        if (!board.isCellEmpty(row, col)) {
            System.out.println("Cell is already taken, try again!");
            return true;
        }
        board.place(row, col, currentPlayer.getMarker());
        return checkGameState(scanner);
    }

    private boolean checkGameState(Scanner scanner) {
        if (hasWinner()) {
            board.print();
            System.out.println("Player " + currentPlayer.getMarker() + " wins!");
            return askPlayAgain(scanner);
        } else if (board.isFull()) {
            board.print();
            System.out.println("It's a draw!");
            return askPlayAgain(scanner);
        }
        switchCurrentPlayer();
        return true;
    }

    private boolean askPlayAgain(Scanner scanner) {
        System.out.print("Play again? (y/n): ");
        String answer = scanner.next();
        if (answer.equals("y")) {
            board.clear();
            currentPlayer = player1;
            return true;
        }
        return false;
    }

    private void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    private boolean hasWinner() {
        char[][] c = board.getCells();
        char m = currentPlayer.getMarker();
        for (int i = 0; i < 3; i++) {
            if (c[i][0] == m && c[i][1] == m && c[i][2] == m) {
                return true;
            }
            if (c[0][i] == m && c[1][i] == m && c[2][i] == m) {
                return true;
            }
        }
        return (c[0][0] == m && c[1][1] == m && c[2][2] == m)
                || (c[0][2] == m && c[1][1] == m && c[2][0] == m);
    }
}