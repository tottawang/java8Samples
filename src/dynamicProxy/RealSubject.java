package dynamicProxy;

public class RealSubject implements Subject {
	
	@Override
	public void doSomething(String arg) {
		System.out.println("hello " + arg);
	}

}
