package dz.dz1.VasilyevDmitriy;

/**
 * Created by VasilyevD on 17.08.2016.
 */
public class Main {
    public static void main(String args[]){


        //Homework


        //Part 2 Variable
        byte byteVar = 100;
        short shortVar = 32000;
        int intVar = 2147000000;
        long longVar = 45L;
        float floatVar = 45.0f;
        double doubleVar = 123.23d;
        boolean booleanVar = true;
        char charVar = 'd';
        String stringVar = "Android one love";

        //Part 3
        System.out.println("First sum is = "+sum(1,2,3,4)); //Return 2
        System.out.println("Second sum is = "+sum(1,2,3,0)); //Return 0, because d = 0

        //Part 4
        System.out.println("First Check - " + isSumBetween(10,5)); //Return true (10+5 = 15)
        System.out.println("Second Check - " + isSumBetween(1,5)); //Return false (1+5 = 6)
        System.out.println("Third Check - " + isSumBetween(10,25)); //Return false (10+25 = 35)

        //Part 5
        System.out.println("2004 is leap-year - "+ isLeapYear(2004));
        System.out.println("2005 is leap-year - "+ isLeapYear(2005));
        System.out.println("100 is leap-year - "+ isLeapYear(100));
        System.out.println("1000 is leap-year - "+ isLeapYear(1000));
        System.out.println("400 is leap-year - "+ isLeapYear(400));
        System.out.println("800 is leap-year - "+ isLeapYear(800));





    }
    //Part 3 Sum method
    public static int sum(int a, int b, int c, int d){
        if (d != 0) {
            return a * (b + c / d);
        } else {
            System.out.println("d = 0! Kernel Panic! Method will be return 0");
            return 0;
        }
    }

    //Part 4 Check sum between 10 and 20
    public static boolean isSumBetween(int a, int b){
        int sum = a+b;
        return sum>=10 && sum<=20;

    }
    //Part 5 Check Year is a leap-year
    public static boolean isLeapYear(int year){
        if (year > 0) {
            return ((year % 100 != 0) & (year % 4 == 0)) | (year % 400 == 0);
        } else {
            System.out.println("Variable year must be > 0; Return false");
            return false;
        }
    }

}
