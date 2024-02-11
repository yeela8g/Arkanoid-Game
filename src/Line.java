//Yeela Granot  209133107   group 111-14

import java.util.List;

/**
 * @author Ye'ela Granot
 * class of line-segments which connects two point - start and end
 * each instance own length, interstection with other lines, distances and more shown below
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * @param start1 point which the line starts from
     * @param end1   point which the line ends in
     */
    public Line(Point start1, Point end1) {
        this.start = start1;
        this.end = end1;
    }

    /**
     * @param x1 the X coordinate of the start point
     * @param y1 the Y coordinate of the start point
     * @param x2 the X coordinate of the end point
     * @param y2 the Y coordinate of the end point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * @return distance of two points of the line
     */
    public double length() {

        return this.start.distance(end);
    }

    /**
     * @return the middle point of the line
     */
    public Point middle() {
        double midX = (this.start.getX() + this.end.getX()) / 2;
        double midY = (this.start.getY() + this.end.getY()) / 2;
        return new Point(midX, midY);
    }

    /**
     * @return the start point of the line
     */
    public Point start() { //random choice
        return this.start;
    }

    /**
     * @return the end point of the line
     */
    public Point end() {
        return this.end;
    }

    /**
     * @param slope of a specific line
     * @param p     point on a specific line
     * @return the intersection with Y-line in order to find the equation line
     */
    public double yLineIntersecting(double slope, Point p) {
        return (p.getY() - slope * p.getX());
    }

    /**
     * @param point its coordinate checked for being inside a range of a given line
     * @return true if line contains point and false otherwise
     */
    public boolean isLineContainsPoint(Point point) {
        float radius = (float) GameLevel.RADIUS;
        boolean isInRangeX, isInRangeY;
        this.setOrderByX();
        float xPlusEpsilon = (float) this.end.getX() + radius / 10;
        float xMinusEpsilon = (float) (this.start.getX() - radius / 10);
        isInRangeX = (point.getX() <= (xPlusEpsilon)) && (point.getX() >= (xMinusEpsilon)); //point is in X range
        this.setOrderByY();
        float yPlusEpsilon = (float) this.end.getY() + radius / 10;
        float yMinusEpsilon = (float) this.start.getY() - radius / 10;
        isInRangeY = (point.getY() <= (yPlusEpsilon)) && (point.getY() >= (yMinusEpsilon)); //point is in Y range
        return isInRangeX && isInRangeY;
    }

    /**
     * @return true if line is a point - made of two identical points
     */
    public boolean isPoint() {
        return this.start.equals(this.end);
    }

    /**
     * @param other checked to have an intersection point with a given line.
     * @return true if two lines intersect , false otherwise
     */
    public boolean isIntersecting(Line other) {
        return this.intersectionWith(other) != null;
    }

        /**
         * @param other line to check the intersection point with our main line object
         * @return the intersection point if the lines intersect, and null otherwise.
        */
    public Point intersectionWith(Line other) {
        Line copyThis = new Line(new Point(this.start().getX(), this.start.getY()),
                new Point(this.end().getX(), this.end().getY()));
        Line copyOther = new Line(new Point(other.start().getX(), other.start().getY()),
                new Point(other.end().getX(), other.end().getY()));
        Point p; //in this ass:this-trajectory , other-edge of the rectangle that collides
        Double thisSlope = copyThis.slope();
        Double otherSlope = copyOther.slope();
        if (thisSlope == null && otherSlope == null || //is parallel
                thisSlope != null && otherSlope != null && (thisSlope.doubleValue() == otherSlope.doubleValue())) {
            if ((copyThis.slope() == null) && (copyOther.slope() == null)) { //both are vertical
                if (copyThis.start.getX() == copyOther.start.getX()) { // on the same line - same x
                    copyThis.setOrderByY();
                    copyOther.setOrderByY();
                    if (copyThis.end.getY() == copyOther.start.getY()) { //intersection point : end head to this tail
                        return new Point(copyThis.end.getX(), copyThis.end.getY());
                    } else if (copyOther.end.getY() == copyThis.start.getY()) { //intersection of this head to end tail
                        return new Point(copyOther.end.getX(), copyOther.end.getY());
                    } else if (copyThis.isPoint() && copyThis.start.getY() > copyOther.start.getY()
                            && copyThis.start.getY() < copyOther.end.getY()) { //this is point in other y range
                        return copyThis.start;
                    } else if (copyOther.isPoint() && copyOther.start.getY() > copyThis.start.getY()
                            && copyOther.start.getY() < copyThis.end.getY()) { //other's point in this y range
                        return copyOther.start;
                    } else {
                        return null; //no intersection
                    }
                } else {
                    return null; //not on the same line - different x
                }
            } else if ((thisSlope != 0) && (otherSlope != 0)) { //same slop not vertical not horizontal
                copyThis.setOrderByX();
                copyOther.setOrderByX();
                if (copyThis.start.getX() == copyOther.end.getX() && copyThis.start.getY() == copyOther.end.getY()) {
                    p = new Point(copyThis.start.getX(), copyThis.start.getY()); //they connect other is down this is up
                    return p;
                } else if (copyOther.start.getX() == copyThis.end.getX()
                        && copyOther.start.getY() == copyThis.end.getY()) {
                    p = new Point(copyOther.start.getX(), copyOther.start.getY()); //connect this is down other is up
                    return p;
                } else {
                    return null; //no intersection point
                }
            } else { //both Horizontal
                if (copyThis.start.getY() == copyOther.start.getY()) { //same line
                    copyThis.setOrderByY();
                    copyOther.setOrderByY();
                    if (copyThis.end.getX() == copyOther.start.getX()) { //intersection point - other is up this is down
                        p = new Point(copyThis.end.getX(), copyThis.end.getY());
                        return p;
                    } else if (copyOther.end.getX() == copyThis.start.getX()) { //intersect point other down this up
                        p = new Point(copyOther.end.getX(), copyOther.end.getY());
                        return p;
                    } else { // same line but not touch
                        return null;
                    }
                } else { //not same line
                    return null;
                }
            }
        } else { //not same slope
            double yIntersecting;
            double xIntersecting;
            if (thisSlope == null || otherSlope == null) { // one is vertical
                if (thisSlope == null) { //this is vertical
                    double nOther = (copyOther.yLineIntersecting(copyOther.slope(), copyOther.start));
                    double mOther = copyOther.slope();
                    yIntersecting = mOther * copyThis.start.getX() + nOther;
                    xIntersecting = copyThis.start.getX();
                } else {  //other is vertical
                    double nThis = (copyThis.yLineIntersecting(copyThis.slope(), copyThis.start));
                    double mThis = copyThis.slope();
                    yIntersecting = mThis * copyOther.start.getX() + nThis;
                    xIntersecting = copyOther.start.getX();
                }
            } else { // calculate intersection point for two classic lines
                double nThis = (copyThis.yLineIntersecting(copyThis.slope(), copyThis.start));
                double nOther = (copyOther.yLineIntersecting(copyOther.slope(), copyOther.start));
                double mThis = copyThis.slope();
                double mOther = copyOther.slope();
                xIntersecting = (nThis - nOther) / (mOther - mThis); //comparison of two line equations
                yIntersecting = ((((mOther) * (nThis)) - ((mThis) * (nOther))) / ((mOther) - (mThis)));
            }
            Point intersectingPoint = new Point(xIntersecting, yIntersecting); //point suspect as intersection
            if (copyThis.isLineContainsPoint(intersectingPoint) && copyOther.isLineContainsPoint(intersectingPoint)) {
                return intersectingPoint; //the point on both lines
            } else {
                return null; //point is not on one line
            }
        }
    }

    /**
     * this function ensure the start point and the end point of the line are sorted by the x values
     * so that start will own the smaller x coordinate value and end will own the bigger.
     */
    public void setOrderByX() {
        if (this.start.getX() > this.end.getX()) { //if the start point is bigger than end point - switch
            double temp = this.start.getX(); //switch x
            this.start.setX(this.end.getX());
            this.end.setX(temp);

            temp = this.start.getY(); //switch y1
            this.start.setY(this.end.getY());
            this.end.setY(temp);
        }
    }

    /**
     * this function ensure the start point and the end point of the line are sorted by the y values
     * so that start will own the smaller y coordinate value and end will own the bigger.
     */
    public void setOrderByY() {
        if (this.start.getY() > this.end.getY()) { //if the start point is bigger than end point - switch
            double temp = this.start.getX(); //switch x
            this.start.setX(this.end.getX());
            this.end.setX(temp);

            temp = this.start.getY(); //switch y
            this.start.setY(this.end.getY());
            this.end.setY(temp);
        }
    }

    /**
     * @return check if the line has a slope and calculate it,
     * otherwise isYParallel boolean turn false and return -1
     */
    public Double slope() {
        double x1 = this.start.getX();
        double y1 = this.start.getY();
        double x2 = this.end.getX();
        double y2 = this.end.getY();
        if (x1 - x2 != 0) { // denominator of line equation cant be zero
            return ((y1 - y2) / (x1 - x2));
        } else {
            return null; //the lines has the same x - vertical
        }
    }

    /**
     * @param other checked if the lines share the same points values
     * in a way which the vector will be the same for both.
     * @return true if the vector is the same, false otherwise.
     */

    public boolean equals(Line other) {
        this.setOrderByX();
        other.setOrderByX();
        boolean startPointEqual = ((this.start.getX()) == (other.start.getX()) //equal (x,y) start point of both lines
                && (this.start.getY()) == (other.start.getY()));
        boolean endPointEqual = ((this.end.getX()) == (other.end.getX()) && (this.end.getY()) == (other.end.getY()));
        //equal (x,y) end point of both lines
        return startPointEqual && endPointEqual;

    }

    /**
     * calculate intersection point of the rectangle with the trajectory line.
     * @param rect collidable with rectangle shape
     * @return intersection point of the rectangle with the trajectory line
     */
    // If this line does not intersect with the rectangle, return null.
    // Otherwise, return the closest intersection point to the
    // start of the line.
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> listOfIntersectionPoints = rect.intersectionPoints(this);
        if (listOfIntersectionPoints.size() == 1) { //if there is only one intersection point with the collidable
            return listOfIntersectionPoints.get(0);
        } else if (listOfIntersectionPoints.size() == 0) { //if there is no intersection point
            return null;
        } else if (listOfIntersectionPoints.size() == 2) { //there two intersection points,take closest to line start
            double distanceFromStart0 = this.start.distance(listOfIntersectionPoints.get(0));
            double distanceFromStart1 = this.start.distance(listOfIntersectionPoints.get(1));
            if (distanceFromStart0 > distanceFromStart1) {
                return listOfIntersectionPoints.get(1);
            } else {
                return listOfIntersectionPoints.get(0);
            }
        } else {
            return null;
        }
    }
}
