package test.prac.examples;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HMThreadSafety {

	public static void main(String[] args) throws InterruptedException {
		
		Map<String, Integer> hm = new HashMap<>();
		hm.put("counter1", 0);
		hm.put("counter2", 100);
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		Runnable task = () -> {
								incrementMap(hm, "counter1");
								incrementMap(hm, "counter2");
							};
		
		for(int i=0; i<100; i++) {
			//service.execute(task);
			service.submit(task);
		}
		
		service.shutdown();
		service.awaitTermination(30,TimeUnit.SECONDS);
		
		System.out.println("Counter 1 value : " + hm.get("counter1"));
		System.out.println("Counter 2 value : " + hm.get("counter2"));					
	}
	
	public static void incrementMap(Map<String, Integer> map, String mapkey) {
		int count = map.get(mapkey);
//		count++;
//		map.put(mapkey, count);
		
		map.computeIfPresent(mapkey, (k,v) -> v+1); 
	}

}
