package com.name.OX;

/**
 * @author Ola Podorska
 */
class Displayer {

    private Language language;

    Displayer(Language language) {
        this.language = language;
        language.loadLanguage();
    }

    void displayQuestionAboutLanguage(){
        System.out.println(language.getSentence("language"));
    }

    void displayQuestionAboutPlayer(){
        System.out.println(language.getSentence("player"));
    }

    void displayQuestionAboutBoardSize(){
        System.out.println(language.getSentence("size"));
    }

    void displayQuestionAboutWinningSigns(){
        System.out.println(language.getSentence("character"));
    }

    void displayQuestionWhoStarts(){
        System.out.println(language.getSentence("who_starts"));
    }

    void displayGameStart(){
        System.out.println(language.getSentence("start"));
    }

    void displayScore(Player player){
        System.out.println(player + " " + language.getSentence("score")  + " " + player.checkPoints());
    }

    void displayWhoWin(Player player){
        System.out.println(language.getSentence("win") + " " + player);
    }

    void displayNewRound(){
        System.out.println(language.getSentence("round"));
    }

    void displayQuestionAboutField(){
        System.out.println(language.getSentence("field"));
    }

    void displayDraw(){
        System.out.println(language.getSentence("draw"));
    }

    void displaySeparator(){
        System.out.println(language.getSentence("separator"));
    }

    void displayBoardSizeError() {
        System.out.println(language.getSentence("bad_size"));
    }

    void displayLanguageError() {
        System.out.println(language.getSentence("bad_language"));
    }

    void displayNotNumberError() {
        System.out.println(language.getSentence("not_number_size"));
    }

    void displayChosenFieldError() {
        System.out.println(language.getSentence("bad_field"));
    }

    void displayBadWinningSigns() {
        System.out.println(language.getSentence("bad_winning_signs"));
    }

    /*void displayScores(Map<String, Player> players) {
        for (Map.Entry<String, Player> entry : players.entrySet()
        ) {
            System.out.println(entry.getValue() + " " + language.getSentence("score")  + " " + entry.getValue().checkPoints());
        }
    }*/
}
