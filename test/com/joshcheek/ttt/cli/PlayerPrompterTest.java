package com.joshcheek.ttt.cli;

import com.joshcheek.ttt.library.ComputerPlayer;
import com.joshcheek.ttt.library.Game;
import com.joshcheek.ttt.library.Player;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 9/8/11
 * Time: 10:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlayerPrompterTest extends junit.framework.TestCase {
    PlayerPrompter      prompter    = new PlayerPrompter();
    IOInteractionMock   interaction = new IOInteractionMock();
    Game                game        = new Game();


    public void testItTellsTheIOInterfaceToPromptForPlayer1() {
        assertFalse(interaction.wasPromptedForPlayer(1));
        Player player = prompter.prompt(interaction, game, 1);
        assertTrue(interaction.wasPromptedForPlayer(1));
    }

    public void testItTellsTheIOInterfaceToPromptForPlayer2() {
        assertFalse(interaction.wasPromptedForPlayer(2));
        Player player = prompter.prompt(interaction, game, 2);
        assertTrue(interaction.wasPromptedForPlayer(2));
    }

    public void testItReturnsAComputerPlayerWhenUserSelectsHuman() {
        interaction.stubPlayerPromptResponse('c');
        Player player = prompter.prompt(interaction, game, 1);
        assertTrue(player instanceof ComputerPlayer);
    }

    public void testItReturnsAHumanPlayerWhenUserSelectsHuman() {
        interaction.stubPlayerPromptResponse('h');
        Player player = prompter.prompt(interaction, game, 1);
        assertTrue(player instanceof HumanPlayer);
    }
}
