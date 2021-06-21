package test.prac.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample3 {
    
    public static void main(String args[]){

        System.out.println(Thread.currentThread().getName() + " started");
        CyclicBarrier barrier = new CyclicBarrier(4 , () -> System.out.println("Barrier released"));
        ExecutorService service = Executors.newFixedThreadPool(4);

        WorkerThreadNew wt1 = new WorkerThreadNew(1000, barrier, "WorkerThreadNew-1");
        WorkerThreadNew wt2 = new WorkerThreadNew(2000, barrier, "WorkerThreadNew-2");
        WorkerThreadNew wt3 = new WorkerThreadNew(3000, barrier, "WorkerThreadNew-3");
        WorkerThreadNew wt4 = new WorkerThreadNew(4000, barrier, "WorkerThreadNew-4");

        WorkerThreadNew wt5 = new WorkerThreadNew(1000, barrier, "WorkerThreadNew-5");
        WorkerThreadNew wt6 = new WorkerThreadNew(2000, barrier, "WorkerThreadNew-6");
        WorkerThreadNew wt7 = new WorkerThreadNew(3000, barrier, "WorkerThreadNew-7");
        WorkerThreadNew wt8 = new WorkerThreadNew(4000, barrier, "WorkerThreadNew-8");

        service.execute(wt1);
        service.execute(wt2);
        service.execute(wt3);
        service.execute(wt4);
        service.execute(wt5);
        service.execute(wt6);
        service.execute(wt7);
        service.execute(wt8);

        System.out.println(Thread.currentThread().getName() + " finished");
        service.shutdown();
    }
}

class WorkerThreadNew extends Thread{

    CyclicBarrier cyclicBarrier;
    int delay;
    String name;

    WorkerThreadNew(int delay, CyclicBarrier cyclicBarrier, String name){
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