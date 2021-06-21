package test.prac.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class ExecutorTest {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		Runnable myRunnableTask = () -> {
										try {
											TimeUnit.MILLISECONDS.sleep(3000);
											System.out.println("Runnable HelloWorld");
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									};
		//Calling execute()
		executorService.execute(myRunnableTask);
		
		Runnable myRunnableTask2 = () -> {
											int sum = 0;
											for(int i=0;i<10;i++){
												sum +=i;
											}
											System.out.println("Runnable Sum:" + sum);
										
		};
		executorService.execute(myRunnableTask2);
		
									
		Callable<String> myCallableTask = () -> {
									TimeUnit.MILLISECONDS.sleep(300);
									return "Callable Task 1 execution";
									};
		Callable<String> myCallableTask2 = () -> {
									TimeUnit.MILLISECONDS.sleep(300);
									return "Callable Task 2 execution";
									};
									
		Callable<String> myCallableTask3 = () -> {
											TimeUnit.MILLISECONDS.sleep(300);
											int sum=0;
											for(int i=0;i<100;i++){
												sum +=i;
											}
											return Integer.toString(sum);
											};
									
		List<Callable<String>> myCallableTaskList = new ArrayList<>();
		myCallableTaskList.add(myCallableTask);
		myCallableTaskList.add(myCallableTask2);
		myCallableTaskList.add(myCallableTask3);
									
		//Calling submit()
		Future<String> futureObj = executorService.submit(myCallableTask);
		String result = null;
		
		try {
			result = futureObj.get();
			System.out.println("submit(), Result1 : " + result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		//Calling invokeAny()
		try {
			String result2 = executorService.invokeAny(myCallableTaskList);
			System.out.println("invokeAny(), Result2 : " + result2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Calling invokeAll()
		List<Future<String>> result3 = null;
		try {
			result3 = executorService.invokeAll(myCallableTaskList);
			for(Future<String> res:result3) {
				try {
					System.out.println("invokeAll(), Result3 : " + res.get());
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		//Shutdown service
		executorService.shutdown();
		try {
			if(!executorService.awaitTermination(3000, TimeUnit.MILLISECONDS)) {
				executorService.shutdownNow();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//This line will throw exception RejectedExecutionException
		//executorService.execute(myRunnableTask);

	}

}
