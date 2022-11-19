/**
 * Assignment7
 * [Yuhao Zhang]
 * [002743843]
 * [Section08]
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GUI {
    static JLabel weightedScore;
    static JFrame frame;

    public static void placeComponents() {
        //Set the frame
        frame = new JFrame("Data Files and GUI");
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel readLabel = new JLabel("Reading File Name");
        readLabel.setBounds(20, 20, 200, 25);  //set the position and area
        panel.add(readLabel);      // add the label to panel

        JLabel writeLable = new JLabel("File Name To Write");
        writeLable.setBounds(600, 20, 200, 25);
        panel.add(writeLable);

        JTextField readText = new JTextField("annual.csv", 30);
        readText.setBounds(20, 70, 200, 25);
        panel.add(readText);

        JTextField writeText = new JTextField(30);
        writeText.setBounds(600, 70, 200, 25);
        panel.add(writeText);

        JButton readFile = new JButton("Click to read from file");
        readFile.setBounds(20, 150, 200, 25);
        panel.add(readFile);

        JButton writeFile = new JButton("Click to write file");
        writeFile.setBounds(600, 150, 200, 25);
        panel.add(writeFile);

        JLabel displayLabel1 = new JLabel("First five lines of file");
        displayLabel1.setBounds(20, 250, 200, 25);
        panel.add(displayLabel1);

        JLabel displayLabel2 = new JLabel("First five lines of new file");
        displayLabel2.setBounds(600, 250, 200, 25);
        panel.add(displayLabel2);

        JTextArea displayFile1 = new JTextArea();
        displayFile1.setLineWrap(true);
        displayFile1.setBounds(20, 350, 400, 200);

        JTextArea displayFile2 = new JTextArea();
        displayFile2.setLineWrap(true);
        displayFile2.setBounds(600, 350, 200, 200);


        readFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String file = readText.getText();
                String filePath = GUI.class.getResource("")+file;
                filePath = filePath.split(":")[1];
                String read = ReadFile.readFile(filePath);
                displayFile1.setText(read);
                displayFile1.setWrapStyleWord(true);
                frame.setVisible(true);
            }
        });
        panel.add(displayFile1);

        writeFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String writeFileName = writeText.getText();
                String readFileName = readText.getText();
                String writeOut = ReadFile.writeIn(writeFileName, readFileName);
                displayFile2.setText(writeOut);
                displayFile2.setWrapStyleWord(true);
                frame.setVisible(true);
            }
        });
        frame.add(panel);
        frame.setVisible(true);

//        JButton calculate = new JButton("Click to calculate score");
//        calculate.setBounds(400, 400, 200,35);
//        //Listener method to calculate
//        calculate.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String fileName =
//                try {
//                    double total = Double.parseDouble(totalText.getText());
//                    double earned = Double.parseDouble(earnedText.getText());
//                    double percent = Double.parseDouble(percentText.getText());
//                    double grade = calculate(total, earned, percent);
//                    String str = String.valueOf(grade);
//                    output(str);
//                    panel.add(weightedScore);
//                    frame.setVisible(false);
//                    frame.setVisible(true);
//                }catch (Exception exception) {
//                    System.out.println("Please check your input");
//                }
////                System.out.println("test");
//            }
//        });
//        panel.add(calculate);
//        frame.add(panel);
//        frame.setVisible(true);
//
//    }
//
//    //method for displaying final result
//    private static void output(String str){
//        weightedScore = new JLabel("Weighted Score:  " + str);
//        weightedScore.setBounds(400, 450, 200, 35);
//    }
//
//    private static double calculate(double total, double earned, double percent){
//        return earned/total*percent;
//    }
    }
}
