//Yeela Granot  209133107   group 111-14

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Block is a rectangle used in the arcade game for changing the ball velocity and blocking it.
 * implements the collidable and sprites interfaces.
 * owns color and location.
 */
public class Block implements Collidable, Sprite, HitNotifier {

    private Rectangle rectangle;
    private final java.awt.Color color;
    private List<HitListener> hitListeners = new ArrayList<>(); //list of all listeners who subscribes after hit

    /**
     * construct game.
     *
     * @param rect   the shape of the block
     * @param color1 block color
     */
    public Block(Rectangle rect, java.awt.Color color1) {
        this.rectangle = rect;
        this.color = color1;
    }

    /**
     * @return this block rectangle shape,
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.notifyHit(hitter);
        boolean switchDx = false;
        boolean switchDy = false;

        if (this.rectangle.calculateUpperEdge().isLineContainsPoint(collisionPoint) || //hit the horizontal edges
                this.rectangle.calculateBottomEdge().isLineContainsPoint(collisionPoint)) {
            switchDy = true;
        }
        if (this.rectangle.calculateLeftEdge().isLineContainsPoint(collisionPoint) || //hit the vertical edges
                this.rectangle.calculateRightEdge().isLineContainsPoint(collisionPoint)) {
            switchDx = true;
        }
        if (switchDx && switchDy) { //hit the horizontal and the vertical edges
            currentVelocity.setDxDirection();
            currentVelocity.setDyDirection();
        } else if (switchDx) { //hit only the horizontal edges.
            currentVelocity.setDxDirection();
        } else if (switchDy) { //hit only the vertical edges.
            currentVelocity.setDyDirection();
        }
        return currentVelocity;
    }

    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) Math.round(this.rectangle.getUpperLeft().getX()),
                (int) (Math.round(this.rectangle.getUpperLeft().getY())),
                (int) (Math.round(this.rectangle.getWidth())), (int) (Math.round(this.rectangle.getHeight())));
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) Math.round(this.rectangle.getUpperLeft().getX()),
                (int) (Math.round(this.rectangle.getUpperLeft().getY())),
                (int) (Math.round(this.rectangle.getWidth())), (int) (Math.round(this.rectangle.getHeight())));

    }

    /**
     * this method is a part of the collidable interface and advances the internal state of the collidable object.
     */
    @Override
    public void timePassed() {
        return;
    }

    /**
     * add the block to the sprite list of the game.
     *
     * @param g game control
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * this method send tis block for removal from the game.
     * @param game the game to remove the block from
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    /**
     * send notification to all listeners in the listeners list about the hit of the ball with this block.
     * @param hitter the ball who hit the block
     */
    private void notifyHit(Ball hitter) {
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
    @Override
    public void addHitListener(HitListener hl) {
        if (this.hitListeners.isEmpty() || !this.hitListeners.contains(hl)) {
            this.hitListeners.add(hl);
        }
    }
    @Override
    public void removeHitListener(HitListener hl) {
        if (this.hitListeners.isEmpty()) {
            return;
        }
        if (this.hitListeners.contains(hl)) {
            this.hitListeners.remove(hl);
        }
    }
}
