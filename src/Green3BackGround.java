//Yeela Granot  209133107   group 111-14

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * this class represent the graphic introduction of the back ground of level 3.
 */
public class Green3BackGround implements Sprite {
        private Point start;
        private int width;
        private int height;
        private int windowColor;
        private boolean isGoingDown;

        /**
         * Instantiates a new Space ship.
         * @param start  the start
         * @param width  the width
         * @param height the height
         */
        public Green3BackGround(Point start, int width, int height) {
            this.start = start;
            this.width = width;
            this.height = height;
            this.isGoingDown = true;
            this.windowColor = 0;
        }
        @Override
        public void drawOn(DrawSurface d) {
            d.setColor(new Color(22, 90, 14, 255));
            d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
            int x = (int) start.getX();
            int y = (int) start.getY();
            d.setColor(Color.white);
            d.fillOval(x + width / 4, y - height / 2, width / 2, height);
            d.setColor(Color.darkGray);
            d.fillOval(x, y, width, height);
            Color[] colors =
                    new Color[] {Color.ORANGE, Color.GREEN, Color.CYAN, Color.PINK, Color.BLUE, Color.YELLOW, Color.RED,
                            Color.BLACK, Color.WHITE};
            for (int i = 0; i < width / 10; i++) {
                d.setColor(colors[(windowColor + i) % colors.length]);
                d.fillCircle(x + 5 + i * 10, y + height / 2, 5);
            }
            for (int i = 0; i < 10; i++) {
                d.setColor(Color.YELLOW);
                d.drawOval(x + 5 * (width / 12) - (5 * i), y + height - 1 + (i * 5), (width / 5) + (i * 10), 5);
            }
            windowColor++;
        }
        @Override
        public void timePassed() {
            double y = start.getY();
            if (this.isGoingDown) {
                this.start = new Point(this.start.getX(), y + 0.5);
            } else {
                this.start = new Point(this.start.getX(), y - 0.5);
            }
        }

        /**
         * Sets going down.
         * @param goingDown the going down
         * @return the going down
         */
        public Green3BackGround setGoingDown(boolean goingDown) {
            isGoingDown = goingDown;
            return this;
        }
        /**
         * Gets start.
         * @return the start
         */
        public Point getStart() {
            return this.start;
        }
    }
