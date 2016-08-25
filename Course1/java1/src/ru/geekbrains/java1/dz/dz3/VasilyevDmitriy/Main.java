package ru.geekbrains.java1.dz.dz3.VasilyevDmitriy;
import java.util.Scanner;

public class Main {
    /*Во время выполнения домашнего задания было выполнено следующее:
    * 1) Выделены классы Gamers - описывающий игроков и TicTacToe - описывающий логику игры
    * 2) Поле можно увеличивать в пределах от 2*2 до 9*9 (При других размерах игра ведет себя некорректно)
    * 3) ИИ теперь может прерывать выигрышную комбинацию игрока для этого был написан метод predictWin() и
    *       немного изменен метод aiTurn
    * 4) Переписана проверка победы(работает при любых значениях)
    * 5) После окончания игры пользовотелю предлагается сыграть еще раз =) (меню)
    * 6) !!!ИИ теперь видит свои выйгрышные ходы!
    * */
    public static void main(String[] args) {
        System.out.println("Крестики Нолики");
        TicTacToe.initMap(); // инициализируем поле
        TicTacToe.printMap(); // печатаем в консоль
        TicTacToe.gameStart();
        Scanner sc = new Scanner(System.in);
        String userInterface;
        while (true){
            System.out.println("Нажми Enter, чтобы сыграть еще одну партию\n" +
                    "Введи ! для выхода");
            userInterface = sc.nextLine();
            if(userInterface.equals("!")) {
                break;
            } else {
                TicTacToe.initMap(); // инициализируем поле
                TicTacToe.printMap(); // печатаем в консоль
                TicTacToe.gameStart();
            }

        }
    }
}

