//Yeela Granot  209133107   group 111-14
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * this class control the resuming or exiting after the game end screen and the pause screen.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed = true;

    /**
     * class constructor.
     * @param sensor1 the game keyboard sensor.
     * @param key1 the enter key to resume with
     * @param animation1 the animation of the game end screen or the pause screen
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor1, String key1, Animation animation1) {
        this.sensor = sensor1;
        this.key = key1;
        this.animation = animation1;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.sensor.isPressed(this.key)) {
            if (!this.isAlreadyPressed) {
                this.stop = true;
            } else {
                this.isAlreadyPressed = false;
            }
        }
        this.animation.doOneFrame(d);
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
