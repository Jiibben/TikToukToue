package controls;

import javax.swing.*;
import java.awt.*;

public class Score extends JLabel {
    public static final Font SCOREFONT = new Font("Verdana", Font.PLAIN, 25);
    public static final Color SCORECOLOR = new Color(123, 99, 175);
    public static final String STARTINGMESSAGE = "Commencez";
    public Score(){
        super();
        this.setVisible(true);
        this.setText(STARTINGMESSAGE);
        this.setFont(SCOREFONT);
        this.setForeground(SCORECOLOR);
        this.setBackground(Color.BLACK);
    }

    public void displayTurn(String id){
        this.setText("C'est au tour des " + id);
    }

    public void restartDisplay(){
        this.setText(STARTINGMESSAGE);

    }

    public void displayWin(String id){
        this.setText("Les " + id + " gagnent");
    }

    public void displayDraw(){
        this.setText("C'est une égalité");
    }
}
