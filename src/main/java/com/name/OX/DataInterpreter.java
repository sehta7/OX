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

    int interpretBoardDimension(String boardDimensionText) {
        return Integer.parseInt(boardDimensionText);
    }

    int interpretWinningSigns(String winningSignsText) {
        return Integer.parseInt(winningSignsText);
    }
}