//Yeela Granot  209133107   group 111-14

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * this class responsible of controlling the game by initialization the objects , and animate them.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites; //list of all sprites in game
    private GameEnvironment environment; //list of all collides object in the game
    public static final int MARGIN = 15;
    public static final int PADDLE_HEIGHT = 30;
    public static final int PADDLE_WIDTH = 90;
    public static final int RADIUS = 7;
    public static final int BLOCK_WIDTH = 60; //todo remove from this class id we change to size of the blocks
    public static final int BLOCK_HEIGHT = 30; //todo also as up
    private Counter score;
    private AnimationRunner runner;
    private KeyboardSensor keyboard;
    private boolean running;
    private LevelInformation currentLevel;
    private Counter ballsCounter;
    private Counter blocksCounter;
    private boolean winning;


    /**
     * constructor ot the game class.
     * @param level the current level.
     * @param runner the animation runner.
     * @param kBord the game keyboard sensor.
     * @param score1 score listener.
     */
    public GameLevel(LevelInformation level, AnimationRunner runner, KeyboardSensor kBord, Counter score1) {
        this.sprites = new SpriteCollection(); //create  both lists
        this.environment = new GameEnvironment();
        this.runner = runner;
        this.keyboard = kBord;
        this.currentLevel = level;
        this.ballsCounter = new Counter(this.currentLevel.numberOfBalls());
        this.blocksCounter = new Counter(this.currentLevel.blocks().size());
        this.score = score1;
    }

    /**
     * getter method of the runner field.
     * @return this animation runner.
     */
    public AnimationRunner getRunner() {
        return this.runner;
    }

    /**
     * add objects to collidable list.
     * @param c new collidable to add
     */
    public void addCollidable(Collidable c) { //add collide to list
        this.environment.addCollidable(c);
    }

    /**
     * add object to the sprites list.
     *
     * @param s new sprite to add
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * this method responsible of removing an collidable object from the game collidables list.
     *
     * @param c the coolidable to remove from the collidables list.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * this method responsible of removing a sprite object from the game sprites list.
     *
     * @param s the sprite to remove from the sprites list.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks and Ball and Paddle and add them to the game.
     */

    public void initialize() {
        Sprite backGround = this.currentLevel.getBackground();
        this.addSprite(backGround);
        Ball[] ballsArr = new Ball[this.currentLevel.numberOfBalls()];
        for (int i = 0; i < ballsArr.length; i++) {
            ballsArr[i] = new Ball(new Point(AnimationRunner.WIDTH / 2,
                    AnimationRunner.HEIGHT - PADDLE_HEIGHT - MARGIN - RADIUS),
                    RADIUS, Color.WHITE, this.currentLevel.initialBallVelocities().get(i),
                    this.environment);
            ballsArr[i].setTrajectory(); //set the trajectory
            ballsArr[i].addToGame(this); //add the ball to the sprite list (ball own also the collidable list)
        }
        Paddle paddle = new Paddle(this.runner.getGui(),
                new Rectangle(new Point(AnimationRunner.WIDTH / 2 - this.currentLevel.paddleWidth() / 2,
                        AnimationRunner.HEIGHT - PADDLE_HEIGHT - MARGIN),
                        this.currentLevel.paddleWidth(), PADDLE_HEIGHT), this.currentLevel.paddleSpeed());
        paddle.addToGame(this);
        Block[] blockArr = new Block[3]; //create borders-blocks and add them to both lists
        blockArr[0] = new Block(new Rectangle(new Point(0, 0),
                AnimationRunner.WIDTH - MARGIN, MARGIN), Color.GRAY); //up
        blockArr[1] = new Block(new Rectangle(new Point(0, MARGIN),
                MARGIN, AnimationRunner.HEIGHT - MARGIN), Color.GRAY); //l
        blockArr[2] = new Block(new Rectangle(new Point(AnimationRunner.WIDTH - MARGIN, 0),
                MARGIN, AnimationRunner.HEIGHT - MARGIN), Color.GRAY); //right
        for (int i = 0; i < blockArr.length; i++) {
            blockArr[i].addToGame(this);
        }
        Block deathRegion = new Block(new Rectangle(new Point(MARGIN, AnimationRunner.HEIGHT - MARGIN),
                AnimationRunner.WIDTH - MARGIN, MARGIN),
                Color.yellow); //down
        this.addCollidable(deathRegion); //add the death region as collidable
        BallRemover ballRemoverListener = new BallRemover(this, ballsCounter); //create ball remover listener
        deathRegion.addHitListener(ballRemoverListener); //add ball remover as listener to death region block
        BlockRemover blockRemoverListener = new BlockRemover(this, blocksCounter);
        ScoreTrackingListener scoreListener = new ScoreTrackingListener(this.score);
        Sprite presentScore = (Sprite) new ScoreIndicator(this.score);
        this.addSprite(presentScore);
        Sprite presentLevelName = new LevelNamePresent(this.currentLevel.levelName());
        this.addSprite(presentLevelName);
        createBlocks(blockRemoverListener, scoreListener);
    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        this.running = true;
        this.runner.run(this);
    }

    /**
     * this class create the level blocks.
     * @param removerListener listener of hit blocks to remove them.
     * @param scoreListener listener of the hit blocks to update score after hit happened.
     */
    private void createBlocks(BlockRemover removerListener, ScoreTrackingListener scoreListener) {
        for (int i = 0; i < this.currentLevel.blocks().size(); i++) {
            Block index = this.currentLevel.blocks().get(i);
            index.addToGame(this);
            index.addHitListener(removerListener);
            index.addHitListener(scoreListener);
        }
    }
    @Override
    public boolean shouldStop() {
        return !this.running;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d); //draw all sprite
        this.sprites.notifyAllTimePassed(); //move everyone
        if ((this.blocksCounter.getValue() == this.currentLevel.blocks().size() - //no more balls left || full block hit
                this.currentLevel.numberOfBlocksToRemove()) || this.ballsCounter.getValue() == 0) {
            this.running = false;
            if (this.ballsCounter.getValue() == 0) {
                this.winning = false;
            }
            if (this.blocksCounter.getValue() == 0) {
                this.score.increase(100);
                this.winning = true;
            }
        }
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                    new PauseScreen(this.keyboard, this)));
        }
    }

    /**
     * this method return if the game ended with a winning or not.
     * @return if the user won.
     */
    public boolean noteEndingState() {
        return this.winning;
    }
}
