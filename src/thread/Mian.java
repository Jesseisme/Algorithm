package thread;

import java.util.concurrent.ArrayBlockingQueue;

public class Mian<T> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue<>(10);
		

	}
	public class Produce<T> implements Runnable {
		ArrayBlockingQueue<T> abq =null;
		int timeout;
		String flag = null;
		public Produce(ArrayBlockingQueue<T> abq,int timeout) {
			this.abq=abq;
			this.timeout= timeout;
			this.flag=flag;  
		}
		
		@Override
		public void run() {
			try {
				System.out.println("produce"+flag);
				abq.put((T) flag);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}

}
