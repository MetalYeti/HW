package JAVA3.HW4;

public class Main {
    private volatile char currentLetter = 'A';
    private final Object mon = new Object();

    public static void main(String[] args) {
        Main m = new Main();

        Thread t1 = new Thread(() -> m.printLetter('A', 'B'));
        Thread t2 = new Thread(() -> m.printLetter('B', 'C'));
        Thread t3 = new Thread(() -> m.printLetter('C', 'A'));

        t1.start();
        t2.start();
        t3.start();
    }

    public void printLetter(char letter, char nextLetterInSequence) {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != letter) {
                        mon.wait();
                    }
                    System.out.print(currentLetter);
                    currentLetter = nextLetterInSequence;
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
