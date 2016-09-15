package ru.geekbrains.java1.dz.dz7.VasilyevDmitriy.Model;

import ru.geekbrains.java1.dz.dz7.VasilyevDmitriy.View.MyWindow;

import static ru.geekbrains.java1.dz.dz7.VasilyevDmitriy.Model.TicTacToe.checkWin;
import static ru.geekbrains.java1.dz.dz7.VasilyevDmitriy.Model.TicTacToe.isMapFull;
import static ru.geekbrains.java1.dz.dz7.VasilyevDmitriy.Model.TicTacToe.printMap;

/**
 * Created by VasilyevD on 15.09.2016.
 */
public class Game {
    private boolean isGameContinue;
    public Game(){
        isGameContinue=true;
    }
    public boolean getIsGameContinue(){
        return isGameContinue;
    }
    public void newGame(){
        isGameContinue=true;
    }
    public void doGameLogic(GameMap map, int spx, int spy){
        Gamers.humanTurn(map.getMap(), spx,spy); // ход человека
        printMap(); // печать поля
        if (checkWin(map.getMap(),'X')) { // проверка победы человека
            MyWindow.setLabel("Победил игрок");
            isGameContinue=false;
        }
        if(!isMapFull(map.getMap())){
            Gamers.aiTurn(map.getMap()); // ход компьютера
            printMap(); // печать поля
            if (checkWin(map.getMap(),'O')) { // проверка победы компьютера
                MyWindow.setLabel("Победил компьютер");
                isGameContinue=false;
            }
        } else {
            MyWindow.setLabel("Ничья!");
            isGameContinue=false;
        }
    }
}
