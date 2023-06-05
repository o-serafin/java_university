package pl.edu.pg.eti.ksg.oop.lab1.transformations;

import javax.swing.*;

public class Fox extends Animal{
    public Fox(int y, int x){
        this.y = y;
        this.x = x;
        this.symbol = 'F';
        this.is_animal = true;
        this.alive = true;
        this.big_index = 0;
        this.initiative = 7;
        this.strength = 3;
        this.name = "Fox";
        this.image = new ImageIcon("C:/Users/olafs/Downloads/fox.png");
    }

    @Override
    public void action(int sizeY, int sizeX, int move[], Creature[][] board) {
        int xi = this.x;
        int yi = this.y;
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
        if (board[yi][xi] != null && board[yi][xi].get_strength() > 3) {
            move[0] = 0;
            move[1] = 0;
        }
    }
}
