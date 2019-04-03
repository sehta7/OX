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
                language = scanner.nextLine();
                if (!AvailableLanguage.compareLanguage(language)) {
                    throw new NotAvailableLanguageException("Must choose available language only");
                }
                return language;
            } catch (NotAvailableLanguageException e) {
                //TODO: add displayer with question
                language = readLanguage();
            }
            return language;
        }
    }

    String readPlayer() {
        return scanner.nextLine();
    }

    String readBoardSize() {
        while (true) {
            String size;
            try {
                size = scanner.nextLine();
                if(!checkIfSizeIsGood(size)){
                    throw new BoardSizeException("Board must be grater than 3 and lower than 100");
                }
                boardSize = Integer.valueOf(size);
                return size;
            } catch (BoardSizeException e) {
                //TODO: add displayer with question
                size = readBoardSize();
                boardSize = Integer.valueOf(size);
            } catch (NumberFormatException e){
                //TODO: add displayer message (only number)
                size = readBoardSize();
                boardSize = Integer.valueOf(size);
            }
            boardSize = Integer.valueOf(size);
            return size;
        }
    }

    private boolean checkIfSizeIsGood(String size) {
        if (Integer.valueOf(size) < 3 || Integer.valueOf(size) > 100){
            return false;
        }
        return true;
    }

    String readWinningSigns() {
        while (true) {
            String winningSigns;
            try {
                winningSigns = scanner.nextLine();
                if(!checkIfWinningSignsAreGood(winningSigns)){
                    throw new WinningSignsException("Number of winning signs must be greater than 3 and lower than board size");
                }
                return winningSigns;
            } catch (WinningSignsException e) {
                //TODO: add displayer with question
                winningSigns = readWinningSigns();
            } catch (NumberFormatException e){
                //TODO: add displayer message (only number)
                winningSigns = readWinningSigns();
            }
            return winningSigns;
        }
    }

    private boolean checkIfWinningSignsAreGood(String winningSigns) {
        //TODO: check if winning signs are lower than board size
        if (Integer.valueOf(winningSigns) < 3){
            return false;
        }
        return true;
    }

    String readField() {
        while (true){
            String field;
            try{
                field = scanner.nextLine();
                if(!checkIfFieldIsGood(field)){
                    throw new BadFieldException("Field must be on the board.");
                }
                return field;
            } catch (BadFieldException e) {
                field = readField();
            }catch (NumberFormatException e){
                field = readField();
            }
            return field;
        }
    }

    private boolean checkIfFieldIsGood(String field) {
        return Integer.valueOf(field) > (boardSize * boardSize);
    }
}