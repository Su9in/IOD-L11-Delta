package pl.put.poznan.transformer.logic;

import java.util.Dictionary;

/**
 * This is the class that takes care of transforming provided text using a set of transforms
 */
public class TextTransformer {
    /**
     * Field for storing all transformations to be applied with current instance of TextTransformer class
     */
    private final String[] transforms;
    /**
     * Dictionary containing numbers and their names in Polish
     */
    public NumberDictionary numberDictionary;
    /**
     * Dictionary containing words and abbreviations in Polish
     */
    public WordsAndAbbrDictionary wordsAndAbbrDictionary;

    /**
     * TextTransformer class constructor
     * @param transforms list of strings representing transformations
     */
    public TextTransformer(String[] transforms, NumberDictionary numberDictionary, WordsAndAbbrDictionary wordsAndAbbrDictionary) {
        this.transforms = transforms;
        this.numberDictionary = numberDictionary;
        this.wordsAndAbbrDictionary = wordsAndAbbrDictionary;
    }

    /**
     * Performs all transformations specified for this object
     * @param text the string of text to be transformed
     * @return text after all transformations
     */
    public String transform(String text){
        TextContainer container = new TextContainer(text);
        Transformer transformer;
        String newText = text;

        for (String t : transforms){
            transformer = switch (t) {
                case "upper" -> new UppercaseDecorator(container);
                case "lower" -> new LowercaseDecorator(container);
                case "capitalize" -> new CapitalizeDecorator(container);
                case "reverse" -> new ReverseDecorator(container);
                case "numbersToText" -> new NumberToTextDecorator(container, numberDictionary);
                case "wordToAbbr" -> new WordToAbbrDecorator(container, wordsAndAbbrDictionary);
                case "abbrToWord" -> new AbbrToWordDecorator(container, wordsAndAbbrDictionary);
                default -> container;
            };
            newText = transformer.transformText();
            container = new TextContainer(newText);
        }

        return newText;
    }
}