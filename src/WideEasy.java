//Yeela Granot  209133107   group 111-14
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * this class represent the graphic animation of level number 2.
 */
public class WideEasy implements LevelInformation {
    private WideEasyBackGround backGround;

    /**
     * class constructor.
     * @param bg this level back ground.
     */
    public WideEasy(WideEasyBackGround bg) {
        this.backGround = bg;
    }
    @Override
    public int numberOfBalls() {
        return 10;
    }
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        for (int i = -150; i < -100; i += 10) { //leftest 5 balls 330 280 -10
            velocityList.add(Velocity.fromAngleAndSpeed(i, 5));
        }
        // Set right Balls Velocities
        for (int i = 30; i < 80; i += 10) { //rightest 5 balls
            velocityList.add(Velocity.fromAngleAndSpeed(i, 5));
        }
        return velocityList;
    }
    @Override
    public int paddleSpeed() {
        return 2;
    }
    @Override
    public int paddleWidth() {
        return AnimationRunner.WIDTH - 100;
    }
    @Override
    public String levelName() {
        return new String("Wide Easy");
    }
    @Override
    public Sprite getBackground() {
        return this.backGround;
    }
    @Override
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        List<Color> colorMatch = new ArrayList<>();
        colorMatch.add(Color.red);
        colorMatch.add(Color.red);
        colorMatch.add(Color.orange);
        colorMatch.add(Color.orange);
        colorMatch.add(Color.yellow);
        colorMatch.add(Color.yellow);
        colorMatch.add(Color.green);
        colorMatch.add(Color.green);
        colorMatch.add(Color.green);
        colorMatch.add(Color.blue);
        colorMatch.add(Color.blue);
        colorMatch.add(Color.pink);
        colorMatch.add(Color.pink);
        colorMatch.add(Color.cyan);
        colorMatch.add(Color.cyan);
        for (int i = 0; i < 15; i++) {
            blockList.add(new Block(new Rectangle(new Point(GameLevel.MARGIN + AnimationRunner.WIDTH / 15 * i,
                    250), AnimationRunner.WIDTH / 15, GameLevel.PADDLE_HEIGHT), colorMatch.get(i)));
        }
    return blockList;
    }
    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
