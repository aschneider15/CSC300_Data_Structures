package pkg;

public class Driver {

	public static void main(String[] args) {
		int[] bubble = new int[] {8, 3, 9, 5, 1, 7, 2, 6, 0, 4};
		int[] select = new int[] {4, 2, 7, 5, 3, 9, 6, 0, 8, 1};
		int[] insert = new int[] {6, 1, 9, 0, 7, 2, 3, 7, 4, 5};
		int[] shella = new int[] {9, 5, 1, 3, 5, 7, 22, 4, 18, 7, 14, 20, 0, 38, 2, 17};
		
		printArray(bubble);
		sort_bubble(bubble);
		printArray(bubble);
		
		System.out.println();
		
		printArray(select);
		sort_selection(select);
		printArray(select);
		
		System.out.println();
		
		printArray(insert);
		sort_insertion(insert);
		printArray(insert);
		
		printArray(shella);
		sort_shell(shella);
		printArray(shella);
	}
	
	public static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
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
	//Bubble Sort algorithm
	public static void sort_bubble(int[] arr) {
		int comparisonCount = 0;//counts the number of comparisons made during sorting
		int swapCount = 0;//counts the number of swaps during algorithm
		for(int i = 1; i < arr.length-1; i++) {
			for(int j = 0; j < arr.length -i; j++) {
				comparisonCount++;
				if(arr[j] > arr[j+1]) {//if first element is greater than second,
					swapElements(arr, j, j+1);//swap them
					swapCount++;
				}
			}
		}
		System.out.println("Finished! Number of Comparisons: " + comparisonCount 
											+ "\tNumber of swaps: " + swapCount);
	}
	
	//Selection Sort algorithm
	public static void sort_selection(int[] arr) {
		int comparisonCount = 0;
		int swapCount = 0;
		int smallestIndex = 0;//used to hold the index of smallest value
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = i+1; j < arr.length; j++) {
				comparisonCount++;
				if(arr[j] < arr[smallestIndex])//if smaller than the current smallest index,
					smallestIndex = j;//then replace smallest index with current
			}
			swapElements(arr, i, smallestIndex);//always swaps the current index "i" with smallest number
			swapCount++;//this process begins at the front-end of the array
		}
		System.out.println("Finished! Number of Comparisons: " + comparisonCount 
				+ "\tNumber of swaps: " + swapCount);	
	}
	
	public static void sort_insertion(int[] arr) {
		int comparisonCount = 0;
		int swapCount = 0;
		for(int i = 1; i < arr.length; i++) {
			int j = i-1;
			while(j > 0 && arr[j] < arr[j-1]) {
				comparisonCount++;
				swapElements(arr, j, j-1);
				swapCount++;
				j--;
			}
		}		
		System.out.println("Finished! Number of Comparisons: " + comparisonCount 
				+ "\tNumber of swaps: " + swapCount);
	}
	
	public static void sort_shell(int[] arr) {
		int comparisonCount = 0;
		int swapCount = 0;
		for(int gap = (int)(Math.log(arr.length) / Math.log(2)) -1; gap > 0; gap--) {
			for(int i = gap; i < arr.length; i++) {
				int j = i;
				comparisonCount++;
				while(j >= gap && arr[j] < arr[j-gap]) {
					swapElements(arr, j, j-gap);
					swapCount++;
					j-=gap;
				}
			}
		}
		System.out.println("Finished! Number of Comparisons: " + comparisonCount 
				+ "\tNumber of swaps: " + swapCount);
	}
}