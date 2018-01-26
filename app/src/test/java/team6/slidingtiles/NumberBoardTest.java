package team6.slidingtiles;

import org.junit.Test;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * NumberBoard unit tests
 */
public class NumberBoardTest {
    @Test
    @SuppressWarnings("unchecked")
    public void boardShuffledContainsAllNumbers() {
        NumberBoard test = new NumberBoard(true, 10);
        Integer[][] board = test.getBoard();
        Set actual = new HashSet();
        Set expect = new HashSet();
        for (int i = 0; i < 25; i++) {
            expect.add(i);
        }
        for (int i = 0; i < 5; i++) {
            actual.addAll(Arrays.asList(board[i]).subList(0, 5));
        }
        assertEquals(5, board.length);
        assertEquals(5, board[0].length);
        assertTrue(actual.containsAll(expect));
    }
}