package game;

import controls.Controls;
import controls.Score;
import game.board.TikTakToe;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {


    public MainWindow() {

        //general window settings
        //closing
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //size
        this.setSize(650, 650);
        this.setMinimumSize(new Dimension(600, 600));
        this.setResizable(false); // comment if want to resize window
        //layout manage
        this.setLayout(new BorderLayout());
        this.setTitle("ToukTikToue");


        //Control board for score and restart button

        Controls controlBoard = new Controls();
        Score scoreBoard = new Score();
        controlBoard.add(scoreBoard);

        this.add(controlBoard, BorderLayout.SOUTH);

        //tiktaktoe game
        TikTakToe gamePanel = new TikTakToe(scoreBoard);
        this.add(gamePanel, BorderLayout.CENTER);
        this.setVisible(true);

        //reset button action handling
        JButton restartButton = new JButton("RESTART");
        restartButton.addActionListener(e -> {
            gamePanel.restartGame();
        });

        //reset button styling
        restartButton.setFont(new Font("Verdana", Font.BOLD, 20));
        restartButton.setForeground(Color.BLACK);
        restartButton.setBackground(Color.LIGHT_GRAY);
        restartButton.setBorderPainted(false);
        restartButton.setFocusPainted(false);
        controlBoard.add(restartButton);


    }


}
