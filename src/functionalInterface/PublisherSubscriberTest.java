package functionalInterface;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Reference http://www.byteslounge.com/tutorials/java-8-consumer-and-supplier
 *
 */
public class PublisherSubscriberTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("starting");
		
		BlockingQueue<User> usersQueue = new LinkedBlockingQueue<User>();
		
		Supplier<User> supplier = () -> {
			try {
				return usersQueue.take();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		};
		
		Consumer<User> consumer = (user) -> {
			System.out.println(user);
		};
		
		PublisherSubscriber<User> publisherSubscriber = new PublisherSubscriber<>(consumer, supplier);
		publisherSubscriber.start();
		
		for (int i = 0; i < 100; i++) {
			  usersQueue.put(new User("user" + i));
		}
	}
}
