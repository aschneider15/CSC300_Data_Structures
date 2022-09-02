/*
 * Aidan C. Schneider - September 2, 2022
 * for CSC 300: Data Structures (Prof. Yiming Liao)
 */
package defPackage;

public class Driver {

	public static void main(String[] args) {
		
		Salesman Adam = new Salesman("Adam", 12);
		Salesman Brian = new Salesman("Brian", 9);
		Salesman Chris = new Salesman("Chris", 16);
		Salesman David = new Salesman("David", 11);
		Salesman Eddie = new Salesman("Eddie", 7);
		
		Salesman[] array0 = new Salesman[] {Adam, Brian, Chris, David, Eddie};
		bubbleSort(array0); //order should be Eddie, Brian, David, Adam, Chris
		
		for(int i = 0; i < array0.length; i++) {
			System.out.println(array0[i].getName() + ": " + array0[i].getSales());
		}
	}
	
	public static void bubbleSort(Salesman[] in) {
		/*int temp = 0;
		 * for(length of array -1)
		 * 	look at element i and element i+1
		 * 	if i > i+1
		 * 		swap i and i+1
		 * 	increment i
		 * 
		 * repeat this process for the length of the array
		 */
		Salesman temp;
		
		for(int j = in.length; j > 0; j--) {
			for(int i = 0; i < in.length - 1; i++) {
				if(in[i].getSales() > in[i+1].getSales()) {
					temp = in[i];
					in[i] = in[i+1];
					in[i+1] = temp;
				}
			}
		}
	}
	
}