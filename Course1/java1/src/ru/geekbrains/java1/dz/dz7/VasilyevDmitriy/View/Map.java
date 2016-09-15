package ru.geekbrains.java1.dz.dz7.VasilyevDmitriy.View;
import ru.geekbrains.java1.dz.dz7.VasilyevDmitriy.Model.Game;
import ru.geekbrains.java1.dz.dz7.VasilyevDmitriy.Model.GameMap;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Map extends JPanel {

    final int PANEL_SIZE = 500;
    int linesCount;
    int CELL_SIZE;
    GameMap mp;
    Game game;

    public Map(int linesCount) {
        this.linesCount = linesCount;
        CELL_SIZE = PANEL_SIZE / linesCount;
        mp = new GameMap();
        mp.initMap();
        game = new Game();
        setBackground(Color.white);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                System.out.println(e.getX() + " " + e.getY());
                int spx = e.getY() / CELL_SIZE;
                int spy = e.getX() / CELL_SIZE;
                System.out.println(spx + " " + spy);
                if(mp.getCharOnPosition(spx,spy)=='*'&&game.getIsGameContinue()){
                    game.doGameLogic(mp,spx,spy);
                    repaint();
                }
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = CELL_SIZE/2-40;
        int y =x;
        for (int i = 0; i < linesCount; i++) {
            g.drawLine(0, i * CELL_SIZE, PANEL_SIZE, i * CELL_SIZE);
            g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, PANEL_SIZE);
        }
        for (int i=0;i<mp.getGameSize();i++){
            for (int j=0;j<mp.getGameSize();j++){
                if(mp.getCharOnPosition(i,j)=='O') {
                    g.drawOval(x+j*CELL_SIZE,y+i*CELL_SIZE,80,80);
                }
                if(mp.getCharOnPosition(i,j)=='X'){
                    g.drawLine(x+j*CELL_SIZE,y+i*CELL_SIZE,x+j*CELL_SIZE+80,y+i*CELL_SIZE+80);
                    g.drawLine(x+j*CELL_SIZE,y+i*CELL_SIZE+80,x+j*CELL_SIZE+80,y+i*CELL_SIZE);

                }
            }
        }
    }
    public void initNewGame(){
        mp.initMap();
        game.newGame();
        repaint();
        MyWindow.setLabel("New Game");
    }
}

