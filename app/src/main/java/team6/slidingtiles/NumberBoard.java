package team6.slidingtiles;

/**
 * This class represents the number-based tile board.
 */

public class NumberBoard extends Board<Integer> {
    private final Integer BLANK = 0;

    /**
     * Default NumberBoard constructor
     */
    NumberBoard() {
        this(true, 3);
    }

    /**
     * NumberBoard constructor
     * @param isBlankLast If true, the last space on the board will be blank,
     *                     otherwise the first space will be blank.
     * @param difficulty   Difficulty level to initialize the board 1+, 1 easiest
     */
    NumberBoard(boolean isBlankLast, int difficulty) {
        // difficulty must be >= 1, or no tiles will be out of place
        if (difficulty < 1) {
            throw new RuntimeException("Difficulty must be >= 1");
        }

        // create the board in a winning configuration
        this.board = new Integer[Board.TILE_SIDE][Board.TILE_SIDE];
        int diff = isBlankLast ? 1 : 0;
        for (int i = 0; i < Board.TILE_COUNT; i++) {
            this.board[i / Board.TILE_SIDE][i % Board.TILE_SIDE] = i + diff;
        }

        // add blank tile
        if (isBlankLast) {
            this.board[Board.TILE_SIDE - 1][Board.TILE_SIDE - 1] = this.BLANK;
        } else {
            this.board[0][0] = this.BLANK;
        }

        // shuffle the board per the difficulty setting (square of difficulty level)
        int shuffles = (int)(Math.pow(difficulty, 2));
        shuffle(shuffles, isBlankLast);
    }

    /**
     * Check if the board is complete/done
     * @return true if the board is complete, false otherwise
     */
    public boolean isComplete() {
        // blank tile is first
        if (this.board[0][0].equals(this.BLANK)) {
            for (int i = 1; i < Board.TILE_COUNT; i++) {
                if (this.board[i / Board.TILE_SIDE][i % Board.TILE_SIDE] != i) {
                    return false;
                }
            }
            return true;
        // blank tile is last
        } else if (this.board[Board.TILE_SIDE - 1][Board.TILE_SIDE - 1].equals(this.BLANK)) {
            for (int i = 0; i < Board.TILE_COUNT - 1; i++) {
                if (this.board[i / Board.TILE_SIDE][i % Board.TILE_SIDE] != i + 1) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get the blank tile representation
     * @return blank tile Integer
     */
    Integer getBlank() {
        return this.BLANK;
    }

}
