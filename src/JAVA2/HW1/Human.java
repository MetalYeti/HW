package JAVA2.HW1;

public class Human implements Actions {
    private String name;
    private int maxRunDistance;
    private int maxJumpHeight;

    public Human(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public boolean run(Treadmill t) {
        int treadLength = t.getLength();
        if (treadLength <= maxRunDistance) {
            System.out.println(name + " пробежал " + treadLength + " метров.");
            return true;
        }
        System.out.println(name + " не смог пробежать " + treadLength + " метров.");
        return false;
    }

    @Override
    public boolean jump(Wall w) {
        int wallHeight = w.getHeight();
        if (wallHeight <= maxJumpHeight) {
            System.out.println(name + " перепрыгнул стену высотой " + wallHeight + " сантиметров.");
            return true;
        }
        System.out.println(name + " не смог перепрыгнуть стену высотой " + wallHeight + " сантиметров.");
        return false;
    }
}
