package com.joshcheek.ttt.cli;

import com.joshcheek.ttt.library.Game;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 9/8/11
 * Time: 11:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class IOInteractionImpl implements IOInteraction {


    private Scanner in;
    private PrintStream out;

    public IOInteractionImpl(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    public void displayResults(Game game) {
        displayBoard(game);
        if(game.isTie())                out.print("The game ended in a tie.");
        else if(game.winner() == 1)     out.print("Player 1 won the game!");
        else if(game.winner() == 2)     out.print("Player 2 won the game!");
    }

    public char promptForPlayer(int playerNumber) {
        askPlayerType(playerNumber);
        char toReturn = getFirstChar();
        if(validPlayerType(toReturn)) return toReturn;
        informUserOfInvalidPlayerType(toReturn);
        return promptForPlayer(playerNumber);
    }

    public int promptMove(Game game) {
        displayBoard(game);
        askUserWhereTheyWantToMove(game);
        String line = in.nextLine();
        if(isValidMove(game, line)) return extractMove(line);
        out.println("Invalid input.");
        return promptMove(game);
    }

    private void displayBoard(Game game) {
        out.println( "     |     |     ");
        out.println( "  " + markerFor(game, 1) + "  |  " + markerFor(game, 2) + "  |  " + markerFor(game, 3) + "  ");
        out.println( "     |     |     ");
        out.println( "-----|-----|-----");
        out.println( "     |     |     ");
        out.println( "  " + markerFor(game, 4) + "  |  " + markerFor(game, 5) + "  |  " + markerFor(game, 6) + "  ");
        out.println( "     |     |     ");
        out.println( "-----|-----|-----");
        out.println( "     |     |     ");
        out.println( "  " + markerFor(game, 7) + "  |  " + markerFor(game, 8) + "  |  " + markerFor(game, 9) + "  ");
        out.println( "     |     |     ");
    }

    private String markerFor(Game game, int position) {
        int player = game.playerAt(position);
        return  player == 1 ? "X" :
                player == 2 ? "O" :
                              " ";
    }

    private String availableMoves(Game game) {
        if(onlyOneMove(game)) return firstAvailableMove(game);
        return availableMovesToString(game);
    }

    private String availableMovesToString(Game game) {
        int[] availableMoves = game.availableMoves();
        String result = "";
        int length = availableMoves.length;
        for(int i=0; i+1<length; ++i) {
            int move = availableMoves[i];
            result += move + ", ";
        }
        result += "or " + availableMoves[length-1];
        return result;
    }

    private String firstAvailableMove(Game game) {
        return Integer.toString(game.availableMoves()[0]);
    }

    private boolean onlyOneMove(Game game) {
        return game.availableMoves().length == 1;
    }

    private char getFirstChar() {
        String line = in.nextLine();
        if(line.length() == 0) return 0;
        return line.toLowerCase().charAt(0);
    }

    private void informUserOfInvalidPlayerType(char toReturn) {
        out.println("Invalid input, expected 'c' or 'h', but got '" + toReturn + "'");
    }

    private boolean validPlayerType(char toReturn) {
        return toReturn == 'c' || toReturn == 'h';
    }

    private void askPlayerType(int playerNumber) {
        out.print("Should Player " + playerNumber + " be a human or computer? (h/c) ");
    }

    private int extractMove(String line) {
        return Integer.parseInt(line);
    }

    private boolean isValidMove(Game game, String line) {
        return 0 < line.length() && !line.matches(".*[^1-9].*") && game.isAvailable(extractMove(line));
    }

    private void askUserWhereTheyWantToMove(Game game) {
        out.print("Where would you like to move? (" + availableMoves(game) + ") ");
    }

}
