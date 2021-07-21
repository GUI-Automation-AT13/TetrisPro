package src.utilities;
import src.shapes.*;

import java.util.Random;

public class RandomShape {
    private static final int MAX_RANDOM = 7;
    private static final int SHAPE_I_INT = 0;
    private static final int SHAPE_J_INT = 1;
    private static final int SHAPE_L_INT = 2;
    private static final int SHAPE_O_INT = 3;
    private static final int SHAPE_S_INT = 4;
    private static final int SHAPE_T_INT = 5;

    /**
     * Generates a class depending on a random number.
     * @return A class of shape.
     */
    public Shape getShape(final int random) {
        int randomNumber = random;
        switch (randomNumber) {
            case SHAPE_I_INT:
                return new Shape(ShapeType.I);
            case SHAPE_J_INT:
                return new Shape(ShapeType.J);
            case SHAPE_L_INT:
                return new Shape(ShapeType.L);
            case SHAPE_O_INT:
                return new Shape(ShapeType.O);
            case SHAPE_S_INT:
                return new Shape(ShapeType.S);
            case SHAPE_T_INT:
                return new Shape(ShapeType.T);
            default:
                return new Shape(ShapeType.Z);
        }
    }
    /**
     * Generates a random number
     * @return a random number
     */
    public int randomNumberGenerator() {
        Random random = new Random();
        int randomNumber = random.nextInt(MAX_RANDOM);
        return randomNumber;
    }
}
