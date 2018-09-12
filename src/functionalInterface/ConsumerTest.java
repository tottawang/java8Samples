package functionalInterface;

import java.util.function.Consumer;

public class ConsumerTest {
	
	public static void main(String[] args) {
		Consumer<String> consumer = ConsumerTest::printName;
		consumer.accept("hello");
		consumer.accept("world");
		
		Consumer<String> consumer2 = (str) -> printName(str);
		consumer2.accept("hello");
		consumer2.accept("world");
	}
	
	public static void printName(String name) {
		System.out.println(name);
	}
}
