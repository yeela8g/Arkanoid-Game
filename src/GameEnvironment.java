//Yeela Granot  209133107   group 111-14

import java.util.ArrayList;
import java.util.List;

/**
 * this class create the list of collidable and responsible for making changes of removing or adding to it.
 */
public class GameEnvironment {
    private List<Collidable> collidableList;

    /**
     * constructor of ths gameEnvironment class.
     */
    public GameEnvironment() {
        this.collidableList = new ArrayList<Collidable>();
    }

    /**
     * @return this field of collidable list
     */
    public List<Collidable> getCollidableList() {
        return this.collidableList;
    }

    /**
     * add the given collidable to the environment.
     * @param c given collidable to add for the list of collidables.
     */
    public void addCollidable(Collidable c) {
        this.collidableList.add(c);
    }

    /**
     * remove from collidable list.
     * @param c the collidable to remove
     */
    public void removeCollidable(Collidable c) {
        if (this.collidableList.contains(c)) {
            this.collidableList.remove(c);
        }
    }

    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.

    /**
     * this method choose the closest intersection point to the ball and return it.
     * @param trajectory the trajectory of the ball moving from its start to its end
     * @return the information about the closest collision that is might going to occur.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<Collidable> copyCollidableList = new ArrayList<>(this.collidableList);
        if (copyCollidableList.size() == 0) { //no collision points
            return null;
        }
        Collidable closest = null;
        Point lineStart = trajectory.start();
        for (int i = 0; i < copyCollidableList.size(); i++) {
                if (trajectory.closestIntersectionToStartOfLine(copyCollidableList.get(i).getCollisionRectangle())
                        != null) { // collidable J also collides - compare distances
                    if (closest == null) { //the first collision point calculated
                        closest = copyCollidableList.get(i);
                    } else { //closest has collidable with collision point
                        Rectangle rect1 = copyCollidableList.get(i).getCollisionRectangle();
                        double iDistance =
                                lineStart.distance(trajectory.closestIntersectionToStartOfLine(rect1));
                        Rectangle rect2 = closest.getCollisionRectangle();
                        double closestDistance =
                                lineStart.distance(trajectory.closestIntersectionToStartOfLine(rect2));
                        if (iDistance < closestDistance) { //one point distance is closer to line start  - choose it
                            closest = copyCollidableList.get(i);
                        }
                    }
                }
        }
        if (closest == null) { //there are no intersection
            return null;
        }
        Point closestPoint = trajectory.closestIntersectionToStartOfLine(closest.getCollisionRectangle());
        CollisionInfo collInfo = new CollisionInfo(closestPoint, closest);
        return collInfo;
    }
}

