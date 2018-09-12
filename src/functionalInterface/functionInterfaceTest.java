package functionalInterface;


/**
 * A functional interface is an interface with one abstract method and used as the type of a lambda expression.
 *
 */
public class functionInterfaceTest {
	
	
    /**
     * We can assign lambda expression to its functional interface instance
     * </br>
     * (String str) -> str.length() takes a String parameter and returns its length
     */
    private static FunctionProcesser processor = str -> str.length();
	
	public static void main(String[] args) {
		System.out.println(processor.getStringLength("myname"));
	}
		
	@FunctionalInterface
	public interface FunctionProcesser {
		int getStringLength(String str);
	}
}
