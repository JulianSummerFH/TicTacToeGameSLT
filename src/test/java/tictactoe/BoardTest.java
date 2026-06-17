package tictactoe;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void isCellEmpty() {
        assertTrue(board.isCellEmpty(0, 0));
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    void place() {
        board.place(1, 1, 'X');
        assertEquals('X', board.getCells()[1][1]);
    }

    @Test
    void isFull() {
        assertFalse(board.isFull());
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

    @Test
    void clear() {
        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
    }
}