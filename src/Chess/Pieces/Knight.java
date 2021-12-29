package Chess.Pieces;

import BoardGame.Board;
import BoardGame.Position;
import Chess.ChessPiece;
import Chess.Color;

public class Knight extends ChessPiece {
    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "N";
    }

    private boolean canMOve(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] posibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0,0);

        p.setValues(position.getRow() - 1,position.getColumn() - 2);
        if(getBoard().positionExist(p) && canMOve(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() - 2,position.getColumn() - 1);
        if(getBoard().positionExist(p) && canMOve(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() - 2,position.getColumn() + 1);
        if(getBoard().positionExist(p) && canMOve(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() - 1 ,position.getColumn() + 2);
        if(getBoard().positionExist(p) && canMOve(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //noroeste
        p.setValues(position.getRow() + 1, position.getColumn() + 2);
        if(getBoard().positionExist(p) && canMOve(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //nordeste
        p.setValues(position.getRow() + 2, position.getColumn() + 1);
        if(getBoard().positionExist(p) && canMOve(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //sudoeste
        p.setValues(position.getRow() + 2, position.getColumn() - 1);
        if(getBoard().positionExist(p) && canMOve(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //diagonal esquerda
        p.setValues(position.getRow() + 1, position.getColumn() - 2);
        if(getBoard().positionExist(p) && canMOve(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        return mat;
    }
}
