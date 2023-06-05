package pl.edu.pg.eti.ksg.oop.lab1.transformations;

import javax.swing.*;

public class Human extends Animal {
    Human(int y, int x) {
        this.is_animal = true;
        this.alive = true;
        this.initiative = 4;
        this.strength = 5;
        this.symbol = 'H';
        this.name = "Human";
        this.image = new ImageIcon("C:/Users/olafs/OneDrive/Pictures/daft&punk.png");
        this.y = y;
        this.x = x;
    }

    @Override
    public void weaken() {
        this.turns_remaining -= 1;
        if (this.strength > 5) {
            strength -= 1;
        }
    }

    @Override
    public void action(int sizeY, int sizeX, int move[], Creature[][] board) {
        if (move[0] == 5){
            move[0] = 0;
            move[1] = 0;
            if (this.turns_remaining <= 0){
                this.strength += 10;
                this.turns_remaining = 15;

                System.out.println("Human activated special ability");
            } else {
                System.out.println("Unable to turn on special ability for "+ this.turns_remaining + " turns");
            }
        }
        else if (this.y + move[0] < 0 || this.y + move[0] >= sizeY || this.x + move[1] < 0 || this.x + move[1] >= sizeX) {
            move[0] = 0;
            move[1] = 0;
        }
    }

}
