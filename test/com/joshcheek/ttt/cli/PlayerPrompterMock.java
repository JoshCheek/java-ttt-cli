package com.joshcheek.ttt.cli;

import com.joshcheek.ttt.library.ComputerPlayer;
import com.joshcheek.ttt.library.Game;
import com.joshcheek.ttt.library.Player;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 9/8/11
 * Time: 8:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlayerPrompterMock extends PlayerPrompter {
    private int timesInvoked = 0;
    private Player[] players = new Player[]{null, null};

    public Player prompt(IOInteraction io, Game game, int playerNumber) {
        ++timesInvoked;
        Player toReturn = new ComputerPlayer(game);
        if (timesInvoked == 2 && players[1] != null) toReturn = players[1];
        if (timesInvoked == 1 && players[0] != null) toReturn = players[0];
        return toReturn;
    }

    public int timesInvoked() {
        return timesInvoked;
    }

    public void mockPlayer1(PlayerMock playerMock) {
        players[0] = playerMock;
    }

    public void mockPlayer2(PlayerMock playerMock) {
        players[1] = playerMock;
    }
}
