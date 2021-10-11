package JAVA3.HW1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        appleBox1.addContent(new Apple());
        appleBox1.addContent(new Apple());
        appleBox1.addContent(new Apple());

        appleBox2.addContent(new Apple());
        appleBox2.addContent(new Apple());
        appleBox2.addContent(new Apple());
        appleBox2.addContent(new Apple());
        appleBox2.addContent(new Apple());
        appleBox2.addContent(new Apple());

        orangeBox.addContent(new Orange());
        orangeBox.addContent(new Orange());

        System.out.println(orangeBox.getWeight());
        System.out.println(appleBox1.getWeight());
        System.out.println(orangeBox.compare(appleBox1));
        System.out.println(appleBox1.compare(orangeBox));

        appleBox2.transferContent(appleBox1);
        System.out.println(orangeBox.getWeight());
        System.out.println(appleBox1.getWeight());
        System.out.println(appleBox2.getWeight());
        System.out.println(orangeBox.compare(appleBox1));
        System.out.println(appleBox1.compare(orangeBox));

        orangeBox.addContent(new Orange());
        orangeBox.addContent(new Orange());
        orangeBox.addContent(new Orange());
        orangeBox.addContent(new Orange());
        System.out.println(appleBox1.compare(orangeBox));

    }

    public static <T> void swapElements(T[] arr, int i, int j){
        T firstEl = arr[i];
        arr[i] = arr[j];
        arr[j] = firstEl;
    }

    public static <T> List<T> arrToList(T[] arr){
        return new ArrayList<>(Arrays.asList(arr));
    }
}
