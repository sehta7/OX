package com.name.OX;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author Ola Podorska
 */
@Test
public class AvailableLanguageTest {

    public void testIfFoundAvailableLanguage() {
        String language = "pl";
        assert (AvailableLanguage.compareLanguage(language)) : "Does not find language which is available";
    }

    public void testIfDoesNotFoundNotAvailableLanguage() {
        String language = "fr";
        assert (!AvailableLanguage.compareLanguage(language)) : "Find language which is not available";
    }
}