//Yeela Granot  209133107   group 111-14


import biuoop.DrawSurface;

import java.awt.Color;

/**
 * this class represent the player by the puddle who collides with the ball and changes its direction.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.GUI gui;
    private Rectangle rect;
    private biuoop.KeyboardSensor keyboard;
    private final java.awt.Color color = Color.RED;
    private int speed;

    /**
     * constructor of the puddle class.
     * @param gui1 the graphic screen
     * @param rect1 the rectangle shape of the paddle
     * @param speed1 the puddle speed in the level.
     */
    public Paddle(biuoop.GUI gui1, Rectangle rect1, int speed1) {
        this.gui = gui1;
        this.rect = rect1;
        this.keyboard = gui.getKeyboardSensor();
        this.speed = speed1;
   }
    /**
     * this method lets the user control the paddle movement to the left direction.
     */
    public void moveLeft() {
        if (this.keyboard.isPressed(this.keyboard.LEFT_KEY) && this.rect.getUpperLeft().getX() > GameLevel.MARGIN) {
            this.rect = new Rectangle(new Point(this.rect.getUpperLeft().getX()
                    - this.speed, this.rect.getUpperLeft().getY()),
                    this.rect.getWidth(), this.rect.getHeight());
        } //if the user pressed left and there is option to move left --> go left
    }
    /**
     * this method lets the user control the paddle movement to the right direction.
     */
    public void moveRight() {
        if (this.keyboard.isPressed(this.keyboard.RIGHT_KEY)
                && (this.rect.getUpperLeft().getX() + this.rect.getWidth()
              <  this.gui.getDrawSurface().getWidth() - GameLevel.MARGIN)) {
            this.rect = new Rectangle(new Point(this.rect.getUpperLeft().getX()
                    + this.speed, this.rect.getUpperLeft().getY()),
                    this.rect.getWidth(), this.rect.getHeight());
        } //if the user pressed right and there is option to move right --> go right
    }
    /**
     * this method is a part of the collidable interface and advances the internal state of the collidable object.
     * in this class the implementing the paddle movement by the user
     */
    public void timePassed() {
        this.moveLeft();
        this.moveRight();
    }

    /**
     * this method responsible for the location and color graphic introducing of the paddle.
     * @param d the surface object
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) Math.round(this.rect.getUpperLeft().getX()),
                (int) (Math.round(this.rect.getUpperLeft().getY())),
                (int) (Math.round(this.rect.getWidth())), (int) (Math.round(this.rect.getHeight())));
        d.setColor(Color.BLACK);
        d.drawRectangle((int) Math.round(this.rect.getUpperLeft().getX()),
                (int) (Math.round(this.rect.getUpperLeft().getY())),
                (int) (Math.round(this.rect.getWidth())), (int) (Math.round(this.rect.getHeight())));
    }

    /**
     * @return this rectangle shape.
     */
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    /**
     * this method gets and intersection point with the ball and the current velocity of the ball and calculate new one.
     * @param collisionPoint the point of future collision with the ball
     * @param currentVelocity current velocity of the ball
     * @param hitter the ball who hit the paddle.
     * @return new velocity considering the location of the intersection point on the puddle.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double width = this.rect.getWidth();
        Point ul = this.rect.getUpperLeft();
        Line[] line = new Line[5];
        line[0] = new Line(ul, new Point(ul.getX() + width / 5, ul.getY())); //five segment region of the paddle
        line[1] = new Line(new Point(ul.getX() + width / 5, ul.getY()),
                new Point(ul.getX() + width / 5 * 2, ul.getY()));
        line[2] = new Line(new Point(ul.getX() + width / 5 * 2, ul.getY()),
                new Point(ul.getX() + width / 5 * 3, ul.getY()));
        line[3] = new Line(new Point(ul.getX() + width / 5 * 3, ul.getY()),
                new Point(ul.getX() + width / 5 * 4, ul.getY()));
        line[4] = new Line(new Point(ul.getX() + width / 5 * 4, ul.getY()),
                new Point(ul.getX() + width, ul.getY()));
        for (int i = 0; i < line.length; i++) {
            if (line[i].isLineContainsPoint(collisionPoint)) { //if ball intersect with any of the upper paddle regions.
                if (i == 0) { //if it hits the first region
                    currentVelocity = this.velocityRegion1(collisionPoint, currentVelocity);
                } else if (i == 1) { //if it hits the second region
                    currentVelocity = this.velocityRegion2(collisionPoint, currentVelocity);
                } else if (i == 2) { //if it hits the third region
                    currentVelocity = this.velocityRegion3(collisionPoint, currentVelocity);
                } else if (i == 3) { //if it hits the 4th region
                    currentVelocity = this.velocityRegion4(collisionPoint, currentVelocity);
                } else { //it hits the first region 5th
                    currentVelocity = this.velocityRegion5(collisionPoint, currentVelocity);
                }
            } else if (this.rect.calculateLeftEdge().isLineContainsPoint(collisionPoint) || //hit the vertical edges
                    this.rect.calculateRightEdge().isLineContainsPoint(collisionPoint)) {
                    currentVelocity.setDxDirection();
            } else if (this.rect.calculateBottomEdge().isLineContainsPoint(collisionPoint)) {  //hit the bottom edge
                currentVelocity.setDyDirection();
            }
        }
        return currentVelocity;
    }

    /**
     * Add this paddle to the game.
     * @param g the game controller
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * @param intersect intersection point
     * @param current current velocity of the ball needed to be changed.
     * @return new velocity of a ball hitting the upper edge of the paddle, in the first region part
     * (change in -60 degrees)
     */
    private Velocity velocityRegion1(Point intersect, Velocity current) {
        return Velocity.fromAngleAndSpeed(-150, current.getSpeed());
    }
    /**
     * @param intersect intersection point
     * @param current current velocity of the ball needed to be changed.
     * @return new velocity of a ball hitting the upper edge of the paddle, in the second region part
     * (change in -30 degrees)
     */
    private Velocity velocityRegion2(Point intersect, Velocity current) {
        return Velocity.fromAngleAndSpeed(-120, current.getSpeed());
    }
    /**
     * @param intersect intersection point
     * @param current current velocity of the ball needed to be changed.
     * @return new velocity of a ball hitting the upper edge of the paddle, in the 3th region part
     * (change the vertical direction)
     */
    private Velocity velocityRegion3(Point intersect, Velocity current) {
        current.setDyDirection();
        return current;
    }
    /**
     * @param intersect intersection point
     * @param current current velocity of the ball needed to be changed.
     * @return new velocity of a ball hitting the upper edge of the paddle, in the 4th region part
     * (change in 30 degrees)
     */
    private Velocity velocityRegion4(Point intersect, Velocity current) {
        return Velocity.fromAngleAndSpeed(-60, current.getSpeed());
    }
    /**
     * @param intersect intersection point
     * @param current current velocity of the ball needed to be changed.
     * @return new velocity of a ball hitting the upper edge of the paddle, in the 5th region part
     * (change in 60 degrees)
     */
    private Velocity velocityRegion5(Point intersect, Velocity current) {
        return Velocity.fromAngleAndSpeed(-30, current.getSpeed());
    }
}