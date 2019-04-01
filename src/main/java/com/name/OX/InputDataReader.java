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
            String language = "";
            try {
                language = scanner.nextLine();
                if (!AvailableLanguage.compareLanguage(language)) {
                    throw new NotAvailableLanguageException("Must choose available language only");
                }
                return language;
            } catch (NotAvailableLanguageException e) {
                language = readLanguage();
            }
            return language;
        }
    }

    String readPlayer() {
        return scanner.nextLine();
    }

    String readBoardSize() {
        String size = scanner.nextLine();
        size += ",";
        size += scanner.nextLine();
        return size;
    }

    String readWinningSigns() {
        return scanner.nextLine();
    }
}