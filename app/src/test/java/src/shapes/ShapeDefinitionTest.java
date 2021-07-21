package src.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeDefinitionTest {

    @Test
    public void generate_ShapeForm_I() {
        boolean[][] actual = ShapeDefinition.generate(ShapeType.I);
        boolean[][] expected = {{ true, true, true, true},
                                { false, false, false, false},
                                { false, false, false, false},
                                { false, false, false, false}};
        assertArrayEquals(expected, actual);
    }


    @Test
    public void generate_ShapeForm_J() {
        boolean[][] actual = ShapeDefinition.generate(ShapeType.J);
        boolean[][] expected = {{true, true, true},
                                {false, false, true},
                                {false, false, false}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void generate_ShapeForm_L() {
        boolean[][] actual = ShapeDefinition.generate(ShapeType.L);
        boolean[][] expected = {{ true, true, true},
                                { true, false, false},
                                { false, false, false}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void generate_ShapeForm_T() {
        boolean[][] actual = ShapeDefinition.generate(ShapeType.T);
        boolean[][] expected = {{ true, true, true},
                                { false, true, false},
                                { false, false, false}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void generate_ShapeForm_S() {
        boolean[][] actual = ShapeDefinition.generate(ShapeType.S);
        boolean[][] expected = {{ false, true, true},
                                { true, true, false},
                                { false, false, false}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void generate_ShapeForm_Z() {
        boolean[][] actual = ShapeDefinition.generate(ShapeType.Z);
        boolean[][] expected = {{ true, true, false},
                                { false, true, true},
                                { false, false, false}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void generate_ShapeForm_O() {
        boolean[][] actual = ShapeDefinition.generate(ShapeType.O);
        boolean[][] expected = {{ true, true},
                                { true, true}};
        assertArrayEquals(expected, actual);
    }
}