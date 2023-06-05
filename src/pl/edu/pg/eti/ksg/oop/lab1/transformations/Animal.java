package pl.edu.pg.eti.ksg.oop.lab1.transformations;

public class Animal extends Creature {

    void action(int sizeY, int sizeX, int move[], Creature[][] board) {
        move[0] = 0;
        move[1] = 0;
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

    void collision_multiply(Creature[][] board, int y_new, int x_new, int sizeX, int sizeY, int pos_of_child[]) {
        for (int i = -1;i < 2;i++) {
            for (int j = -1;j < 2;j++) {
                if (y_new + i >= 0 && y_new + i < sizeY && x_new + j >= 0 && x_new + j < sizeX) {
                    if (board[y_new + i][x_new + j] == null) {
                        pos_of_child[0] = y_new + i;
                        pos_of_child[1] = x_new + j;
                        return;
                    }
                }
            }
        }
    }

    int no_fight(Creature[][] board, int y_new, int x_new, int new_pos[], int sizeX, int sizeY) {
        if (board[y_new][x_new].has_shell) { //check if we attack turtle
            if (this.strength < 5) { // check if attacker is weaker than 5
                return 1;
            }
			else {
                return 0;
            }
        }
		else if (board[y_new][x_new].is_jumping) {
            int escape = (int)(Math.random() * 2);
            if (escape == 1) {
                for (int i = -1;i < 2;i++) {
                    for (int j = -1;j < 2;j++) {
                        if (y_new + i >= 0 && y_new + i < sizeY && x_new + j >= 0 && x_new + j < sizeX) {
                            if (board[y_new + i][x_new + j] == null) {
                                new_pos[0] = y_new + i;
                                new_pos[1] = x_new + j;
                                return 2;
                            }
                        }
                        else {
                            return 0;
                        }
                    }
                }
            }
            else {
                return 0;
            }
        }
        return 0;
    }
}
