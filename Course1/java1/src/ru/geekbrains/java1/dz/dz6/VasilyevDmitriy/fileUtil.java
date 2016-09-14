package ru.geekbrains.java1.dz.dz6.VasilyevDmitriy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by VasilyevD on 07.09.2016.
 */
public class fileUtil {
    public static String stringFromFileLoad(String fileName){
        StringBuffer sb = new StringBuffer();
        int i;
        FileInputStream fs;
        try {
            fs = new FileInputStream(fileName);
            do {
                i=fs.read();
                if (i!=-1)sb.append((char)i);
            } while (i!=-1);
            fs.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }
    public static void concatFile(String inputFile1, String inputFile2, String outputFile){
        String file1, file2;
        file1 = stringFromFileLoad(inputFile1);
        file2 = stringFromFileLoad(inputFile2);
        FileOutputStream fso;
        try {
            fso = new FileOutputStream(outputFile);
            writeToFile(file1, fso);
            writeToFile(file2, fso);
            fso.close();
        } catch (Exception e){
            e.printStackTrace();
            return;
        }
    }
    private static void writeToFile(String s, FileOutputStream f){
        try {
            for (int i = 0; i<s.length();i++){
                f.write(s.charAt(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean isWordInFile(String word, String file){
        String content = stringFromFileLoad(file);
        if (content.indexOf(word)!=-1) return true;
        return false;
    }
}
