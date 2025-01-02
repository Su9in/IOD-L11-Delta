package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class TextTransformerTest {
    TextTransformer transformer;
    NumberDictionary numberDictionary;
    WordsAndAbbrDictionary wordsAndAbbrDictionary;
    String text = "Hello! I'm about to get Transformed!";
    String text2 = "Pan Profesor między innymi przekazał, że np. 25 punktów nie wystarczy.";
    String expected;

    @BeforeEach
    void setUp() {
        numberDictionary = mock(NumberDictionary.class);
        wordsAndAbbrDictionary = mock(WordsAndAbbrDictionary.class);
    }

    @Test
    void testUpper() {
        String[] transforms = {"upper"};
        transformer = new TextTransformer(transforms, numberDictionary, wordsAndAbbrDictionary);
        expected = "HELLO! I'M ABOUT TO GET TRANSFORMED!";
        assertEquals(expected, transformer.transform(text));
    }

    @Test
    void testLower() {
        String[] transforms = {"lower"};
        transformer = new TextTransformer(transforms, numberDictionary, wordsAndAbbrDictionary);
        expected = "hello! i'm about to get transformed!";
        assertEquals(expected, transformer.transform(text));
    }

    @Test
    void testCapitalize() {
        String[] transforms = {"capitalize"};
        transformer = new TextTransformer(transforms, numberDictionary, wordsAndAbbrDictionary);
        expected = "Hello! I'm About To Get Transformed!";
        assertEquals(expected, transformer.transform(text));
    }

    @Test
    void testReverse() {
        String[] transforms = {"reverse"};
        transformer = new TextTransformer(transforms, numberDictionary, wordsAndAbbrDictionary);
        expected = "!demrofSnart teg ot tuobA m'i !olleh";
        assertEquals(expected, transformer.transform(text));
    }

    @Test
    void testNumbersToText() {
        String[] transforms = {"numbersToText"};
        when(numberDictionary.isKeyInDictionary("20")).thenReturn(true);
        when(numberDictionary.isKeyInDictionary("5")).thenReturn(true);
        when(numberDictionary.getValue("20")).thenReturn("dwadzieścia");
        when(numberDictionary.getValue("5")).thenReturn("pięć");
        transformer = new TextTransformer(transforms, numberDictionary, wordsAndAbbrDictionary);
        expected = "Pan Profesor między innymi przekazał, że np. dwadzieścia pięć punktów nie wystarczy.";
        assertEquals(expected, transformer.transform(text2));
    }

    @Test
    void testWordToAbbr() {
        String[] transforms = {"wordToAbbr"};
        String[] words = {"Profesor", "między innymi"};
        when(wordsAndAbbrDictionary.getListOfWords()).thenReturn(words);
        when(wordsAndAbbrDictionary.getAbbrFromWord("Profesor")).thenReturn("Prof.");
        when(wordsAndAbbrDictionary.getAbbrFromWord("między innymi")).thenReturn("m.in.");
        transformer = new TextTransformer(transforms, numberDictionary, wordsAndAbbrDictionary);
        expected = "Pan Prof. m.in. przekazał, że np. 25 punktów nie wystarczy.";
        assertEquals(expected, transformer.transform(text2));
    }

    @Test
    void testAbbrToWord() {
        String[] transforms = {"abbrToWord"};
        String[] abbrs = {"np."};
        when(wordsAndAbbrDictionary.getListOfAbbrs()).thenReturn(abbrs);
        when(wordsAndAbbrDictionary.getWordFromAbbr("np.")).thenReturn("na przykład");
        transformer = new TextTransformer(transforms, numberDictionary, wordsAndAbbrDictionary);
        expected = "Pan Profesor między innymi przekazał, że na przykład 25 punktów nie wystarczy.";
        assertEquals(expected, transformer.transform(text2));
    }
}