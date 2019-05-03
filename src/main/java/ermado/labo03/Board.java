/* ------------------------------------------------------
GEN- LAB 3
File : Board
Authors : Carpita Edoardo, Dutu Launay Marion, Moreira Erwan
Date : 01-05-2019

Brief : This class implements the board of the game. We decided
        to implement it with a config file created with all
        the squares names (and colors for a future implementation).

        This enable a more simple way to load all needed
        information of the board keeping an evolutive approach.

---------------------------------------------------------*/

package ermado.labo03;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private static final int BOARDSIZE = 40;
    private static final String BOARDCONFIG = "src/config/monopoly_board_US.txt";

    private ArrayList<Square> squaresOfTheBoard;

    public Board() throws IOException {
        squaresOfTheBoard = new ArrayList<>(BOARDSIZE);
        loadBoard();
    }

    private void loadBoard() throws IOException {
        File file = new File(BOARDCONFIG);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line;
        int counter = 0;

        while ((line = br.readLine()) != null) {
            if (!line.equals("")) {
                /* All valuable infos are divided with a ; in the config file */
                List<String> lineTab = new ArrayList<>(Arrays.asList(line.split(";")));
                String typeOfSquare = lineTab.get(0);

                switch (typeOfSquare) {
                    case "GTJail": {
                        Square square = new GoToJailSquare(lineTab.get(2), counter++);
                        squaresOfTheBoard.add(square);
                        break;
                    }
                    case "Tax": {
                        Square square = new IncomeTaxSquare(lineTab.get(2), counter++);
                        squaresOfTheBoard.add(square);
                        break;
                    }
                    case "Go": {
                        Square square = new GoSquare(lineTab.get(2), counter++);
                        squaresOfTheBoard.add(square);
                        break;
                    }
                    default: {
                        Square square = new RegularSquare(lineTab.get(2), counter++);
                        squaresOfTheBoard.add(square);
                        break;
                    }
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
