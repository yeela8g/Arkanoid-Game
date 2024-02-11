//Yeela Granot  209133107   group 111-14

/**
 * this class is in charge of removing blocks from the game.
 * as well as keeping count of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * constructor of the class.
     * @param game the game to remove the block from
     * @param removedBlocks the block to remove.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * getter of the counter field.
     * @return the value of the blocks counter.
     */
    public Counter getRemainingBlocks() {
        return this.remainingBlocks;
    }

    /**
     * remove blocks that are hit from the game.
     * @param beingHit blocks to remove
     * @param hitter the ball who hit the block
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        if (this.remainingBlocks.getValue() > 0) {
            beingHit.removeHitListener(this);
            beingHit.removeFromGame(this.game);
            this.remainingBlocks.decrease(1);
        }
    }
}
