package team6.slidingtiles;

/**
 * Super class for MathBoard and NumberBoard
 */

abstract class Board<T> {
    static int TILE_SIDE = 5;
    static int TILE_COUNT = (int)(Math.pow(TILE_SIDE, 2));

    T[][] board;

    Board() {}

    /**
     * Shuffles the Board
     * @param iterations Number of times to shuffle the blank and an adjacent tile
     */
    void shuffle(int iterations, boolean isBlankLast) {
        int direction;
        int blankX = 0;
        int blankY = 0;
        int tileX = 0;
        int tileY = 0;
        if (isBlankLast) {
            blankX = Board.TILE_SIDE - 1;
            blankY = Board.TILE_SIDE - 1;
        }

        // randomly swap blank with adjacent tile, repeat if swap failed
        for (int i = 0; i < iterations; i++) {
            direction = (int)(Math.random() * 4);
            // 0 = up, 1 = right, 2 = down, 3 = left
            switch (direction) {
                case 0:
                    tileY = blankY - 1;
                    tileX = blankX;
                    break;
                case 1:
                    tileY = blankY;
                    tileX = blankX + 1;
                    break;
                case 2:
                    tileY = blankY + 1;
                    tileX = blankX;
                    break;
                case 3:
                    tileY = blankY;
                    tileX = blankX - 1;
                    break;
            }

            // Swap. If it actually worked, update blank coordinates. Otherwise, do it again.
            if (swapTiles(blankX, blankY, tileX, tileY)) {
                blankX = tileX;
                blankY = tileY;
            } else {
                --i;
            }
        }
    }

    /**
     * Swaps two tiles on the board (if possible)
     * @param tile1X first tile's x-coordinate
     * @param tile1Y first tile's y-coordinate
     * @param tile2X second tile's x-coordinate
     * @param tile2Y second tile's y-coordinate
     * @return true if the move was legal and completed, false if the move was illegal and not completed
     */
    boolean swapTiles(int tile1X, int tile1Y, int tile2X, int tile2Y) {
        // ensure one of the supplied tile locations is blank
        if (this.board[tile1Y][tile1X] != this.getBlank() &&
            this.board[tile2Y][tile2X] != this.getBlank()) {
            return false;
        }

        // ensure both tiles are on the board
        if (tile1X >= 0 && tile1X < Board.TILE_SIDE &&
                tile1Y >= 0 && tile1Y < Board.TILE_SIDE &&
                tile2X >= 0 && tile2X < Board.TILE_SIDE &&
                tile2Y >= 0 && tile2Y < Board.TILE_SIDE) {
            int xDiff = Math.abs(tile1X - tile2X);
            int yDiff = Math.abs(tile1Y - tile2Y);

            // ensure Manhattan distance between tiles is exactly one, then swap
            if (xDiff + yDiff == 1) {
                T temp = this.board[tile1Y][tile1X];
                this.board[tile1Y][tile1X] = this.board[tile2Y][tile2X];
                this.board[tile2Y][tile2X] = temp;
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the current board configuration
     * @return the board
     */
    T[][] getBoard() {
        return this.board;
    }

    /**
     * Get the blank tile representation
     */
    abstract T getBlank();

}
