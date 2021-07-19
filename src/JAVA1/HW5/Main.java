package JAVA1.HW5;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Алексей Иванов", "Уборщик", "aliv@mail.ru", "89273002020", 10000, 65),
                new Employee("Иван Алексеев", "Бухгалтер", "ival@mail.ru", "89273002021", 30000, 35),
                new Employee("Марина Петрова", "Директор", "marina@mail.ru", "89273002022", 100000, 25),
                new Employee("Елена Пупкина", "Программист", "elpup@mail.ru", "89273002023", 50000, 31),
                new Employee("Виктор Сидоров", "Водитель", "visid@mail.ru", "89273002024", 20000, 42),
        };

        for (Employee employee : employees) {
            if (employee.getAge() >= 40) {
                employee.showInfo();
            }
        }
    }
}
