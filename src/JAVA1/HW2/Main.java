package JAVA1.HW2;

public class Main {
    public static void main(String[] args) {
        System.out.println(squareDigits(9207));

    }

    public static int squareDigits(int n) {
        String result = "";
        while (n % 10 >= 0 && n > 0) {
            int j = n % 10;
            result = (int) Math.pow(j, 2) + result;
            n /= 10;
        }
        return Integer.parseInt(result);
    }


    private static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    private static void repeatString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(s);
        }
    }

    private static boolean isNegative(int num) {
        return num < 0;
    }

    private static void printSign(int num) {
        String sign = (num >= 0) ? "Положительное" : "Отрицательное";
        System.out.println(sign);
    }

    private static boolean sumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }
}
