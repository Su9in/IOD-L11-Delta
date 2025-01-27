package pl.put.poznan.transformer.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *  This is NumberDictionary class that stores numbers and its names in Polish.
 *  Dictionary elements looks like this 'key value'
 *  Every element should be in separate line
 */

public class NumberDictionary {
    private HashMap<String, String> numberDictionary = new HashMap<>();

    /**
     * Function that loads dictionary data from csv file
     * Prints Stack Trace in case of an error file was not found
     * @param filePath path to the file with dictionary values
     *
     */
    private void loadData(String filePath){
        String line;
        String[] dictElems;

        try{
            File dictFile = new File(filePath);
            Scanner reader = new Scanner(dictFile);

            while(reader.hasNextLine()) {
                line = reader.nextLine();
                dictElems = line.split(" ");
                numberDictionary.put(dictElems[0], dictElems[1]);
            }

            reader.close();

        } catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Function that gets the value stored in dictionary under given key
     * @param key searched key value
     * @return value in dictionary
     */
    public String getValue(String key){
        return numberDictionary.get(key);
    }

    /**
     * Function that answers the question is key in dictionary
     * @param key searched key
     * @return true if key is in dictionary or false
     */
    public boolean isKeyInDictionary(String key) {
        return numberDictionary.containsKey(key);
    }

    /**
     * Class constructor
     * @param filePath path to the dictionary file
     */
    public NumberDictionary(String filePath){
        this.loadData(filePath);
    }
}
