package com.joshcheek.ttt.cli;

import com.joshcheek.ttt.library.Game;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 9/8/11
 * Time: 8:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class IOInteractionMock implements IOInteraction {
    boolean gameWasOver = false;

    public void displayResults(Game game) {
        gameWasOver = game.isOver();
    }

    public boolean gameWasOverWhenIDisplayedResults() {
        return gameWasOver;
    }
}

