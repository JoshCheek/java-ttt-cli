package com.joshcheek.ttt.cli;

import com.joshcheek.ttt.library.ComputerPlayer;
import com.joshcheek.ttt.library.Game;
import com.joshcheek.ttt.library.Player;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 9/8/11
 * Time: 7:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlayerPrompter {
    boolean player1WasComputer = false;

    public Player prompt(IOInteraction io, Game game, int playerNumber) {
        if(player1WasComputer) return new HumanPlayer(game, io);
        if('c' == getPlayerTypeFromUser(io, playerNumber))
            return new ComputerPlayer(game);
        return new HumanPlayer(game, io);
    }

    private char getPlayerTypeFromUser(IOInteraction io, int playerNumber) {
        char response = io.promptForPlayer(playerNumber);
        if('c' == response && playerNumber == 1)
            player1WasComputer = true;
        return response;
    }
}
