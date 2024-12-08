package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberToTextDecoratorTest {
    TextContainer container;
    NumberToTextDecorator decorator;
    String text = "This is 1 12 44 50 128 200 302 480 1000";
    String expected = "This is jeden dwanaście czterdzieści cztery pięćdziesiąt sto dwadzieścia osiem dwieście trzysta dwa czterysta osiemdziesiąt tysiąc";

    @BeforeEach
    void setUp() {
        container = new TextContainer(text);
        decorator = new NumberToTextDecorator(container);
    }

    @Test
    void testNumberToText() {
        assertEquals(expected, decorator.transformText());
    }
}
