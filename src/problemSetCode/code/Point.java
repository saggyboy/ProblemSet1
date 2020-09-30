package problemSetCode.code;

import java.util.Objects;

public class Point {
    public double x,y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "ProblemSetCOde.Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double distanceFromOrigin(){
        return Math.sqrt(x * x + y * y);
    }

    public String getQuadrant() {
        if (x > 0 && y > 0) {
            return "Quadrant 1";
        } else if (x<0 && y>0){
            return "Quadrant 2";
        } else if (x<0 && y<0){
            return "Quadrant 3";
        } else if (x>0 && y<0){
            return "Quadrant 4";
        }
        return "Axes";
    }

    public double distanceTo(Point other){
        double xDistance = x - other.x;
        double yDistance = y - other.y;

        return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
    }

    public Point closestPoint(Point[] points){
        //Set the closest point to the first point in the array and calculate the distance
        Point closestPoint = points[0];
        double distanceToClosestPoint = distanceTo(closestPoint);

        //Loop through the points and see if the distance of the current point is less than the distance from the previously stored closest point
        for (int i = 1; i < points.length; i++) {
            Point currentPoint = points[i];
            double distanceToCurrent = distanceTo(currentPoint);
            if (distanceToCurrent < distanceToClosestPoint){

                //If so, update the distance and point to be the closest point and closest distance
                closestPoint = currentPoint;
                distanceToClosestPoint = distanceToCurrent;
            }
        }
        return closestPoint;
    }
}
