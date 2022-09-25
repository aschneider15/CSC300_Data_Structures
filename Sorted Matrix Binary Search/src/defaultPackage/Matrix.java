package defaultPackage;

public class Matrix {

	private int columnSize;
	private int rowSize;
	private int startingNum = 0;
	private int[][] matrix;
	
	public Matrix(int columnSize, int rowSize) {
		this.rowSize = rowSize;
		this.columnSize = columnSize;
		this.matrix = new int[this.columnSize][this.rowSize];
		this.fillMatrix();
	}
	public Matrix(int columnSize, int rowSize, int startingNum) {
		this.rowSize = rowSize;
		this.columnSize = columnSize;
		this.matrix = new int[this.columnSize][this.rowSize];
		this.startingNum = startingNum;
		this.fillMatrix();
	}
	
	public void fillMatrix() {
		int count = this.startingNum;
		for(int i = 0; i < this.columnSize; i++) {
			for(int j = 0; j < this.rowSize; j++) {
				this.matrix[i][j] = count;
				count++;
			}
		}		
	}
	
	public void printMatrix() {
		for(int i = 0; i < this.columnSize; i++) {
			System.out.print("[");
			for(int j = 0; j < this.rowSize; j++) {
				System.out.print("[" + this.matrix[i][j] + "], ");
			}
			System.out.println("]");
		}
	}
	
	public int[] rowRange(int columnNum) {
		int low = this.matrix[columnNum][0];
		int high = this.matrix[columnNum][this.matrix[columnNum].length -1];
		int[] range = new int[] {low, high};
		return range;
	}
	
	public int[] locateKey(int key) {
		/*
		 * start in middle column
		 * ----------------------
		 * if key > max of row,
		 * 		low = med + 1
		 * 		derive med
		 * else if key < min of row
		 * 		high = med - 1
		 * 		derive med
		 * else
		 * 		begin binary search in column
		 */
		int[] output = new int[] {-1, -1};
		int low = 0;
		int high = this.columnSize -1;
		int med = (high + low)/2;
		
		
		while(med >= low && med <= high) {
			if(key < this.rowRange(med)[0]) {
				high = med -1;
			}
			else if(key > this.rowRange(med)[1]) {
				low = med +1;
			}
			else {
				int columnNum = med;
				low = 0;
				high = this.rowSize;
				med = (high + low)/2;
				System.out.println();
				
				while(med >= low && med <= high) {
					if(key < this.matrix[columnNum][med]) {
						high = med -1;
					}
					else if(key > this.matrix[columnNum][med]) {
						low = med +1;
					}
					else {
						output[0] = columnNum;
						output[1] = med;
						System.out.println("location of " + key + ": [" + output[0] + ", " + output[1] + "]");
						break;
					}
					med = (high + low)/2;
				}
				break;
			}
			med = (high + low)/2;
		}
		if(-1 == output[0] && -1 == output[1]) {
			System.out.println(key + " is not found within.");
		}
			return output;
	}
}
