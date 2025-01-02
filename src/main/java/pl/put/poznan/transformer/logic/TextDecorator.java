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
    public NumberDictionary numberDictionary;
    public WordsAndAbbrDictionary wordsAndAbbrDictionary;

    /**
     * Constructs a TextDecorator with the specified transformer.
     * @param transformer the Transformer object to be decorated
     */
    public TextDecorator(Transformer transformer) {
        this.transformer = transformer;
    }

    /**
     * Constructs a TextDecorator with the specified transformer and number dictionary.
     * @param transformer the Transformer object to be decorated
     * @param numberDictionary the dictionary with numbers written in Polish
     */
    public TextDecorator(Transformer transformer, NumberDictionary numberDictionary) {
        this.transformer = transformer;
        this.numberDictionary = numberDictionary;
    }

    /**
     * Constructs a TextDecorator with the specified transformer and words and abbreviations dictionary.
     * @param transformer the Transformer object to be decorated
     * @param wordsAndAbbrDictionary the dictionary with words and abbreviations
     */
    public TextDecorator(Transformer transformer, WordsAndAbbrDictionary wordsAndAbbrDictionary) {
        this.transformer = transformer;
        this.wordsAndAbbrDictionary = wordsAndAbbrDictionary;
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
