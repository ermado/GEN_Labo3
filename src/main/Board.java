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

        File file = new File(BOARDCONFIG);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        int counter = 0;
        while ((line = br.readLine()) != null) {
            if (line != "") {
                List<String> lineTab = new ArrayList<String>(Arrays.asList(line.split("\\t")));
                Square square = new Square(lineTab.get(1), counter++);
                squaresOfTheBoard.add(square);

            }
        }

    }

    public Square getSquare(Square currentPos, int distance) {
        int index = (currentPos.getNumber() + distance) % Board.BOARDSIZE;
        return squaresOfTheBoard.get(index);
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
