//Yeela Granot  209133107   group 111-14

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * this class responsible of all setting and features of the first level - direct hit.
 */
public class DirectHit implements LevelInformation {
    private BackGroundDirectHit background;

    /**
     * constructor of the class.
     * @param bg the graphic back ground.
     */
    public DirectHit(BackGroundDirectHit bg) {
        this.background = bg;
    }
    @Override
    public int numberOfBalls() {
        return 1;
    }
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        velocityList.add(Velocity.fromAngleAndSpeed(90, 3));
        return velocityList;
    }
    @Override
    public int paddleSpeed() {
        return 8;
    }
    @Override
    public int paddleWidth() {
        return AnimationRunner.WIDTH / 8;
    }

    // the level name will be displayed at the top of the screen.
    @Override
    public String levelName() {
        return new String("Direct Hit");
    }

    // Returns a sprite with the background of the level
    @Override
    public Sprite getBackground() {
        return this.background;
    }

    // The Blocks that make up this level, each block contains
    // its size, color and location.
    @Override
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        blockList.add(new Block(new Rectangle(new Point(AnimationRunner.WIDTH / 2 - 15, AnimationRunner.WIDTH
                / 8 + 50), GameLevel.BLOCK_HEIGHT, GameLevel.BLOCK_HEIGHT), Color.red));
        return blockList;
    }
    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
