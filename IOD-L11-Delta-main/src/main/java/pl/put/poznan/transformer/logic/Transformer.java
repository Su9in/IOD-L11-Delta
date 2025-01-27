package pl.put.poznan.transformer.logic;

/**
 * This is a part of the decorator pattern used in this project (component).
 */

public interface Transformer {
    /**
     * Defines a way for transform objects to return the result of transformation.
     * @return text after the transformation
     */
    public String transformText();
}
