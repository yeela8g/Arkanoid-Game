//Yeela Granot  209133107   group 111-14
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * this class represent the graphic animation of the pause screen.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private GameLevel gameContinue;

    /**
     * constructor pf the pause screen class.
     * @param k the key board sensor.
     * @param toContinue the game level of which the pausing occur.
     */
    public PauseScreen(KeyboardSensor k, GameLevel toContinue) {
        this.keyboard = k;
        this.stop = false;
        this.gameContinue = toContinue;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}