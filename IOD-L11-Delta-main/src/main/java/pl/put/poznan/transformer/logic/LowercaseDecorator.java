package pl.put.poznan.transformer.logic;

/**
 * This is a part of the decorator pattern used in this project (concrete decorator).
 * This class is responsible for changing all letters in given String to lowercase.
 */

public class LowercaseDecorator extends TextDecorator {
    /**
     * Constructs a LowercaseDecorator with the specified transformer.
     * @param transformer the Transformer object to be decorated
     */
    public LowercaseDecorator(Transformer transformer) {
        super(transformer);
    }

    /**
     * Transforms the text by converting all letters to lowercase.
     * @return the transformed text in lowercase
     */
    @Override
    public String transformText() {
        return transformer.transformText().toLowerCase();
    }
}
