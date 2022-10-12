package game;

import java.util.Random;

class Monster{
    private int x;
    private int y;
    private static final Random rand = new Random();

    Monster(){
        x = rand.nextInt(10);
        y = rand.nextInt(10);
    }

    int getX(){
        return x;
    }

    void setX(int x){
        this.x = x;
    }

    int getY(){
        return y;
    }

    void setY(int y){
        this.y = y;
    }

    void moveMonster(){
        int choose;
        boolean flag = true;

        // Using a while loop till an appropriate move is entered
        while(flag){
            // Randomizing the monster's move
            choose = rand.nextInt(4) + 1;
            switch(choose){
                case 1:
                    if(x+1 <= 9){
                        x++;
                        flag = false;
                    }
                    break;
                case 2:
                    if(x-1 >= 0){
                        x--;
                        flag = false;
                    }
                    break;
                case 3:
                    if(y+1 <= 9){
                        y++;
                        flag = false;
                    }
                    break;
                case 4:
                    if(y-1 >= 0){
                        y--;
                        flag = false;
                    }
                    break;
                default:
                    break;
            }
        }
    }
}