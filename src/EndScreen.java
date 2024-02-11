//Yeela Granot  209133107   group 111-14

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * this class represent the end screen animation in the end of the game.
 */
public class EndScreen implements Animation {
    private boolean isWin;
    private int score;
    private AnimationRunner runner;

    /**
     * class constructor.
     * @param win game finish state
     * @param score1 the final score
     * @param runner1 animation running the end screen.
     */
    public EndScreen(boolean win, int score1, AnimationRunner runner1) {
        this.isWin = win;
        this.score = score1;
        this.runner = runner1;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.pink);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        String message = "";
        if (isWin) {
            d.setColor(Color.white);
            message = "Congratulation !! you are a winner. your score is: " + this.score;
        } else {
            d.setColor(Color.white);
            message = "Game over, maybe next time... your score: " + this.score;
        }
        d.drawText(10, d.getHeight() / 2, message, 32);
    }
    @Override
    public boolean shouldStop() {
        return false;
    }
}
