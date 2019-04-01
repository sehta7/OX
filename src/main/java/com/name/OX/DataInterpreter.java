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
        String[] splitSize = boardSizeText.split(",");
        return new BoardSize(Integer.valueOf(splitSize[0]), Integer.valueOf(splitSize[1]));
    }

    int interpretWinningSigns(String winningSignsText) {
        return Integer.parseInt(winningSignsText);
    }
}