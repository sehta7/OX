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
        Player naughtPlayer = dataInterpreter.interpretPlayers(inputDataReader.readPlayer(), scanner);
        naughtPlayer.setSymbol(Symbol.NAUGHT);
        Player crossPlayer = dataInterpreter.interpretPlayers(inputDataReader.readPlayer(), scanner);
        crossPlayer.setSymbol(Symbol.CROSS);
        int boardSize = dataInterpreter.interpretBoardSize(inputDataReader.readBoardSize());
        int winningSigns = dataInterpreter.interpretWinningSigns(inputDataReader.readWinningSigns());
        gameOptions.configure(language, new Players(naughtPlayer, crossPlayer), boardSize, winningSigns);
        return new StartState(gameOptions, 0);
    }

    @Override
    public GameStateName whichState() {
        return GameStateName.OPTIONS;
    }
}