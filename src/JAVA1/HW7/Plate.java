package JAVA1.HW7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (n <= food) {
            food -= n;
            return true;
        }
        return false;
    }

    public void increaseFood(int n) {
        food += n;
    }

    @Override
    public String toString() {
        return String.format("В тарелке %d еды", food);
    }
}
