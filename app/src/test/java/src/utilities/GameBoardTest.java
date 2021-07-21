package src.utilities;

import org.junit.Test;
import src.shapes.*;
import src.utilities.*;

import java.util.Arrays;

import static org.junit.Assert.*;

public class GameBoardTest {
    @Test
    public void createGameBoardArray_Height2AndWidth4_arrayOf2x4() {
        GameBoard gameBoard = new GameBoard();
        boolean[][] actual = gameBoard.createGameBoardArray(2, 4);
        boolean[][] expected = new boolean[2][4];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void cleanRowOnArray_Row1_GameBoardArrayWithRow1False() {
        GameBoard gameBoard = new GameBoard();
        boolean[][] array = createArray(3,10);
        gameBoard.setGameBoardArray(0, 0, array);
        gameBoard.cleanRowOnArray(1);
        boolean[][] actual = gameBoard.getGameBoardArray();
        boolean [][] expected = new boolean[20][10];
        Arrays.fill(expected[0], true);
        Arrays.fill(expected[2], true);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void checkFullRow_Row5AndValueFalse_True() {
        GameBoard gameBoard = new GameBoard();
        boolean actual = gameBoard.checkFullRow(5, false);
        assertTrue(actual);
    }

    @Test
    public void checkFullRow_Row1AndValueTrue_False() {
        GameBoard gameBoard = new GameBoard();
        boolean actual = gameBoard.checkFullRow(1, true);
        assertFalse(actual);
    }

    @Test
    public void setGameBoardArray_1And2AndArrayOf2x2_UpdatedArray() {
        GameBoard gameBoard = new GameBoard();
        Shape shape = new Shape(ShapeType.O);
        gameBoard.setGameBoardArray(shape);
        boolean[][] actual = gameBoard.getGameBoardArray();
        boolean [][] expected = new boolean[20][10];
        expected[0][3] = true;
        expected[0][4] = true;
        expected[1][3] = true;
        expected[1][4] = true;
        assertArrayEquals(expected, actual);
    }

    @Test
    public void adjustLines_GameBoardArray_OrderedGameBoardArray() {
        GameBoard gameBoard = new GameBoard();
        boolean[][] array = createArray(1,10);
        gameBoard.setGameBoardArray(0, 1, array);
        gameBoard.setGameBoardArray(0, 5, array);
        gameBoard.setGameBoardArray(0, 10, array);
        gameBoard.setGameBoardArray(0, 15, array);
        gameBoard.adjustLines();
        boolean[][] actual = gameBoard.getGameBoardArray();
        boolean [][] expected = new boolean[20][10];
        Arrays.fill(expected[16], true);
        Arrays.fill(expected[17], true);
        Arrays.fill(expected[18], true);
        Arrays.fill(expected[19], true);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getLineFromGameBoardArray_Row10_BooleanArrayFullWithFalse() {
        GameBoard gameBoard = new GameBoard();
        boolean[][] actual = gameBoard.getLineFromGameBoardArray(10);
        boolean[][] expected = new boolean[1][10];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void updateLinesOnGameBoard_GameBoardArray_EmptyGameBoardArray() {
        GameBoard gameBoard = new GameBoard();
        boolean[][] array = createArray(1,10);
        gameBoard.setGameBoardArray(0, 1, array);
        gameBoard.setGameBoardArray(0, 10, array);
        gameBoard.setGameBoardArray(0, 18, array);
        gameBoard.setGameBoardArray(0, 19, array);
        gameBoard.updateLinesOnGameBoard();
        boolean[][] actual = gameBoard.getGameBoardArray();
        boolean[][] expected = new boolean[20][10];
        assertArrayEquals(expected, actual);
    }

    /**
     * Creates an array full of true values
     * @param height of the array
     * @param width of the array
     * @return the array with dimensions and values set
     */
    public static boolean[][] createArray(int height, int width) {
        boolean[][] array = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                array[i][j] = true;
            }
        }
        return array;
    }
}