package JAVA2.HW1;

public class Wall implements Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean doAction(Actions a) {
        return a.jump(this);
    }
}
