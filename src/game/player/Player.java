package game.player;

import javax.swing.*;

public class Player {
    private ImageIcon sprite;
    private String id;


    public Player(String imagePath, String id) {
        this.sprite = new ImageIcon(imagePath);
        this.id = id;

    }


    public ImageIcon getPlayerSprite(){
        return this.sprite;
    }

    public String getId() {
        return id;
    }
}
