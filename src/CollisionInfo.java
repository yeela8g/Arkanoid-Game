//Yeela Granot  209133107   group 111-14

/**
 * holds the information about collision of the ball with some collidable: the point of collide + the collidable itself.
 */
public class CollisionInfo {
   private Point collidePoint;
    private Collidable collidableX;

    /**
     * constructor of the collisionInfo class.
     * @param collP collision point
     * @param x the collidable itself
     */
    public CollisionInfo(Point collP, Collidable x) {
        this.collidePoint = collP;
        this.collidableX = x;
    }

    /**
     * @return the point at which the collision occurs.
      */
    public Point collisionPoint() {
        return this.collidePoint;
    }

    /**
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collidableX;
    }

}
