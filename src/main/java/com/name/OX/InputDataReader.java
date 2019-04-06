package com.name.OX;

import java.util.Scanner;

/**
 * @author Ola Podorska
 */
class InputDataReader {

    private Scanner scanner;
    private int boardSize;

    InputDataReader(Scanner scanner) {
        this.scanner = scanner;
    }

    String readLanguage() {
        while (true) {
            String language;
            try {
                //TODO:: add displayer with question
                language = scanner.nextLine();
                if(!AvailableLanguage.compareLanguage(language)) {
                    throw new NotAvailableLanguageException("Must choose available language only");
                }
                //TODO:: To chyba nie potrzebne? Wystarczy nam ze zwroci na koncu
                return language;
            } catch (NotAvailableLanguageException e) {
                //TODO: add displayer with question
                language = readLanguage();
            }
            return language;
        }
    }

    String readPlayer() {
        //TODO:: Tutaj chyba logika do ogarniecia
        return scanner.nextLine();
    }

    String readBoardSize() {
        //TODO:: Czy potrzebujemy tutaj tej petli wgl? IntelliJ mowi ze nie bardzo, bo w kazdym "catch-u" i tak wywolujesz na nowo ta funkcje
        while (true) {
            String size;
            try {
                //TODO:: przed tym tez jakies info ze chcemy wieloks planszy i w jakiej formie maja byc podane dane
                size = scanner.nextLine();
                if(!checkIfSizeIsGood(size)) {
                    throw new BoardSizeException("Board must be grater than 3 and lower than 100");
                }
                //TODO:: chyba niepotrzbene, wystarczy ze przypiszemy na koncu ;)
                boardSize = Integer.valueOf(size);
                //TODO:: To chyba nie potrzebne? Wystarczy nam ze zwroci na koncu
                return size;
            } catch (BoardSizeException e) {
                //TODO: add displayer with question
                size = readBoardSize();
                //TODO::czy to sie kiedys wykona? Czy jest nam potrzebne?
                boardSize = Integer.valueOf(size);
            } catch (NumberFormatException e) {
                //TODO: add displayer message (only number)
                size = readBoardSize();
                //TODO::czy to sie kiedys wykona? Czy jest nam potrzebne?
                boardSize = Integer.valueOf(size);
            }
            boardSize = Integer.valueOf(size);
            return size;
        }
    }

    //TODO:: metody prywatne raczej na koncu klaski wrzucamy ;)
    private boolean checkIfSizeIsGood(String size) {
        //TODO:: zamiast liczb na sztywno zrobilbym zmienne (magic numbers)
        //TODO:: Ten if moze byc urposzczony - IntelliJ
        if(Integer.valueOf(size) < 3 || Integer.valueOf(size) > 100) {
            return false;
        }
        return true;
    }

    String readWinningSigns() {
        //TODO:: Czy potrzebujemy tutaj tej petli wgl? IntelliJ mowi ze nie bardzo, bo w kazdym "catch-u" i tak wywolujesz na nowo ta funkcje
        while (true) {
            String winningSigns;
            try {
                winningSigns = scanner.nextLine();
                if(!checkIfWinningSignsAreGood(winningSigns)) {
                    throw new WinningSignsException(
                            "Number of winning signs must be greater than 3 and lower than board size");
                }
                //TODO:: To chyba nie potrzebne? Wystarczy nam ze zwroci na koncu
                return winningSigns;
            } catch (WinningSignsException e) {
                //TODO: add displayer with question
                winningSigns = readWinningSigns();
            } catch (NumberFormatException e) {
                //TODO: add displayer message (only number)
                winningSigns = readWinningSigns();
            }
            return winningSigns;
        }
    }

    private boolean checkIfWinningSignsAreGood(String winningSigns) {
        //TODO: check if winning signs are lower than board size
        //TODO:: zamiast liczb na sztywno zrobilbym zmienne (magic numbers)
        //TODO:: Ten if moze byc urposzczony - IntelliJ
        if(Integer.valueOf(winningSigns) < 3) {
            return false;
        }
        return true;
    }

    String readField() {
        //TODO:: Czy potrzebujemy tutaj tej petli wgl? IntelliJ mowi ze nie bardzo, bo w kazdym "catch-u" i tak wywolujesz na nowo ta funkcje
        while (true) {
            String field;
            try {
                field = scanner.nextLine();
                if(!checkIfFieldIsGood(field)) {
                    throw new BadFieldException("Field must be on the board.");
                }
                //TODO:: To chyba nie potrzebne? Wystarczy nam ze zwroci na koncu
                return field;
            } catch (BadFieldException e) {
                field = readField();
            } catch (NumberFormatException e) {
                //TODO:: Wiadomosc co poszlo nie tak -> e.getMessage()?
                field = readField();
            }
            return field;
        }
    }

    private boolean checkIfFieldIsGood(String field) {
        //tutaj nie bardzo wiem dlaczego tak to sie sprawdza :p
        return Integer.valueOf(field) > (boardSize * boardSize);
    }
}