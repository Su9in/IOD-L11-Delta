package pl.put.poznan.transformer.logic;

import javax.xml.crypto.dsig.Transform;

/**
 * This is a part of the decorator pattern used in this project (decorator).
 * This class is to be extended by more concrete decorators.
 */

public class TextDecorator implements Transformer {
    protected Transformer transformer; // a reference to the "component"

    public TextDecorator(Transformer transformer) {
        this.transformer = transformer;
    }

    @Override
    public String transformText() {
        return transformer.transformText();
    }
}
