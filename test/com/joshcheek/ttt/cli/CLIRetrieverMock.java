package com.joshcheek.ttt.cli;

import com.joshcheek.ttt.library.Game;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 9/8/11
 * Time: 8:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class CLIRetrieverMock extends CLIRetriever {
    public CLIRetrieverMock(PlayerPrompter playerPrompter, IOInteraction ioInteraction, Game game) {
        super(playerPrompter, ioInteraction, game);
    }

    public PlayerPrompterMock playerPrompterMock() {
        return (PlayerPrompterMock)playerPrompter();
    }

    public void mockPlayer1(PlayerMock playerMock) {
        ((PlayerPrompterMock)playerPrompter()).mockPlayer1(playerMock);
    }

    public void mockPlayer2(PlayerMock playerMock) {
        ((PlayerPrompterMock)playerPrompter()).mockPlayer2(playerMock);
    }

    public IOInteractionMock ioInteractionMock() {
        return (IOInteractionMock)ioInteraction();
    }
}
