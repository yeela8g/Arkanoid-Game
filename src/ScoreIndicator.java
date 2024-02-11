//Yeela Granot  209133107   group 111-14

import biuoop.DrawSurface;

/**
 * in charge of displaying the current score.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;

    /**
     * constructor of the class.
     * @param scoreCounter initialized counter from the game class
     */
    public ScoreIndicator(Counter scoreCounter) {
        this.score = scoreCounter;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(270, 15, "Score: " + this.score.getValue(),  16);
    }

   @Override
    public void timePassed() {
        return;
    }
}
