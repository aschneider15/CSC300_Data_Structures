package LinSear;
public class Driver {

	public static void main(String[] args) {
		String phrase = "In the beginning, God created the heavens and the earth";
		String key = "the";
		int count = countAppearanceOfSubstring(phrase, key);
		
		System.out.print("The word " + "'" + key + "'" +  " appears in the phrase " + count + " times.");
	}
	
	/*
	 *input: String phrase, sub-string of word we are looking for
	 *output: the number of times the sub-string appears in the given phrase
	 *
	 *outline:
	 *	setup: make the whole thing lower case, replace any non-letters with spaces
	 *	parse the phrase string into an array list of sub-strings
	 *	create a counter variable
	 *	go through the array list and compare each string to the key
	 *		if they match, good: increase counter
	 *		else, oh well. Has it tried sucking less?
	 *	return the final result of counter
	 */
	public static int countAppearanceOfSubstring(String phrase, String key) {
		String[] List;
		String temp = "";
		int counter = 0;
		phrase = phrase.toLowerCase();
		key = key.toLowerCase();
		for(int i = 0; i < phrase.length(); i++) {
			if(phrase.charAt(i) < 'a' || phrase.charAt(i) > 'z') { 
				phrase = phrase.replace(phrase.charAt(i), ' ');
			}
		}
		//System.out.println(phrase);
		
		List = phrase.split(" ");
		for(int i = 0; i < List.length; i++) {
			if(List[i].equals(key))
				counter++;
		}
		
		return counter;
	}
}
