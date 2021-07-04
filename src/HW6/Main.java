package HW6;

import HW6.Animals.*;

public class Main {
    public static void main(String[] args) {

        Dog dog1 = new Dog("Tuzik");
        Dog dog2 = new Dog("Bobik");

        Cat cat = new Cat("Barsik");

        dog1.run(150);
        dog1.swim(25);

        dog2.run(550);
        dog2.swim(8);

        cat.run(185);
        cat.swim(20);

        System.out.println(Animal.getCounter());
        System.out.println(Cat.getCounter());
        System.out.println(Dog.getCounter());
    }
}
