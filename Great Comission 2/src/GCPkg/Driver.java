package GCPkg;
import java.util.ArrayList;

public class Driver {
	
	public static void main(String[] args) {
		ArrayList<Generation> population = new ArrayList<Generation>();
		Generation startingGen = new Generation("start", 7700000000L, 13L, 18);
		population.add(startingGen);
		
		long totalPop = 7700000000L;
		long numDisciples = 13L;
		int year = 0;
		
		while(numDisciples < totalPop) {
			totalPop = 0;
			numDisciples = 0;
			for(int i = 0; i < population.size(); i++) {
				
				if(population.get(i).getAge() == 30) {//increase population
					Generation g = new Generation(null, population.get(i).getPopSize()/2, population.get(i).getNumDisciples() / 2);
					population.add(g);
					System.out.println("+++++NEW GENERATION CREATED!+++++");
				}
				
				if(population.get(i).getAge() >= 18	 &&  population.get(i).getAge() % 3 == 0) {//train new disciples after 3 yrs
					population.get(i).train(3);
				}
				
				if(population.get(i).getAge() == 72) {//
					population.remove(i);
					System.out.println("-----GENERATION HAS DIED!-----");
				}
				else {//figure out the total population by adding the population size of each generation
					totalPop += population.get(i).getPopSize();//do the same with number of disciples
					numDisciples += population.get(i).getNumDisciples();
				}
				population.get(i).getOlder();
				System.out.println(totalPop + " " + numDisciples);
			}
			year++;
		}
		
		System.out.println("The Great Comission will be hypothetically fulfilled after " + year + " years.");
	}
}
