package test.prac.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample2 {
    
    public static void main(String args[]){

        System.out.println(Thread.currentThread().getName() + " started");
        CyclicBarrier barrier = new CyclicBarrier(4 , () -> System.out.println("Barrier released"));

        WorkerThreadNew wt1 = new WorkerThreadNew(1000, barrier, "WorkerThreadNew-1");
        WorkerThreadNew wt2 = new WorkerThreadNew(2000, barrier, "WorkerThreadNew-2");
        WorkerThreadNew wt3 = new WorkerThreadNew(3000, barrier, "WorkerThreadNew-3");
        WorkerThreadNew wt4 = new WorkerThreadNew(4000, barrier, "WorkerThreadNew-4");

        WorkerThreadNew wt5 = new WorkerThreadNew(1000, barrier, "WorkerThreadNew-5");
        WorkerThreadNew wt6 = new WorkerThreadNew(2000, barrier, "WorkerThreadNew-6");
        WorkerThreadNew wt7 = new WorkerThreadNew(3000, barrier, "WorkerThreadNew-7");
        WorkerThreadNew wt8 = new WorkerThreadNew(4000, barrier, "WorkerThreadNew-8");

        Thread t1 = new Thread(wt1);
        Thread t2 = new Thread(wt2);
        Thread t3 = new Thread(wt3);
        Thread t4 = new Thread(wt4);
        Thread t5 = new Thread(wt5);
        Thread t6 = new Thread(wt6);
        Thread t7 = new Thread(wt7);
        Thread t8 = new Thread(wt8);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();

        System.out.println(Thread.currentThread().getName() + " finished");

    }
}

class WorkerThreadNew1 implements Runnable{

    CyclicBarrier cyclicBarrier;
    int delay;
    String name;

    WorkerThreadNew1(int delay, CyclicBarrier cyclicBarrier, String name){
        this.delay = delay;
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }
    public void run(){
        try {
            Thread.sleep(delay);
            System.out.println(name + " executed ");
            int awaitCount =  cyclicBarrier.await();
            if(awaitCount == 0){
                System.out.println("barrier called all threads wait");
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}