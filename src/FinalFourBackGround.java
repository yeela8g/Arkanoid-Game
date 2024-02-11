//Yeela Granot  209133107   group 111-14

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * this class represent the graphic back ground of level 4.
 */
public class FinalFourBackGround implements Sprite {

        /**
         * Draw the sprite to the screen.
         * @param d - the surface
         */
        @Override
        public void drawOn(DrawSurface d) {
            d.setColor(new Color(146, 219, 255));
            d.fillRectangle(0, 0, d.getWidth(), d.getHeight());

            // rainbow
            d.setColor(Color.RED);
            d.fillCircle(400, 300, 200);
            d.setColor(Color.ORANGE);
            d.fillCircle(400, 300, 185);
            d.setColor(Color.YELLOW);
            d.fillCircle(400, 300, 160);
            d.setColor(Color.GREEN);
            d.fillCircle(400, 300, 145);
            d.setColor(Color.CYAN);
            d.fillCircle(400, 300, 130);
            d.setColor(Color.BLUE);
            d.fillCircle(400, 300, 105);
            d.setColor(new Color(107, 0, 255));
            d.fillCircle(400, 300, 90);
            d.setColor(new Color(146, 219, 255));
            d.fillCircle(400, 300, 75);
            d.fillRectangle(200, 300, 400, 200);

            //the clouds under the rainbow
            d.setColor(new Color(238, 238, 238));
            d.fillCircle(600, 300, 30);
            d.setColor(new Color(233, 233, 233));
            d.fillCircle(550, 300, 40);
            d.fillCircle(500, 300, 25);

            d.setColor(new Color(233, 233, 233));
            d.fillCircle(300, 300, 45);
            d.setColor(new Color(238, 238, 238));
            d.fillCircle(200, 300, 30);
            d.fillCircle(250, 300, 35);

            //left cloud rain
            d.setColor(Color.WHITE);
            for (int i = 0; i < 10; i++) {
                d.drawLine(150 + 10 * i, 410, 110 + 10 * i, 600);
            }
            //left cloud
            d.setColor(Color.LIGHT_GRAY);
            d.fillCircle(170, 425, 30);
            d.fillCircle(155, 395, 25);
            d.setColor(Color.GRAY.brighter());
            d.fillCircle(195, 390, 25);
            d.setColor(Color.GRAY);
            d.fillCircle(225, 395, 30);
            d.fillCircle(210, 420, 20);

            //right cloud rain
            d.setColor(Color.WHITE);
            for (int i = 0; i < 10; i++) {
                d.drawLine(600 + 10 * i, 470, 560 + 10 * i, 600);
            }
            //right cloud
            d.setColor(Color.LIGHT_GRAY);
            d.fillCircle(680, 470, 30);
            d.fillCircle(665, 505, 20);
            d.setColor(Color.GRAY.brighter());
            d.fillCircle(650, 475, 25);
            d.setColor(Color.GRAY);
            d.fillCircle(610, 480, 25);
            d.fillCircle(625, 510, 30);
        }

        /**
         * Notify the sprite that time has passed.
         */
        @Override
        public void timePassed() {
        }
    }
