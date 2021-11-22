package Chess.Pieces;

import BoardGame.Board;
import BoardGame.Position;
import Chess.ChessPiece;
import Chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMOve(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
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
        return mat;
    }
}
