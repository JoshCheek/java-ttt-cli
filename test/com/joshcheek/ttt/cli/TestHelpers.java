package com.joshcheek.ttt.cli;

import com.joshcheek.ttt.library.Game;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 9/8/11
 * Time: 7:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestHelpers {
    public static CLIRetrieverMock mockRetriever() {
        return new CLIRetrieverMock(new PlayerPrompterMock(), new IOInteractionMock(), new Game());
    }

    public static void assertContains(String haystack, String needle) {
        assertTrue("Expected \"" + haystack + "\" to contain \"" + needle + "\"",
                haystack.contains(needle));
    }

    public static void assertDoesntContain(String haystack, String needle) {
        assertFalse("Expected \"" + haystack + "\" to NOT contain \"" + needle + "\"",
                haystack.contains(needle));
    }
}
