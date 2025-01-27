package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CezarCipherDecipherDecoratorTest {
    TextContainer container;
    CezarCipherDecorator decorator;
    CezarDecipherDecorator decorator2;
    String text = "Dzisiaj zjadłem zupę na obiad, ale była nie dobra.";
    String expected = "Dzisiaj zjadłem zupę na obiad, ale była nie dobra.";

    @BeforeEach

    void setUp() {
        container = new TextContainer(text);
        decorator = new CezarCipherDecorator(container);
    }



    @Test
    void testCezarCypher() {
        assertNotEquals(expected, decorator.transformText());
    }

    @Test
    void testCezarDecipher() {
        String text = decorator.transformText();
        container = new TextContainer(text);
        decorator2 = new CezarDecipherDecorator(container);

        assertEquals(expected, decorator2.transformText());
    }

}
