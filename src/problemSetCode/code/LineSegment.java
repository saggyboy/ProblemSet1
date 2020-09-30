package problemSetCode.code;

public class LineSegment {
    Point p1, p2;

    public LineSegment(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point[] subDivide(int dividedSegments){
        //Calculate deltas of the segments
        double deltaX = p2.x - p1.x;
        double deltaY = p2.y - p1.y;

        //Calculate deltas of the divided segment lengths
        double xStep = deltaX/dividedSegments;
        double yStep = deltaY/dividedSegments;

        //Add the steps together to make the new subdivided points
        Point[] points = new Point[dividedSegments-1];
        for (int i = 1; i < dividedSegments; i++) {
            points[i-1] = new Point(p1.x + xStep * i, p1.y + yStep * i);
        }
        return points;
    }

    public Point interpolate(double distanceFromFirstPoint){
        //Find proportion of the distanceFromFirstPoint to distance of line segment
        double segmentLength = p1.distanceTo(p2);
        double proportion = distanceFromFirstPoint/segmentLength;

        //Find deltas of line segment
        double deltaX = p2.x - p1.x;
        double deltaY = p2.y - p1.y;

        //Multiply deltas by proportion
        double interpolatedX = deltaX * proportion;
        double interpolatedY = deltaY * proportion;

        //Create new point given interpolated x and y values
        return new Point(interpolatedX + p1.x, interpolatedY + p1.y);
    }

}
