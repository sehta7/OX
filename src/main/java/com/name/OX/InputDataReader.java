package com.name.OX;

import java.util.Scanner;

/**
 * @author Ola Podorska
 */
class InputDataReader {

    private Scanner scanner;
    private int boardSize;
    private static final int MIN_SIZE = 3;
    private static final int MAX__SIZE = 100;

    InputDataReader(Scanner scanner) {
        this.scanner = scanner;
    }

    String readLanguage() {
        String language;
        try {
            language = scanner.nextLine();
            if (!AvailableLanguage.compareLanguage(language)) {
                throw new NotAvailableLanguageException("Must choose available language only");
            }
        } catch (NotAvailableLanguageException e) {
            //TODO: add displayer with question
            language = readLanguage();
        }
        return language;
    }

    String readPlayer() {
        return scanner.nextLine();
    }

    String readBoardSize() {
        String size;
        try {
            size = scanner.nextLine();
            if (!checkIfSizeIsGood(size)) {
                throw new BoardSizeException("Board must be grater than 3 and lower than 100");
            }
        } catch (BoardSizeException e) {
            //TODO: add displayer with question
            size = readBoardSize();
        } catch (NumberFormatException e) {
            //TODO: add displayer message (only number)
            size = readBoardSize();
        }
        boardSize = Integer.valueOf(size);
        return size;
    }

    String readWinningSigns() {
        String winningSigns;
        try {
            winningSigns = scanner.nextLine();
            if (!checkIfWinningSignsAreGood(winningSigns)) {
                throw new WinningSignsException("Number of winning signs must be greater than 3 and lower than board size");
            }
        } catch (WinningSignsException e) {
            //TODO: add displayer with question
            winningSigns = readWinningSigns();
        } catch (NumberFormatException e) {
            //TODO: add displayer message (only number)
            winningSigns = readWinningSigns();
        }
        return winningSigns;
    }

    String readField() {
        String field;
        try {
            field = scanner.nextLine();
            if (!checkIfFieldIsGood(field)) {
                throw new BadFieldException("Field must be on the board.");
            }
        } catch (BadFieldException e) {
            field = readField();
        } catch (NumberFormatException e) {
            field = readField();
        }
        return field;
    }

    private boolean checkIfSizeIsGood(String size) {
        return Integer.valueOf(size) >= MIN_SIZE && Integer.valueOf(size) <= MAX__SIZE;
    }

    private boolean checkIfWinningSignsAreGood(String winningSigns) {
        //TODO: check if winning signs are lower than board size
        return Integer.valueOf(winningSigns) >= MIN_SIZE;
    }

    private boolean checkIfFieldIsGood(String field) {
        return Integer.valueOf(field) > (boardSize * boardSize);
    }
}