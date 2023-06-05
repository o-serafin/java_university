package pl.edu.pg.eti.ksg.oop.lab1.transformations;

import javax.swing.*;

public class Creature {

    protected int age;
    protected int x, y;
    protected int strength;
    protected int initiative;
    protected int big_index;

    public ImageIcon image;
    public boolean is_animal;
    public int turns_remaining = 0;
    public boolean has_shell = false;
    public boolean is_jumping = false;
    public boolean alive;
    public String name;
    public char symbol;

    void increse_strength(int n) {
        this.strength += n;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    int get_strength() {
        return strength;
    }

    void change_coords(int y, int x) {
        this.x = x;
        this.y = y;
    }

    void weaken() {};

    void action(int sizeY, int sizeX, int move[], Creature[][] board){};

    void collision_multiply(Creature[][] board, int y_new, int x_new, int sizeX, int sizeY, int pos_of_child[]){};

    int no_fight(Creature[][] board, int y_new, int x_new, int new_pos[], int sizeX, int sizeY){
        return 0;
    };

}
