package com.joshcheek.ttt.cli;

import com.joshcheek.ttt.library.Game;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 9/8/11
 * Time: 11:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class HumanPlayerTest extends junit.framework.TestCase  {
    Game                game            = new Game();
    IOInteractionMock   ioInteraction   = new IOInteractionMock();
    HumanPlayer         player          = new HumanPlayer(game, ioInteraction);


    public void testWhenITellMyHumanPlayerToTakeTheirTurnTheyShouldPromptTheHumanAndMakeTheMove() {
        ioInteraction.stubPlayerMoveResponse(2);
        assertFalse(ioInteraction.hasBeenAskedToGetPlayerMove());
        player.takeTurn();
        assertTrue(ioInteraction.hasBeenAskedToGetPlayerMove());
        assertTrue(game == ioInteraction.gamePlayerMovedAgainst());
        assertEquals("010000000", game.board());
    }
}
