package Lessons.Lesson11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadTrain {

    public static void main(String[] args) {

        int countResult;
        double timeResult;
        long startTime, endTime;
        BigArray bigArray = new BigArray();

        startTime = getCurrentTimeMillis();
        oneThread(bigArray);
        endTime = getCurrentTimeMillis();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        timeResult = getResultTime(startTime, endTime);
        countResult = bigArray.getCount();

        System.out.println("1 Thread Execution Time: " + timeResult + "s");
        System.out.println("Count Of 1435: " + countResult);


        startTime = getCurrentTimeMillis();
        countResult = fourThreads(bigArray);
        endTime = getCurrentTimeMillis();

        timeResult = getResultTime(startTime, endTime);

        System.out.println("4 Thread Execution Time: " + timeResult + "s");
        System.out.println("Count Of 1435: " + countResult);
    }

    private static int fourThreads(BigArray bigArray) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Future<Integer>> list = new ArrayList<>();
        Callable<Integer> callable = new BigArrayThread(bigArray);
        Future<Integer> future = executor.submit(callable);
        list.add(future);

        for (Future<Integer> fut : list){
            try {
                return fut.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        return -1;
    }

    private static void oneThread(BigArray bigArray) {
        Runnable runnable = new BigArrayThread(bigArray);
        Thread oneThread = new Thread(runnable);
        oneThread.start();
    }


    private static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    private static double getResultTime(long start, long end) {
        return (double) (end - start) / 1000;
    }

}
