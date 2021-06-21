package test.prac.multithreading;
import java.util.concurrent.CountDownLatch;

public class CountdownLatchExample1 {

    public static void main(String args[]){

        CountDownLatch latch = new CountDownLatch(4);

        Worker worker1 = new Worker(latch, 1000, "worker-0");
        Worker worker2 = new Worker(latch, 2000, "worker-1");
        Worker worker3 = new Worker(latch, 3000, "worker-2");
        Worker worker4 = new Worker(latch, 4000, "worker-3");
        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        try{
            latch.await();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        // Main thread exists only after the worker threads have finished execution
        System.out.println(Thread.currentThread().getName() + " exit");
    }
}

class Worker extends Thread{

    CountDownLatch latch;
    int delay;
    String name;

    public Worker(CountDownLatch latch, int delay, String name){
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