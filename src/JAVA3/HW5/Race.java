package JAVA3.HW5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CyclicBarrier;

public class Race {
    private ArrayList<Stage> stages;
    private CyclicBarrier readiness;
    private final ArrayBlockingQueue winner = new ArrayBlockingQueue(1);

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public CyclicBarrier getReadiness() { return readiness; }

    public boolean isWinner(Car c) {
        return winner.offer(c);
    }

    public Race(int participants, Stage... stages) {
        this.readiness = new CyclicBarrier(participants);
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}
