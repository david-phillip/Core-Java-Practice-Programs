package test.prac.multithreading;

import java.util.concurrent.*;

public class CompletableFutureExample {

    // using completableFuture as future object
    public static void main(String args[]) throws InterruptedException {

        System.out.println("Main enter");

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "David";
        }).thenApplyAsync((name1)-> {
                return name1 + " Phillip";
        }).thenAcceptAsync(name -> {
                System.out.println("Hello " + name + " " + Thread.currentThread().getName());
        },executorService).thenRun(() -> {
                System.out.println("Completed " + Thread.currentThread().getName());
        });

        System.out.println("Main exit");
        executorService.awaitTermination(7, TimeUnit.SECONDS);

    }
}
