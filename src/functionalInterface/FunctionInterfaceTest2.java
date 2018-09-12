package functionalInterface;

/**
 * Functional interfaces are those interfaces which have only one abstract method, it can have default methods, 
 * static methods and it can also override java.lang.Object class method.
 *
 */
public class FunctionInterfaceTest2 {
	
	@FunctionalInterface
	public interface Decorable {
	 
	 // one abstract method
	 void decorateWithCurtains();
	 
	 // default method
	 default void decorateWithPaints(){
	  	System.out.println("Decorating using paints");
	 }
	 
	 // Overriding method of java.lang.Object
	 @Override
	 public int hashCode();
	}
	
	public static void main(String[] args) {
        // Using lambda expression
		Decorable dec = ()-> {System.out.println("Decorating with curtains");};
		dec.decorateWithCurtains();
	}
}