package functionalInterface;

import java.util.function.Supplier;

public class SupplierTest {
	
	public static void main(String[] args) {
		
		Supplier<User> user = User::new;
		System.out.println(user.get());
		
		Supplier<User> user2 = Factory::produceUser;
		System.out.println(user2.get());
		
		SupplierTest supplierTest = new SupplierTest();
		supplierTest.doProduceUser();
	}
	
	static class Factory {
		public static User produceUser() {
			return new User();
		}
	}
	
	public void doProduceUser() {
		Supplier<User> user = this::produceUser;
		System.out.println(user.get());
	}
	
	private User produceUser(){
		return new User();
	}
	 

}
