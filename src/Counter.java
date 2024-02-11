//Yeela Granot  209133107   group 111-14
/**
 * this class is a simple counter.
 */
public class Counter {
    private int count;
    /**
     * constructor of the class.
     * @param count1 the initialized number of the counter.
     */
    public Counter(int count1) {
        this.count = count1;
    }

    /**
     * this method increase the counter value.
     * @param number the change of the counter value
     */
    public void increase(int number) {
        this.count += number;
    }

    /**
     * subtract number from current count.
     * @param number the change of the counter value
     */
    public void decrease(int number) {
        this.count -= number;
    }

    /**
     * get current count.
     * @return current count
     */
    public int getValue() {
        return this.count;
    }
}
