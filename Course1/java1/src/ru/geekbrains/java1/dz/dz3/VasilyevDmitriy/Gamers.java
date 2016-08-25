package ru.geekbrains.java1.dz.dz3.VasilyevDmitriy;

import java.util.Random;
import java.util.Scanner;

import static ru.geekbrains.java1.dz.dz3.VasilyevDmitriy.TicTacToe.isCellEmpty;
import static ru.geekbrains.java1.dz.dz3.VasilyevDmitriy.TicTacToe.predictWin;

/**
 * Created by VasilyevD on 24.08.2016.
 * Класс, описывающий поведение игроков - компьютера и человека
 */
public class Gamers {
    private static Scanner sc = new Scanner(System.in); // Scanner для чтения консоли
    private static Random rand = new Random(); // генератор случайных чисел

    public static void aiTurn(char map[][]) {
        int x, y;
        String predict = predictWin();
        System.out.println(predict);
        //Метод predictWin() возвращает строку вида y_x или NO
        //Если вернул NO, значит выигрышной комбинации нет, ставим свою фишку
        //в любое место, если вернул y_x то получаем y и x обращаясь к символам
        //на 0 и 2 позиции в строке и преобразуем в Int
        if (predict.equals("NO")){
            System.out.println("Компьютер думает, куда ему поставить фишку");
            do { // компьютер пытается случайно выбрать незанятое поле для хода
                x = rand.nextInt(TicTacToe.SIZE);
                y = rand.nextInt(TicTacToe.SIZE);
            } while (!isCellEmpty(x, y));
        } else {
            x = Character.getNumericValue(predict.charAt(predict.length()-1));
            y = Character.getNumericValue(predict.charAt(0));
            System.out.println("Компьютер раскрыл ваш коварный план!");
        }
        System.out.println("Компьютер ставит фишку в "+(x+1)+" "+(y+1));
        map[x][y] = 'O'; // как только ячейка



        // найдена, ставим туда О
    }
    public static void humanTurn(char map[][]) { // ход человека
        int x, y;
        do {
            System.out.println("Введите координаты в формате 'Номер строки' пробел 'Номер столбца'");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellEmpty(x, y)); // пользователь вводит координаты до тех пор, пока не укажет на свободную ячейку
        map[x][y] = 'X'; // после чего ставим туда Х
    }
}
