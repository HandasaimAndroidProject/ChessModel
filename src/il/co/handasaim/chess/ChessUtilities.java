package il.co.handasaim.chess;

import java.util.List;

/**
 * The representation of a chess board using a string is as follows:
 * The first character is either w (white) or b (black) to denote current player, followed by a new line character.
 * The next four lines represent the board. Each line will have 8 characters followed by a new line character.
 * The character have the following meaning:
 * A space means an empty cell.
 * An uppercase means white, lowercase means black.
 * K - king, Q - queen, B - bishop, R - rook, N - knight, P - pawn
 */
public class ChessUtilities {
    /**
     * Returns a list of possible moves
     * @param state A string representation of a current game state
     * @return A list of boards in string representation
     */
    public List<String> getNextStates(String state) {
        return null;
    }
}
