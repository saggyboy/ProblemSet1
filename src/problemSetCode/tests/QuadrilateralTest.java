package problemSetCode.tests;

import org.junit.Test;
import problemSetCode.code.Point;
import problemSetCode.code.Quadrilateral;
import problemSetCode.code.Triangle;

import static org.junit.Assert.assertEquals;

public class QuadrilateralTest {

    @Test
    public void getArea() {
        Quadrilateral quadrilateral = new Quadrilateral(new Point(0,0), new Point(0,3), new Point(4,3), new Point(4,0), Quadrilateral.QuadrilateralTypes.RECTANGLE);
        assertEquals(12, quadrilateral.getArea(), .0001);
    }

    @Test
    public void getPerimeter() {
    }
}