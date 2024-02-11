//Ye'ela Granot  209133107   group 111-14

/**
 * interface of collidable object includes the paddle and the blocks.
 */
public interface Collidable {
    /**
     * @return  the "collision shape" of the object..
     */
    Rectangle getCollisionRectangle();

    /**
     * notify the object that we collided with it at collisionPoint with a given velocity.
     * @param collisionPoint point of collision with collidable
     * @param currentVelocity current velocity of the ball
     * @param hitter the ball who hit the collidable
     * @return new velocity expected after the hit based on the force of the object.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
