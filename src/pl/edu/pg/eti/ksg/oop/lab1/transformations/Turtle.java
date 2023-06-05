package pl.edu.pg.eti.ksg.oop.lab1.transformations;

import javax.swing.*;

class Turtle extends Animal {

    public Turtle(int y, int x) {
    this.has_shell = true;
    this.is_animal = true;
    this.alive = true;
    this.big_index = 3;
    this.initiative = 1;
    this.strength = 2;
    this.symbol = 'T';
    this.name = "Turtle";
    this.y = y;
    this.x = x;
    this.image = new ImageIcon("C:/Users/olafs/Downloads/turtle.png");
    }


    @Override
    void action(int sizeY, int sizeX, int move[], Creature[][] board) {
        int chance = (int)(Math.random() * 4);
        move[0] = 0;
        move[1] = 0;
        if (chance != 2) {
            return;
        }
        int xi = this.x;
        int yi = this.y;
        int dir = (int)(Math.random() * 2) ; // 0 for horizontal 1 for vertical
        int val = (int)(Math.random() * 2);
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