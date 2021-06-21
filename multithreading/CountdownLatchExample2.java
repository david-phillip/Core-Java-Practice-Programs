package test.prac.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountdownLatchExample2 {

    public static void main(String args[]) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(6);
        ExecutorService service = Executors.newFixedThreadPool(6);

        WorkerNew worker0 = new WorkerNew(latch, 1000, "WorkerNew-0");
        WorkerNew worker1 = new WorkerNew(latch, 2000, "WorkerNew-1");
        WorkerNew worker2 = new WorkerNew(latch, 1000, "WorkerNew-2");
        WorkerNew worker3 = new WorkerNew(latch, 2000, "WorkerNew-3");
        WorkerNew worker4 = new WorkerNew(latch, 1000, "WorkerNew-4");
        WorkerNew worker5 = new WorkerNew(latch, 2000, "WorkerNew-5");

        service.execute(worker0);
        service.execute(worker1);
        service.execute(worker2);
        service.execute(worker3);
        service.execute(worker4);
        service.execute(worker5);

        service.awaitTermination(8, TimeUnit.SECONDS);
        latch.await();

        // Main thread is exist only after the WorkerNew threads have finished execution
        System.out.println(Thread.currentThread().getName() + " exit");

        service.shutdown();

    }
}

class WorkerNew extends Thread{

    CountDownLatch latch;
    int delay;
    String name;

    public WorkerNew(CountDownLatch latch, int delay, String name){
        this.latch = latch;
        this.delay = delay;
        this.name = name;
    }

    public void run(){
        try{
            Thread.sleep(delay);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(name + " exit");
        latch.countDown();
        System.out.println("Latch count : " + latch.getCount());
    }
}

