package src.shapes;

import org.junit.Test;
import src.shapes.Shape;
import src.shapes.ShapeType;

import static org.junit.Assert.*;

public class ShapeTest {
    @Test
    public void moveRight_changePositionX3_x4() {
        Shape shapeI = new Shape(ShapeType.I);
        shapeI.moveRight();
        assertEquals(4, shapeI.getxPosition());
    }

    @Test
    public void moveRight_move10timesFromX3_x6() {
        Shape shapeI = new Shape(ShapeType.I);
        for (int i = 0; i < 10; i++) {
            shapeI.moveRight();
        }
        assertEquals(6, shapeI.getxPosition());
    }

    @Test
    public void moveLeft_changePositionX3_x2() {
        Shape shapeI = new Shape(ShapeType.S);
        shapeI.moveLeft();
        assertEquals(2, shapeI.getxPosition());
    }

    @Test
    public void moveLeft_move10timesFromX3_x0() {
        Shape shapeI = new Shape(ShapeType.S);
        for (int i = 0; i < 10; i++) {
            shapeI.moveLeft();
        }
        assertEquals(0, shapeI.getxPosition());
    }

    @Test
    public void moveDown_changePositionY0_y1() {
        Shape shapeI = new Shape(ShapeType.Z);
        shapeI.moveDown();
        assertEquals(1, shapeI.getyPosition());
    }

    @Test
    public void moveDown_moveShapeI25timesFromY0_y19() {
        Shape shapeI = new Shape(ShapeType.I);
        for (int i = 0; i < 25; i++) {
            shapeI.moveDown();
        }
        assertEquals(19, shapeI.getyPosition());
    }
    @Test
    public void moveDown_moveShapeS25timesFromY0_y18() {
        Shape shapeI = new Shape(ShapeType.S);
        for (int i = 0; i < 25; i++) {
            shapeI.moveDown();
        }
        assertEquals(18, shapeI.getyPosition());
    }

    @Test
    public void moveDown_moveShapeO25timesFromY0y18() {
        Shape shapeI = new Shape(ShapeType.O);
        for (int i = 0; i < 25; i++) {
            shapeI.moveDown();
        }
        assertEquals(18, shapeI.getyPosition());
    }

    @Test
    public void rotate_changePositionShapeT_shapeTVertical() {
        Shape shapeT = new Shape(ShapeType.T);
        shapeT.rotate();
        boolean[][] actual = shapeT.getContainer();
        boolean[][] expected = {{false, false, true},
                                {false, true, true},
                                {false, false, true}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void rotateShape_changePositionShapeSOneMove_shapeSVertical() {
        Shape shapeS = new Shape(ShapeType.S);
        shapeS.rotate();
        boolean[][] actual = shapeS.getContainer();
        boolean[][] expected = {{false, true, false},
                                {false, true, true},
                                {false, false, true}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void rotateShape_changePositionShapeSTwoMoves_shapeSHorizontal() {
        Shape shapeS = new Shape(ShapeType.S);
        shapeS.rotate();
        shapeS.rotate();
        boolean[][] actual = shapeS.getContainer();
        boolean[][] expected = {{false, false, false},
                                {false, true, true},
                                {true, true, false}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void rotateShape_changePositionShapeSThreeMoves_shapeSVertical() {
        Shape shapeS = new Shape(ShapeType.S);
        shapeS.rotate();
        shapeS.rotate();
        shapeS.rotate();
        boolean[][] actual = shapeS.getContainer();
        boolean[][] expected = {{true, false, false},
                                {true, true, false},
                                {false, true, false}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void rotateShape_changePositionShapeSFourMoves_shapeSHorizontal() {
        Shape shapeS = new Shape(ShapeType.S);
        shapeS.rotate();
        shapeS.rotate();
        shapeS.rotate();
        shapeS.rotate();
        boolean[][] actual = shapeS.getContainer();
        boolean[][] expected = {{false, true, true},
                                {true, true, false},
                                {false, false, false}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getPartialShape_ShapeI_I() {
        Shape shape = new Shape(ShapeType.I);
        boolean[][] actual = shape.getPartialShape();
        boolean[][] expected = {{true, true, true, true}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getPartialShape_ShapeIRotatedOneTime_I() {
        Shape shape = new Shape(ShapeType.I);
        shape.rotate();
        boolean[][] actual = shape.getPartialShape();
        boolean[][] expected = {{true},{true},{true},{true}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getPartialShape_ShapeIRotatedTwoTimes_I() {
        Shape shape = new Shape(ShapeType.I);
        shape.rotate();
        shape.rotate();
        boolean[][] actual = shape.getPartialShape();
        boolean[][] expected = {{true, true, true, true}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getPartialShape_ShapeIRotatedThreeTimes_I() {
        Shape shape = new Shape(ShapeType.I);
        shape.rotate();
        shape.rotate();
        shape.rotate();
        boolean[][] actual = shape.getPartialShape();
        boolean[][] expected = {{true},{true},{true},{true}};
        assertArrayEquals(expected, actual);
    }
}