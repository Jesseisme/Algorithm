package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;


public class ProducerConsumerInBlockingQueue {  
	
	public static void main(String res[]) {
		ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(10);
		//开启Producer线程
		new Thread(new Producer(abq, 500, "ad")).start();
		new Thread(new Producer(abq, 1000, "nike")).start();;
		//开启Consumer线程
		new Thread(new Consumer(abq, 50)).start();
	}
	
	private static class Producer implements Runnable{
		ArrayBlockingQueue<String> abq = null;
		private int timeout = 0;
		String flag = null;
		//构造函数
		public Producer(ArrayBlockingQueue<String> abq,int timeout,String flag) {
			this.abq=abq;
			this.timeout=timeout;
			this.flag = flag;
		}
		@Override
		public void run() {
			while(!Thread.currentThread().isInterrupted()) {//判断次线程是否中断
				try {
					System.out.println("put "+flag);
					abq.put("product"+flag);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					TimeUnit.MILLISECONDS.sleep(timeout);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private static class Consumer implements Runnable{
		ArrayBlockingQueue<String> abq = null;
		int timeout = 0;
		//构造函数
		private Consumer(ArrayBlockingQueue<String> abq,int timeout ) {
			this.abq=abq;
			this.timeout = timeout;
		}
		@Override
		public void run() {
			while(!Thread.currentThread().isInterrupted()) {
				try {
					System.out.println("take "+abq.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					TimeUnit.MILLISECONDS.sleep(timeout);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
}  
