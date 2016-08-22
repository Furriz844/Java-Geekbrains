package ru.geekbrains.java1.dz.dz2.VasilyevDmitriy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by VasilyevD on 22.08.2016.
 */
public class HomeWork2 {
    public static void main(String args[]) {
        //Homework 2. Part 1-2
        //Create array and change 0 to 1
        int[] array = {1,0,1,1,0,0,0,1,1};
        System.out.println(Arrays.toString(array));
        for(int i=0;i<array.length;i++){
            if(array[i]==0) {
                array[i] = 1;
            }
        }
        System.out.println(Arrays.toString(array));
        //Homework 2. End of  Part 1-2

        //Homework 2. Part 3
        //A fill cycle
        int[] array2 = new int[8];
        for(int i=0;i<array2.length;i++){
            array2[i]=1+3*i;
        }
        System.out.println(Arrays.toString(array2));
        //Homework 2. End of Part 3

        //Homework 2. Part 4
        //element*2 if element <6
        int[] mas = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for(int i=0;i<mas.length;i++){
            if(mas[i]<6) {
                mas[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(mas));
        //Homework 2. End of  Part 4

        //Homework 2. Part 5
        //Min and Max
        int[] mas2 = { 8, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 23 };
        int min = mas2[0];
        int max = mas2[0];
        for(int i=1;i<mas2.length;i++){ //not need check first element
            if(mas2[i]<min) {
                min = mas2[i];
            }
            if(mas2[i]>max) {
                max = mas2[i];
            }
        }
        System.out.println("Min is "+ min +"\n"
                +"Max is "+max);
        //Homework 2. End of  Part 5

        //Homework 2. Part 6
        //Calc.java
        int answer;
        Scanner sc = new Scanner(System.in);
        String userInterface;
        System.out.println("Simple Calculator");
        while (true){
            System.out.println("Press Enter to calculate!\n" +
                    "Input e to exit!");
            userInterface = sc.nextLine();
            if(userInterface.equals("e")) {
                break;
            } else {
                answer = Calc.calculateIt();
                System.out.println("Answer is "+answer);
            }

        }
    }
}
