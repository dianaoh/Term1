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
	public void diagnoal(int n) {
		int [][]arr= new int[n][n];
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[i].length;j++) {
				if (i==j) {
					arr[i][j]=n;
				}
				else if (i+j==arr.length-1) {
					arr[i][j]=n;
				}
			}
		}
	}
	
	//Medium1
	public void triangle (int n) {
		for (int i=0;i<n;i++) {
			for (int j=0;j<i;j++) {
				
			}
		}
	}
}
