package pl.edu.pg.eti.ksg.oop.lab1.transformations;

import javax.swing.*;

public class Guarana extends Plant{
    Guarana(int y, int x) {
        this.is_animal = false;
        this.alive = true;
        this.big_index = 7;
        this.initiative = 0;
        this.strength = 0;
        this.symbol = 'G';
        this.name = "Guarana";
        this.image = new ImageIcon("C:/Users/olafs/Downloads/Guarana.png");
        this.y = y;
        this.x = x;
    }
}
