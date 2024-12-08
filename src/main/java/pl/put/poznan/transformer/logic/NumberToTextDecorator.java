package pl.put.poznan.transformer.logic;

import static pl.put.poznan.transformer.logic.TextTransformer.numberDictionary;

public class NumberToTextDecorator extends TextDecorator  {
    public NumberToTextDecorator(Transformer transformer) { super(transformer); }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null) {
            return false;
        }

        try {
            double d = Integer.parseInt(strNumber);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }



    @Override
    public String transformText() {
        String[] words = transformer.transformText().split(" ");
        String result = "";
        String[] letters;

        for (String word : words) {
            if (isNumeric(word)){
                if (Integer.parseInt(word)<=1000){
                    switch (word.length()) {
                        case 2:
                            if (Integer.parseInt(word) > 20) {
                                String tens = word.charAt(0) + "0";
                                String ones = word.charAt(1) + "";
                                tens = numberDictionary.getValue(tens);
                                ones = numberDictionary.getValue(ones);

                                if (word.charAt(1) == '0') word = tens;
                                else word = tens + " " + ones;
                            } else {
                                word = numberDictionary.getValue(word);
                            }
                            break;

                        case 3:
                            String hundreds = word.charAt(0) + "00";
                            String tens = word.charAt(1) + "0";
                            String ones = word.charAt(2) + "";
                            hundreds = numberDictionary.getValue(hundreds);
                            tens = numberDictionary.getValue(tens);
                            ones = numberDictionary.getValue(ones);
                            if ((word.charAt(1) == '0') && (word.charAt(2) == '0')) word = hundreds;
                            else if (word.charAt(1) == '0') word = hundreds + " " + ones;
                            else if (word.charAt(2) == '0') word = hundreds + " " + tens;
                            else word = hundreds + " " + tens + " " + ones;
                            break;

                        default:
                            word = numberDictionary.getValue(word);
                    }
                }
                else {
                    System.out.println("The number " + Integer.parseInt(word) + " is too big!");
                }
            }
            result += word + " ";
        }

        result = result.substring(0, result.length() - 1);
        return result;
    }
}
