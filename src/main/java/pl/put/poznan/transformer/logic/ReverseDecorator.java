package pl.put.poznan.transformer.logic;

/**
 * This is a part of the decorator pattern used in this project (concrete decorator).
 * This class is responsible for reversing the order of all characters in a String, while
 * preserving the positions of uppercase and lowercase letters.
 */

public class ReverseDecorator extends TextDecorator  {
    public ReverseDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transformText() {
        String text = super.transformText();
        int[] upperIndices = new int[text.length()];
        String result = "";

        // Keeping record of positions in text that contained an upperCase letter
        for (int i = 0; i < text.length(); i++) {
            if (Character.isAlphabetic(text.charAt(i)) && text.charAt(i) == Character.toUpperCase(text.charAt(i))) {
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
