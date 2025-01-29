package pl.put.poznan.transformer.logic;

//import static pl.put.poznan.transformer.logic.TextTransformer.wordsAndAbbrDictionary;

/**
 * This is a part of the decorator pattern used in this project (concrete decorator).
 * This class is responsible for transforming specific words in given String into their abbreviations.
 */

public class WordToAbbrDecorator extends TextDecorator{
    /**
     * Constructs a WordToAbbrDecorator with the specified transformer.
     * @param transformer the Transformer object to be decorated
     * @param dictionary the dictionary with words and abbreviations
     */
    public WordToAbbrDecorator(Transformer transformer, WordsAndAbbrDictionary dictionary) {
        super(transformer, dictionary);
    }
    /**
     * Geos through every word in a dictionary. If a word from dictionary is found in a given String it transforms it into related abbreviation.
     * @return text with words transformed into their abbreviations
     */
    @Override
    public String transformText() {
        String text = transformer.transformText();

        String[] dictWords = wordsAndAbbrDictionary.getListOfWords();

        for (String word : dictWords) {
            if (text.contains(word)) {

                int index = -1;
                while (true) {
                    index = text.indexOf(word, index + 1);
                    if (index == -1) break;
                    else {
                        char charAfterWord;
                        if (index + word.length() < text.length()) charAfterWord = text.charAt(index + word.length());
                        else charAfterWord = ' ';

                        char charBeforeWord;
                        if (index > 0) charBeforeWord = text.charAt(index - 1);
                        else charBeforeWord = 'X';

                        if (
                                (index == 0 && (charAfterWord == ' ' || charAfterWord == ',')) ||      // word at the beginning of a text
                                        (index > 0 &&                                // word at the end of a sentence
                                                (charAfterWord == '.' || charAfterWord == ',' || charAfterWord == '?'  || charAfterWord == '!' ) &&
                                                charBeforeWord == ' '
                                        ) ||
                                        (index > 0 && charBeforeWord == ' ' && charAfterWord == ' ')     // word in the middle of a text
                        ) text = text.replace(word, wordsAndAbbrDictionary.getAbbrFromWord(word));

                    }
                }


            }
        }

        if (text.charAt(text.length() - 1) == '.' && text.charAt(text.length() - 2) == '.')
            text = text.substring(0, text.length() - 1);

        return text;

    }

}
