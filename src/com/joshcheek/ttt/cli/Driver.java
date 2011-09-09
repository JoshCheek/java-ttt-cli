package com.joshcheek.ttt.cli;

import com.joshcheek.ttt.library.Game;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 9/9/11
 * Time: 1:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class Driver {
    public static void main(String[] args) {
        CLIRetriever retriever = new CLIRetriever(  new PlayerPrompter(),
                                                    new IOInteractionImpl(System.in, System.out),
                                                    new Game());
        new CLI(retriever);
    }
}
