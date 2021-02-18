package thread;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {
	public static <V> void main(String res[]) {
		 ExecutorService p = Executors.newFixedThreadPool(2);
		 p.execute(new FutureTask<>(new Callable<V>() {

			@Override
			public V call() throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
		}));
		 Runnable task = null;
		p.submit(task);
		HashMap<Integer, String> map = new HashMap<>();
		Set<Entry<Integer, String>> e = map.entrySet();
		Iterator<Entry<Integer, String>> iterator = e.iterator();
		while(iterator.hasNext()) {
			Entry<Integer, String> next = iterator.next();
			Object value = next.getValue();
			Object key = next.getKey();
			next.setValue((String) value);
		}
		new Thread( new Runnable() {
			public void run() {
				
			}
		}).start();;
	}
	int[] a ;
	ExecutorService es = Executors.newFixedThreadPool(2);
	
}
