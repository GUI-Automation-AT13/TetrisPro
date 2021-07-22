package src.tetris;
import src.tetris.shapes.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomShapeTest {

    @Test
    public void getShape_GetRandomNumber_ShapeI() {
        RandomShape randomShape = new RandomShape();
        Shape shapeI = new Shape(ShapeType.I);
        assertEquals(shapeI.getClass(),randomShape.getShape(0).getClass());
    }

    @Test
    public void getShape_GetRandomNumber_ShapeJ() {
        RandomShape randomShape = new RandomShape();
        Shape shapeJ = new Shape(ShapeType.J);
        assertEquals(shapeJ.getClass(),randomShape.getShape(1).getClass());
    }

    @Test
    public void getShape_GetRandomNumber_ShapeL() {
        RandomShape randomShape = new RandomShape();
        Shape shapeL = new Shape(ShapeType.L);
        assertEquals(shapeL.getClass(),randomShape.getShape(2).getClass());
    }

    @Test
    public void getShape_GetRandomNumber_ShapeO() {
        RandomShape randomShape = new RandomShape();
        Shape shapeO = new Shape(ShapeType.O);
        assertEquals(shapeO.getClass(),randomShape.getShape(3).getClass());
    }

    @Test
    public void getShape_GetRandomNumber_ShapeS() {
        RandomShape randomShape = new RandomShape();
        Shape shapeS = new Shape(ShapeType.S);
        assertEquals(shapeS.getClass(),randomShape.getShape(4).getClass());
    }

    @Test
    public void getShape_GetRandomNumber_ShapeT() {
        RandomShape randomShape = new RandomShape();
        Shape shapeT = new Shape(ShapeType.T);
        assertEquals(shapeT.getClass(),randomShape.getShape(5).getClass());
    }

    @Test
    public void getShape_GetRandomNumber_ShapeZ() {
        RandomShape randomShape = new RandomShape();
        Shape shapeZ = new Shape(ShapeType.Z);
        assertEquals(shapeZ.getClass(),randomShape.getShape(6).getClass());
    }

    @Test
    public void randomNumberGenerator_MaxRange_ValuesUnderMaxRange() {
        RandomShape randomShape = new RandomShape();
        int max = 0;
        for (int i = 0; i < 1000000; i++) {
            int random = randomShape.randomNumberGenerator();
            if (max < random) {
                max = random;
            }
        }
        assertTrue(max <= 7);
    }

    @Test
    public void randomNumberGenerator_MinRange_ValuesOverMinRange() {
        RandomShape randomShape = new RandomShape();
        int min = 10;
        for (int i = 0; i < 1000000; i++) {
            int random = randomShape.randomNumberGenerator();
            if (min < random) {
                min = random;
            }
        }
        assertTrue(min >= 0);
    }

    @Test
    public void randomNumberGenerator_SingleValue_ValuesInRange() {
        RandomShape randomShape = new RandomShape();
        int zeroCount = 0;
        for (int i = 0; i < 1000000; i++) {
            int random = randomShape.randomNumberGenerator();
            if (random == 0) {
                zeroCount++;
            }
        }
        assertFalse(zeroCount == 1000000);
    }
}