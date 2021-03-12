package array2D;

public class EvenMoreWith2dArrays {
	//Easy1
	public void combined (char [][]arr) {
		String word="";
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[i].length;j++) {
				word+=arr[i][j];
			}
		}
		System.out.println(word);
	}
	
	//Easy2
	public void diagonal(int n) {
		int [][]arr= new int[n][n];
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				if (i==j) {
					arr[i][j]=n;
				}
				else if (i+j==arr.length-1) {
					arr[i][j]=n;
				}
			}
		}
		display (arr);
	}
	
	//Medium1
	public void triangle (int n) {
		int count=1;
		int[][]arr= new int[n+1][];
		for (int i=0;i<n+1;i++) {
			arr[i]= new int [i];
			for (int j=0;j<i;j++) {
				arr[i][j]=count;
				count++;
			}
		}
		display (arr);
	}
	
	//Medium2
	public void addZero (int [][]arr) {
		int [][]arr2= new int [arr.length][];
		for (int i=0;i<arr.length;i++) {
			arr2[i]=new int [arr[i].length*2];
			for (int j=0;j<arr[i].length;j++) {
				if (j%2!=0) {
					arr2[i][j]=0;
				}
				else {
					arr2[i][j]=arr[i][j/2];
				}
			}
		}
		display (arr2);
	}
	
	//Medium3
	public void flipRows (double [][]arr) {
		double repeated=0;
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[i].length/2;j++) {
				repeated =arr[i][j];
				arr[i][j]=arr[i][arr[i].length-j-1];
				arr[i][arr[i].length-j-1]=repeated;
			}
		}
		display (arr);
	}
	
	//Hard1
	public void sumColumn (int [][]arr) {
		int longestColumn = 0;
		for (int i=0;i<arr.length;i++) {
			if (longestColumn<arr[i].length) {
				longestColumn= arr[i].length;
			}
		}
		int []sumColumn = new int [longestColumn];
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[i].length;j++) {
				sumColumn[j]+=arr[i][j];
			}
		}
		display (sumColumn);
	}
	
//	//Challenge
//	public void sort(int [][]arr) {
//		int position=0;
//		int mini= 0;
//		int minj=0;
//		int minimum=arr[0][0];
//		
//		for (int i=0;i<arr.length;i++) {
//			for (int j=0;j<arr[i].length;j++) {
//				for (int z=0;z;z++) {
//					if (minimum>arr[i][j]) {
//						minimum=arr[i][j];
//						mini=i;
//						minj=j;
//					}
//				}
//			}
//			
//		}
//	}
	
//	public void snake (int [][]arr) {
//		boolean sorted=false;
//		int repeated=arr[0][0];
//		while (sorted==false) {
//			for (int i=0;i<arr.length;i++) {
//				if (i%2==0) {
//					for (int j=0;j<arr[i].length;j++) {
//						if (arr[i+1][j]<arr[i][j]) {
//							repeated=arr[i][j];
//							arr[i][j]=arr[i+1][j];
//							arr[i+1][j]=repeated;
//						}
//					}
//				}
//				else {
//					for (int j=arr[i].length-1;j>=0;j--) {
//						if (arr[i][j]<arr[i+1][j]) {
//							repeated=arr[i][j];
//							arr[i][j]=arr[i+1][j];
//							arr[i+1][j]=repeated;
//						}
//					}
//				}
//			}
//		}
//	}
	
	public void display(int[]arr) {
		for (int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public void display (int [][]arr) {
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void display (double [][]arr) {
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String [] args) {
		EvenMoreWith2dArrays a= new EvenMoreWith2dArrays();
		char [][]arr1= {
				{'s','t','r'},
				{'a','w'},
				{'b','e','r','r','y'}
		};
		int [][]arr2= {
				{1,2,3,4},
				{1,2},
				{3,4,5}
				
		};
		
		double [][]arr3= {
				{5,4,3,2},
				{1,0,-1,0},
				{-2,-1,0}
		};
		
		//a.combined (arr1);
		//a.diagonal(6);
		//a.triangle (4);
		//a.addZero(arr2);
		//a.flipRows(arr3);
		//a.sumColumn(arr2);
		//a.sort(arr2);
	}
}
