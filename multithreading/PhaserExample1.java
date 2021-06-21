package test.prac.multithreading;

import java.util.concurrent.Phaser;

public class PhaserExample1 {

    public static void main(String args[]){

        Phaser phaser = new Phaser();
        phaser.register();

        Thread t1 = new Thread(new MyRunnable("Worker-1", 1000, phaser));
        Thread t2 = new Thread(new MyRunnable("Worker-2", 3000, phaser));
        Thread t3 = new Thread(new MyRunnable("Worker-3", 5000, phaser));

        t1.start();
        t2.start();
        t3.start();

        int currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase + " has completed");

        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase + " has completed");

        phaser.arriveAndDeregister();

        if(phaser.isTerminated()){
            System.out.println("Phaser is terminated");
        }
    }
}

class MyRunnable implements Runnable{

    Phaser phaser;
    String name;
    int delay;

    MyRunnable(String name, int delay, Phaser phaser){
        this.name = name;
        this.delay = delay;
        this.phaser = phaser;
        this.phaser.register();
    }

    public void run(){

        // Phase 1 start
        System.out.println(name + " started working on phase " + phaser.getPhase() );
        phaser.arriveAndAwaitAdvance();

        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Phase 2 start
        System.out.println(name + " started working on phase " + phaser.getPhase() );
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phaser.arriveAndAwaitAdvance();

        // All phase completed
        phaser.arriveAndDeregister();
    }
}

