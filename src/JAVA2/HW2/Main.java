package JAVA2.HW2;

import JAVA2.HW2.Exceptions.MyArrayDataException;
import JAVA2.HW2.Exceptions.MyArraySizeException;

public class Main {
    public static void main(String[] args) {

        String[][] array = {
                new String[]{"1", "3", "5", "9"},
                new String[]{"2", "6", "8", "10"},
                new String[]{"79", "25", "12", "28"},
                new String[]{"4", "88", "16", "3"}
        };

        try {
            System.out.println(sumArray(array));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int sumArray(String[][] array) throws MyArrayDataException, MyArraySizeException {
        if (array.length != 4) {
            throw new MyArraySizeException("В массиве должно быть 4 строки");
        }

        int result = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("В строке " + i + " должно быть 4 графы");
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    result += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return result;
    }
}
