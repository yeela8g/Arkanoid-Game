//Yeela Granot  209133107   group 111-14

/**
 * this class represent a listener to balls which the user couldn't catch with the puddle and removed them.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * constructor of the class.
     * @param game the game control object
     * @param ballsNum current balls number in the game
     */
    public BallRemover(GameLevel game, Counter ballsNum) {
        this.game = game;
        this.remainingBalls = ballsNum;
    }

    /**
     * this method is getter of the remaining balls number member.
     * @return the counter member value.
     */
    public Counter getRemainingBalls() {
        return this.remainingBalls;
    }

    /** when a ball hit the dead region under the puddle and there are still balls in the game, remove ball from the.
     * sprite list and update the balls counter.
     * @param beingHit the region dead block
     * @param hitter the ball to remove from game
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        if (this.remainingBalls.getValue() > 0) {
            hitter.removeFromGame(this.game);
            this.remainingBalls.decrease(1);
        }
    }
}
