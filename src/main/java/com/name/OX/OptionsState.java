package com.name.OX;

import java.util.Scanner;

/**
 * @author Ola Podorska
 */
class OptionsState implements GameState {

    private GameOptions gameOptions;
    private Scanner scanner;

    OptionsState(GameOptions gameOptions, Scanner scanner) {
        this.gameOptions = gameOptions;
        this.scanner = scanner;
    }

    @Override
    public GameState nextState() {
        InputDataReader inputDataReader = new InputDataReader(scanner);
        DataInterpreter dataInterpreter = new DataInterpreter();
        Language language = dataInterpreter.interpretLanguage(inputDataReader.readLanguage());
        Player naughtPlayer = dataInterpreter.interpretPlayers(inputDataReader.readPlayer());
        Player crossPlayer = dataInterpreter.interpretPlayers(inputDataReader.readPlayer());
        int boardLength = dataInterpreter.interpretBoardDimension(inputDataReader.readBoardLength());
        int boardHeight = dataInterpreter.interpretBoardDimension(inputDataReader.readBoardHeight());
        int winningSigns = dataInterpreter.interpretWinningSigns(inputDataReader.readWinningSigns());
        gameOptions.configure(language, new Players(naughtPlayer, crossPlayer), new BoardSize(boardLength, boardHeight),
                winningSigns);
        System.out.println(gameOptions);
        return null;
    }

    @Override
    public void whichState() {
        System.out.println(GameStateName.OPTIONS);
    }
}