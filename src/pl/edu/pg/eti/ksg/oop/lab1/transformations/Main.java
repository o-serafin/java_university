package pl.edu.pg.eti.ksg.oop.lab1.transformations;

public class Main {
    public static void main(String[] args) {
        World world = new World(15,15);
        world.create_board();
        world.print_world_image();
        world.getButton().addActionListener(e -> world.world_cycle());
    }
}
