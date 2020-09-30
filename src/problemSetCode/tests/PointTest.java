package problemSetCode.tests;

import problemSetCode.code.Point;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    @Test
    public void distanceFromOrigin() {
        Point point = new Point(1,2);
        assertEquals(Math.sqrt(5), point.distanceFromOrigin(), 0.00001);
    }

    @Test
    public void getQuadrant() {
        assertEquals("Quadrant 1",new Point(3,4).getQuadrant());
        assertEquals("Quadrant 2",new Point(-4.5,6).getQuadrant());
        assertEquals("Quadrant 3",new Point(-1,-1).getQuadrant());
        assertEquals("Quadrant 4",new Point(19,-3.2215).getQuadrant());

        assertEquals("Axes",new Point(0,-7).getQuadrant());
        assertEquals("Axes",new Point(12,0).getQuadrant());
        assertEquals("Axes",new Point(0,0).getQuadrant());
    }

    @Test
    public void distanceTo() {
        Point point = new Point(1,2);
        Point point2 = new Point(4,6);
        assertEquals(5, point.distanceTo(point2), 0.00001);
    }

    @Test
    public void testDistanceToPoint() {
        //Test in a straight line
        Point point1 = new Point(1,0);
        Point point2 = new Point(3,0);

        assertEquals(2, point1.distanceTo(point2), 0.00001);

        //Test on a diagonal line
        point1 = new Point(1,1);
        point2 = new Point(3,3);

        assertEquals(2 * Math.sqrt(2), point1.distanceTo(point2), 0.00001);

        //Test with negative numbers
        point1 = new Point(-1,-1);
        point2 = new Point(-3,-3);

        assertEquals(2 * Math.sqrt(2), point1.distanceTo(point2), 0.00001);
    }

    @Test
    public void testClosestPoint() {
        //Create the point we will be finding the closest point to
        Point point1 = new Point(2,4);

        //Create an array of points which will be fed to the closestPoint method
        Point[] points = new Point[6];
        points[0] = new Point(-5,-2);
        points[1] = new Point(-1,-1);
        points[2] = new Point(0,0);
        points[3] = new Point(3,5);
        points[4] = new Point(3,5);
        points[5] = new Point(7,6);

        //Call the method on point1 given the point array and get the closest point back
        Point closestPoint = point1.closestPoint(points);

        assertEquals(new Point (3,5), closestPoint);
    }
}