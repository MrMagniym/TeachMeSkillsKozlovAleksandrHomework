package Lessons.Lesson11;

import java.util.concurrent.Callable;

public record BigArrayThread(BigArray bigArray) implements Runnable, Callable<Integer> {

    @Override
    public void run() {
        for (int i = bigArray.setCountZero(); i < bigArray.length() - 1; i++) {
            if (bigArray.checkNumberEquivalenceByIndex(i, 1435)) {
                bigArray.incCount();
            }
        }
    }

    @Override
    public Integer call() {
        for (int i = bigArray.setCountZero(); i < bigArray.length() - 1; i++) {
            if (bigArray.checkNumberEquivalenceByIndex(i, 1435)) {
                bigArray.incCount();
            }
        }
        return bigArray.getCount();
    }
}
