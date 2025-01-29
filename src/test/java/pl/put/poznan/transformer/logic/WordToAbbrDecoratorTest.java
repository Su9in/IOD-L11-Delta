package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/*
    Class for testing WordToAbbrDecorator class using Mock objects
 */
public class WordToAbbrDecoratorTest {

    TextContainer container;
    WordToAbbrDecorator decorator;
    WordsAndAbbrDictionary wordsAndAbbrDictionary;

    String text = "Profesory to między innymi na przykład ulica tak zwany profesor";
    String expected = "Profesory to m.in. np. ul. tzw. prof.";

    @BeforeEach
    void setUp() {
        wordsAndAbbrDictionary = mock(WordsAndAbbrDictionary.class);
        container = new TextContainer(text);
        decorator = new WordToAbbrDecorator(container, wordsAndAbbrDictionary);
    }

    @Test
    void testWordToAbbr() {
        String[] words = {"między innymi", "na przykład", "ulica", "tak zwany", "profesor"};
        when(wordsAndAbbrDictionary.getListOfWords()).thenReturn(words);
        when(wordsAndAbbrDictionary.getAbbrFromWord(words[0])).thenReturn("m.in.");
        when(wordsAndAbbrDictionary.getAbbrFromWord(words[1])).thenReturn("np.");
        when(wordsAndAbbrDictionary.getAbbrFromWord(words[2])).thenReturn("ul.");
        when(wordsAndAbbrDictionary.getAbbrFromWord(words[3])).thenReturn("tzw.");
        when(wordsAndAbbrDictionary.getAbbrFromWord(words[4])).thenReturn("prof.");
        assertEquals(expected, decorator.transformText());
    }

}