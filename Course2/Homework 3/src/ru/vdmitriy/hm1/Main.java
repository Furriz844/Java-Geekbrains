package ru.vdmitriy.hm1;

import javax.swing.*;
import java.text.Normalizer;
import java.util.*;

/**
 * Created by VasilyevD on 30.09.2016.
 */
public class Main {

    public static void main(String[] args) {
        String Song = "work it harder make it " +
                "do it faster makes us " +
                "more than ever hour " +
                "our work is never over " +
                "work it harder " +
                "do it faster " +
                "more than ever " +
                "our work is never over " +
                "work it harder " +
                "make it better " +
                "do it faster " +
                "makes us stronger";
        System.out.println(howManyWords(Song));
        System.out.println(wordsWhichMadeString(Song));
        JFrame frame = new JFrame();
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
    public static HashMap<String, Integer> howManyWords(String s){
        String[] words = s.split(" ");
        HashMap<String, Integer> wordList = new HashMap<>();
        for(String word: words){
            if(wordList.containsKey(word)) {
                /** Можно ли сделать увеличение значения
                 * параметра более элегантно?
                 */
                int value = wordList.get(word);
                value++;
                wordList.put(word, value);
            } else {
                wordList.put(word,1);
            }
        }
        return wordList;
    }
    public static HashSet<String> wordsWhichMadeString(String s) {
        HashSet<String> words = new HashSet<>(Arrays.asList(s.split(" ")));
        return words;
    }
}
