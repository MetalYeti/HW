package JAVA3.HW5;

import java.util.concurrent.ArrayBlockingQueue;

public class Tunnel extends Stage {
    private ArrayBlockingQueue<Car> abq;

    public Tunnel(int capacity) {
        abq = new ArrayBlockingQueue(capacity);
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                abq.put(c);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                abq.take();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
