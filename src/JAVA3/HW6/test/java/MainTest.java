package JAVA3.HW6.test.java;
import JAVA3.HW6.main.java.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    Main m = new Main();

    @Test
    void test1arrayWithFour() {
        assertArrayEquals(new int[]{2, 1, 7}, m.arrayWithFour(new int[]{2, 3, 5, 4, 2, 4, 2, 1, 7}));
    }

    @Test
    void test2arrayWithFour() {
        assertArrayEquals(new int[]{}, m.arrayWithFour(new int[]{2, 3, 4, 5, 4}));
    }

    @Test
    void test3arrayWithFour() {
        assertArrayEquals(new int[]{3, 2, 5, 8}, m.arrayWithFour(new int[]{1, 4, 3, 2, 5, 8}));
    }

    @Test
    void test4arrayWithFour() {
        assertThrows(RuntimeException.class, () -> m.arrayWithFour(new int[]{2, 3}));
    }

    @Test
    void test5arrayWithFour() {
        assertThrows(RuntimeException.class, () -> m.arrayWithFour(new int[]{}));
    }

    @Test
    void test1onesAndFours() {
        assertTrue(m.onesAndFours(new int[]{1, 4, 1, 1, 4, 1}));
    }

    @Test
    void test2onesAndFours() {
        assertFalse(m.onesAndFours(new int[]{1, 1, 1, 1, 1, 1}));
    }

    @Test
    void test3onesAndFours() {
        assertFalse(m.onesAndFours(new int[]{4, 4}));
    }

    @Test
    void test4onesAndFours() {
        assertFalse(m.onesAndFours(new int[]{1, 2, 1, 1, 4, 1}));
    }

    @Test
    void test5onesAndFours() {
        assertFalse(m.onesAndFours(new int[]{}));
    }
}
