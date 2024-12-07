package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextTransformerTest {
    TextTransformer transformer;
    String text = "Hello! I'm about to get Transformed!";
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
}