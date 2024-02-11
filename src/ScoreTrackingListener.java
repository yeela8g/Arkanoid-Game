//Yeela Granot  209133107   group 111-14

/**
 * in charge of track over the game hits of the blocks and update the score count .
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * the constructor of the class.
     * @param scoreCounter initialized score tracking listeners from the game control.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
       this.currentScore.increase(5);
    }
}
