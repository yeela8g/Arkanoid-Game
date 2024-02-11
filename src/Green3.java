//Yeela Granot  209133107   group 111-14

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * this class represent the animation of level 3.
 */
public class Green3 implements LevelInformation {
    private Green3BackGround backGround;
    public static final int BLOCK_LINES = 5;
    public static final int MAX_BLOCKS_IN_ROW = 10;
    public static final int BLOCK_START_LINE = 100;

    /**
     * constructor class.
     * @param bg back ground of level 3.
     */
    public Green3(Green3BackGround bg) {
        this.backGround = bg;
    }

    @Override
    public int numberOfBalls() {
        return 2;
    }
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        velocityList.add(Velocity.fromAngleAndSpeed(290, 3));
        velocityList.add(Velocity.fromAngleAndSpeed(70, 3));
        return velocityList;
    }
    @Override
    public int paddleSpeed() {
        return 7;
    }
    @Override
    public int paddleWidth() {
        return AnimationRunner.WIDTH / 8;
    }
    @Override
    public String levelName() {
        return new String("Green 3");
    }
    @Override
    public Sprite getBackground() {
        return this.backGround;
    }
    @Override
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        for (int i = 0; i < 5; i++) { //create blocks and add them to both lists
            List<Color> colorList = new ArrayList<Color>();
            colorList.add(new Color(87, 81, 90, 255));
            colorList.add(new Color(165, 24, 39, 255));
            colorList.add(new Color(236, 233, 17, 255));
            colorList.add(new Color(4, 78, 184, 255));
            colorList.add(new Color(223, 214, 227, 255));
            this.createBlocks((MAX_BLOCKS_IN_ROW - i), colorList.get(i),
                    AnimationRunner.WIDTH - GameLevel.MARGIN - GameLevel.BLOCK_WIDTH,
                    BLOCK_START_LINE + GameLevel.PADDLE_HEIGHT * i, blockList);
        }
        return blockList;
    }
    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }

    /**
     * this method responsible of creating this level blocks.
     * @param numOfBlocks number of blocks.
     * @param color color of blocks.
     * @param biggestX biggest x axis value in a row.
     * @param columnY y axis value of the row.
     * @param blockList list of all blocks.
     */
    private void createBlocks(int numOfBlocks, Color color, int biggestX, int columnY, List<Block> blockList) {
        for (int i = 0; i < numOfBlocks; i++) {
            Block block = new Block(new Rectangle(new Point((double) biggestX - GameLevel.BLOCK_WIDTH * i,
                    (double) columnY), GameLevel.BLOCK_WIDTH, GameLevel.BLOCK_HEIGHT), color);
            blockList.add(block);
        }
    }
}
