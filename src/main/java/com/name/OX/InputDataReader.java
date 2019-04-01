package com.name.OX;

import java.util.Scanner;

/**
 * @author Ola Podorska
 */
class InputDataReader {

    private Scanner scanner;

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
                size += ",";
                size += scanner.nextLine();
                if(!checkIfSizeIsGood(size)){
                    throw new BoardSizeException("Board must be grater than 3 and lower than 100");
                }
                return size;
            } catch (BoardSizeException e) {
                //TODO: add displayer with question
                size = readBoardSize();
            } catch (NumberFormatException e){
                //TODO: add displayer message (only number)
                size = readBoardSize();
            }
            return size;
        }
    }

    private boolean checkIfSizeIsGood(String size) {
        String[] splitSize = size.split(",");
        if (Integer.valueOf(splitSize[0]) < 3 || Integer.valueOf(splitSize[0]) > 100
                || Integer.valueOf(splitSize[1]) < 3 || Integer.valueOf(splitSize[1]) > 100){
            return false;
        }
        return true;
    }

    String readWinningSigns() {
        return scanner.nextLine();
    }
}