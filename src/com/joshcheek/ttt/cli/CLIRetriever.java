package com.joshcheek.ttt.cli;

import com.joshcheek.ttt.library.Game;
import com.joshcheek.ttt.library.Player;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 9/8/11
 * Time: 8:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class CLIRetriever {
    private Game game;
    private PlayerPrompter playerPrompter;
    private IOInteraction ioInteraction;

    public CLIRetriever(PlayerPrompter playerPrompter, IOInteraction ioInteraction, Game game) {
        this.playerPrompter = playerPrompter;
        this.ioInteraction = ioInteraction;
        this.game = game;
    }

    public Player retrievePlayer(int playerNumber) {
        return playerPrompter().prompt(ioInteraction, game, playerNumber);
    }

    public Game retrieveGame() {
        return game;
    }

    public PlayerPrompter playerPrompter() {
        return playerPrompter;
    }

    public IOInteraction ioInteraction() {
        return ioInteraction;
    }
}
