package functionalInterface;

public class User {
	
	private String name;
	
	public User() {
		this("test");
	}
	
	public User(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
