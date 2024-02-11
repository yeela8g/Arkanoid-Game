//Yeela Granot  209133107   group 111-14

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

/**
 * this class responsible of running all graphic animations of the game.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private biuoop.KeyboardSensor keyboard;

    /**
     * the class constructor.
     */
    public AnimationRunner() {
        this.gui = new GUI("ass6", WIDTH, HEIGHT);
        this.framesPerSecond = 60;
        this.keyboard = this.gui.getKeyboardSensor();
    }

    /**
     * getter for the gui field.
     * @return the game gui.
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * getter for the keyboard field.
     * @return the keyboard sensor of the game.
     */
    public KeyboardSensor getKeyboard() {
        return keyboard;
    }

    /**
     * this method run the animation until stop condition is valid.
     * @param animation current animation for introduction.
     */

    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis();
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d); //game logic
            this.gui.show(d);

            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                Sleeper sleeper = new Sleeper();
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
        return;
    }
}
