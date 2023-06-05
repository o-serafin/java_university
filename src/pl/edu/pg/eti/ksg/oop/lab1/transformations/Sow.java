package pl.edu.pg.eti.ksg.oop.lab1.transformations;

import javax.swing.*;

public class Sow extends Plant {
    Sow(int y, int x) {
        this.is_animal = false;
        this.alive = true;
        this.big_index = 6;
        this.initiative = 0;
        this.strength = 0;
        this.symbol = '%';
        this.name = "Sow_Thistle";
        this.y = y;
        this.x = x;
        this.image = new ImageIcon("C:/Users/olafs/Downloads/Sow.png");
    }
    @Override
    void action(int sizeY, int sizeX, int move[], Creature[][] board) {
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                move[i] = this.y;
            }
            else {
                move[i] = this.x;
            }
        }
        int yi = 0;
        int xi = 1;
        for (int z = 0; z < 3; z++) {
            int sow = (int)(Math.random() * 30) ;
            if (sow == 1) {
                int i = (int)(Math.random() * 3) - 1;
                int j = (int)(Math.random() * 3) - 1;
                int count = 0;
                while (count<100) {
                    count++;
                    if (this.y + i >= 0 && this.y + i < sizeY && this.x + j >= 0 && this.x + j < sizeX && board[this.y + i][this.x + j] == null) {
                        move[yi] = this.y + i;
                        move[xi] = this.x + j;
                        break;
                    }
				else {
                        i = (int)(Math.random() * 3) - 1;
                        j = (int)(Math.random() * 3) - 1;
                    }
                }
            }
        }
    }
}
