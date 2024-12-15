package pl.put.poznan.transformer.logic;

import static pl.put.poznan.transformer.logic.TextTransformer.numberDictionary;

/**
 * This is NumberToTextClass which transforms numbers (integers and floats smaller or equal 1000 and floats with max two decimal places)
 * in given input to its full text names in Polish
* */

public class NumberToTextDecorator extends TextDecorator  {

    /**
     * Class constructor
     * @param transformer Inherited class
     */
    public NumberToTextDecorator(Transformer transformer) { super(transformer); }

    /**
     * Function to check if given string is a integer
     * @param strNumber checked word
     * @return true or false
     */
    public static boolean isInt(String strNumber) {
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

    /**
     * Function to check if given string is a float
     * @param strNumber checked word
     * @return true or false
     */
    public static boolean isFloat(String strNumber) {
        if (strNumber == null) {
            return false;
        }

        try {
            float d = Float.parseFloat(strNumber);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }

    /**
     * Function that transforms given String number into its text name
     * @param word String number that will be transformed
     * @return String with full number name
     */
    private String transformInt(String word) {
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

        return word;
    }


    /**
     * Function inherited from TextTransformer that transforms whole given text but changed to transform numbers
     * to its names
     * @return Whole sentence with replaced numbers
     */
    @Override
    public String transformText() {
        String[] words = transformer.transformText().split(" ");
        String result = "";
        String[] letters;

        for (String word : words) {
            if (isInt(word)){
                word = transformInt(word);
            }
            if (isFloat(word)) {
                String[] splittedNumber = word.split("\\.");
                int wholeNum = Integer.parseInt(splittedNumber[0]);
                if(wholeNum <= 1000) {
                    if(splittedNumber[1].length() <= 2) {
                        if(wholeNum != 0){
                            word = transformInt(splittedNumber[0]);
                            word += " i ";
                        }
                        else word = "";

                        if (splittedNumber[1].length()==2){
                            if (splittedNumber[1].charAt(0) != '0') word += transformInt(splittedNumber[1].charAt(0)+"0") + " ";

                            if(splittedNumber[1].charAt(1) == '1')  word += "jedna setna";
                            else if (splittedNumber[1].charAt(1) == '2')  word += "dwie setne";
                            else if (splittedNumber[1].charAt(1) == '3')  word += "trzy setne";
                            else if (splittedNumber[1].charAt(1) == '4')  word += "cztery setne";
                            else{
                                word += transformInt(splittedNumber[1].charAt(1)+"");
                                word += " setnych";
                            };
                        }
                        if (splittedNumber[1].length()==1){
                            if(splittedNumber[1].charAt(0) == '1')  word += "jedna dziesiąta";
                            else if (splittedNumber[1].charAt(0) == '2')  word += "dwie dzeisiąte";
                            else if (splittedNumber[1].charAt(0) == '3')  word += "trzy dzeisiąte";
                            else if (splittedNumber[1].charAt(0) == '4')  word += "cztery dzeisiąte";
                            else{
                                word += transformInt(splittedNumber[1]);
                                word += " dziesiątych";
                            };
                        }

                    }
                }
            }
            result += word + " ";
        }

        result = result.substring(0, result.length() - 1);
        return result;
    }
}
