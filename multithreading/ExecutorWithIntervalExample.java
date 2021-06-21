package test.prac.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ExecutorWithIntervalExample {

	public static void main(String[] args) {
		
		//ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
		
		Runnable myRunnableTask = () -> {
									int sum = 0;
									for(int i=0;i<10;i++){
										sum +=i;
										try {
											TimeUnit.SECONDS.sleep(5);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									System.out.println("Runnable Sum:" + sum);
					};
		//executes after 2sec 			
		//executorService.schedule(myRunnableTask, 2, TimeUnit.SECONDS);
		
		executorService.scheduleAtFixedRate(myRunnableTask, 1, 1, TimeUnit.SECONDS);
		//executorService.scheduleWithFixedDelay(myRunnableTask, 3, 2, TimeUnit.SECONDS);
		
		
		Callable<String> myCallableTask = () -> {
			TimeUnit.MILLISECONDS.sleep(300);
			int sum=0;
			for(int i=0;i<100;i++){
				sum +=i;
			}
			return Integer.toString(sum);
			};
		
		ScheduledFuture<String> futureObj = executorService.schedule(myCallableTask, 2, TimeUnit.SECONDS);
		try {
			String sum = futureObj.get();
			System.out.println("Sum : " + sum);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
		executorService.shutdown();
	}

}
