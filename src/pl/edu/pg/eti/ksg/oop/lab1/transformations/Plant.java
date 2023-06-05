package pl.edu.pg.eti.ksg.oop.lab1.transformations;

public class Plant extends Creature{
    void collision_multiply(Creature[][] board, int y_new, int x_new, int sizeX, int sizeY, int pos_of_child[]) {

    }

    int no_fight(Creature[][] board, int y_new, int x_new, int new_pos[], int sizeX, int sizeY) {
        return 0;
    }

    void action(int sizeY, int sizeX, int move[], Creature[][] board) {
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                move[i] = this.y;
            }
            else {
                move[i] = this.x;
            }
        }
        int sow = (int)(Math.random() * 30) ;
        int yi = 0;
        int xi = 1;
        if (sow == 1) {
            int i = (int)(Math.random() * 3) - 1;
            int j = (int)(Math.random() * 3) - 1;
            int count = 0;
            while (count < 100) {
                count++;
                if (this.y + i >= 0 && this.y + i < sizeY && this.x + j >= 0 && this.x + j < sizeX && board[this.y + i][this.x + j] == null) {
                    move[yi] = this.y + i;
                    move[xi] = this.x + j;
                    break;
                }
				else{
                    i = (int)(Math.random() * 3) - 1;
                    j = (int)(Math.random() * 3) - 1;
                }
            }
        }
    }
}
