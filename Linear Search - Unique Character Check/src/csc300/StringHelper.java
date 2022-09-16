package csc300;

public class StringHelper {
	
	/*inspect the first character
	 * using a for loop, compare all subsequent characters with said char
	 * if there is a match, break out of the loop and return false
	 * if there is not a match, move onto the next char in the string and repeat
	 * 
	 */
	public static boolean noDuplicateChars(String phrs) {
		phrs = phrs.toLowerCase(); //upper case have different unicode
		for(int i = 0; i < phrs.length(); i++) {
			for(int j = i + 1; j < phrs.length(); j++) {
				if(phrs.charAt(i) == phrs.charAt(j))
					return false;
			}
		}
		return true;
	}
}
