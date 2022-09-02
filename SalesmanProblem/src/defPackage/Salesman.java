package defPackage;

public class Salesman {
	
	private String name;
	private int salesTotal;
	
	public Salesman(String name, int salesTotal) {
		this.name = name;
		this.salesTotal = salesTotal;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public int getSales() {
		return this.salesTotal;
	}
	
	public void setSales(int salesTotal) {
		this.salesTotal = salesTotal;
	}

}
