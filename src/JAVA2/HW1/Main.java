package JAVA2.HW1;

public class Main {
    public static void main(String[] args) {

        Actions[] actions = {
                new Human("Александр", 100, 35),
                new Human("Петр", 20, 60),
                new Cat("Васька", 150, 75),
                new Robot("Бендер", 300, 200)
        };

        Obstacle[] obstacles = {
                new Wall(50),
                new Wall(60),
                new Treadmill(120),
                new Wall(20),
                new Treadmill(200)
        };

        for (Actions a : actions) {
            for (Obstacle o : obstacles) {
                if (!o.doAction(a)) {
                    break;
                }
            }
        }

        System.out.println(getWorkingHours(DayOfWeek.TUESDAY));

    }

    private static String getWorkingHours(DayOfWeek dw) {
        if (dw == DayOfWeek.SATURDAY || dw == DayOfWeek.SUNDAY) {
            return "Сегодня выходной";
        }
        return String.valueOf(dw.getWorkingHours());
    }

}
