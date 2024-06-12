package app;

import javax.swing.*;

import java.awt.Color;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Counter implements ActionListener {

    int count = 0;
    JFrame frame;
    JLabel label;
    JLabel label1;
    JLabel label2;
    JPanel panel;
    JPanel buttons;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;

    public Counter() {
        frame = new JFrame();

        panel = new JPanel();
        buttons = new JPanel();

        b1 = new JButton("Random fact");
        b1.addActionListener(this);
        b2 = new JButton("Counter");
        b2.addActionListener(this);

        label = new JLabel("Click To get a random ass fact");
        label1 = new JLabel("");
        label2 = new JLabel("");
        label2.setFont(new Font("Serif", Font.PLAIN, 25));
        label1.setFont(new Font("Serif", Font.PLAIN, 35));
        label.setFont(new Font("Serif", Font.PLAIN, 35));

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(2, 1, 0, 0));
        buttons.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        buttons.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        buttons.setLayout(new GridLayout(1, 0, 0, 0));

        frame.add(panel, BorderLayout.SOUTH);
        frame.add(buttons, BorderLayout.NORTH);
        panel.add(label);
        panel.add(label1);
        panel.add(label2);
        buttons.add(b1);
        buttons.add(b2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Counter");
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Counter();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            
            Random rand = new Random();
            int top = 52;
            count = rand.nextInt(top);


            JDBCConnection jdbc = new JDBCConnection();
            ArrayList<facts> facts = jdbc.getFacts(count);

            for (facts facts2 : facts) {
                label1.setText(facts2.getBFacts());
                label2.setText(facts2.getSFacts());
            }
        }

        if (e.getSource() == b2) {
            panel.remove(label);
            panel.remove(label1);
            panel.remove(label2);
            
            
        }
    }
}