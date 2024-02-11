//Yeela Granot  209133107   group 111-14

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * ball class represent circles which can be send to graphic presentation for the arcade game.
 * the balls have radius, color and point coordinates of the center, color, velocity
 * and own a list of collidable objects
 */
public class Ball implements Sprite {
    private final int radius;
    private Point point;
    private final java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;
    private Line trajectory;

    /**
     * this method construct new balls.
     * @param y the y coordinate of the ball center point
     * @param x the x coordinate of the center point of the ball
     * @param r the radius size of the ball
     * @param color1 the ball color
     */
    public Ball(double x, double y, int r, java.awt.Color color1) {
        this.point = new Point(x, y);
        this.radius = r;
        this.color = color1;
    }

    /**
     * constructor with point initialization.
     * @param p center point
     * @param r radius of the ball
     * @param color1 the ball color
     */
    public Ball(Point p, int r, java.awt.Color color1) {
        this.point = p;
        this.radius = r;
        this.color = color1;
    }

    /**
     *
     * @param p center point
     * @param r ball radius
     * @param color1 ball color
     * @param vel ball velocity
     * @param game list of all collidable objects in the game
     */
    public Ball(Point p, int r, java.awt.Color color1, Velocity vel, GameEnvironment game) {
        this.point = p;
        this.radius = r;
        this.color = color1;
        this.velocity = vel;
        this.gameEnvironment = game;
    }


    /**
     * @param game game environment hold a list of all the collidable instances.
     */
    public void setGameEnvironment(GameEnvironment game) {
        this.gameEnvironment = game;
    }


    /**
     * @return this function return the x value of the circle center.
     */
    public double getX() {
        return this.point.getX();
    }

    /**
     * @return this function return the Y value of the circle center.
     */
    public double getY() {
        return this.point.getY();
    }

    /**
     * @return this function return the radius size of the circle.
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * getter for center point.
     * @return the center point
     */
    public Point getPoint() {
        return this.point;
    }

    /**
     * @return the wanted color for painting the circle.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * @return ball velocity value.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * @param surface paints the balls according to their inner features values.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) Math.round(this.getX()), (int) Math.round(this.getY()), this.getSize());
        surface.setColor(Color.BLACK);
        surface.drawCircle((int) Math.round(this.getX()), (int) Math.round(this.getY()), this.getSize());
    }

    /**
     * changes the internal state of the ball by changing its center point location according to the current velocity.
     */
    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * getter for the game environment field.
     * @return list of all collidable objects in the game
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
    }

    /**
     * this method changes the velocity value of this ball by a point.
     * @param v velocity of the ball
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * this method changes the velocity value of the ball by explicit two coordinate of a point.
     * @param dx the change value of x in velocity
     * @param dy the change value of y in velocity
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * calculates the new trajectory of the ball after moving one step forward.
     */
    public void setTrajectory() {
        Point pCenter = this.point;
        Point endTrajectory = this.velocity.applyToPoint(this.point);
        this.trajectory = new Line(pCenter, endTrajectory);
    }

    /**
     * updates the velocity according to whether the ball will collide or not.
     */
    public void moveOneStep() {
        if (this.trajectory == null) {
           setTrajectory();
        }
        CollisionInfo collideInfo = this.gameEnvironment.getClosestCollision(this.trajectory);
        if (collideInfo != null) { //if there's collision
           this.setVelocity(collideInfo.collisionObject().hit(this, collideInfo.collisionPoint(), this.getVelocity()));
        }
        this.point = this.getVelocity().applyToPoint(this.point); //apply new velocity
        this.setTrajectory();
    }

    /**
     * add the ball to the sprite list of the game.
     * @param g game control
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * this method remove the ball from the sprites list of the game.
     * @param game game control to remove the ball from
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }



}