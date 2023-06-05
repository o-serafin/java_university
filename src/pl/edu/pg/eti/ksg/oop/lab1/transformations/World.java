package pl.edu.pg.eti.ksg.oop.lab1.transformations;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class World {
    String animal_names[] = {"Antelope","Wolf","Sheep","Turtle","Fox","Hogweed","Sow_Thistle","Grass","Guarana","Belladonna","Human"};
    ImageIcon empty_field = new ImageIcon("C:/Users/olafs/Downloads/field.png");
    JFrame frame;
    JPanel mainPanel;
    JPanel map;
    JPanel buttons;
    Container cp;
    String animal_name = "";
    int human_move[] = new int[2];;

    public JButton button;
    public JButton button_load;
    public JButton button_save;

    public boolean human_present = false;
    public Human human = null;
    public Creature[][] board;
    public int sizeX,sizeY;
    public Creature[][] creatures;
    public int[] num_of_creatures = new int[9];

    public void initialize(){
        for (int j = 0; j < 9; j++) {
            num_of_creatures[j] = 0;
        }
        creatures = new Creature[9][200];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 200; j++) {
                creatures[i][j] = null;
            }
        }
    }

    public boolean get_field(int y, int x) {
        if (board[y/40][x/40] == null){
            return true;
        }
        else {
            return false;
        }
    }

    public void add_Antelope(int y, int x) {
        creatures[2][num_of_creatures[2]] = new Antelope(y,x);
        board[y][x] = creatures[2][num_of_creatures[2]];
        num_of_creatures[2] += 1;
    }

    public void add_human(int y, int x) {
        human = new Human(y, x);
        board[y][x] = human;
        human_present = true;
    }

    public void add_Sheep(int y, int x) {
        creatures[2][num_of_creatures[2]] = new Sheep(y,x);
        board[y][x] = creatures[2][num_of_creatures[2]];
        num_of_creatures[2] += 1;
    }

    public void add_Fox(int y, int x){
        creatures[0][num_of_creatures[0]] = new Fox(y,x);
        board[y][x] = creatures[0][num_of_creatures[0]];
        num_of_creatures[0] += 1;
    }

    public void add_Wolf(int y, int x){
        creatures[1][num_of_creatures[1]] = new Wolf(y,x);
        board[y][x] = creatures[1][num_of_creatures[1]];
        num_of_creatures[1] += 1;
    }

    public void add_Turtle(int y, int x){
        creatures[3][num_of_creatures[3]] = new Turtle(y,x);
        board[y][x] = creatures[3][num_of_creatures[3]];
        num_of_creatures[3] += 1;
    }

    public void add_Grass(int y, int x){
        creatures[4][num_of_creatures[4]] = new Grass(y,x);
        board[y][x] = creatures[4][num_of_creatures[4]];
        num_of_creatures[4] += 1;
    }

    public void add_Hogweed(int y, int x){
        creatures[5][num_of_creatures[5]] = new Hogweed(y,x);
        board[y][x] = creatures[5][num_of_creatures[5]];
        num_of_creatures[5] += 1;
    }

    public void add_Sow(int y, int x){
        creatures[6][num_of_creatures[6]] = new Sow(y,x);
        board[y][x] = creatures[6][num_of_creatures[6]];
        num_of_creatures[6] += 1;
    }

    public void add_Guarana(int y, int x){
        creatures[7][num_of_creatures[7]] = new Guarana(y,x);
        board[y][x] = creatures[7][num_of_creatures[7]];
        num_of_creatures[7] += 1;
    }

    public void add_Belladonna(int y, int x){
        creatures[8][num_of_creatures[8]] = new Belladonna(y,x);
        board[y][x] = creatures[8][num_of_creatures[8]];
        num_of_creatures[8] += 1;
    }

    public void add_from_clicking(String name, int y, int x) {
        if (name.equals("Fox")) {
            add_Fox(y, x);
        }
        else if (name.equals("Wolf")) {
            add_Wolf(y, x);
        }
        else if (name.equals("Sheep")) {
            add_Sheep(y, x);
        }
        else if (name.equals("Antelope")) {
            add_Antelope(y, x);
        }
        else if (name.equals("Turtle")) {
            add_Turtle(y, x);
        }
        else if (name.equals("Hogweed")) {
            add_Hogweed(y, x);
        }
        else if (name.equals("Guarana")) {
            add_Guarana(y, x);
        }
        else if (name.equals("Sow_Thistle")) {
            add_Sow(y, x);
        }
        else if (name.equals("Grass")) {
            add_Grass(y, x);
        }
        else if (name.equals("Belladonna")) {
            add_Belladonna(y, x);
        }
        else if (name.equals("Human")) {
            if (human_present){
                System.out.println("Human already present");
            }
            else{
                add_human(y, x);
            }
        }
    }

    void delete_state(){
        human = null;
        human_present = false;
        for (int i = 0;i < 9;i++) {
            num_of_creatures[i] = 0;
        }
        for (int i = 0; i < 9;i++) {
            for (int j = 0;j < 200;j++) {
                creatures[i][j] = null;
            }
        }
        for (int i = 0; i < sizeY;i++) {
            for (int j = 0; j < sizeX;j++) {
                board[i][j] = null;
            }
        }
    }

    void load_file(){
        delete_state();
        File file = new File("C:/Users/olafs/test/src/pl/edu/pg/eti/ksg/oop/lab1/transformations/saves.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splitStr = line.split(" ");
                String name = splitStr[0];
                int y = Integer.parseInt(splitStr[1]);
                int x = Integer.parseInt(splitStr[2]);
                add_from_clicking(name,y,x);
                System.out.println(name+" "+y+" "+x);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        print_world_image();
    }

    public void create_board() {
        board = new Creature[sizeY][sizeX];
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                board[i][j] = null;
            }
        }
    }

    public void save_file(){
        try {
            FileWriter myWriter = new FileWriter("C:/Users/olafs/test/src/pl/edu/pg/eti/ksg/oop/lab1/transformations/saves.txt");
            if (human != null && human.alive){
                myWriter.write("Human "+human.getY()+" "+human.getX());
                myWriter.write(System.lineSeparator());
            }
            for (int y = 0; y < 9; y++) {
                for (int x = 0; x < num_of_creatures[y];x++) {
                    if (creatures[y][x].alive) {
                        myWriter.write(creatures[y][x].name+" "+creatures[y][x].getY()+" "+creatures[y][x].getX());
                        myWriter.write(System.lineSeparator());
                    }
                }
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void print_world() {
        for (int i = 0; i < sizeY; ++i) {
            for (int j = 0;j < sizeX;j++) {

                if (board[i][j] == null) {
                    System.out.print('.');
                }
                else {
                    System.out.print(board[i][j].symbol);
                }

            }
            System.out.println();
        }
        System.out.println();
    }

    public void print_world_image() {
        map.removeAll();
        for (int i = 0; i < sizeY; ++i) {
            for (int j = 0;j < sizeX;j++) {

                if (board[i][j] == null) {
                    JLabel l = new JLabel(empty_field);
                    cp.add(l);
                }
                else {
                    JLabel l = new JLabel(board[i][j].image);
                    cp.add(l);
                }
            }
        }
        frame.pack();
        frame.setVisible(true);
    }

    public World(int sizeY, int sizeX){
        button = new JButton("Next Turn");
        button_load = new JButton("Load State");
        button_load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                load_file();
            }
        });
        button_save = new JButton("Save State");
        button_save.setFocusable(false);
        button_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save_file();
            }
        });
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setFocusable(true);
        frame.setVisible(true);
        mainPanel = new JPanel();
        buttons = new JPanel();
        frame.add(mainPanel);
        map = new JPanel();
        map.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x = (e.getX());
                int y = (e.getY());
                if (get_field(y, x)) {
                    animal_name = "";
                    JFrame frame1 = new JFrame("Choose animal");
                    frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JPanel animals = new JPanel();
                    frame1.add(animals);
                    JButton button_done = new JButton("Done");
                    button_done.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            add_from_clicking(animal_name, y / 40, x / 40);
                            print_world_image();
                            frame1.dispose();
                        }
                    });
                    frame1.add(button_done, BorderLayout.SOUTH);
                    animals.setLayout(new GridLayout(6, 1));
                    for (int i = 0; i < 11; i++) {
                        JButton buttonx = new JButton(animal_names[i]);
                        animals.add(buttonx);
                        buttonx.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                animal_name = (buttonx.getText());
                            }
                        });
                    }
                    frame1.setSize(200, 300);
                    frame1.setVisible(true);
                }
            }
        });
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                human_move[0] = 0;
                human_move[1] = 0;
                if (keyCode == KeyEvent.VK_UP) {
                    human_move[0] = -1;
                }
                else if (keyCode == KeyEvent.VK_DOWN) {
                    human_move[0] = 1;
                }
                else if (keyCode == KeyEvent.VK_LEFT) {
                    human_move[1] = -1;
                }
                else if (keyCode == KeyEvent.VK_RIGHT) {
                    human_move[1] = 1;
                }
                else if (keyCode == KeyEvent.VK_1) {
                    human_move[0] = 5;
                }
            }
        });
        mainPanel.add(map);
        mainPanel.add(buttons);
        buttons.add(button);
        button.setFocusable(false);
        button_load.setFocusable(false);
        buttons.add(button_load);
        buttons.add(button_save);
        cp = map;
        cp.setLayout(new GridLayout(sizeY, sizeX));
        initialize();
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }


    public void move_animal(Creature creature, int move[]) {
        if (board[creature.getY() + move[0]][creature.getX() + move[1]] == null) {
            board[creature.getY()][creature.getX()] = null;
            board[creature.getY() + move[0]][creature.getX() + move[1]] = creature;
            System.out.println(creature.name + " moves from y=" + Integer.toString(creature.getY()) + " x=" + Integer.toString(creature.getX()) +" to y="+ Integer.toString(creature.getY()+move[0])+" x="+Integer.toString(creature.getX()+move[1]));
            creature.change_coords(creature.getY() + move[0], creature.getX() + move[1]);
        } else if (move[0] == 0 && move[1] == 0) {
            System.out.println("Remains the same");
        }
        else if (board[creature.getY() + move[0]][creature.getX() + move[1]].symbol == creature.symbol) {
            int child_pos[] = new int[2];
            child_pos[0] = creature.getY() + move[0];
            child_pos[1] = creature.getX() + move[1];
            creature.collision_multiply(board, creature.getY() + move[0], creature.getX() + move[1], sizeX, sizeY, child_pos);
            if (child_pos[0] == creature.getY() + move[0] && child_pos[1] == creature.getX() + move[1]) {
                System.out.println("Unable to find place for child");
            }
            else {
                if (creature.name == "Turtle" && num_of_creatures[3] < 200) {
                    add_Turtle(child_pos[0], child_pos[1]);
                }
                else if (creature.name == "Fox" && num_of_creatures[0] < 200) {
                    add_Fox(child_pos[0], child_pos[1]);
                }
                else if (creature.name == "Sheep" && num_of_creatures[2] < 200) {
                    add_Sheep(child_pos[0], child_pos[1]);
                }
                else if (creature.name == "Antelope" && num_of_creatures[2] < 200) {
                    add_Antelope(child_pos[0], child_pos[1]);
                }
                else if (creature.name == "Wolf" && num_of_creatures[1] < 200) {
                    add_Wolf(child_pos[0], child_pos[1]);
                }
                System.out.println("New " + creature.name + " is born on y=" + Integer.toString(child_pos[0]) + " x=" + Integer.toString(child_pos[1]));
            }
        }
        else {
            int new_pos[] = new int[2];
            new_pos[0] = 0;
            new_pos[1] = 0;
            int no_fight = creature.no_fight(board, creature.getY() + move[0], creature.getX() + move[1], new_pos, sizeX, sizeY);
            if (no_fight == 1) {
                System.out.println("Turtle survived");
            }
            else if (no_fight == 2) {
                Creature antelope = board[creature.getY() + move[0]][creature.getX() + move[1]];
                board[new_pos[0]][new_pos[1]] = antelope;
                antelope.change_coords(new_pos[0], new_pos[1]);
                board[creature.getY() + move[0]][creature.getX() + move[1]] = creature;
                board[creature.getY()][creature.getX()] = null;
                creature.change_coords(creature.getY() + move[0], creature.getX() + move[1]);
                System.out.println("Antelope escaped to field y=" + Integer.toString(antelope.getY()) + " x=" + Integer.toString(antelope.getX()));
            }
            else {
                Creature victim = board[creature.getY() + move[0]][creature.getX() + move[1]];
                if (creature.get_strength() < victim.get_strength() || victim.symbol == '#') {
                    creature.alive = false;
                    if(creature.name == "Human"){
                        human_present = false;
                    }
                    board[creature.getY()][creature.getX()] = null;
                    System.out.println(creature.name + " is killed by " + victim.name);
                }
                else {
                    victim.alive = false;
                    if(victim.name == "Human"){
                        human_present = false;
                    }
                    if (victim.name == "Guarana") {
                        creature.increse_strength(3);
                    }
                    board[victim.getY()][victim.getX()] = creature;
                    board[creature.getY()][creature.getX()] = null;
                    creature.change_coords(creature.getY() + move[0], creature.getX() + move[1]);
                    System.out.println(victim.name + " is killed by " + creature.name);
                }
            }
        }
    }

    void move_plants(Creature creature, int move[]) {
        if (creature.symbol == '#') {
            for (int i = 0; i < 4; i++) {
                int j = i * 2;
                if (!(move[j] == creature.getY() && move[j + 1] == creature.getX())) {
                    Creature victim = board[move[j]][move[j+1]];
                    board[move[j]][move[j+1]] = null;
                    victim.alive = false;
                    if(victim.name == "Human"){
                        human_present = false;
                    }
                    System.out.println(victim.name + " is killed by Hogweed");
                }
            }
        }
        else {
            for (int i = 0; i < 7; i += 2) {
                if (!(move[i] == creature.getY() && move[i + 1] == creature.getX())) {

                    if (creature.name == "Guarana" && num_of_creatures[7] < 200) {
                        add_Guarana(move[i],move[i+1]);
                    }
                    else if (creature.name == "Belladonna" && num_of_creatures[8] < 200) {
                        add_Belladonna(move[i], move[i + 1]);
                    }
                    else if (creature.name == "Sow Thistle" && num_of_creatures[6] < 200) {
                        add_Sow(move[i], move[i + 1]);
                    }
                    else if (creature.name == "Grass" && num_of_creatures[4] < 200) {
                        add_Grass(move[i], move[i + 1]);
                    }
                    System.out.println("New " + creature.name + " is born on y=" + Integer.toString(move[i]) + " x=" + Integer.toString(move[i + 1]) + " from y = " + Integer.toString(creature.getY()) + " x = " + Integer.toString(creature.getX()));
                }
            }
        }
    }

    public void world_cycle(){
        for (int i = 0;i < 9;i++) {
            if (i == 2 && human != null && human.alive) {
                human.action(sizeY, sizeX, human_move, board);
                move_animal(human, human_move);
                human_move[0] = 0;
                human_move[1] = 0;
                human.weaken();
            }
            if (i < 4) {
                for (int j = 0;j < num_of_creatures[i];j++) {
                    if (creatures[i][j].alive) {
                        int move[] = new int[8];
                        creatures[i][j].action(sizeY, sizeX, move, board);
                        move_animal(creatures[i][j], move);
                    }
                }
            }
            else{
                for (int j = 0;j < num_of_creatures[i];j++) {
                    if (creatures[i][j].alive) {
                        int move[] = new int[8];
                        creatures[i][j].action(sizeY, sizeX, move, board);
                        move_plants(creatures[i][j], move);
                    }
                }
            }
        }
        print_world_image();
    }

    public JButton getButton() {
        return button;
    }
}
