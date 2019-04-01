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
        return scanner.nextLine();
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