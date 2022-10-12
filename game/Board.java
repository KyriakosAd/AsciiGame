package game;

import java.util.Arrays;
import java.util.Random;

class Board {
    // Two-dimensional char array which will be used to print the 10x10 board
    private final char[][] map;

    // Integer turn which will be used to swap between the hero and the monster
    private int turn = 0;

    // Boolean endgame which will be used to end the program
    private boolean endGame = false;

    private final Monster m = new Monster();

    private final Hero h = new Hero();

    Board(){
        map = new char[10][10];

        // Using a while loop till the monster's position is different from the hero's
        while(h.getY() == m.getY() && h.getX() == m.getX()){
            Random rand = new Random();
            m.setY(rand.nextInt(10));
            m.setX(rand.nextInt(10));
        }

        // Calling method printMap() to print initial board
        printMap();
    }

    int getTurn(){
        return turn;
    }

    boolean getEndgame(){
        return endGame;
    }

    private void printMap(){
        // Using a for loop to assign char '-' to every element of array map
        for (char[] chars : map) {
            Arrays.fill(chars, '-');
        }

        // These two if statements are to make sure that the winner is the one shown at the end board
        if(!(checkWin() && turn == 0)){
            map[m.getY()][m.getX()] = 'M';
        }
        if(!(checkWin() && turn == 1)){
            map[h.getY()][h.getX()] = 'H';
        }

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    void nextTurn(){
        // If statement to switch between hero's and monster's turn
        if(turn == 0){
            // Calling method moveHero() to move the hero based on user input
            h.moveHero();

            // Calling method checkWin() to check whether the hero and the monster are in the same position
            checkWin();
            System.out.println("\nHero's move");

            // Calling method printMap() to print current board
            printMap();

            if(checkWin()){
                endGame = true;
            }
            else{
                turn++;
            }
        }
        else{
            m.moveMonster();

            checkWin();
            System.out.println("\nMonster's first move");

            printMap();

            if(checkWin()){
                endGame = true;
            }
            if(!endGame){
                m.moveMonster();

                checkWin();
                System.out.println("\nMonster's second move");

                printMap();

                if(checkWin()){
                    endGame = true;
                }
                else{
                    turn--;
                }
            }
        }
    }

    private boolean checkWin(){
        return (m.getX() == h.getX() && m.getY() == h.getY());
    }
}
