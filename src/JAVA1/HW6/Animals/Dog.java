package JAVA1.HW6.Animals;

public class Dog extends Animal {
    private final int RUN_LIMIT = 500;
    private final int SWIM_LIMIT = 10;
    private static int dogCounter;

    public Dog(String name) {
        super(name);
        dogCounter++;
    }

    @Override
    public void run(int distance) {
        if (distance > RUN_LIMIT){
            System.out.println("Собака так далеко бегать не умеет!");
            return;
        }
        super.run(distance);
    }

    @Override
    public void swim(int distance) {
        if (distance > SWIM_LIMIT){
            System.out.println("Собака так далеко плавать не умеет!");
            return;
        }
        super.swim(distance);
    }

    public static int getCounter() {
        return dogCounter;
    }
}
