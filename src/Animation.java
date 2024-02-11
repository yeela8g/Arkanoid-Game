//Yeela Granot  209133107   group 111-14
import biuoop.DrawSurface;

/**
 * this interface represent an animation class.
 * it can be run by the anumation runner and introduces in the screen
 */
public interface Animation {
    /**
     * this method manage the graphic logic in the animation.
     * @param d draw surface of the gui to represent all sprites.
     */
    void doOneFrame(DrawSurface d);

    /**
     * checking for stop conditions to stop the animation running on the screen.
     * @return whether to stop or not.
     */
    boolean shouldStop();
}