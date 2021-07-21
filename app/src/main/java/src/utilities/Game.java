package src.utilities;

import src.shapes.*;

public class Game {
    private int xMovement;
    private int yMovement;
    private boolean downLimitReached = false;

    /**
     * Gets the yMovement value
     * @return an int with the value
     */
    public int getYMovement() {
        return yMovement;
    }

    /**
     * Gets the downLimitReached value
     * @return a boolean with the value
     */
    public boolean getDownLimitReached() {
        return downLimitReached;
    }

    /**
     * Gets the xMovement value
     * @return an int with the value
     */
    public int getXMovement() {
        return xMovement;
    }

    /**
     * Verifies if the shape collides with the game board array
     * @param shape the figure to check
     * @param gameBoard the game board array
     * @param direction the movement direction to check
     * @return a boolean with the result
     */
    public boolean checkCollision(final Shape shape, final GameBoard gameBoard, final DirectionType direction) {
        selectDirection(direction, shape);
        if (downLimitReached) {
            return true;
        }
        int shapeHeight = shape.getPartialShape().length;
        int shapeWidth = shape.getPartialShape()[0].length;
        int xInitial = shape.getxPosition() + xMovement + shape.getLeftColumns();
        int yInitial = shape.getyPosition() + yMovement + shape.getTopRows();
        boolean[][] matchArray = gameBoard.getPartialGameBoardArray(xInitial, yInitial, shapeHeight, shapeWidth);
        return compareArrays(matchArray, shape.getPartialShape(), shapeHeight, shapeWidth);
    }

    /**
     * Checks if two arrays have a similar value on a same position
     * @param firstArray to compare
     * @param secondArray to compare
     * @param height of the arrays
     * @param width of the arrays
     * @return a boolean with the result
     */
    public boolean compareArrays(final boolean[][] firstArray, final boolean[][] secondArray, final int height, final int width) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (firstArray[i][j] && secondArray[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Sets the parameters to check collision on a certain direction
     * @param direction the shape's current direction
     * @param shape that is moving
     */
    public void selectDirection(final DirectionType direction, final Shape shape) {
        xMovement = 0;
        yMovement = 0;
        downLimitReached = false;
        switch (direction) {
            case Left:
                if (shape.checkLeftLimit()) {
                    xMovement = 0;
                } else {
                    xMovement = -1;
                }
                break;
            case Down:
                if (shape.checkDownLimit()) {
                    downLimitReached = true;
                } else {
                    yMovement = 1;
                }
                break;
            case Right:
                if (shape.checkRightLimit()) {
                    xMovement = 0;
                } else {
                    xMovement = 1;
                }
                break;
            case Rotate:
                if (shape.checkRotation()) {
                    shape.rotate();
                }
                break;
            case Hold:
                System.out.println("Hold Position");
                break;
            default:
                System.out.println("Invalid entry");
                break;
        }
    }
}
