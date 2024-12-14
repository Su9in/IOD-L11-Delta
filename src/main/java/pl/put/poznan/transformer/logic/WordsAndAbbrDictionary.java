package pl.put.poznan.transformer.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *  Dictionaries for converting between words and their abbreviations.
 *  Dictionary elements looks like this '<key> <value>' where '<key>' is a word, and '<value>' is an abbreviation.
 *  Every element should be separated with ",".
 */

public class WordsAndAbbrDictionary {
    private HashMap<String, String> abbrToWordsDictionary = new HashMap<>();
    private HashMap<String, String> wordsToAbbrDictionary = new HashMap<>();

    private void loadData(String filePath) {
        String line;
        String[] dictElements;

        try {
            File file = new File(filePath);
            Scanner reader = new Scanner(file);

            while(reader.hasNextLine()) {
                line = reader.nextLine();
                dictElements = line.split(",");
                wordsToAbbrDictionary.put(dictElements[0], dictElements[1]);
                abbrToWordsDictionary.put(dictElements[1], dictElements[0]);
            }

            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String[] getListOfWords() {
        return wordsToAbbrDictionary.keySet().toArray(new String[0]);
    }

    public String[] getListOfAbbrs() {
        return abbrToWordsDictionary.keySet().toArray(new String[0]);
    }

    public String getWordFromAbbr(String key) {
        return abbrToWordsDictionary.get(key);
    }

    public String getAbbrFromWord(String key) {
        return wordsToAbbrDictionary.get(key);
    }

    public WordsAndAbbrDictionary(String filePath) {
        this.loadData(filePath);
    }

}
