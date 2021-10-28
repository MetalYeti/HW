package JAVA3.HW6.main.java;
import java.util.Arrays;

public class Main {

    public int[] arrayWithFour(int[] arr) {
        int lastFourPos = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                lastFourPos = i;
            }
        }
        if (lastFourPos == 0) {
            throw new RuntimeException("В массиве нет 4 (или массив пуст)");
        }

        return Arrays.copyOfRange(arr, lastFourPos + 1, arr.length);
    }

    public boolean onesAndFours(int[] arr) {
        boolean ones = false;
        boolean fours = false;
        boolean others = false;

        for (int e : arr) {
            if (e == 1) {
                ones = true;
            } else if (e == 4) {
                fours = true;
            } else {
                others = true;
            }
        }
        return ones && fours && !others;
    }
}
