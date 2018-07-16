package cs.ualberta.cmput402.tictactoe.board;

import cs.ualberta.cmput402.tictactoe.board.exceptions.InvalidMoveException;

/**
 * Created by snadi on 2018-07-16.
 */
public class Board {

    private enum SquareType {EMPTY, X, O};
    private SquareType board[][];

    public Board(){
        board = new SquareType[3][3];
    }

    public void playMove(SquareType squareType, int x, int y) throws InvalidMoveException {

        if(!isSquareAvailable(x, y)){
            //the given coordinates already contain a played move
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid Move: Square ");
            stringBuilder.append(x);
            stringBuilder.append(",");
            stringBuilder.append(y);
            stringBuilder.append(" already contains ");
            stringBuilder.append(getSymbol(board[x][y]));
            throw new InvalidMoveException(stringBuilder.toString());
        }else{
            board[x][y] = squareType;
        }

    }

    public Boolean isSquareAvailable(int x, int y){
        return (board[x][y] != SquareType.EMPTY);
    }

    public String getSymbol(SquareType squareType){
        switch(squareType){
            case EMPTY:
                return "EMPTY";
            case X:
                return "X";
            case O:
                return "O";
            default:
                return "UNKNOWN SYMBOL";
        }
    }


}
