package csc300;
import java.lang.Math;

public class Driver {
	
	public static void main(String[] args) {
		Danny danny = new Danny();
		//fill danny with a lot of numbers
		for(int i = 0; i < 10000; i++) {
			String keyvalue = "" + (int)(Math.random()*1000000);
			System.out.println(keyvalue);
			danny.Add(keyvalue, keyvalue);
		}
		System.out.println("============");
		//now search for 100 random keys
		long initialTime = System.nanoTime();
		for(int i = 0; i < 100; i++) {
			String randSearch = "" + (int)(Math.random()*1000000);
			HashNode output = danny.Get(randSearch);
			if(output != null) {
				System.out.println(" +++ " +randSearch + " is located at bucket " + output.Code);
			} else {
				System.out.println(randSearch + " is not within the HashTable.");
			}
		}
		long finalTime = System.nanoTime();
		System.out.println("============ \n Time spent: " + (finalTime - initialTime) + "ns");
	}
}
