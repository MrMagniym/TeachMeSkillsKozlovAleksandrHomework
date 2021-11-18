package Lessons.Lesson11;

public class BigArray {

    private final int[] bigArray = new int[1000000];
    private int count;

    public BigArray(){
        for (int i = 0; i <= bigArray.length-1; i++) {
            bigArray[i] = (int) (1 + Math.random() * 15000);
        }
    }

    public synchronized boolean checkNumberEquivalenceByIndex(int index, int number){ return bigArray[index] == number; }

    public synchronized int setCountZero(){
        return count = 0;
    }

    public synchronized int getCount(){
        return count;
    }

    public synchronized void incCount() { count++; }

    public synchronized int length(){
        return bigArray.length;
    }

}
