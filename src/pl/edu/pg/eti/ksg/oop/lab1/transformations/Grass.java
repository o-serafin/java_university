package pl.edu.pg.eti.ksg.oop.lab1.transformations;

import javax.swing.*;

public class Grass extends Plant{
    Grass(int y, int x) {
        this.is_animal = false;
        this.alive = true;
        this.big_index = 4;
        this.initiative = 0;
        this.strength = 0;
        this.symbol = ',';
        this.name = "Grass";
        this.image = new ImageIcon("C:/Users/olafs/Downloads/Grass.png");
        this.y = y;
        this.x = x;
    }
}
