package csc300;
import csc300.Chaining.*;
import csc300.OpenAddressing.*;
import java.lang.Math;

public class Driver {
	
	public static void main(String[] args) throws Exception {
		Danny danny = new Danny();
		Steve steve = new Steve();
		//fill danny and steve with a lot of numbers
		for(int i = 0; i < 10000; i++) {
			String keyvalue = "" + (int)(Math.random()*1000000);
			System.out.println(keyvalue);
			
			danny.Add(keyvalue, keyvalue);
				steve.HashInsert(keyvalue, keyvalue);
		}
		System.out.println("============");
		//now search for danny and steve for 100 random keys
		String[] randomKeys = new String[100];
		for(int i = 0; i < randomKeys.length; i++) {
			randomKeys[i] = "" + (int)(Math.random()*1000000);
		}
		//searching danny
		long initialTime = System.nanoTime();
		for(String key : randomKeys) {
			HashNode output = danny.Get(key);
			if(output != null) {
				System.out.println(" +++ " + key + " is located at bucket " + output.Code);
			} else {
				System.out.println(key + " is not within the HashTable.");
			}
		}
		long dannyFinalTime = System.nanoTime() - initialTime;
		System.out.println("============ \n Danny's time spent: " + dannyFinalTime + "ns");
		
		//searching steve
		initialTime = System.nanoTime();
		for(String key : randomKeys) {
			HashNodeOpen output = steve.Get(key);
			if(output != null) {
				System.out.println(" +++ " + key + " is located at bucket " + output.Code);
			} else {
				System.out.println(key + " is not within the HashTable.");
			}
		}
		long steveFinalTime = System.nanoTime() - initialTime;
		System.out.println("============ \n Steve's time spent: " + steveFinalTime + "ns");
		
		//compare danny and steve final times
		System.out.println("\n======================== \n ========================");
		System.out.println("Steve Final Time: " + steveFinalTime + "\tDanny Final Time: " + dannyFinalTime);
		System.out.println("Danny is " + (long)(dannyFinalTime - steveFinalTime) + "faster than Steve.");
	}
}
