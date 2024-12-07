package pl.put.poznan.transformer.logic;

/**
 * This is a part of the decorator pattern used in this project (concrete decorator).
 * This class is responsible for changing all letters in given String to lowercase.
 */

public class LowercaseDecorator extends TextDecorator {
    public LowercaseDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transformText() {
        return transformer.transformText().toLowerCase();
    }
}
