package cs.ualberta.cmput402.tictactoe.board;

import cs.ualberta.cmput402.tictactoe.board.exceptions.InvalidMoveException;

/**
 * Created by snadi on 2018-07-16.
 */
public class Board {

    public enum SquareType {EMPTY, X, O};
    private enum State {PlayerX, PlayerO, Win};
    private State state;
    private SquareType board[][];

    public Board(){
        board = new SquareType[3][3];
    }

    public void play(){
        
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

            if (hasWon(x, y))
                state = State.Win;
            else if(state == State.PlayerX)
                state = State.PlayerO;
            else if (state == State.PlayerO)
                state = State.PlayerX;
        }

    }

    public boolean isSquareAvailable(int x, int y){
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

    public boolean hasWon(int lastXPlayed, int lastYPlayed){

        //check vertical
        if (board[lastXPlayed][0].equals(board[lastXPlayed][1]) && board[lastXPlayed][1].equals(board[lastXPlayed][2])){
            return true;
        }
        //check horizontal
        else if(board[0][lastYPlayed].equals(board[1][lastYPlayed]) && board[1][lastYPlayed].equals(board[2][lastYPlayed])){
            return true;
        }
        //check diagonal
        else{
            if(board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]))
                return true;
            else if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]))
                return true;
        }

        return false;
    }

    public void printBoard(){
        for(int i  = 0; i < 3; i++){
            for(int j = 0 ; j < 3; j++){
                System.out.print(getSymbol(board[i][j]));
                if (j == 2)
                    System.out.println("");
                else
                    System.out.print(" | ");
            }
        }
    }


}
