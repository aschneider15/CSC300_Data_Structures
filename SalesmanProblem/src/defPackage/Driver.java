/*Aidan C. Schneider - September 2, 2022
 * for CSC 300: Data Structures (Prof. Yiming Liao)
 */
package defPackage;

public class Driver {

	public static void main(String[] args) {
		
		Salesman Adam = new Salesman("Adam", 1200);
		Salesman Brian = new Salesman("Brian", 900);
		Salesman Chris = new Salesman("Chris", 1600);
		Salesman David = new Salesman("David", 1100);
		Salesman Eddie = new Salesman("Eddie", 700);
		Salesman Felix = new Salesman("Felix", 1400);
		
		Salesman[] array0 = new Salesman[] {Adam, Brian, Chris, David, Eddie, Felix};
		Salesman[] arrayResult = new Salesman[5];
		arrayResult = Salesman.topFive(array0);
		
		for(int i = 0; i < arrayResult.length; i++) {
			System.out.println(arrayResult[i].getName() + " total sales: " + arrayResult[i].getSales());
			//order should be Chris, Felix, Adam, David, Brian
		}
	}
}
