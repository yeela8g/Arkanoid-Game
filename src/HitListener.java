//Yeela Granot  209133107   group 111-14
/**
 * this interface represent all classes of hit listeners who remove balls/blocks from the game.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * @param beingHit the collidable that was hit.
     * @param hitter the Ball that's doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
