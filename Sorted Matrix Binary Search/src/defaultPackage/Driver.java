/*Aidan Schneider - CSC 300
 *September 24, 2022
 */
package defaultPackage;

public class Driver {
	
	
	public static void main(String[] args) { 
		
		Matrix mat = new Matrix(10, 10, 33);
		mat.printMatrix();
		mat.locateKey(69);
		mat.locateKey(-22);
		mat.locateKey(141);
	}		
}
