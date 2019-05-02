/* ------------------------------------------------------
GEN- LAB 3
File : Board
Authors : Carpita Edoardo, Dutu Launay Marion, Moreira Erwan
Date : 01-05-2019

Brief : This class implement the board of the game, we decided
        to implement this with a config file created with all
        the squares name (and colors for future implementation).

        This enable a more simple way to load all needed
        information of the board keeping an evolutive approach.

---------------------------------------------------------*/

package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private static final int BOARDSIZE = 40;
    private static final String BOARDCONFIG = "src/config/monopoly_board_US.txt";

    private ArrayList<Square> squaresOfTheBoard;

    public Board() throws IOException {
        squaresOfTheBoard = new ArrayList<Square>(BOARDSIZE);
        loadBoard();
    }

    private void loadBoard() throws IOException {
        File file = new File(BOARDCONFIG);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line;
        int counter = 0;

        while ((line = br.readLine()) != null) {
            if (line != "") {
                /* all valuable info are divided with a tab in the config file */
                List<String> lineTab = new ArrayList<String>(Arrays.asList(line.split(";")));
                String typeOfSquare = lineTab.get(0);

                if (typeOfSquare.equals("GTJail")) {
                    Square square = new GoToJailSquare(lineTab.get(2), counter++);
                    squaresOfTheBoard.add(square);
                } else {
                    Square square = new RegularSquare(lineTab.get(2), counter++);
                    squaresOfTheBoard.add(square);
                }
            }
        }
    }


    public Square getRelativeSquare(Square currentPos, int distance) {
        int index = (currentPos.getNumber() + distance) % Board.BOARDSIZE;
        return squaresOfTheBoard.get(index);
    }

    public Square getAbsoluteSquare(int index) {
        return squaresOfTheBoard.get(index % Board.BOARDSIZE);
    }

    public Square getStartSquare() {
        return squaresOfTheBoard.get(0);
    }

    public String toString() {
        String result = "";

        for (Square square : squaresOfTheBoard) {
            result += square.toString() + "\n";
        }
        return result;
    }

}
