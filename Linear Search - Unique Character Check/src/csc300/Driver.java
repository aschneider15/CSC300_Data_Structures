package csc300;

public class Driver {
	public static void main(String[] args) {
		String[] names = new String[8];
		names[0] = "David"; //f
		names[1] = "Michael"; //t
		names[2] = "James"; //t
		names[3] = "Jirard"; //f
		names[4] = "Evelyn"; //f
		names[5] = "Julia"; //t
		names[6] = "Rachel"; //t
		names[7] = "Nikki"; //f
		
		Boolean[] unique = new Boolean[8];
		
		for(int i = 0; i < names.length; i++) {
			unique[i] = StringHelper.noDuplicateChars(names[i]);
			System.out.println(names[i] + ": " + unique[i]);
		}
	}
}
