//Yeela Granot  209133107   group 111-14

import java.util.List;
/**
 * this interface represent a level setting in a game.
 */
public interface LevelInformation {
    /**
     * number of initialized balls in a level.
     * @return number of initialized balls in a level.
     */
    int numberOfBalls();

    /**
     * @return The initial velocity of each ball.
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return this level puddle speed.
     */
    int paddleSpeed();

    /**
     * @return this level puddle width.
     */
    int paddleWidth();

    /**
     * @return the level name will be displayed at the top of the screen.
     */
    String levelName();

    /**
     * @return a sprite with the background of the level.
     */
    Sprite getBackground();

    /**
     * @return The Blocks that make up this level.
     */
    List<Block> blocks();
    /**
     * @return Number of blocks that should be removed
     */
    int numberOfBlocksToRemove();
}