package pkg;

public class Driver {

	public static void main(String[] args) {
		int[] grandArray = new int[10000];
		int[] copy1 = new int [10000];
		int[] copy2 = new int [10000];
		int[] copy3 = new int [10000];
		int[] copy4 = new int [10000];
		for(int i = 0; i < 10000; i++) {
			grandArray[i] = (int)((Math.random() * 10));
			copy1[i] = (int)((Math.random() * 10));
			copy2[i] = (int)((Math.random() * 10));
			copy3[i] = (int)((Math.random() * 10));
			copy4[i] = (int)((Math.random() * 10));
		}
		
		double avgTimeBubble = 0;
		double avgTimeSelection = 0;
		double avgTimeInsertion = 0;
		double avgTimeShell = 0;
		double avgTimeQuick = 0;
		
		for(int i = 0; i < 300; i++) {
			
		double startTime = System.currentTimeMillis();
		sort_bubble(grandArray);
		double endTime = System.currentTimeMillis();
		avgTimeBubble += (endTime - startTime);
		
		startTime = System.currentTimeMillis();
		sort_selection(copy1);
		endTime = System.currentTimeMillis();
		avgTimeSelection += (endTime - startTime);
		
		startTime = System.currentTimeMillis();
		sort_insertion(copy2);
		endTime = System.currentTimeMillis();
		avgTimeInsertion += (endTime - startTime);

		startTime = System.currentTimeMillis();
		sort_shell(copy4);
		endTime = System.currentTimeMillis();
		avgTimeShell += (endTime - startTime);

		startTime = System.currentTimeMillis();
		sort_quick(copy4, 0, copy4.length-1);
		endTime = System.currentTimeMillis();
		avgTimeQuick += (endTime - startTime);
		}
		
		avgTimeBubble /= 300;
		avgTimeSelection /= 300;
		avgTimeInsertion /= 300;
		avgTimeShell /= 300;
		avgTimeQuick /= 300;
		
		System.out.println("The average time for bubble sort was " + avgTimeBubble + "ms.");
		System.out.println("The average time for selection sort was " + avgTimeSelection + "ms.");
		System.out.println("The average time for insertion sort was " + avgTimeInsertion + "ms.");
		System.out.println("The average time for shell sort was " + avgTimeShell + "ms.");
		System.out.println("The average time for quick sort was " + avgTimeQuick + "ms.");

		
	}
	
	public static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(i % 100 == 0) {
				System.out.println();
			}
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	//this function is used to swap the elements of an array
	//given an array and the two indices whose contents need to be swapped
	public static void swapElements(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	public static int partition(int[] arr, int low, int high) {
	/*
	 * 	pivot is the midpoint value
	 * while(!done)
	 * Look at left and rightmost values
	 * while(left value is less than pivot value, look at the next one)
	 * while(right value is greater than pivot value, look at the next one)
	 * if(low >= high) > done = true
	 * else > swap(high, low), high--, low++
	 * ==return high==
	 */
		int midpoint = low + (high-low)/2;
		int pivot = arr[midpoint];
		int left = low;
		int right = high;
		boolean done = false;
		//System.out.println("" + midpoint + pivot + left + right);
		
		while(!done) {
			while(arr[left] < pivot) {
				left++;
				//System.out.println("iterated left once");
			}
			while(arr[right] > pivot) {
				right--;
				//System.out.println("iterated right once");
			}
			if(left >= right) {
				done = true;
			}
			else {
				swapElements(arr, left, right);
				//System.out.println("Swap successful");
				left++;
				right--;
			}
		}
		//printArray(arr);
		return right;
	}
	
	
	//Bubble Sort algorithm
	public static void sort_bubble(int[] arr) {
		int swapCount = 0;//counts the number of swaps during algorithm
		for(int i = 1; i < arr.length-1; i++) {
			for(int j = 0; j < arr.length -i; j++) {
				if(arr[j] > arr[j+1]) {//if first element is greater than second,
					swapElements(arr, j, j+1);//swap them
					swapCount++;
				}
			}
		}
		//System.out.println("Finished! Number of swaps: " + swapCount);
	}
	
	//Selection Sort algorithm
	public static void sort_selection(int[] arr) {
		int swapCount = 0;
		int smallestIndex = 0;//used to hold the index of smallest value
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j] < arr[smallestIndex])//if smaller than the current smallest index,
					smallestIndex = j;//then replace smallest index with current
			}
			swapElements(arr, i, smallestIndex);//always swaps the current index "i" with smallest number
			swapCount++;//this process begins at the front-end of the array
		}
		//System.out.println("Finished! Number of swaps: " + swapCount);
	}
	
	public static void sort_insertion(int[] arr) {
		int swapCount = 0;
		for(int i = 1; i < arr.length; i++) {
			int j = i-1;
			while(j > 0 && arr[j] < arr[j-1]) {
				swapElements(arr, j, j-1);
				swapCount++;
				j--;
			}
		}		
		//System.out.println("Finished! Number of swaps: " + swapCount);
	}
	
	public static void sort_shell(int[] arr) {
		int swapCount = 0;
		for(int gap = (int)(Math.sqrt(arr.length)) -1; gap > 0; gap--) {
			for(int i = gap; i < arr.length; i++) {
				int j = i;
				while(j >= gap && arr[j] < arr[j-gap]) {
					swapElements(arr, j, j-gap);
					swapCount++;
					j-=gap;
				}
			}
		}
		//System.out.println("Finished! Number of swaps: " + swapCount);
	}
	
	public static void sort_quick(int[] arr, int startIndex, int endIndex) {
		if(endIndex <= startIndex)
			return;
		int high = partition(arr, startIndex, endIndex);
		sort_quick(arr, startIndex, high);
		sort_quick(arr, high+1, endIndex);
	}
}