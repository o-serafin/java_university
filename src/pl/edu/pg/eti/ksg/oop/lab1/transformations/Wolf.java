package pl.edu.pg.eti.ksg.oop.lab1.transformations;

import javax.swing.*;

public class Wolf extends Animal{

    public Wolf(int y, int x){
        this.y = y;
        this.x = x;
        this.symbol = 'W';
        this.alive = true;
        this.is_animal = true;
        this.big_index = 1;
        this.initiative = 5;
        this.strength = 9;
        this.name = "Wolf";
        this.image = new ImageIcon("C:/Users/olafs/Downloads/wolf.png");
    }
}
