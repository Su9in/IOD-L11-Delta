package pl.put.poznan.transformer.logic;

/**
 * This is a part of the decorator pattern used in this project (concrete component).
 * This class's only purpose is to hold some text and return it.
 */

public class TextContainer implements Transformer {

    private String text;

    public TextContainer(String text) {
        this.text = text;
    }

    @Override
    public String transformText() {
        return this.text;
    }
}
