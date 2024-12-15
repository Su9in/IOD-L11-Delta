package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordsAndAbbrDictionaryTest {
    WordsAndAbbrDictionary testDictionary = new WordsAndAbbrDictionary("src/main/resources/wordsAndAbbrDictionary.csv");

    @Test
    void testDictionary() {
        assertEquals("na przykład", testDictionary.getWordFromAbbr("np."));
        assertEquals("między innymi", testDictionary.getWordFromAbbr("m.in."));

        assertEquals("np.", testDictionary.getAbbrFromWord("na przykład"));
        assertEquals("m.in.", testDictionary.getAbbrFromWord("między innymi"));
    }
}