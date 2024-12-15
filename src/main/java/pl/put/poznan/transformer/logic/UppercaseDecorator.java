package pl.put.poznan.transformer.logic;

/**
 * This is a part of the decorator pattern used in this project (concrete decorator).
 * This class is responsible for changing all letters in given String to uppercase.
 */

public class UppercaseDecorator extends TextDecorator {
    /**
     * Constructs an UppercaseDecorator with the specified transformer.
     * @param transformer the Transformer object to be decorated
     */
    public UppercaseDecorator(Transformer transformer) {
        super(transformer);
    }

    /**
     * Transforms the text by converting all letters to uppercase.
     * @return the transformed text in uppercase
     */
    @Override
    public String transformText() {
        return transformer.transformText().toUpperCase();
    }
}
