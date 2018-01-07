package il.co.handasaim.chess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChessUtilitiesTest {

    @Test
    void testNextStatesPawnTwoStep() {
        String startPosition = "w\n" +
                "rnbqkbnr\n" +
                "pppppppp\n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "PPPPPPPP\n" +
                "RNBQKBNR\n";
        String secondPosition = "b\n" +
                "rnbqkbnr\n" +
                "pppppppp\n" +
                "        \n" +
                "        \n" +
                "    P   \n" +
                "        \n" +
                "PPPP PPP\n" +
                "RNBQKBNR\n";

        List<String> states = new ChessUtilities().getNextStates(startPosition);

        Assertions.assertTrue(states.contains(secondPosition));
    }

    @Test
    void testNextStatesPawnOneStep() {
        String startPosition = "w\n" +
                "rnbqkbnr\n" +
                "pppppppp\n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "PPPPPPPP\n" +
                "RNBQKBNR\n";
        String secondPosition = "b\n" +
                "rnbqkbnr\n" +
                "pppppppp\n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "P       \n" +
                " PPPPPPP\n" +
                "RNBQKBNR\n";

        List<String> states = new ChessUtilities().getNextStates(startPosition);

        Assertions.assertTrue(states.contains(secondPosition));
    }

    @Test
    void testNextStatesKnight() {
        String startPosition = "w\n" +
                "rnbqkbnr\n" +
                "pppppppp\n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "     K  \n" +
                "PPPPPPPP\n" +
                "RNBQ BNR\n";
        String state1 = "b\n" +
                "rnbqkbnr\n" +
                "pppppppp\n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "PPPPPPPP\n" +
                "RNBQKBNR\n";
        String state2 = "b\n" +
                "rnbqkbnr\n" +
                "pppppppp\n" +
                "        \n" +
                "        \n" +
                "   K    \n" +
                "        \n" +
                "PPPPPPPP\n" +
                "RNBQ BNR\n";

        List<String> states = new ChessUtilities().getNextStates(startPosition);

        Assertions.assertTrue(states.contains(state1));
        Assertions.assertTrue(states.contains(state2));
    }


    @Test
    void testNextStatesQueenEats() {
        String startPosition = "b\n" +
                "rnb kbnr\n" +
                "pppp ppp\n" +
                "        \n" +
                "    p q \n" +
                "        \n" +
                "        \n" +
                "PPPPPPPP\n" +
                "RNBQKBNR\n";
        String state1 = "w\n" +
                "rnb kbnr\n" +
                "pppp ppp\n" +
                "        \n" +
                "    p q \n" +
                "        \n" +
                "        \n" +
                "PPPPPPqP\n" +
                "RNBQKBNR\n";
        String state2 = "w\n" +
                "rnb kbnr\n" +
                "pppp ppp\n" +
                "        \n" +
                "    p q \n" +
                "        \n" +
                "        \n" +
                "PPPqPPPP\n" +
                "RNBQKBNR\n";

        List<String> states = new ChessUtilities().getNextStates(startPosition);

        Assertions.assertTrue(states.contains(state1));
        Assertions.assertTrue(states.contains(state2));
    }


    @Test
    void testNextStatesPawnEats() {
        String startPosition = "w\n" +
                "rnbq bnr\n" +
                "ppppkppp\n" +
                "        \n" +
                "    p   \n" +
                "    PP  \n" +
                "        \n" +
                "PPPP  PP\n" +
                "RNBQKBNR\n";
        String validState = "b\n" +
                "rnbq bnr\n" +
                "ppppkppp\n" +
                "        \n" +
                "    P   \n" +
                "    P   \n" +
                "        \n" +
                "PPPP  PP\n" +
                "RNBQKBNR\n";
        String invalidState = "b\n" +
                "rnbq bnr\n" +
                "ppppkppp\n" +
                "        \n" +
                "    P   \n" +
                "     P  \n" +
                "        \n" +
                "PPPP  PP\n" +
                "RNBQKBNR\n";
        String invalidState2 = "b\n" +
                "rnbq bnr\n" +
                "ppppkppp\n" +
                "        \n" +
                "    p   \n" +
                "     P  \n" +
                "    P   \n" +
                "PPPP  PP\n" +
                "RNBQKBNR\n";

        List<String> states = new ChessUtilities().getNextStates(startPosition);

        Assertions.assertTrue(states.contains(validState));
        Assertions.assertFalse(states.contains(invalidState));
        Assertions.assertFalse(states.contains(invalidState2));
    }

    @Test
    void testNextStatesCheck() {
        String startPosition = "w\n" +
                "rnbq bnr\n" +
                "pppp ppp\n" +
                "        \n" +
                "    k   \n" +
                "        \n" +
                "  Q     \n" +
                "PPPPPPPP\n" +
                "RNB KBNR\n";
        String validState = "b\n" +
                "rnbq bnr\n" +
                "pppp ppp\n" +
                "    k   \n" +
                "        \n" +
                "        \n" +
                "  Q     \n" +
                "PPPPPPPP\n" +
                "RNB KBNR\n";
        String invalidState = "b\n" +
                "rnb  bnr\n" +
                "ppppqppp\n" +
                "        \n" +
                "    k   \n" +
                "        \n" +
                "  Q     \n" +
                "PPPPPPPP\n" +
                "RNB KBNR\n";

        List<String> states = new ChessUtilities().getNextStates(startPosition);

        Assertions.assertTrue(states.contains(validState));
        Assertions.assertFalse(states.contains(invalidState));
    }
}