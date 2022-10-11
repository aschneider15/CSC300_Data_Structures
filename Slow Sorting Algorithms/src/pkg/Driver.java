package pkg;

public class Driver {

	public static void main(String[] args) {
		int[] list0 = new int[] {9, 5, 1, 3, 5, 7, 22, 4, 18, 7, 14, 20, 0, 38, 2, 17};
		int[] list1 = new int[] {9, 5, 1, 3, 5, 7, 22, 4, 18, 7, 14, 20, 0, 38, 2, 17};
		int[] list2 = new int[] {9, 5, 1, 3, 5, 7, 22, 4, 18, 7, 14, 20, 0, 38, 2, 17};
		int[] list3 = new int[] {9, 5, 1, 3, 5, 7, 22, 4, 18, 7, 14, 20, 0, 38, 2, 17};
		
		printArray(list0);
		sort_bubble(list0);
		printArray(list0);
		
		System.out.println();
		
		printArray(list1);
		sort_selection(list1);
		printArray(list1);
		
		System.out.println();
		
		printArray(list2);
		sort_insertion(list2);
		printArray(list2);
		
		System.out.println();
		
		printArray(list3);
		sort_shell(list3);
		printArray(list3);
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
		int swapCount = 0;//counts the number of swaps during algorithm
		for(int i = 1; i < arr.length-1; i++) {
			for(int j = 0; j < arr.length -i; j++) {
				if(arr[j] > arr[j+1]) {//if first element is greater than second,
					swapElements(arr, j, j+1);//swap them
					swapCount++;
				}
			}
		}
		System.out.println("Finished! Number of swaps: " + swapCount);
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
		System.out.println("Finished! Number of swaps: " + swapCount);
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
		System.out.println("Finished! Number of swaps: " + swapCount);
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
		System.out.println("Finished! Number of swaps: " + swapCount);
	}
}