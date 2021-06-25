package HW3;

public class Main {
    public static void main(String[] args) {
        //1
        int[] arr1 = new int[10];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (int) Math.round(Math.random());
        }

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Math.abs(arr1[i] - 1);
        }

        //2
        int[] arr2 = new int[100];
        for (int i = 0; i < 100; i++) {
            arr2[i] = i + 1;
        }

        //3
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            int x = arr3[i];
            arr3[i] = (x < 6) ? x * 2 : x;
        }

        //4
        int[][] arr4 = new int[6][6];
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                if (i == j || j == arr4[i].length - 1 - i) {
                    arr4[i][j] = 1;
                }
            }
        }

        //6
        int[] arr6 = {1, 3, 6, 9, 87, 5, 4, 25, 66, 12, -8};
        int max = arr6[0];
        int min = arr6[0];
        for (int i : arr6) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
    }

    //5
    public static int[] makeArray(int len, int initialValue) {
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = initialValue;
        }
        return result;
    }

    //7
    public static boolean checkBalance(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int j = 0; j <= i; j++) {
                leftSum += arr[j];
            }
            for (int k = arr.length - 1; k > i; k--) {
                rightSum += arr[k];
            }
            if (leftSum == rightSum) {
                return true;
            }
        }
        return false;
    }

    //8
    public static int[] shiftArray(int[] arr, int n) {
        int repeat;
        if (Math.abs(n) >= arr.length) {
            repeat = Math.abs(n) % arr.length;
        } else {
            repeat = Math.abs(n);
        }

        for (int j = 0; j < repeat; j++) {
            if (n > 0) {
                int last = arr[arr.length - 1];
                for (int i = arr.length - 1; i > 0; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[0] = last;
            } else {
                int first = arr[0];
                for (int i = 0; i < arr.length - 1; i++) {
                    arr[i] = arr[i + 1];
                }
                arr[arr.length - 1] = first;
            }
        }
        return arr;
    }
}
