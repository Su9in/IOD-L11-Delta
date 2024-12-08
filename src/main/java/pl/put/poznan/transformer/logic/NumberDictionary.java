package pl.put.poznan.transformer.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *  Dictionary elements looks like this '<key> <value>'
 *  Every element should be in separate line
 */

public class NumberDictionary {
    private HashMap<String, String> numberDictionary = new HashMap<>();

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

    public String getValue(String key){
        return numberDictionary.get(key);
    }

    public boolean isKeyInDictionary(String key) {
        return numberDictionary.containsKey(key);
    }

    public NumberDictionary(String filePath){
        this.loadData(filePath);
    }
}
