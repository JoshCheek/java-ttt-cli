package com.joshcheek.ttt.cli;

import com.joshcheek.ttt.library.Game;
import com.joshcheek.ttt.library.Player;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 9/7/11
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class CLI {
    private Game game;
    private Player[] players;
    private IOInteraction ioInteraction;

    public CLI(CLIRetriever retriever) {
        setGame(retriever);
        setPlayers(retriever);
        setIOInteraction(retriever);
        runGame();
        displayResults();
    }

    private void setIOInteraction(CLIRetriever retriever) {
        ioInteraction = retriever.ioInteraction();
    }

    private void displayResults() {
        ioInteraction.displayResults(game);
    }

    private void setGame(CLIRetriever retriever) {
        game = retriever.retrieveGame();
    }

    private void setPlayers(CLIRetriever retriever) {
        players = new Player[]{retriever.retrievePlayer(1), retriever.retrievePlayer(2)};
    }

    private void runGame() {
        while(!game.isOver())
            players[game.turn()-1].takeTurn();
    }
}
