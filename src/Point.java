//Ye'ela Granot  209133107   group 111-14
/**
 * @author Ye'ela Granot
 *one dimensial point class
 */
public class Point {
    private double x;
    private double y;

    /**
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param other a point to calculate the distance to
     * @return the distance between two points
    */
    public double distance(Point other) {
        double dX = this.x - other.getX();
        double dY = this.y - other.getY();
        return Math.sqrt((dX * dX) + (dY * dY));
    }
    /**
     *checks for equality between two points.
     * @param other a point to compare coordinates with
     * @return true if the points are equal
     */
    public boolean equals(Point other) {
        return (this.x == other.x) && (this.y == other.y);
    }

    /**
     * @return the x coordinate
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return the y coordinate
     */
    public double getY() {
        return this.y;
    }

    /**
     * @param x1 the new value of x
     */
    public void setX(double x1) {
        this.x = x1;
    }
    /**
     * @param y1 the new value of y
     */
    public void setY(double y1) {
        this.y = y1;
    }
}