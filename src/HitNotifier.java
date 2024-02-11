//Yeela Granot  209133107   group 111-14

/**
 * this interface represent all classes of hit notifiers who gives the listeners notification about hits.
 */
public interface HitNotifier {
    /**
     *  Add hit listener as a listener to hit events.
     * @param hl hit listener to add.
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hit listener from the list of listeners to hit events.
     * @param hl hit listener to remove.
     */
    void removeHitListener(HitListener hl);
}
