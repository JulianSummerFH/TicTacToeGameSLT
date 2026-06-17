package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void hasWinnerRow() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(0, 2, 'X');
        assertEquals('X', board.getCells()[0][0]);
        assertEquals('X', board.getCells()[0][1]);
        assertEquals('X', board.getCells()[0][2]);
    }

    @Test
    void hasWinnerColumn() {
        board.place(0, 0, 'O');
        board.place(1, 0, 'O');
        board.place(2, 0, 'O');
        assertEquals('O', board.getCells()[0][0]);
        assertEquals('O', board.getCells()[1][0]);
        assertEquals('O', board.getCells()[2][0]);
    }

    @Test
    void hasWinnerDiagonal() {
        board.place(0, 0, 'X');
        board.place(1, 1, 'X');
        board.place(2, 2, 'X');
        assertEquals('X', board.getCells()[0][0]);
        assertEquals('X', board.getCells()[1][1]);
        assertEquals('X', board.getCells()[2][2]);
    }

    @Test
    void isDraw() {
        char[] markers = {'X', 'O'};
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, markers[count % 2]);
                count++;
            }
        }
        assertTrue(board.isFull());
    }
}