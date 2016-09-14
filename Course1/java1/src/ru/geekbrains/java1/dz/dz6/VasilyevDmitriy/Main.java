package ru.geekbrains.java1.dz.dz6.VasilyevDmitriy;

/**
 * Created by VasilyevD on 07.09.2016.
 */
public class Main {
    public static void main(String args[]){
        //Файлы должны лежать в корне проекта
        fileUtil.concatFile("file1.txt","file2.txt","file3.txt");
        System.out.println(fileUtil.isWordInFile("us", "file3.txt"));
    }
}
