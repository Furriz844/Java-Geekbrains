package ru.geekbrains.java1.dz.dz2.VasilyevDmitriy;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by VasilyevD on 22.08.2016.
 */
public class Calc {
    private static int inputNumber(String i){
        Scanner in = new Scanner(System.in);
        String s = null;
        Pattern p = Pattern.compile("^\\d+$");
        Matcher m = null;
        do
        {
            System.out.println("Please, input a "+i+" number ");
            s = in.nextLine();
            m = p.matcher(s);
        } while(!m.matches());

        return Integer.parseInt(s);
    }
    public static int calculateIt(){
        int a,b,c;
        a = inputNumber("first");
        b = inputNumber("second");
        System.out.println("First number is "+a+"\nSecond number is "+b);
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, input operation. You can use + , - , / , * .");
        String option =sc.nextLine();
        switch (option) {
            case "+":{
                c = a+b;
                break;
            }
            case "-":{
                c = a-b;
                break;
            }
            case "/":{
                if(b==0){
                    System.out.println("Error! Divide by Zero. return 0");
                    c = 0;
                } else {
                    c = a/b;
                }
                break;
            }
            case "*":{
                c = a*b;
                break;
            }
            default:{
                System.out.println("Error! Unknow operation. return 0");
                c= 0;
                break;
            }
        }
        return c;
    }
}
