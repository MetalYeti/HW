package HW7;

public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate(50);
        Cat[] cats = {
                new Cat("Барсик", 10),
                new Cat("Марсик", 17),
                new Cat("Муська", 15),
                new Cat("Мурзик", 12),
                new Cat("Гарфилд", 30),
                new Cat("Васька", 8),
        };

        System.out.println(plate);

        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
        }

        System.out.println(plate);
    }
}
