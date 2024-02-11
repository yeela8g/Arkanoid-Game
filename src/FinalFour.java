//Yeela Granot  209133107   group 111-14

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * this class represent level 4.
 */
public class FinalFour implements LevelInformation {
    private FinalFourBackGround backGround;
    public static final int BLOCK_LINES = 7;
    public static final int MAX_BLOCKS_IN_ROW = 15;
    public static final int BLOCK_START_LINE = 100;
    public static final int NEW_BLOCK_WIDTH = 51;

    /**
     * constructor of the class.
     * @param bg the animation ba ck ground of level 4.
     */
    public FinalFour(FinalFourBackGround bg) {
        this.backGround = bg;
    }

    @Override
    public int numberOfBalls() {
        return 3;
    }

    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        velocityList.add(Velocity.fromAngleAndSpeed(290, 5));
        velocityList.add(Velocity.fromAngleAndSpeed(-90, 5));
        velocityList.add(Velocity.fromAngleAndSpeed(70, 5));
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
        return new String("Final Four");
    }

    // Returns a sprite with the background of the level
    @Override
    public Sprite getBackground() {
        return this.backGround;
    }


    // The Blocks that make up this level, each block contains
    // its size, color and location.
    @Override
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
            List<Color> colorList = new ArrayList<Color>();
            colorList.add(new Color(87, 81, 90, 255));
            colorList.add(new Color(165, 24, 39, 255));
            colorList.add(new Color(236, 233, 17, 255));
            colorList.add(new Color(15, 175, 18, 255));
            colorList.add(new Color(223, 214, 227, 255));
            colorList.add(new Color(206, 151, 193, 255));
            colorList.add(new Color(50, 213, 213, 255));
            for (int i = 0; i < BLOCK_LINES; i++) { //create blocks and add them to both lists
            this.createBlocks(MAX_BLOCKS_IN_ROW, colorList.get(i),
                    AnimationRunner.WIDTH - GameLevel.MARGIN - NEW_BLOCK_WIDTH,
                    BLOCK_START_LINE + GameLevel.BLOCK_HEIGHT * i, blockList);
        }
        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }

    /**
     * this method responsible of creating the level blocks.
     * @param numOfBlocksInRow number of block in a row.
     * @param color the row blocks color
     * @param biggestX x start value - of the rightest block in a row
     * @param columnY y axis value of the row.
     * @param blockList list of all blocks of the level.
     */
    private void createBlocks(int numOfBlocksInRow, Color color, int biggestX, int columnY, List<Block> blockList) {
        for (int i = 0; i < numOfBlocksInRow; i++) {
            Block block = new Block(new Rectangle(new Point((double) (biggestX - i * NEW_BLOCK_WIDTH),
                    (double) columnY), NEW_BLOCK_WIDTH, GameLevel.BLOCK_HEIGHT), color);
            blockList.add(block);
        }
    }

}
