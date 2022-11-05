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

public class GUI {
    static JLabel weightedScore ;
    static JFrame frame;
    public static void placeComponents(){
        //Set the frame
        frame = new JFrame("Weighted Grade");
        frame.setSize(1000,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel totalLabel = new JLabel("Total Assignment Points");
        totalLabel.setBounds(20, 20, 200, 25);  //set the position and area
        panel.add(totalLabel);      // add the label to panel

        JLabel earnedLabel = new JLabel("Earned Point");
        earnedLabel.setBounds(600, 20, 200, 25);
        panel.add(earnedLabel);

        JLabel percentLabel = new JLabel("Percentage of class（%）");
        percentLabel.setBounds(20, 200, 200, 25);
        panel.add(percentLabel);

        JTextField totalText = new JTextField(4);
        totalText.setBounds(20, 70, 200,25);
        panel.add(totalText);

        JTextField earnedText = new JTextField(4);
        earnedText.setBounds(600, 70, 200,25);
        panel.add(earnedText);

        JTextField percentText = new JTextField(3);
        percentText.setBounds(20, 250, 200, 25);
        panel.add(percentText);

        JButton calculate = new JButton("Click to calculate score");
        calculate.setBounds(400, 400, 200,35);
        //Listener method to calculate
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double total = Double.parseDouble(totalText.getText());
                    double earned = Double.parseDouble(earnedText.getText());
                    double percent = Double.parseDouble(percentText.getText());
                    double grade = calculate(total, earned, percent);
                    String str = String.valueOf(grade);
                    output(str);
                    panel.add(weightedScore);
                    frame.setVisible(false);
                    frame.setVisible(true);
                }catch (Exception exception) {
                    System.out.println("Please check your input");
                }
//                System.out.println("test");
            }
        });
        panel.add(calculate);
        frame.add(panel);
        frame.setVisible(true);

    }

    //method for displaying final result
    private static void output(String str){
        weightedScore = new JLabel("Weighted Score:  " + str);
        weightedScore.setBounds(400, 450, 200, 35);
    }

    private static double calculate(double total, double earned, double percent){
        return earned/total*percent;
    }
}
