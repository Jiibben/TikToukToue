package game.board;

import game.player.Player;

import javax.swing.*;
import java.awt.*;

public class TikTakToeCell extends JButton {

    // 0 for checked 1 for round 2 for cross
    private Player checkedBy;
    public static final Color WINNINGCOLOR = Color.GREEN;

    public TikTakToeCell(){
        super();
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        this.setVisible(true);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);

    }

    public void setWinning(){
        this.setBackground(WINNINGCOLOR);
        this.setContentAreaFilled(true);
        this.setBorderPainted(false);
    }

    public void disableCell(){
        this.setEnabled(false);
    }
    public void enableCell(){
        this.setEnabled(true);
    }
    public void check(Player player){
        this.checkedBy = player;
        this.setIcon(player.getPlayerSprite());
        this.setDisabledIcon(player.getPlayerSprite());
        this.setEnabled(false);

    }

    public Player getCheckedBy(){
        return this.checkedBy;
    }

    public void uncheck(){
        checkedBy = null;
    }

    public void restartCell(){
        this.uncheck();
        this.enableCell();
        this.setIcon(null);
        this.setContentAreaFilled(false);
        this.setBorderPainted(true);
    }

    public boolean canBeChecked(){
        return checkedBy == null;

    }



}
