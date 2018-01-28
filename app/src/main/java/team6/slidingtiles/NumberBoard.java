package team6.slidingtiles;

/**
 * This class represents the number-based tile board.
 */

public class NumberBoard extends Board {

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
        this.board = new String[Board.TILE_SIDE][Board.TILE_SIDE];
        int diff = isBlankLast ? 1 : 0;
        for (int i = 0; i < Board.TILE_COUNT; i++) {
            this.board[i / Board.TILE_SIDE][i % Board.TILE_SIDE] = Integer.toString(i + diff);
        }

        // add blank tile
        if (isBlankLast) {
            this.blankX = Board.TILE_SIDE - 1;
            this.blankY = Board.TILE_SIDE - 1;
        } else {
            this.blankX = 0;
            this.blankY = 0;
        }
        this.board[this.blankY][this.blankX] = Board.BLANK;

        // shuffle the board per the difficulty setting (square of difficulty level)
        int shuffles = (int)(Math.pow(difficulty, 2));
        shuffle(shuffles);
    }

    /**
     * Check if the board is complete/done
     * @return true if the board is complete, false otherwise
     */
    public boolean isComplete() {
        // blank tile is first
        if (this.board[0][0].equals(Board.BLANK)) {
            for (int i = 1; i < Board.TILE_COUNT; i++) {
                if (!this.board[i / Board.TILE_SIDE][i % Board.TILE_SIDE].equals(Integer.toString(i))) {
                    return false;
                }
            }
            return true;
        // blank tile is last
        } else if (this.board[Board.TILE_SIDE - 1][Board.TILE_SIDE - 1].equals(Board.BLANK)) {
            for (int i = 0; i < Board.TILE_COUNT - 1; i++) {
                if (!this.board[i / Board.TILE_SIDE][i % Board.TILE_SIDE].equals(Integer.toString(i + 1))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

}
