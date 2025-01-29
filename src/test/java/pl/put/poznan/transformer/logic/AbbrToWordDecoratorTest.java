package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AbbrToWordDecoratorTest {
    TextContainer container;
    AbbrToWordDecorator decorator;
    WordsAndAbbrDictionary wordsAndAbbrDictionary;

    String text = "Lek., to m.in.! np. ul.? tzw. bigos.";
    String expected = "Lekarz, to między innymi! na przykład ulica? tak zwany bigos.";

    @BeforeEach
    void setUp() {
        wordsAndAbbrDictionary = mock(WordsAndAbbrDictionary.class);
        container = new TextContainer(text);
        decorator = new AbbrToWordDecorator(container, wordsAndAbbrDictionary);
    }

    @Test
    void testWordToAbbr() {
        String[] abbrs = {"np.", "m.in.", "Lek.", "ul.", "tzw."};
        when(wordsAndAbbrDictionary.getListOfAbbrs()).thenReturn(abbrs);
        when(wordsAndAbbrDictionary.getWordFromAbbr(abbrs[0])).thenReturn("na przykład");
        when(wordsAndAbbrDictionary.getWordFromAbbr(abbrs[1])).thenReturn("między innymi");
        when(wordsAndAbbrDictionary.getWordFromAbbr(abbrs[2])).thenReturn("Lekarz");
        when(wordsAndAbbrDictionary.getWordFromAbbr(abbrs[3])).thenReturn("ulica");
        when(wordsAndAbbrDictionary.getWordFromAbbr(abbrs[4])).thenReturn("tak zwany");
        assertEquals(expected, decorator.transformText());
    }
}