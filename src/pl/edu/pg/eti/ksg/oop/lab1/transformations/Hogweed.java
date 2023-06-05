package pl.edu.pg.eti.ksg.oop.lab1.transformations;

import javax.swing.*;

public class Hogweed extends Plant {
    Hogweed(int y, int x) {
        this.is_animal = false;
        this.alive = true;
        this.big_index = 5;
        this.initiative = 0;
        this.strength = 10;
        this.symbol = '#';
        this.name = "Hogweed";
        this.y = y;
        this.x = x;
        this.image = new ImageIcon("C:/Users/olafs/Downloads/Hogweed.png");
    }

    @Override
    public void action(int sizeY, int sizeX, int move[], Creature[][] board) {
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                move[i] = this.y;
            } else {
                move[i] = this.x;
            }
        }
        int yi = 0;
        int xi = 1;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (this.y + i >= 0 && this.y + i < sizeY && this.x + j >= 0 && this.x + j < sizeX && Math.abs(i) != Math.abs(j)) {
                    if (board[this.y + i][this.x + j] != null && board[this.y + i][this.x + j].is_animal) {
                        move[yi] = this.y + i;
                        move[xi] = this.x + j;
                        yi += 2;
                        xi += 2;
                    }
                }
            }
        }
    }
}
