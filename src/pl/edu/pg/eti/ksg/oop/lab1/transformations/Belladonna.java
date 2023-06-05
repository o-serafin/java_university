package pl.edu.pg.eti.ksg.oop.lab1.transformations;

import javax.swing.*;

public class Belladonna extends Plant {
    Belladonna(int y, int x) {
        this.is_animal = false;
        this.alive = true;
        this.big_index = 8;
        this.initiative = 0;
        this.strength = 99;
        this.symbol = '+';
        this.name = "Belladonna";
        this.image = new ImageIcon("C:/Users/olafs/Downloads/Belladonna.png");
        this.y = y;
        this.x = x;
    }
}
