package JAVA1.HW6.Animals;

public class Cat extends Animal {
    private final int RUN_LIMIT = 200;
    private static int catCounter;

    public Cat(String name) {
        super(name);
        catCounter++;
    }

    @Override
    public void swim(int distance) {
        System.out.printf("%s не умеет плавать!\n", name);
    }

    @Override
    public void run(int distance) {
        if (distance > RUN_LIMIT){
            System.out.println("Кошка так далеко бегать не умеет!");
            return;
        }
        super.run(distance);
    }

    public static int getCounter() {
        return catCounter;
    }
}
