package pl.put.poznan.transformer.logic;

import java.util.Arrays;

/**
 * This is a part of the decorator pattern used in this project (concrete decorator).
 * This class is responsible for capitalizing every word in given String.
 */

public class CapitalizeDecorator extends TextDecorator {
    public CapitalizeDecorator(Transformer transformer) {
        super(transformer);
    }

    /**
     * Goes through every word in a given String, capitalizes the first letter, and then puts
     * it all back together into a single String.
     * @return capitalized text
     */

    @Override
    public String transformText() {
        String[] words = transformer.transformText().split("\\s");
        String result = "";
        for (String word : words) {
            word = word.substring(0, 1).toUpperCase() + word.substring(1);
            result += word + " ";
        }
        result = result.substring(0, result.length() - 1);
        return result;
    }
}
