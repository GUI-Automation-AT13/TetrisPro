package src.utilities;
import src.shapes.*;
import src.utilities.*;
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
}