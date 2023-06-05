package pl.edu.pg.eti.ksg.oop.lab1.transformations;

import javax.swing.*;

public class Sheep extends Animal{
    Sheep(int y, int x) {
        this.is_animal = true;
        this.alive = true;
        this.big_index = 2;
        this.initiative = 4;
        this.strength = 4;
        this.symbol = 'S';
        this.name = "Sheep";
        this.y = y;
        this.x = x;
        this.image = new ImageIcon("C:/Users/olafs/Downloads/sheep.png");
    }
}
