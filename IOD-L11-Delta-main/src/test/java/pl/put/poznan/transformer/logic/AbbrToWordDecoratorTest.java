package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AbbrToWordDecoratorTest {
    TextContainer container;
    AbbrToWordDecorator decorator;

    String text = "Lek. to m.in. np. ul. tzw. bigos.";
    String expected = "Lekarz to między innymi na przykład ulica tak zwany bigos.";

    @BeforeEach
    void setUp() {
        container = new TextContainer(text);
        decorator = new AbbrToWordDecorator(container);
    }

    @Test
    void testWordToAbbr() {
        assertEquals(expected, decorator.transformText());
    }
}