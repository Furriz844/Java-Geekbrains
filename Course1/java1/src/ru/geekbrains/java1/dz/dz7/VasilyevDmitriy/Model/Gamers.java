package ru.geekbrains.java1.dz.dz7.VasilyevDmitriy.Model;

import ru.geekbrains.java1.dz.dz7.VasilyevDmitriy.View.MyWindow;

import java.util.Random;
import static ru.geekbrains.java1.dz.dz7.VasilyevDmitriy.Model.TicTacToe.isCellEmpty;
import static ru.geekbrains.java1.dz.dz7.VasilyevDmitriy.Model.TicTacToe.predictWin;


/**
 * Created by VasilyevD on 24.08.2016.
 * Класс, описывающий поведение игроков - компьютера и человека
 */
public class Gamers {
    private static Random rand = new Random(); // генератор случайных чисел

    public static void aiTurn(char map[][]) {
        int x, y;
        String s="Компьютер ";
        String predict = predictWin(map,'O');
        //Метод predictWin() возвращает строку вида y_x или NO
        //Если вернул NO, значит выигрышной комбинации нет, ставим свою фишку
        //в любое место, если вернул y_x то получаем y и x обращаясь к символам
        //на 0 и 2 позиции в строке и преобразуем в Int
        if (!predict.equals("NO")){
            x = Character.getNumericValue(predict.charAt(predict.length()-1));
            y = Character.getNumericValue(predict.charAt(0));
            s=s+"оказался хитрее вас и ";
        } else {
            predict = predictWin(map,'X');
            if (!predict.equals("NO")){
                x = Character.getNumericValue(predict.charAt(predict.length()-1));
                y = Character.getNumericValue(predict.charAt(0));
                s=s+"раскрыл ваш коварный план и ";
            } else {
                //MyWindow.setLabel("Компьютер думает, куда ему поставить фишку");
                do { // компьютер пытается случайно выбрать незанятое поле для хода
                    x = rand.nextInt(TicTacToe.SIZE);
                    y = rand.nextInt(TicTacToe.SIZE);
                } while (!isCellEmpty(map,x, y));
            }
        }
        MyWindow.setLabel(s+"ставит фишку в "+(x+1)+" "+(y+1));
        map[x][y] = 'O';
    }

    public static void humanTurn(char map[][], int x, int y) { // ход человека
        map[x][y] = 'X'; // после чего ставим туда Х
        MyWindow.setLabel("Вы ставите фишку в "+(x+1)+" "+(y+1));
    }
}
