package dynamicProxy;

import java.lang.reflect.Proxy;

public class Test {
	
	public static void main(String[] args) {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true"); 
	    Subject subject2 = (Subject)Proxy.newProxyInstance(Test.class.getClassLoader(),
	                         new Class[]{Subject.class}, new ProxySubject(new RealSubject()));	    
	    subject2.doSomething("proxy");
	}

}
