package array2D;

public class Array2dIntro {
	//Quesiton 1
	//A. 6
	//B. 1
	//C. Index out of bounds
	//D. 3
	//E. 'k'
	//F. Index out of bounds
	//G. 203
	//H. 107
	//I. The position of the array stored in the computer
	
	//Question 2
	public void squareArray (int n) {
		int [][]arr= new int [n][n];
		display (arr);
	}
	
	//Question 3
	public void numColumns (int [][]arr) {
		System.out.println("columns: "+arr[0].length);
		System.out.println("rows: "+arr.length);
	}
	
	//Question 4
	public void newArray (int x1, int x2, int x3, int x4, int x5, int x6) {
		int [][]arr= 
		{	{x1},
			{x2,x3},
			{x4,x5,x6}
		};
		
		display(arr);
	}
	
	public void display (int [][]arr) {
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main (String args[]) {
		Array2dIntro a= new Array2dIntro ();
		int [][]arr= new int [1][2];
		a.squareArray(7);
		a.numColumns(arr);
		a.newArray(1, 2, 3, 4, 5, 6);
	}
}
