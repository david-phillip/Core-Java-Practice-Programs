package test.prac.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Counter1{

    static volatile int counter = 0;

    public int getValue() {
        return counter;
    }

    public void incrementValue() {
        ++counter;
    }
}

public class VolatileExample {

    public static void main(String[] args) {

        Counter1 c1 = new Counter1();

        try {
            Runnable task1 = () -> {
                for(int i=1;i<=10;i++) {
                    System.out.println("c1 current value : " + c1.counter + " in Thread " +  Thread.currentThread().getName());
                    c1.incrementValue();
                }
            };

            Runnable task2 = () -> {
                for(int i=1;i<=10;i++) {
                    System.out.println("c1 current value : " + c1.getValue() + " in Thread " +  Thread.currentThread().getName());
                    c1.incrementValue();
                }
            };

            new Thread(task1).start();
            new Thread(task2).start();

            getFinalCount(c1);

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void getFinalCount(Counter1 c1){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Incremented value of counter is : " + c1.getValue());
    }
}
