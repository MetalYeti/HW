package JAVA1.HW6.Animals;

public abstract class Animal {
    protected String name;
    protected static int animalCounter;

    public Animal(String name) {
        this.name = name;
        animalCounter++;
    }

    public void run(int distance) {
        System.out.printf("%s пробежал %d метров\n", name, distance);
    }

    public void swim(int distance) {
        System.out.printf("%s проплыл %d метров\n", name, distance);
    }

    public static int getCounter() {
        return animalCounter;
    }
}
