package game;

import java.util.Random;
import java.util.Scanner;

class Hero {
    private int x;
    private int y;
    private final Scanner in = new Scanner(System.in);

    Hero(){
        Random rand = new Random();
        x = rand.nextInt(10);
        y = rand.nextInt(10);
    }

    int getX(){
        return x;
    }

    int getY(){
        return y;
    }

    void moveHero(){
        boolean flag = true;

        // Using a while loop till an appropriate move is entered
        while(flag){
            System.out.println("\nEnter next move for hero:");
            String move = in.nextLine();

            // Using a switch case to execute user's move
            switch(move){
                case "up":
                    if(y-1 >= 0){
                        y--;
                        flag = false;
                    }
                    else{
                        System.out.println("\nUnable to move there.");
                    }
                    break;
                case "down":
                    if(y+1 <= 9){
                        y++;
                        flag = false;
                    }
                    else{
                        System.out.println("\nUnable to move there.");
                    }
                    break;
                case "left":
                    if(x-1 >= 0){
                        x--;
                        flag = false;
                    }
                    else{
                        System.out.println("\nUnable to move there.");
                    }
                    break;
                case "right":
                    if(x+1 <= 9){
                        x++;
                        flag = false;
                    }
                    else{
                        System.out.println("\nUnable to move there.");
                    }
                    break;
                default:
                    System.out.println("\nInvalid move.");
                    break;
            }
        }
    }
}
