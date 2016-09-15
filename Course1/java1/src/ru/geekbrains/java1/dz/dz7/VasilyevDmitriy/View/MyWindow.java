package ru.geekbrains.java1.dz.dz7.VasilyevDmitriy.View;
import ru.geekbrains.java1.dz.dz7.VasilyevDmitriy.Model.GameMap;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyWindow extends JFrame {
    static JLabel jLabel;
    public MyWindow() {
        setSize(500, 550);
        setResizable(false);
        setLocation(800, 200);
        setTitle("Крестики Нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Map jpMap = new Map(GameMap.getGameSize());
        JPanel jpBottom = new JPanel(new GridLayout());
        jpBottom.setBackground(new Color(128, 255, 224));
        add(jpBottom, BorderLayout.SOUTH);
        add(jpMap, BorderLayout.CENTER);


        JButton jbStart = new JButton("Start New Game");
        JButton jbExit = new JButton("Exit Game");
        jLabel = new JLabel("New Game");
        jpBottom.add(jbStart);
        jpBottom.add(jbExit);
        add(jLabel, BorderLayout.NORTH);
        jbExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jbStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpMap.initNewGame();
            }
        });

        setVisible(true);

    }
    public static void setLabel(String s){
        jLabel.setText(s);
    }
}
