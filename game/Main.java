package game;

import javax.swing.*;

class Main {
    public static void main(String[] args) {
        Board board = new Board();

        // Declaring JDialog dialog to print appropriate message
        JDialog dialog;

        // Using a while loop to run through the program till boolean endGame is true
        while(!board.getEndgame()){
            board.nextTurn();
        }

        dialog = new JDialog();

        // Setting dialog window on top (mainly to prevent it from hiding behind the IDE)
        dialog.setAlwaysOnTop(true);

        if(board.getTurn() == 0){
            JOptionPane.showMessageDialog(dialog, "The hero has won the game.");
        }
        else{
            JOptionPane.showMessageDialog(dialog, "The monster has won the game.");
        }

        //Disposing dialog window
        dialog.dispose();
    }
}
