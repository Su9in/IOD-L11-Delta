package pl.put.poznan.transformer.logic;

/**
 * This is CezarCipherDecorator which transforms normal text into cipher to make it unreadable.
 * */

public class CezarCipherDecorator extends TextDecorator {

    /**
     * Class constructor
     * @param transformer Inherited class
     */
    public CezarCipherDecorator(Transformer transformer) { super(transformer); }

    /**
     * Function inherited from TextTransformer that transforms whole given text but changed to cipher text
     * to unreadable version
     * @return Whole ciphered sentence
     */
    @Override
    public String transformText(){
        int letterSpacing = 5;
        String[] words = transformer.transformText().split(" ");
        String result = "";
        for (String word : words) {
            for (Character c : word.toCharArray()) {
                result += (char)((int)c+letterSpacing);
            }
            result += " ";
        }
        result = result.substring(0, result.length()-1);

        return result;
    }
}
