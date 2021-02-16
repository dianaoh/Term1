package array2D;

public class MoreWith2dArrays {
	
	public void display (int [][]arr) {
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]);
				
			}System.out.println();
		}
	}

	public void display (char [][]arr) {
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]);
				
			}System.out.println();
		}
	}
	
	//Question 1
	public void fill (int n) {
		int count=1;
		int[][] arr = new int [n][n];
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr.length;j++) {
				arr[i][j]=count;
				count++;
			}
		}
		display (arr);
	}
	
	//Question 2
	public void max (double [][]arr) {
		double max = arr[0][0];
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[i].length;j++) {
				if (max<arr[i][j]) {
					max=arr[i][j];
				}
			}
		}
		System.out.println(max);
	}
	
	//Question 3
	public void sum (int[][]arr) {
		int sum=0;
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[i].length;j++) {
				sum+= arr[i][j];
			}
		}
		System.out.println(sum);
	}
	
	//Question 4
	public void sumRows (int[][]arr) {
		int []arr1=new int[arr.length];
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[i].length;j++) {
				arr1[i]+=arr[i][j];
			}
		}
		
		for (int i=0;i<arr.length;i++) {
			System.out.print(arr1[i]+" ");
		}
	}
	
	//Hard
	public void magic (int[][]arr) {
		int magicNum = 0;
		for (int i=0;i<arr.length;i++) {
			arr[i][0]=magicNum;
		}
		
		int diagonal1=0, diagonal2=0;
		int rows=0;
		int columns=0;
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[i].length;j++) {
				if (i==j) {
					diagonal1+=arr[i][j];
				}
				
				if (arr.length==i+j) {
					diagonal2+=arr[i][j];
				}
				rows+=arr[i][j];
				
			}
			
		}
	}
	
	public void boxMax(int [][]arr) {
		int currentSum=arr[0][0];
		int maxSum=arr[0][0];
		int currentTopLeft=arr[0][0];
		int maxTopLeft=arr[0][0];
		for (int i=0;i<arr.length-4;i++) {
			for (int j=0;j<arr.length-4;j++) {
				for (int z=i;z<i+3;z++) {
					for (int g=j;g<j+3;j++) {
						currentSum+=arr[z][j];
						currentTopLeft=arr[i+2][j];
					}
				}
				if (maxSum<currentSum) {
					maxSum=currentSum;
					maxTopLeft=currentTopLeft;
				}
			}
		}
		System.out.println(maxTopLeft);
	}
	
	public static void main(String[]args) {
		MoreWith2dArrays a= new MoreWith2dArrays ();
		int [][]arr1= new int [2][3];
		double [][]arr2= {{1,2},{-1,-3},{1.5,2.5}};
		int [][]arr3= {{1},{2},{3},{4,5,6}};
		int [][]arr= {
				{1,2,3,4,5,5},
				{3,2,3,1,3,5},
				{0,-1,6,4,9,3},
				{12,31,23,1,2}
		};
		//a.fill(6);
		//a.max(arr2);
		//a.sum(arr3);
		//a.sumRows(arr3);
		a.boxMax(arr);
		
		
	}
}
