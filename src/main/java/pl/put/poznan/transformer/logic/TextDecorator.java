package pl.put.poznan.transformer.logic;

import javax.xml.crypto.dsig.Transform;

/**
 * This is a part of the decorator pattern used in this project (decorator).
 * This class is to be extended by more concrete decorators.
 */

public class TextDecorator implements Transformer {
    /**
     * A reference to the "component" being decorated.
     */
    protected Transformer transformer;

    /**
     * Constructs a TextDecorator with the specified transformer.
     * @param transformer the Transformer object to be decorated
     */
    public TextDecorator(Transformer transformer) {
        this.transformer = transformer;
    }

    /**
     * Transforms the text by delegating the call to the wrapped transformer.
     * @return the transformed text
     */
    @Override
    public String transformText() {
        return transformer.transformText();
    }
}
