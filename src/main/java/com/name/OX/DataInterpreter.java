package com.name.OX;

import java.util.Scanner;

/**
 * @author Ola Podorska
 */
class DataInterpreter {

    Language interpretLanguage(String languageText) {
        return new Language(languageText);
    }

    Player interpretPlayers(String playerText, Scanner scanner) {
        //TODO:: Mozna uproscic zwracajac od razu obiekt, nie tworzac zmiennej ;)
        Player player = new Player(playerText, scanner);
        return player;
    }

    //TODO:: Te trzy metodki to w sumie parser ze String na Int, mozna by bylo stworzyc nowa klaske do tego?

    int interpretBoardSize(String boardSizeText) {
        return Integer.parseInt(boardSizeText);
    }

    int interpretWinningSigns(String winningSignsText) {
        return Integer.parseInt(winningSignsText);
    }

    //TODO:: public??
    public int interpretField(String fieldText) {
        return Integer.parseInt(fieldText);
    }
}