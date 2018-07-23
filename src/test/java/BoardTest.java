import cs.ualberta.cmput402.tictactoe.board.Board;
import cs.ualberta.cmput402.tictactoe.board.exceptions.InvalidMoveException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.model.TestClass;

/**
 * Created by snadi on 2018-07-23.
 */
public class BoardTest {

    private Board board;

    @Before
    public void setup(){
        board = new Board();
    }

    @Test
    public void testInit(){
        for(int i = 0; i < 3; i++){
            for (int j = 0 ; j < 3; j++){
                assert(board.isSquareAvailable(i, j));
            }
        }

        assert(board.getCurrentPlayer().equals(Board.Player.X));
    }

    @Test
    public void testPlayMove() throws InvalidMoveException{
        board.playMove(1,1);

        assert(!board.isSquareAvailable(1,1));
        assert(board.getCurrentPlayer().equals(Board.Player.O));
    }

}
