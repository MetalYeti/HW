package JAVA1.HW4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean checkWin(char symb) {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                if (checkConditions(x, y, symb)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkConditions(int x, int y, char symb) {
        return checkCondition(x, y, 1, 0, symb) ||
                checkCondition(x, y, 0, 1, symb) ||
                checkCondition(x, y, 1, 1, symb) ||
                checkCondition(x, y, 1, -1, symb);
    }

    public static boolean checkCondition(int x, int y, int shiftDirectionX, int shiftDirectionY, char symb) {
        int maxPointX = x + (DOTS_TO_WIN - 1) * shiftDirectionX;
        int maxPointY = y + (DOTS_TO_WIN - 1) * shiftDirectionY;

        if (maxPointX >= SIZE || maxPointY < 0 || maxPointY >= SIZE) return false;

        for (int i = 0; i < DOTS_TO_WIN; i++) {
            if (map[y + i * shiftDirectionY][x + i * shiftDirectionX] != symb) {
                return false;
            }
        }
        return true;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int[] winXY = aiCheckTurn(DOT_O);
        int[] interfereXY = aiCheckTurn(DOT_X);

        if (winXY != null) {
            aiNotRandomTurn(winXY);
        } else if (interfereXY != null) {
            aiNotRandomTurn(interfereXY);
        } else {
            aiRandomTurn();
        }
    }

    public static void aiNotRandomTurn(int[] xy) {
        int x = xy[0];
        int y = xy[1];
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static int[] aiCheckTurn(char c) {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                if (isCellValid(x, y)) {
                    map[y][x] = c;
                    if (checkWin(c)) {
                        map[y][x] = DOT_EMPTY;
                        return new int[]{x, y};
                    }
                    map[y][x] = DOT_EMPTY;
                }
            }
        }
        return null;
    }

    public static void aiRandomTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        return map[y][x] == DOT_EMPTY;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
