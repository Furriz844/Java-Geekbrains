package ru.geekbrains.java1.dz.dz5.VasilyevDmitriy;

import java.util.Scanner;

/**
 * Created by VasilyevD on 05.09.2016.
 * Программа написана исходя из руководства http://www.openchess.ru/pravilaChess.php
 */
public class Main {
    public static void main(String args[]){
        System.out.println("Введите номер фигуры, которую собираетесь поставить на поле:\n" +
                "1 - Пешка\n" +
                "2 - Слон\n" +
                "3 - Ладья\n" +
                "4 - Конь\n" +
                "5 - Ферзь\n" +
                "6 - Король\n");
        Scanner sc = new Scanner(System.in);
        int figure = sc.nextInt();
        if (figure>0 && figure <7){
            System.out.print("Введите начальную позицию: ");
            String startPoint = sc.next();
            System.out.print("Введите конечную позицию: ");
            String endPoint = sc.next();
            switch (figure) {
                case 1:
                    Chess.Peshka peshka = new Chess.Peshka(startPoint, endPoint);
                    System.out.println("Возможность такого хода - "+peshka.isRightMove());
                    break;
                case 2:
                    Chess.Slon slon = new Chess.Slon(startPoint, endPoint);
                    System.out.println("Возможность такого хода - "+slon.isRightMove());
                    break;
                case 3:
                    Chess.Ladya ladya = new Chess.Ladya(startPoint, endPoint);
                    System.out.println("Возможность такого хода - "+ladya.isRightMove());
                    break;
                case 4:
                    Chess.Kon kon = new Chess.Kon(startPoint, endPoint);
                    System.out.println("Возможность такого хода - "+kon.isRightMove());
                    break;
                case 5:
                    Chess.Ferz ferz = new Chess.Ferz(startPoint, endPoint);
                    System.out.println("Возможность такого хода - "+ferz.isRightMove());
                    break;
                case 6:
                    Chess.Korol korol = new Chess.Korol(startPoint, endPoint);
                    System.out.println("Возможность такого хода - "+korol.isRightMove());
                    break;
            }
        } else {
            System.out.println("Такой фигуры нет");
        }
    }
}
