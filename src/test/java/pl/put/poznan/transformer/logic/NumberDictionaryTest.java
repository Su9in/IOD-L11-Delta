package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class NumberDictionaryTest {
    NumberDictionary testDictionary = new NumberDictionary("src/main/resources/testDictionary.csv");

    @Test
    void testCapitalize() {
        assertEquals("zero", testDictionary.getValue("0"));
        assertEquals("one", testDictionary.getValue("1"));
        assertNotEquals("two", testDictionary.getValue("2"));
    }
}
