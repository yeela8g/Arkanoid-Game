//Ye'ela Granot  209133107   group 111-14

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ye'ela Granot
 * this class represent two dimensial rectangle
 */
public class Rectangle {
    private Point pUpperLeft;
    private double width;
    private double height;

    /**
     * Create a new rectangle with location and width/height.
     * @param upperLeft1 the top left point of the rectangle
     * @param width1  the width of the rectangle
     * @param height1 the height of the rectangle
     */
    public Rectangle(Point upperLeft1, double width1, double height1) {
        this.pUpperLeft = upperLeft1;
        this.width = width1;
        this.height = height1;
    }

    /**
     *  Return a (possibly empty) List of intersection points
     *  with the specified line.
     * @param line tested for intersection point with a specific rectangle
     * @return an Arraylist of intersections point
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> listOfIntersectionPoints = new ArrayList<>();
        Point intersectionUpperEdge = line.intersectionWith(calculateUpperEdge()); //start&end swith
        Point intersectionBottomEdge = line.intersectionWith(calculateBottomEdge());
        Point intersectionLeftEdge = line.intersectionWith(calculateLeftEdge());
        Point intersectionRightEdge = line.intersectionWith(calculateRightEdge());

        if (intersectionUpperEdge != null) { //if there is an intersection point with the upper edge add it
            listOfIntersectionPoints.add(intersectionUpperEdge);
        }
        if (intersectionBottomEdge != null) {
            listOfIntersectionPoints.add(intersectionBottomEdge);
        } //if there is an intersection point with the bottom edge add it
        if (intersectionLeftEdge != null) {
            listOfIntersectionPoints.add(intersectionLeftEdge);
        } //if there is an intersection point with the left edge add it
        if (intersectionRightEdge != null) {
            listOfIntersectionPoints.add(intersectionRightEdge);
        } //if there is an intersection point with the right edge add it
        listOfIntersectionPoints = this.checkRepetitions(listOfIntersectionPoints);
        return listOfIntersectionPoints;
    }

    /**
     * @return the width and height of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * @return the height and height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }


    /**
     * @return the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.pUpperLeft;
    }

    /**
     * @return the upper edge of the rectangle
     */
    public Line calculateBottomEdge() {
        Point lowerRight = new Point(this.pUpperLeft.getX() + width, this.pUpperLeft.getY() + this.height);
        Point lowerLeft = new Point(lowerRight.getX() - this.width, lowerRight.getY());
        return new Line(lowerRight, lowerLeft);
    }
    /**
     *
     * @return the bottom edge of the rectangle
     */
    public Line calculateUpperEdge() {
        return new Line(this.pUpperLeft, new Point(this.pUpperLeft.getX() + this.width, this.pUpperLeft.getY()));
    }

    /**
     * @return the left edge of the rectangle
     */
    public Line calculateLeftEdge() {
        return new Line(this.pUpperLeft, new Point(this.pUpperLeft.getX(), this.pUpperLeft.getY() + this.height));
    }

    /**
     * @return the right edge of the rectangle
     */
    public Line calculateRightEdge() {
        Point lowerRight = new Point(this.pUpperLeft.getX() + this.width, this.pUpperLeft.getY() + this.height);
        return new Line(lowerRight, new Point(this.pUpperLeft.getX() + this.width, lowerRight.getY() - this.height));
    }

    /**
     * remove duplicated point in the intersection points array.
     * @param array the array checked for repetitions
     * @return array without repetitions
     */

    private java.util.List<Point> checkRepetitions(List<Point> array) {

        if (array.size() == 1) {
        return array;
        } else if (array.size() == 2) {
            if (array.get(0).equals(array.get(1))) {
                array.remove(1);
            }
            return array;
        } else {
            List<Point> listWithoutDuplicates = new ArrayList<>();
            boolean equals = false;
            int i = 0;
            int j = 0;
            for (i = array.size() - 1; i >= 0; i--) {
                for (j = i - 1; j >= 0; j--) {
                    if (array.get(i).equals(array.get(j))) {
                        equals = true;
                    }
                }
                if (!equals) {
                    listWithoutDuplicates.add(array.get(i));

                }
                equals = false;
            }
            //listWithoutDuplicates.add(array.get(0));
            return listWithoutDuplicates;
        }
    }
}
