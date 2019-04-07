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
        Displayer displayer = new Displayer(new Language("en"));
        displayer.displayQuestionAboutLanguage();
        Language language = dataInterpreter.interpretLanguage(inputDataReader.readLanguage());
        displayer = new Displayer(language);
        displayer.displayQuestionWhoStarts();
        Player naughtPlayer = dataInterpreter.interpretPlayers(inputDataReader.readPlayer(), scanner);
        naughtPlayer.setSymbol(Symbol.NAUGHT);
        displayer.displayQuestionAboutPlayer();
        Player crossPlayer = dataInterpreter.interpretPlayers(inputDataReader.readPlayer(), scanner);
        crossPlayer.setSymbol(Symbol.CROSS);
        displayer.displayQuestionAboutBoardSize();
        int boardSize = dataInterpreter.interpretBoardSize(inputDataReader.readBoardSize());
        displayer.displayQuestionAboutWinningSigns();
        int winningSigns = dataInterpreter.interpretWinningSigns(inputDataReader.readWinningSigns());
        gameOptions.configure(language, new Players(naughtPlayer, crossPlayer), boardSize, winningSigns);
        return new StartState(gameOptions, 0);
    }

    @Override
    public GameStateName whichState() {
        return GameStateName.OPTIONS;
    }
}