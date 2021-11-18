package Lessons.Lesson11;

import java.util.concurrent.Callable;

public class BigArrayThread implements Runnable, Callable<Integer> {

    private BigArray bigArray;

    public BigArrayThread(BigArray bigArray){
        this.bigArray = bigArray;
    }

    public BigArrayThread(){

    }

    @Override
    public void run() {
        for (int i = bigArray.setCountZero(); i < bigArray.length() - 1; i++){
            if (bigArray.checkNumberEquivalenceByIndex(i, 1435)){
                bigArray.incCount();
            }
        }
    }

    @Override
    public Integer call() {
        for (int i = bigArray.setCountZero(); i < bigArray.length() - 1; i++){
            if (bigArray.checkNumberEquivalenceByIndex(i, 1435)){
                bigArray.incCount();
            }
        }
        return bigArray.getCount();
    }
}
