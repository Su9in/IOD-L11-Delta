package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CapitalizeDecoratorTest {
    TextContainer container;
    CapitalizeDecorator decorator;
    String text = "This is a sentence to be capitalized. the same, goes for THIS one!";
    String expected = "This Is A Sentence To Be Capitalized. The Same, Goes For THIS One!";

    @BeforeEach
    void setUp() {
        container = new TextContainer(text);
        decorator = new CapitalizeDecorator(container);
    }

    @Test
    void testCapitalize() {
        assertEquals(expected, decorator.transformText());
    }
}