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
    private boolean gameWasOver = false;
    private Game gameThatWasPromptedWith;
    private char userResponseToPlayerPrompt='c';
    private boolean[] wasPromptedForPlayer = new boolean[]{false, false};


    public void displayResults(Game game) {
        gameWasOver = game.isOver();
    }

    public char promptForPlayer(Game game, int playerNumber) {
        wasPromptedForPlayer[playerNumber-1] = true;
        gameThatWasPromptedWith = game;
        return userResponseToPlayerPrompt;
    }

    public boolean gameWasOverWhenIDisplayedResults() {
        return gameWasOver;
    }

    public boolean wasPromptedForPlayer(int playerNumber) {
        return wasPromptedForPlayer[playerNumber-1];
    }

    public Game gameThatWasPromptedWith() {
        return gameThatWasPromptedWith;
    }

    public void stubPlayerPromptResponse(char userResponse) {
        userResponseToPlayerPrompt = userResponse;
    }
}

