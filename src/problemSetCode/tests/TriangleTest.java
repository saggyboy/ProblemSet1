package problemSetCode.tests;

import org.junit.Test;
import problemSetCode.code.Point;
import problemSetCode.code.Triangle;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void getArea() {
        Triangle triangle = new Triangle(new Point(0,0), new Point(0,3), new Point(4,0), Triangle.TriangleTypes.SCALENE, true);
        assertEquals(6, triangle.getArea(), .0001);
    }

    @Test
    public void getPerimeter() {
    }
}