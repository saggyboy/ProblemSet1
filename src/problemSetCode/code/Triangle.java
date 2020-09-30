package problemSetCode.code;

public class Triangle implements Shape{
    private TriangleTypes triangleType;
    private Point p1,p2,p3;
    private double side1, side2, side3;
    private boolean rightTriangle;

    public Triangle(Point p1, Point p2, Point p3){
        this(p1, p2, p3, TriangleTypes.NONE, false);
    }

    public Triangle(Point p1, Point p2, Point p3, TriangleTypes triangleType, boolean rightTriangle) {
        this.triangleType = triangleType;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.rightTriangle = rightTriangle;
        side1 = p1.distanceTo(p2);
        side2 = p2.distanceTo(p3);
        side3 = p3.distanceTo(p1);
    }

    @Override
    public double getArea() {
        double sP = getPerimeter()*.5;
        return Math.sqrt(sP * (sP - side1) * (sP - side2) * (sP - side3));
    }

    @Override
    public double getPerimeter() {
        return (side1 + side2 + side3);
    }

    public enum TriangleTypes{
        EQUILATERAL, ISOSCELES, SCALENE, RIGHT, NONE
    }
}
