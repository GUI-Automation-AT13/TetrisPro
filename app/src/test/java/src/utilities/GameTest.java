package src.utilities;

import org.junit.Test;
import src.shapes.*;
import src.utilities.DirectionType;
import src.utilities.Game;
import src.utilities.GameBoard;

import java.util.Arrays;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void checkCollision_ShapeIGameBoardDownMovement_True() {
        Game game = new Game();
        GameBoard gameBoard = new GameBoard();
        Shape shape = new Shape(ShapeType.I);
        boolean[][] fullRow = {{true, true, true, true, true,true, true, true, true, true}};
        gameBoard.setGameBoardArray(0, 1,fullRow);
        boolean actual = game.checkCollision(shape, gameBoard, DirectionType.Down);
        assertTrue(actual);
    }

    @Test
    public void checkCollision_ShapeIGameBoardDownMovement_False() {
        Game game = new Game();
        GameBoard gameBoard = new GameBoard();
        Shape shape = new Shape(ShapeType.I);
        boolean[][] fullRow = {{true, true, true, true, true, false, true, true, true, true}};
        gameBoard.setGameBoardArray(0, 4,fullRow);
        boolean actual = game.checkCollision(shape, gameBoard, DirectionType.Down);
        assertFalse(actual);
    }

    @Test
    public void checkCollision_ShapeJGameBoardRightMovement_True() {
        Game game = new Game();
        GameBoard gameBoard = new GameBoard();
        Shape shape = new Shape(ShapeType.J);
        boolean[][] fullColumn = {{true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}};
        gameBoard.setGameBoardArray(6, 0,fullColumn);
        boolean actual = game.checkCollision(shape, gameBoard, DirectionType.Right);
        assertTrue(actual);
    }

    @Test
    public void checkCollision_ShapeJGameBoardRightMovement_False() {
        Game game = new Game();
        GameBoard gameBoard = new GameBoard();
        Shape shape = new Shape(ShapeType.J);
        boolean[][] fullColumn = {{true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}};
        gameBoard.setGameBoardArray(9, 0,fullColumn);
        boolean actual = game.checkCollision(shape, gameBoard, DirectionType.Right);
        assertFalse(actual);
    }

    @Test
    public void checkCollision_ShapeLGameBoarLeftMovement_True() {
        Game game = new Game();
        GameBoard gameBoard = new GameBoard();
        Shape shape = new Shape(ShapeType.L);
        boolean[][] fullColumn = {{true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}};
        gameBoard.setGameBoardArray(2, 0,fullColumn);
        boolean actual = game.checkCollision(shape, gameBoard, DirectionType.Left);
        assertTrue(actual);
    }

    @Test
    public void checkCollision_ShapeLGameBoardLeftMovement_False() {
        Game game = new Game();
        GameBoard gameBoard = new GameBoard();
        Shape shape = new Shape(ShapeType.L);
        boolean[][] fullColumn = {{true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}};
        gameBoard.setGameBoardArray(0, 0,fullColumn);
        boolean actual = game.checkCollision(shape, gameBoard, DirectionType.Left);
        assertFalse(actual);
    }

    @Test
    public void checkCollision_ShapeIGameBoardDownMovementLimitReached_True() {
        Game game = new Game();
        GameBoard gameBoard = new GameBoard();
        Shape shape = new Shape(ShapeType.I);
        for (int i = 0; i < 20; i++) {
            shape.moveDown();
        }
        boolean actual = game.checkCollision(shape, gameBoard, DirectionType.Down);
        assertTrue(actual);
    }

    @Test
    public void selectDirection_ShapeJGameBoardDownMovement_YMovement1() {
        Game game = new Game();
        Shape shape = new Shape(ShapeType.J);
        game.selectDirection(DirectionType.Down,shape);
        int actual = game.getYMovement();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void selectDirection_ShapeJGameBoardDownMovement_DownLimitReached() {
        Game game = new Game();
        Shape shape = new Shape(ShapeType.J);
        for (int i = 0; i < 19; i++) {
            shape.moveDown();
        }
        game.selectDirection(DirectionType.Down,shape);
        boolean actual = game.getDownLimitReached();
        assertTrue(actual);
    }

    @Test
    public void selectDirection_ShapeJGameBoardLeftMovement_XMovement0() {
        Game game = new Game();
        Shape shape = new Shape(ShapeType.J);
        for (int i = 0; i < 4; i++) {
            shape.moveLeft();
        }
        game.selectDirection(DirectionType.Left,shape);
        int actual = game.getXMovement();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void selectDirection_ShapeJGameBoardLeftMovement_XMovementNegative1() {
        Game game = new Game();
        Shape shape = new Shape(ShapeType.J);
        game.selectDirection(DirectionType.Left,shape);
        int actual = game.getXMovement();
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void selectDirection_ShapeJGameBoardRightMovement_XMovement0() {
        Game game = new Game();
        Shape shape = new Shape(ShapeType.J);
        for (int i = 0; i < 5; i++) {
            shape.moveRight();
        }
        game.selectDirection(DirectionType.Right, shape);
        int actual = game.getXMovement();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void selectDirection_ShapeJGameBoardRightMovement_XMovement1() {
        Game game = new Game();
        Shape shape = new Shape(ShapeType.J);
        game.selectDirection(DirectionType.Right,shape);
        int actual = game.getXMovement();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void checkCollision_ShapeIInitialPosition_False() {
        Game game = new Game();
        Shape shape = new Shape(ShapeType.I);
        GameBoard gameBoard = new GameBoard();
        boolean[][] fullRow = {{true, true, true, true, true, true, true, true, true, true}};
        gameBoard.setGameBoardArray(0, 1, fullRow);
        assertFalse(game.checkCollision(shape, gameBoard, DirectionType.Hold));
    }

    @Test
    public void checkCollision_ShapeIInitialPosition_True() {
        Game game = new Game();
        Shape shape = new Shape(ShapeType.I);
        GameBoard gameBoard = new GameBoard();
        boolean[][] fullRow = {{true, true, true, true, true, true, true, true, true, true}};
        gameBoard.setGameBoardArray(0, 0, fullRow);
        assertTrue(game.checkCollision(shape, gameBoard, DirectionType.Hold));
    }

    @Test
    public void checkCollision_ShapeLInitialPosition_False() {
        Game game = new Game();
        Shape shape = new Shape(ShapeType.L);
        GameBoard gameBoard = new GameBoard();
        boolean[][] fullRow = {{true, true, true, true, true, true, true, true, true, true}};
        gameBoard.setGameBoardArray(0, 2, fullRow);
        assertFalse(game.checkCollision(shape, gameBoard, DirectionType.Hold));
    }

    @Test
    public void checkCollision_ShapeLInitialPosition_True() {
        Game game = new Game();
        Shape shape = new Shape(ShapeType.L);
        GameBoard gameBoard = new GameBoard();
        boolean[][] fullRow = {{true, true, true, true, true, true, true, true, true, true}};
        gameBoard.setGameBoardArray(0, 1, fullRow);
        assertTrue(game.checkCollision(shape, gameBoard, DirectionType.Hold));
    }
}