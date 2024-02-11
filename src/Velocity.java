//Yeela Granot  209133107   group 111-14
/**
 * this class responsible for the movement of the ball during the bouncing animation.
 */

public class Velocity {
    private double dx;
    private double dy;

    /**
     * this constructor reset new velocity dx and dy values by an angle and a distance.
     * @param angle of the change in the movement (degrees) - after that been converted to radians
     * @param speed the distance between the old center to the new one
     * @return new initialized velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double angleRad = (Math.PI) / 180 * angle;
        double dx = Math.cos(angleRad) * speed;
        double dy = Math.sin(angleRad) * speed;
        return new Velocity(dx, dy);
    }

    /**
     * constructor initialization.
     * @param dx1 the change between the two x values
     * @param dy1 the change between the two y values
     */
    public Velocity(double dx1, double dy1) {
        this.dx = dx1;
        this.dy = dy1;
    }

    /**
     * @param p center point of the ball
     * @return new center point calculated with the change of the velocity
     */
    public Point applyToPoint(Point p) {
        return new Point((p.getX() + this.dx), (p.getY() + this.dy));
    }

    /**
     * @return the change in x by the velocity
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * @return the change in y by the velocity
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * this method responsible for changing the x values of the center point.
     * This in order to make the ball change his direction so the animation bouncing
     * stay inside the graphic picture bounds
     */
    public void setDxDirection() {
        this.dx *= -1;
    }

    /**
     * this method responsible for changing the y values of the center point.
     * This in order to make the ball change his direction so the animation bouncing
     * stay inside the graphic picture bounds
     */
    public void setDyDirection() {
        this.dy *= -1;
    }

    /**
     * @return speed of the ball by his velocity values
     */
    public double getSpeed() {
        return Math.sqrt(this.dx * this.dx + this.dy * this.dy);
    }

}