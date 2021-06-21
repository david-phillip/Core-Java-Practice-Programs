package test.prac.multithreading;

import java.util.concurrent.*;

public class FutureExample {

    public static void main(String args[]) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(1);

        Future<Integer> future = service.submit(new MyCallable());
        System.out.println("Future value :" + future.get() + Thread.currentThread().getName());

        System.out.println("Exit Main method() " + Thread.currentThread().getName());
    }
}

class MyCallable implements Callable{
    public Integer call() throws InterruptedException {

        Thread.sleep(5000);
        return 10;
    }
}