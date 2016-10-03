package ru.vdmitriy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by VasilyevD on 03.10.2016.
 */
public class Chat extends JFrame {

    JLabel label = new JLabel("Log chat");
    JScrollPane scrollPane;
    JTextArea textArea; //chats log
    JPanel p2 = new JPanel();
    JLabel label2 =new JLabel("Type you message");
    JTextField textArea2 =  new JTextField(25);
    JButton button;
    String fileName = "log.txt";

    public Chat(){
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 500, 400);
        setResizable(false);
        setLayout(new BorderLayout());

        add(label, BorderLayout.NORTH);

        textArea = new JTextArea(10,10);
        scrollPane = new JScrollPane(textArea,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, BorderLayout.CENTER);

        button = new JButton("Submit");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    printMessage();
                } catch (IOException d){
                    d.printStackTrace();
                    System.out.println("Get Error with Write/Read Log file");;
                }

            }
        });


        p2.add(label2);
        p2.add(textArea2);
        p2.add(button);
        add(p2,BorderLayout.SOUTH);


        setVisible(true);
    }

    private  void printMessage() throws IOException{
        Date d = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("hh:mm");
        String message = textArea2.getText();
        String msg = "User "+format1.format(d)+" : "+message+'\n';
        textArea.append(msg);
        File logfile = new File(fileName);
        if(logfile.exists()){
            writeMessage(msg);
        } else {
            logfile.createNewFile();
            writeMessage(msg);
        }
    }
    private void writeMessage(String msg) throws IOException{
        PrintWriter pw = new PrintWriter(new FileWriter(fileName, true));
        pw.print(msg);
        pw.close();
    }
}
