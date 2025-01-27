package pl.put.poznan.transformer.logic;

/**
 * This is CezarDecipherDecorator which transforms ciphered text to readable one.
 * */

public class CezarDecipherDecorator extends TextDecorator {

    /**
     * Class constructor
     * @param transformer Inherited class
     */
    public CezarDecipherDecorator(Transformer transformer) { super(transformer); }

    /**
     * Function inherited from TextTransformer that transforms whole given text but changed to transform cipher text
     * to its readable version
     * @return Whole human-readable sentence
     */
    @Override
    public String transformText(){
        int letterSpacing = 5;
        String[] words = transformer.transformText().split(" ");
        String result = "";
        for (String word : words) {
            for (Character c : word.toCharArray()) {
                result += (char)((int)c-letterSpacing);
            }
            result += " ";
        }
        result = result.substring(0, result.length()-1);

        return result;
    }
}
