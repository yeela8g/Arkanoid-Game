//Yeela Granot  209133107   group 111-14

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * this class responsible for the graphic background of level 1 - direct hit.
 */
public class BackGroundDirectHit implements Sprite {

    /**
     * Draw the sprite to the screen.
     * @param d - the surface
     */
    @Override
    public void drawOn(DrawSurface d) {

        // big target
        d.setColor(new Color(176, 93, 175, 255));
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(new Color(55, 64, 33));
        d.drawCircle(400, 165, 50);
        d.drawCircle(400, 165, 85);
        d.drawCircle(400, 165, 125);
        d.drawLine(400, 0, 400, 140);
        d.drawLine(420, 165, 575, 165);
        d.drawLine(400, 190, 400, 330);
        d.drawLine(230, 165, 375, 165);


        // left small target
        d.drawCircle(150, 400, 15);
        d.drawCircle(150, 400, 45);
        d.drawCircle(150, 400, 75);
        d.drawLine(150, 500, 150, 300);
        d.drawLine(55, 400, 245, 400);

        // right small target
        d.drawCircle(650, 400, 15);
        d.drawCircle(650, 400, 45);
        d.drawCircle(650, 400, 75);
        d.drawLine(650, 300, 650, 500);
        d.drawLine(555, 400, 750, 400);
    }

    /**
     * Notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
    }
}
