package JAVA1.HW7;

public class Cat {
    private String name;
    private int appetite;
    private boolean isFull;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isFull = false;
    }

    public void eat(Plate p) {
        isFull = p.decreaseFood(appetite);
    }

    @Override
    public String toString() {
        return String.format("Кот %s съедает %d еды, чтобы наесться, сейчас %s.", name, appetite, isFull ? "сыт" : "голоден");
    }
}
