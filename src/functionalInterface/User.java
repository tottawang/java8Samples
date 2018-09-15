package functionalInterface;

public class User {
	
	private String name;
	
	public User() {
		this.name = "test";
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
