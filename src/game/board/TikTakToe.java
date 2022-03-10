package game.board;

import controls.Score;
import game.board.TikTakToeCell;
import game.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;

public class TikTakToe extends JPanel implements ActionListener {
    TikTakToeCell[] cells = new TikTakToeCell[9];

    private final ArrayDeque<Player> playerQueue = new ArrayDeque<>();
    private final Player crossPlayer = new Player("/home/allanburnier/IdeaProjects/gui/cross.png", "croix");
    private final Player roundPlayer = new Player("/home/allanburnier/IdeaProjects/gui/round.png", "ronds");
    private Player currentlyPlaying;


    private Score scoreBoard;

    public TikTakToe(Score score) {
        this.scoreBoard = score;
        this.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < this.cells.length; i++) {
            TikTakToeCell cell = new TikTakToeCell();
            this.add(cell);
            cell.addActionListener(this);
            this.cells[i] = cell;
        }
        this.initPlayers();
    }

    private void initPlayers() {
        playerQueue.add(crossPlayer);
        playerQueue.add(roundPlayer);
        this.currentlyPlaying = playerQueue.pollFirst();

    }

    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (cells[i * 3].getCheckedBy() != null && cells[i * 3].getCheckedBy() == cells[i * 3 + 1].getCheckedBy() && cells[i * 3 + 1].getCheckedBy() == cells[i * 3 + 2].getCheckedBy()) {
                return true;
            }
            if (cells[i].getCheckedBy() != null && cells[i].getCheckedBy() == cells[i + 3].getCheckedBy() && cells[i + 3].getCheckedBy() == cells[i + 6].getCheckedBy()) {
                return true;
            }
            if (cells[0].getCheckedBy() != null && cells[0].getCheckedBy() == cells[4].getCheckedBy() && cells[4].getCheckedBy() == cells[8].getCheckedBy()) {
                return true;
            }
            if (cells[2].getCheckedBy() != null && cells[2].getCheckedBy() == cells[4].getCheckedBy() && cells[4].getCheckedBy() == cells[6].getCheckedBy()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDraw() {
        for (TikTakToeCell c : this.cells) {
            if (c.getCheckedBy() == null) {
                return false;
            }
        }
        return true;
    }

    private void disableGrid() {
        for (TikTakToeCell c : this.cells) {
            c.disableCell();
        }
    }

    public void restartGame() {
        for (TikTakToeCell c : this.cells) {
            c.restartCell();
            this.playerQueue.clear();
            this.initPlayers();
            this.scoreBoard.restartDisplay();
        }
    }

    private void nextRound() {
        if (checkWin()) {
            playerQueue.clear();
            disableGrid();
            this.scoreBoard.displayWin(currentlyPlaying.getId());

        } else if (checkDraw()) {
            playerQueue.clear();
            this.scoreBoard.displayDraw();

        } else {
            playerQueue.add(currentlyPlaying);
            this.currentlyPlaying = playerQueue.pollFirst();
            this.scoreBoard.displayTurn(this.currentlyPlaying.getId());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (TikTakToeCell cell : cells) {
            if (e.getSource() == cell) {
                if (cell.canBeChecked() && this.playerQueue.size() > 0) {

                    cell.check(currentlyPlaying);
                    this.nextRound();


                }
            }
        }

    }
}
