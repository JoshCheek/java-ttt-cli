package com.joshcheek.ttt.cli;

import com.joshcheek.ttt.library.Game;
import com.joshcheek.ttt.library.Player;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 9/8/11
 * Time: 8:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlayerMock implements Player {
    private int currentMove = 0;
    private int[] moves;
    private Game game;

    public PlayerMock(int[] moves, Game game) {
        this.moves = moves;
        this.game = game;
        currentMove = 0;
    }

    public void takeTurn() {
        game.mark(moves[currentMove++]);
    }
}
