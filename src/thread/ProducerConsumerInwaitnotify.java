package thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumerInwaitnotify {
	public static void main(String args[]) {
		System.out.println("How to use wait and notify method in Java");
		System.out.println("Solving Producer Consumper Problem");
		Queue<Integer> buffer = new LinkedList<>();
		int maxSize = 10;
		ProducerConsumerInwaitnotify pc = new ProducerConsumerInwaitnotify();
		Thread producer = pc.new Producer(buffer, maxSize, "PRODUCER");
		Thread consumer = pc.new Consumer(buffer, maxSize, "CONSUMER");
		producer.start();
		consumer.start();
	}

	// 生产者线程
	class Producer extends Thread {
		private Queue<Integer> queue;
		private int maxSize;

		public Producer(Queue<Integer> queue, int maxSize, String name) {
			super(name);
			this.queue = queue;
			this.maxSize = maxSize;
		}

		@Override
		public void run() {
			while (true) {
				synchronized (queue) {
					while (queue.size() == maxSize) { // 当缓存区满的时候
						try {
							// 进入wait
							queue.wait();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
					Random random = new Random();
					int i = random.nextInt();
					System.out.println("Producing value : " + i);
					queue.add(i);
					queue.notifyAll();
				}
			}
		}
	}

	// 消费者线程
	class Consumer extends Thread {
		private Queue<Integer> queue;
		private int maxSize;

		public Consumer(Queue<Integer> queue, int maxSize, String name) {
			super(name);
			this.queue = queue;
			this.maxSize = maxSize;
		}

		@Override
		public void run() {
			while (true) {
				synchronized (queue) {
					while (queue.isEmpty()) {
						System.out.println("Queue is empty," + "Consumer thread is waiting"
								+ " for producer thread to put something in queue");
						try {
							queue.wait();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
					System.out.println("Consuming value : " + queue.remove());
					queue.notifyAll();
				}
			}
		}
	}
}
