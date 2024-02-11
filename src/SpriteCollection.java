//Ye'ela Granot  209133107   group 111-14


import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * this class holds a list of all sprites in the game.
 */
public class SpriteCollection {
    private List<Sprite> spriteList; //make a list of sprites

    /**
     * constructor of the spriteCollection class.
     */
    public SpriteCollection() {
        this.spriteList = new ArrayList<>();
    }

    /**
     * getter method.
     * @return sprite list of the game.
     */
    public List<Sprite> getSpriteList() {
        return this.spriteList;
    }
    /**
     * add new sprite object to the sprites list of the game.
     * @param s the sprite to add
     */
    public void addSprite(Sprite s) { //add new sprite to list
        this.spriteList.add(s);
    }
    /**
     * remove new sprite object to the sprites list of the game.
     * @param s the sprite to remove
     */
    public void removeSprite(Sprite s) { //remove exist sprite from list
        if (this.spriteList.contains(s)) {
            this.spriteList.remove(s);
        }
    }

    /**
     * call timePassed() method on all sprites.
     */
    public void notifyAllTimePassed() { //move sprites -ball/block/paddle
        List<Sprite> copySpriteList = new ArrayList<>(this.spriteList);
        for (int i = 0; i < copySpriteList.size(); i++) {
            copySpriteList.get(i).timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     * @param d the surface object
     */
    public void drawAllOn(DrawSurface d) { //draw all sprites
        List<Sprite> copySpriteList = new ArrayList<>(this.spriteList);
        for (int i = 0; i < copySpriteList.size(); i++) {
            copySpriteList.get(i).drawOn(d);
        }
    }
}
