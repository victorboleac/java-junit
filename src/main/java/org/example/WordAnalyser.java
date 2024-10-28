package org.example;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class WordAnalyser {
    public String[] findLongestWords(String text) {
        // TODO: Implement the logic to find the longest word(s) in the given text
        String cleanedText = text.replaceAll("[^a-zA-Z0-9]", " ");
        String [] arrayOfString = cleanedText.split(" ");
        String longestString = arrayOfString[0];
        for(int i =1; i< arrayOfString.length; i++){
            if(arrayOfString[i].length()>longestString.length()){
                longestString = arrayOfString[i];
            }
        }
        ArrayList<String> stringArray = new ArrayList<>();
        for(String word : arrayOfString){
            if(word.length() == longestString.length()){
                stringArray.add(word);
            }
        }
        String[] result = new String[stringArray.size()];
        for(int i=0; i<stringArray.size(); i++){
            result[i] = stringArray.get(i);
        }
        return result;
    }

    public Map<Character, Integer> calculateLetterFrequency(String text) {
        // TODO: Implement the logic to calculate the frequency of each letter in the given text
        Map<Character, Integer> frequency = new HashMap<>();
        for(char ch: text.toCharArray()){
            ch = Character.toLowerCase(ch);
             if (frequency.containsKey(ch)){
                 frequency.put(ch, frequency.get(ch)+1);
             } else {
                 frequency.put(ch,1);
             }
        }
        return frequency;
    }
}