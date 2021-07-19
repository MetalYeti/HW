package JAVA2.HW1;

public class Treadmill implements Obstacle {
    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean doAction(Actions a) {
        return a.run(this);
    }
}
