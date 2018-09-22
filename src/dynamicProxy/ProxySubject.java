package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxySubject implements InvocationHandler {
	
	private Object target;
	
	public ProxySubject(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("brfore call specific method >>" + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("after call specific method>>" + method.getName());
        return result;
	}

}
