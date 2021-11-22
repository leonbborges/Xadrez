package Aplication;

import BoardGame.Board;
import Chess.ChessException;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        Scanner sc = new Scanner(System.in);
        List<ChessPiece> captured = new ArrayList<>();


        while (true){

           try{
               UI.clearScreen();
               UI.printMatch(chessMatch, captured);
               System.out.println();
               System.out.print("Source: ");
               ChessPosition source =UI.readChessPosition(sc);

               boolean[][] possibleMovies = chessMatch.possibleMoves(source);
               UI.clearScreen();
               UI.printBoard(chessMatch.getPieces(), possibleMovies);

               System.out.println();
               System.out.print("Target: ");
               ChessPosition target =UI.readChessPosition(sc);
               ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
               System.out.println();

               if(capturedPiece != null){
                   captured.add(capturedPiece);
               }
           }
           catch (ChessException e){
               System.out.println(e.getMessage());
               sc.nextLine();
           }
           catch (InputMismatchException e){
               System.out.println(e.getMessage());
               sc.nextLine();
           }

        }
    }
}
