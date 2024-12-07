package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseDecoratorTest {
    TextContainer container;
    ReverseDecorator decorator;
    String text = "RevERse thiS!";
    String expected = "!siHT esrevEr";

    @BeforeEach
    void setUp() {
        container = new TextContainer(text);
        decorator = new ReverseDecorator(container);
    }

    @Test
    void testCapitalize() {
        assertEquals(expected, decorator.transformText());
    }
}