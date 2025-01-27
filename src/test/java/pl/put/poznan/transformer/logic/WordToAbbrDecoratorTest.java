package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordToAbbrDecoratorTest {

    TextContainer container;
    WordToAbbrDecorator decorator;

    String text = "Profesory między innymi, to między innymi! na przykład? ulica tak zwany profesor";
    String expected = "Profesory m.in., to m.in.! np.? ul. tzw. prof.";

    @BeforeEach
    void setUp() {
        container = new TextContainer(text);
        decorator = new WordToAbbrDecorator(container);
    }

    @Test
    void testWordToAbbr() {
        assertEquals(expected, decorator.transformText());
    }

}