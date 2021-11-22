package BoardGame;

public abstract class Piece {
    protected Position position;
    protected Board board;


    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    protected Board getBoard() {
        return board;
    }

    public abstract boolean [][] posibleMoves();

    public boolean possibleMove(Position position){
        return posibleMoves()[position.getRow()][position.getColumn()];
    }
    public boolean isThereAnyPossibleMove(){
        boolean[][] mat = posibleMoves();
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat.length; j++){
                return  true;
            }
        }
       return false;
    }
}
