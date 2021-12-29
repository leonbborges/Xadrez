package Chess.Pieces;

import BoardGame.Board;
import BoardGame.Position;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;
    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMOve(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }
    private boolean testeRookCastiling(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p!=null && p instanceof Rook && p.getColor() ==getColor() && p.getMoveCount() ==0;
    }
    @Override
    public boolean[][] posibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0,0);
        //acima
        p.setValues(position.getRow() - 1,position.getColumn());
        if(getBoard().positionExist(p) && canMOve(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //abaixo
        p.setValues(position.getRow() + 1,position.getColumn());
        if(getBoard().positionExist(p) && canMOve(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //esquerda
        p.setValues(position.getRow() ,position.getColumn() - 1);
        if(getBoard().positionExist(p) && canMOve(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //direita
        p.setValues(position.getRow() ,position.getColumn() + 1);
        if(getBoard().positionExist(p) && canMOve(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //noroeste
        p.setValues(position.getRow() -1, position.getColumn() - 1);
        if(getBoard().positionExist(p) && canMOve(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //nordeste
        p.setValues(position.getRow() -1, position.getColumn() + 1);
        if(getBoard().positionExist(p) && canMOve(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //sudoeste
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if(getBoard().positionExist(p) && canMOve(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //diagonal esquerda
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if(getBoard().positionExist(p) && canMOve(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        // special move
        if (getMoveCount() ==0 && !chessMatch.getCheck()){
            Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
            if (testeRookCastiling(posT1)){
                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
                Position p2 = new Position(position.getRow(), position.getColumn() + 2);
                if(getBoard().piece(p1) == null && getBoard().piece(p2) == null){
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }
            Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
            if (testeRookCastiling(posT2)){
                Position p1 = new Position(position.getRow(), position.getColumn() - 1);
                Position p2 = new Position(position.getRow(), position.getColumn() - 2);
                Position p3 = new Position(position.getRow(), position.getColumn() - 3);
                if(getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null){
                    mat[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }
        return mat;
    }
}
