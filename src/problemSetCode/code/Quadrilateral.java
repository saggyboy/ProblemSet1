package problemSetCode.code;

public class Quadrilateral implements Shape{
    private QuadrilateralTypes quadrilateralType;
    private Point p1,p2,p3,p4;
    private double side1, side2, side3, side4, diagonalSeparation;

    public Quadrilateral(Point p1, Point p2, Point p3, Point p4, QuadrilateralTypes QuadrilateralType) {
        this.quadrilateralType = quadrilateralType;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;

        side1 = p1.distanceTo(p2);
        side2 = p2.distanceTo(p3);
        side3 = p3.distanceTo(p4);
        side4 = p4.distanceTo(p1);
        diagonalSeparation = p1.distanceTo(p3);
    }

    @Override
    public double getArea() {
//        double angle1 = Math.acos(((side1*side1)+(side2*side2) - (diagonalSeparation * diagonalSeparation))/2*side1*side2);
//        double angle2 = Math.acos(((side3*side3)+(side4*side4) - (diagonalSeparation * diagonalSeparation))/2*side3*side4);
//        return (.5*side1*side2*Math.sin(angle1)) + (.5*side3*side4*Math.sin(angle2));
        Triangle triangle1 = new Triangle(p1,p2,p3);
        Triangle triangle2 = new Triangle(p3,p4,p1);
        return triangle1.getArea() + triangle2.getArea();
    }

    @Override
    public double getPerimeter() {
        return (side1 + side2 + side3 + side4);
    }

    public enum QuadrilateralTypes{
        SQUARE, RHOMBUS, RECTANGLE, KITE, NONE, TRAPEZOID, DIAMOND
    }
}
