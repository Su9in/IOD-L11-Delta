package pl.put.poznan.transformer.logic;

/**
 * This is a part of the decorator pattern used in this project (concrete component).
 * This class's only purpose is to hold some text and return it.
 */

public class TextContainer implements Transformer {
    /**
     * The text held by this container.
     */
    private String text;

    /**
     * Constructs a TextContainer with the specified text.
     * @param text the text to be held by this container
     */
    public TextContainer(String text) {
        this.text = text;
    }

    /**
     * Returns the text held by this container.
     * @return text held by the container
     */
    @Override
    public String transformText() {
        return this.text;
    }
}
