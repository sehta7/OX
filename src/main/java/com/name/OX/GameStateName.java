package com.name.OX;

/**
 * @author Ola Podorska
 */
enum GameStateName {
    OPTIONS {
        @Override
        public String toString() {
            return "Options in game";
        }
    },
    DEF_OPTIONS{
        @Override
        public String toString(){
            return "Default options";
        }
    },
    START {
        @Override
        public String toString() {
            return "Game is starting";
        }
    },
    ROUND_O {
        @Override
        public String toString() {
            return "Play naught player";
        }
    },
    ROUND_X {
        @Override
        public String toString() {
            return "Play cross player";
        }
    },
    FINISH {
        @Override
        public String toString() {
            return "Game is ended";
        }
    }
}