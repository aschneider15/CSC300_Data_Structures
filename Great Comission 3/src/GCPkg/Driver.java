package GCPkg;
import java.util.ArrayList;
/*
 * the objective for the third portion of the Great Commission assignment is
 * to figure out a potential factor which would explain why, after 2000 years,
 * Christ's commission has still not been fulfilled. 
 * 
 * Since only an estimated 33%
 * of the population in current day believes in Christianity, I decided to include
 * a randomness factor into the conversion process:
 * For each time a conversion is attempted, a random integer between
 * zero and eight will be generated. If the number is zero, then the conversion is to
 * be considered a success. Otherwise, the conversion will be a failure. 
 */

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
					//System.out.println("+++++NEW GENERATION CREATED!+++++");
				}
				
				if(population.get(i).getAge() >= 18	 &&  population.get(i).getAge() % 3 == 0) {//train new disciples after 3 yrs
					int rndm = (int)(Math.random()*9);
					if(rndm == 0) {
						population.get(i).train(3);
					}
				}
				
				if(population.get(i).getAge() == 72) {//
					population.remove(i);
					//System.out.println("-----GENERATION HAS DIED!-----");
				}
				else {//figure out the total population by adding the population size of each generation
					totalPop += population.get(i).getPopSize();//do the same with number of disciples
					numDisciples += population.get(i).getNumDisciples();
				}
				population.get(i).getOlder();
				//System.out.println(totalPop + " " + numDisciples);
			}
			year++;
		}
		
		System.out.println("The Great Comission will be hypothetically fulfilled after " + year + " years.");
	}
}
