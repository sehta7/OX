package com.name.OX;

import java.util.Scanner;

/**
 * @author Ola Podorska
 */
class DataInterpreter {

    Language interpretLanguage(String languageText){
        return new Language(languageText);
    }

    Player interpretPlayers(String playerText, Scanner scanner) {
        return new Player(playerText, scanner);
    }

    int interpretBoardSize(String boardSizeText) {
        return Integer.parseInt(boardSizeText);
    }

    int interpretWinningSigns(String winningSignsText) {
        return Integer.parseInt(winningSignsText);
    }

    int interpretField(String fieldText) {
        return Integer.parseInt(fieldText);
    }
}