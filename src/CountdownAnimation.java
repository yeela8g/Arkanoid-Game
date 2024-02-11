//Yeela Granot  209133107   group 111-14

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * The Countdown animation.
 */
public class CountdownAnimation implements Animation {
        private boolean running;
        private long numOfMillis;
        private int initialCount;
        private long initiationTime;
        private double numOfSeconds;
        private int countFrom;
        private SpriteCollection gameScreen;

        /**
         * Instantiates a new Countdown animation.
         * @param numOfSeconds the num of seconds
         * @param countFrom    the count from
         * @param gameScreen   the game screen
         */
        public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
            this.running = true;
            this.numOfMillis = (long) (numOfSeconds * 1000);
            this.countFrom = countFrom;
            this.initialCount = countFrom;
            this.gameScreen = gameScreen;
            this.initiationTime = System.currentTimeMillis();
        }


        /**
         * Do one frame.
         * @param surface the surface
         */
        @Override
        public void doOneFrame(DrawSurface surface) {
            if (this.countFrom == 0) {
                this.running = false;
            }
            this.gameScreen.drawAllOn(surface);
            surface.setColor(Color.RED);
            surface.drawText(385, 450, Integer.toString(this.countFrom), 65);
            if (System.currentTimeMillis() - this.initiationTime
                    > this.numOfMillis / this.initialCount) {
                this.initiationTime = System.currentTimeMillis();
                this.countFrom--;
            }
        }

        /**
         * Should stop boolean.
         * @return the boolean
         */
        @Override
        public boolean shouldStop() {
            return !this.running;
        }
    }
