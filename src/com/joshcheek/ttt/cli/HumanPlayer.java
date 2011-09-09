package com.joshcheek.ttt.cli;

import com.joshcheek.ttt.library.Game;
import com.joshcheek.ttt.library.Player;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 9/8/11
 * Time: 10:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class HumanPlayer implements Player {
    private IOInteraction ioInteraction;
    private Game game;

    public HumanPlayer(Game game, IOInteraction ioInteraction) {
        this.ioInteraction = ioInteraction;
        this.game = game;
    }

    public void takeTurn() {
        int move = ioInteraction.promptMove(game);
        game.mark(move);
    }
}
