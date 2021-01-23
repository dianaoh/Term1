package array;

public class ImportantArray {
	public void min(int []arr) {
		int min=Integer.MAX_VALUE;
		for (int i=0;i<arr.length; i++) {
			if (arr[i]<min) {
				min= arr[i];
			}
		}
		System.out.println(min);
	}
	
	public void average (int []arr) {
		int sum =0;
		for (int i=0;i<arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(sum/arr.length);
	}
	
	public void search (String []arr, String keyword) {
		boolean find =false;
		for (int i=0;i<arr.length;i++) {
			if (arr[i].equals (keyword)) {
				System.out.println(i);
				find = true;
			}
		}
		if (find==false) {
			System.out.println(-1);
		}
	}
	
	public void duplicates (int []arr1, int [] arr2) {
		for (int i=0;i<arr1.length;i++) {
			for (int j=0;j<arr2.length;j++) {
				if (arr2[j]==arr1[i]) {
					System.out.println();
				}
			}
		}
	}
	
	public void 
	public static void miain (String [] args) {
		ImportantArray a = new ImportantArray ();
		
	}
}
