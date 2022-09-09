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
	
	public static Salesman[] topFive(Salesman[] in) {
		/*int temp = 0;
		 * for(length of array -1)
		 * 	look at element i and element i+1
		 * 	if i > i+1
		 * 		swap i and i+1
		 * 	increment i
		 * 
		 * repeat this process for the length of the array
		 */
		Salesman[] topFive = new Salesman[5];
		Salesman temp;
		
		for(int j = in.length; j > 0; j--) {
			for(int i = 0; i < in.length - 1; i++) {
				if(in[i].getSales() < in[i+1].getSales()) {
					temp = in[i];
					in[i] = in[i+1];
					in[i+1] = temp;
				}
			}
		}
		for(int i = 0; i < 5; i++) {
			topFive[i] = in[i];
		}
		return topFive;
	}

}
