//Yeela Granot  209133107   group 111-14
import biuoop.DrawSurface;

/**
 * this class responsible of representing the level name.
 */
public class LevelNamePresent implements Sprite {
    private String name;

    /**
     * class constructor.
     * @param nameLevel the name of the current level.
     */
    public LevelNamePresent(String nameLevel) {
        this.name = nameLevel;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(470, 15, "Level Name: " + this.name,  16);
    }

    @Override
    public void timePassed() {
        return;
    }


}
