package ru.geekbrains.java1.dz.dz7.VasilyevDmitriy.Model;

/**
 * Created by VasilyevD on 15.09.2016.
 */
public class GameMap {
    private static final int gameSize=3;
    private char[][] map = new char[gameSize][gameSize];

    public void initMap(){
        for (int i = 0; i < gameSize; i++) { // двойным циклом проходимся по всему массиву
            for (int j = 0; j < gameSize; j++) {
                map[i][j] = '*'; // и заполняем каждую ячейку *
            }
        }
    }

    public static int getGameSize() {
        return gameSize;
    }
    public char getCharOnPosition(int x, int y){
        return map[x][y];
    }

    public char[][] getMap() {
        return map;
    }
}
