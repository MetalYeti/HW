package JAVA3.HW1;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> content;

    public Box() {
        this.content = new ArrayList<>();
    }

    public float getWeight(){
        if (content.isEmpty()) return 0;

        return content.size() * content.get(0).getWeight();
    }

    public boolean compare(Box<?> compareTo) {
        return (this.getWeight() - compareTo.getWeight()) < 0.00001;
    }

    public void addContent(T obj){
        content.add(obj);
    }

    public void transferContent(Box<T> target){
        if (this.equals(target)) {
            throw new IllegalArgumentException("Невозможно пересыпать коробку саму в себя!");
        }
        for (T el : content) {
             target.addContent(el);
         }
        content.clear();
    }
}
