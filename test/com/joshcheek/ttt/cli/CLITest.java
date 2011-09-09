package com.joshcheek.ttt.cli;

import com.joshcheek.ttt.library.Game;

import static com.joshcheek.ttt.cli.TestHelpers.mockRetriever;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 9/8/11
 * Time: 7:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class CLITest extends junit.framework.TestCase {

    private Game game;
    private CLIRetrieverMock retriever;


    public void testWhenIRunANewGameItPromptsForFirstPlayerAndSecondPlayer() {
        playGameWherePlayer1Wins();
        assertEquals(2, retriever.playerPrompterMock().timesInvoked());
    }

    public void testUntilTheGameIsOverItAlternatesPromptingEachPlayerForTheBoard() {
        playGameWherePlayer1Wins();
        assertEquals("111220000", game.board());
    }

    public void testWhenTheGameIsOverItDisplaysTheResults() {
        playGameWherePlayer1Wins();
        assertTrue(retriever.ioInteractionMock().gameWasOverWhenIDisplayedResults());
    }


    private void playGameWherePlayer1Wins() {
        retriever = mockRetriever();
        game = retriever.game();
        retriever.mockPlayer1(new PlayerMock(new int[]{1, 2, 3, 9}, game)); // game should end after 1, 2, 3
        retriever.mockPlayer2(new PlayerMock(new int[]{4, 5, 6}, game));    // game should end after 4, 5
        CLI cli = new CLI(retriever);
    }
}
