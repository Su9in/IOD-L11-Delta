package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class that tests does numberToText class work correct
 */
public class NumberToTextDecoratorTest {
    TextContainer container;
    NumberToTextDecorator decorator;
    NumberDictionary numberDictionary;
    String text = "This is 0.1 0.01 0.06 2.54, 78.95 2000.54 0.456 1 12 44 50 128, 200 302 480 1000 2000!";
    String expected = "This is jedna dziesiąta jedna setna sześć setnych dwa i pięćdziesiąt cztery setne, siedemdziesiąt osiem i dziewięćdziesiąt pięć setnych 2000.54 0.456 jeden dwanaście czterdzieści cztery pięćdziesiąt sto dwadzieścia osiem, dwieście trzysta dwa czterysta osiemdziesiąt tysiąc 2000!";


    @BeforeEach
    /**
     * Setup of every test
     */
    void setUp() {
        numberDictionary = new NumberDictionary("src/main/resources/numbersDictionarySource.csv");
        container = new TextContainer(text);
        decorator = new NumberToTextDecorator(container, numberDictionary);
    }


    @Test
    /**
     * Comparing output of the function of the given input with expected value
     */
    void testNumberToText() {
        assertEquals(expected, decorator.transformText());
    }
}
