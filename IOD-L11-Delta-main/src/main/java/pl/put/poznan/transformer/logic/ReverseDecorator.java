package pl.put.poznan.transformer.logic;

import static java.lang.Character.isUpperCase;

/**
 * This is a part of the decorator pattern used in this project (concrete decorator).
 * This class is responsible for reversing the order of all characters in a String, while
 * preserving the positions of uppercase and lowercase letters.
 */

public class ReverseDecorator extends TextDecorator  {
    /**
     * Constructs a ReverseDecorator with the specified transformer.
     * @param transformer the Transformer object to be decorated
     */
    public ReverseDecorator(Transformer transformer) {
        super(transformer);
    }

    /**
     * Transforms the text by reversing the order of all characters while preserving
     * the case of each letter at its original position.
     * @return the transformed text with reversed character order
     */
    @Override
    public String transformText() {
        String text = super.transformText();
        int[] upperIndices = new int[text.length()];
        String result = "";

        // Keeping record of positions in text that contained an upperCase letter
        for (int i = 0; i < text.length(); i++) {
            if (isUpperCase(text.charAt(i))) {
                upperIndices[i] = 1;
            }
            else {
                upperIndices[i] = 0;
            }
        }
        text = text.toLowerCase();

        for (int i = text.length() - 1; i >= 0; i--) {
            char c = text.charAt(i);
            if (upperIndices[(text.length() - 1) - i] == 1) {
                c = Character.toUpperCase(c);
            }
            result += c;
        }

        return result;
    }
}
