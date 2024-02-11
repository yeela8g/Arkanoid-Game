//Ye'ela Granot  209133107   group 111-14

import biuoop.DrawSurface;

/**
 * interface of sprites objects includes the paddle and the blocks and the ball.
 */
public interface Sprite {
    /**
     *draw the sprite to the screen.
     * @param d the surface object
      */
    void drawOn(DrawSurface d);

    /**
     *  notify the sprite that time has passed.
     */
    void timePassed();
}
