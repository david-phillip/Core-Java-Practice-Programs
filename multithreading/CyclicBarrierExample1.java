package test.prac.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample1 {

    public static void main(String args[]){

        System.out.println(Thread.currentThread().getName() + " started");
        CyclicBarrier barrier = new CyclicBarrier(4);

        WorkerThread wt1 = new WorkerThread(1000, barrier, "WorkerThread-1");
        WorkerThread wt2 = new WorkerThread(2000, barrier, "WorkerThread-2");
        WorkerThread wt3 = new WorkerThread(3000, barrier, "WorkerThread-3");
        WorkerThread wt4 = new WorkerThread(4000, barrier, "WorkerThread-4");

        WorkerThread wt5 = new WorkerThread(1000, barrier, "WorkerThread-5");
        WorkerThread wt6 = new WorkerThread(2000, barrier, "WorkerThread-6");
        WorkerThread wt7 = new WorkerThread(3000, barrier, "WorkerThread-7");
        WorkerThread wt8 = new WorkerThread(4000, barrier, "WorkerThread-8");

        wt1.start();
        wt2.start();
        wt3.start();
        wt4.start();

        wt5.start();
        wt6.start();
        wt7.start();
        wt8.start();

        System.out.println(Thread.currentThread().getName() + " finished");
    }
}

class WorkerThread extends Thread{

    CyclicBarrier cyclicBarrier;
    int delay;
    String name;

    WorkerThread(int delay, CyclicBarrier cyclicBarrier, String name){
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
