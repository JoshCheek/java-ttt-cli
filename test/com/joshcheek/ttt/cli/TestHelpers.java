package com.joshcheek.ttt.cli;

import com.joshcheek.ttt.library.Game;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 9/8/11
 * Time: 7:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestHelpers {
    public static IOInteractionMock mockIO() {
        return new IOInteractionMock();
    }

    public static CLIRetrieverMock mockRetriever() {
        return new CLIRetrieverMock(new PlayerPrompterMock(), new IOInteractionMock(), new Game());
    }

}
