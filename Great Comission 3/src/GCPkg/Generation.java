package GCPkg;

public class Generation {
	
	private String name;
	private long size;
	private long numDisciples;
	private int age = 0;
	
	public Generation(String name, long size, long startDisciples) {
		this.name = name;
		this.size = size;
		this.numDisciples = startDisciples;
	}
	
	public Generation(String name, long size, long startDisciples, int startAge) {
		this.name = name;
		this.size = size;
		this.numDisciples = startDisciples;
		this.age = startAge;
	}
	
	public long getPopSize() {
		return this.size;
	}
	
	public long getNumDisciples() {
		return this.numDisciples;
	}
	
	public void train(int yield) {
		this.numDisciples *= yield;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void getOlder() {
		this.age++;
	}
}
