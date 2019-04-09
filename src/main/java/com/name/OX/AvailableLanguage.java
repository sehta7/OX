package com.name.OX;

/**
 * @author Ola Podorska
 */
enum AvailableLanguage {

    PL("pl"), EN("en");

    private String name;

    AvailableLanguage(String languageName) {
        name = languageName;
    }

    public static boolean compareLanguage(String nameToCheck){
        for (AvailableLanguage name : values()
                ) {
            if (name.name.equals(nameToCheck)){
                return true;
            }
        }
        return false;
    }
}
