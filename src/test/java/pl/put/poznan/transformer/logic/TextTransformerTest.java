package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextTransformerTest {
    TextTransformer transformer;
    String text = "Hello! I'm about to get Transformed!";
    String text2 = "Pan Profesor przekazał między innymi, że np. 25 punktów nie wystarczy.";
    String expected;

    @Test
    void testUpper() {
        String[] transforms = {"upper"};
        transformer = new TextTransformer(transforms);
        expected = "HELLO! I'M ABOUT TO GET TRANSFORMED!";
        assertEquals(expected, transformer.transform(text));
    }

    @Test
    void testLower() {
        String[] transforms = {"lower"};
        transformer = new TextTransformer(transforms);
        expected = "hello! i'm about to get transformed!";
        assertEquals(expected, transformer.transform(text));
    }

    @Test
    void testCapitalize() {
        String[] transforms = {"capitalize"};
        transformer = new TextTransformer(transforms);
        expected = "Hello! I'm About To Get Transformed!";
        assertEquals(expected, transformer.transform(text));
    }

    @Test
    void testReverse() {
        String[] transforms = {"reverse"};
        transformer = new TextTransformer(transforms);
        expected = "!demrofSnart teg ot tuobA m'i !olleh";
        assertEquals(expected, transformer.transform(text));
    }

    @Test
    void testNumbersToText() {
        String[] transforms = {"numbersToText"};
        transformer = new TextTransformer(transforms);
        expected = "Pan Profesor przekazał między innymi, że np. dwadzieścia pięć punktów nie wystarczy.";
        assertEquals(expected, transformer.transform(text2));
    }

//    @Test
//    void testWordToAbbr() {
//        String[] transforms = {"wordToAbbr"};
//        transformer = new TextTransformer(transforms);
//        expected = "Pan Prof. przekazał m.in., że np. 25 punktów nie wystarczy.";
//        assertEquals(expected, transformer.transform(text2));
//    }

    @Test
    void testAbbrToWord() {
        String[] transforms = {"abbrToWord"};
        transformer = new TextTransformer(transforms);
        expected = "Pan Profesor przekazał między innymi, że na przykład 25 punktów nie wystarczy.";
        assertEquals(expected, transformer.transform(text2));
    }
}