package com.name.OX;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author Ola Podorska
 */

@Test
public class LanguageTest {

    @Test(dataProviderClass = DP.class, dataProvider = "languageName")
    public void testIfLanguageReturnsItName(String name) {
        Language language = new Language(name);
        assert (language.whatLanguage().equals(name)) : "Language does not know its name";
    }
}