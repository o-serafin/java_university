package pl.edu.pg.eti.ksg.oop.lab1.transformations;

import javax.swing.*;

class Antelope extends Animal {
    public Antelope(int y, int x) {
        this.is_animal = true;
        this.alive = true;
        this.big_index = 2;
        this.initiative = 4;
        this.strength = 4;
        this.symbol = 'A';
        this.name = "Antelope";
        this.y = y;
        this.x = x;
        this.is_jumping = true;
        this.image = new ImageIcon("C:/Users/olafs/Downloads/antelope.png");
    }
    @Override
    void action(int sizeY, int sizeX, int move[], Creature[][] board) {
        int xi = this.x;
        int yi = this.y;
        for (int z = 0;z < 2;z++) {
            int dir = (int)(Math.random() * 2) ; // 0 for horizontal 1 for vertical
            int val = (int)(Math.random() * 2) ;
            if (val == 0) {
                val = -1;
            }
            if (dir == 1) {
                if (yi + val < 0 || yi + val >= sizeY) {
                    move[0] -= val;
                    yi -= val;
                }
                else {
                    move[0] += val;
                    yi += val;
                }
            }
            else {
                if (xi + val < 0 || xi + val >= sizeX) {
                    move[1] -= val;
                    xi -= val;
                }
                else {
                    move[1] += val;
                    xi += val;
                }
            }
        }
    }

}
