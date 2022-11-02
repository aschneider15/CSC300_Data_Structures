package pkg;

public class Driver {

	public static void main(String[] args) {
		int[] inArr = new int[10000];
		for(int i = 0; i < inArr.length; i++) {
			inArr[i] = (int)(Math.random()*10);
		}
		long start = System.currentTimeMillis();
		mergeSort(inArr, 0, inArr.length -1);
		long end = System.currentTimeMillis();
		System.out.println("resulting time: " + (end-start) + "ms.");
	}
	
	public static void mergeSort(int[] numbers, int i, int k) {
	      int j = 0;
	      
	      if (i < k) {
	         j = (i + k) / 2;  //midpoint

	         mergeSort(numbers, i, j); //call itself for left partition
	         mergeSort(numbers, j + 1, k); //call itself for right partition
	            
	         // Merge left and right partition in sorted order
	         mergeHelper(numbers, i, j, k);
	      }
	   }
	
	/*
	 * declare a new array of same size for output
	 */
	public static void mergeHelper(int[] arr, int i, int j, int k) {
		int[] outArray = new int[arr.length];
		int outSize = k - i + 1;
		
		int mergePos = 0;
	    int leftPos = i;
	    int rightPos = j + 1;
		
	    while (leftPos <= j && rightPos <= k) { //look for the smallest element between partitions
	         if (arr[leftPos] <= arr[rightPos]) {
	            outArray[mergePos] = arr[leftPos];
	            leftPos++;
	         }
	         else {
	            outArray[mergePos] = arr[rightPos];
	            rightPos++;
	         }
	         mergePos++;
	      }
	    
	    while (leftPos <= j) { //dump the remaining left partition
	         outArray[mergePos] = outArray[leftPos];
	         leftPos++;
	         mergePos++;
	      }
	    
	    while (rightPos <= k) { //dump the remaining right partition
	         outArray[mergePos] = outArray[rightPos];
	         rightPos++;
	         mergePos++;
	      }
	    
	    for (mergePos = 0; mergePos < outSize; mergePos++) { //replace the original array's contents with the merged
	         arr[i + mergePos] = outArray[mergePos];
	      }
	}
	
	public static void printArray(int[] arr) {
		System.out.print("");
		for(int i = 0; i < arr.length -1; i++) {
			for(int j = 0; j < 100; j++) {
				System.out.print(arr[i] + " ");
				i++;
			}
			System.out.println();
		}
		System.out.print("");
	}
}
