//Yeela Granot  209133107   group 111-14

import biuoop.KeyboardSensor;
import java.util.List;

/**
 * this class manage the game flow between all levels.
 */
public class GameFlow {
    private AnimationRunner runner;
    private KeyboardSensor keyboard;
    private Counter score = new Counter(0);
    private boolean isWin;

    /**
     * slass constructor.
     * @param ar animation runner.
     * @param ks keyboard sensor.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.keyboard = ks;
        this.runner = ar;
    }

    /**
     * this method run the levels.
     * @param levels game levels to run.
     */
    public void runLevels(List<LevelInformation> levels) {

        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.runner, this.keyboard, this.score);

            level.initialize();
            level.run();
            this.isWin = level.noteEndingState();
            if (!this.isWin) {
                break;
            }
        }
        this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                new EndScreen(isWin, this.score.getValue(), this.runner)));
    }
}
