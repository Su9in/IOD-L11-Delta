package pl.put.poznan.transformer.logic;

import static pl.put.poznan.transformer.logic.TextTransformer.wordsAndAbbrDictionary;

/**
 * This is a part of the decorator pattern used in this project (concrete decorator).
 * This class is responsible for transforming specific abbreviations in given String into related words.
 */

public class AbbrToWordDecorator extends TextDecorator {
    /**
     * Constructs a AbbrToWordDecorator with the specified transformer.
     * @param transformer the Transformer object to be decorated
     */
    public  AbbrToWordDecorator(Transformer transformer) {
        super(transformer);
    }

    /**
     * Geos through every abbreviation in a dictionary. If an abbreviation from dictionary is found in a given String it transforms it into related word.
     * @return text with words transformed into their abbreviations
     */
    @Override
    public String transformText() {
        String text = transformer.transformText();

        String[] dictAbbrs = wordsAndAbbrDictionary.getListOfAbbrs();

        for (String abbr : dictAbbrs) {
            if (text.contains(abbr)) {

                int index = -1;
                while (true) {
                    index = text.indexOf(abbr, index + 1);
                    if (index == -1) break;
                    else {
                        char charAfterAbbr;
                        if (index + abbr.length() < text.length()) charAfterAbbr = text.charAt(index + abbr.length());
                        else charAfterAbbr = ' ';

                        char charBeforeAbbr;
                        if (index > 0) charBeforeAbbr = text.charAt(index - 1);
                        else charBeforeAbbr = 'X';

                        if (
                                (index == 0 && (charAfterAbbr == ' ' || charAfterAbbr == ',')) ||              // abbr at the beginning of a text
                                        (index > 0 &&                                // abbr at the end of a sentence
                                                (charAfterAbbr == '.' || charAfterAbbr == ',' || charAfterAbbr == '?'  || charAfterAbbr == '!' ) &&
                                                charBeforeAbbr == ' '
                                        ) ||
                                        (index > 0 && charBeforeAbbr == ' ' && charAfterAbbr == ' ')     // abbr in the middle of a text
                        ) text = text.replace(abbr, wordsAndAbbrDictionary.getWordFromAbbr(abbr));

                    }
                }

            }
        }

        return text;

    }

}
