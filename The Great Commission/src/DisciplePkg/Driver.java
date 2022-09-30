package DisciplePkg;

public class Driver {
	public static void main(String[] args) {
		long numDisciples = 13;
		long totalPopulation = 7700;
		totalPopulation *= 1000000;
		
		System.out.println(howManyYears(numDisciples, totalPopulation));
		System.out.println(howManyYears50(numDisciples, totalPopulation));

		
	}
	
	public static int howManyYears(long initialDisciples, long totalPop) {
		int years = 0;
		while(initialDisciples < totalPop) {
			initialDisciples *=3;
			years += 3;
		}
		return years;
	}
	
	public static int howManyYears50(long initialDisciples, long totalPop) {
		int years = 0;
		while(initialDisciples < totalPop) {
			initialDisciples *=4;
			years += 3;
		}
		return years;
	}
}
