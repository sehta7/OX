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

    String readBoardLength() {
        return scanner.nextLine();
    }

    String readBoardHeight() {
        return scanner.nextLine();
    }

    String readWinningSigns() {
        return scanner.nextLine();
    }
}