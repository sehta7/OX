package com.name.OX;

/**
 * @author Ola Podorska
 */
class DataInterpreter {

    Language interpretLanguage(String languageText){
        return new Language(languageText);
    }

    Player interpretPlayers(String playerText) {
        Player player = new Player(playerText);
        return player;
    }

    BoardSize interpretBoardSize(String boardSizeText) {
        return new BoardSize(Integer.valueOf(boardSizeText));
    }

    int interpretWinningSigns(String winningSignsText) {
        return Integer.parseInt(winningSignsText);
    }
}