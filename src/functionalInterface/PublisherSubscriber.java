package functionalInterface;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Following the idea and sample from 
 * http://www.byteslounge.com/tutorials/java-8-consumer-and-supplier
 *
 */
public class PublisherSubscriber<T> extends Thread {
	
	private Consumer<T> consumer;
	private Supplier<T> supplier;
	private boolean shouldRun = true;
	
	public PublisherSubscriber(Consumer<T> consumer, Supplier<T> supplier) {
		this.consumer = consumer;
		this.supplier = supplier;
	}
	
	@Override
	public void run() {
		while(shouldRun) {
			T object = this.supplier.get();
			consumer.accept(object);
		}
	}	
}
