package array;

public class ArrayPractice {
	//Display
	public void display (int []arr) {
		for (int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	//Easy 1
	public void average (double []arr) {
		double sum=0;
		for (int i=0;i<arr.length;i++) {
			sum+=arr [i];
		}
		System.out.println(sum/arr.length);
	}
	//Easy 2
	public void posNeg (int []arr) {
		String [] determinant = new String[arr.length];
		for (int i=0;i<arr.length;i++) {
			if (arr[i]>0) {
				determinant[i]="pos";
			}
			else {
				determinant[i]="neg";
			}
		}
		
		for (int i=0;i<determinant.length;i++) {
			System.out.print(determinant[i]+" ");
		}
	}
	//Easy 3
	public void merge (int[]arr,int []arr1) {
		int [] array = new int [arr.length+arr1.length];
		for (int i=0;i<array.length;i++) {
			if (i<arr.length) {
				array[i]=arr[i];
			}
			else {
				array[i]=arr1[i-arr.length];
			}
		}
		display (array);
	}
	
	//Easy 4
	public void find (char []arr,char c) {
		boolean x=false;
		for (int i=0;i<arr.length;i++) {
			if (arr[i]==c) {
				System.out.println("contains");
				x=true;
			}
		}
		if (x==false) {
			System.out.println("does not contain");
		}
	}
	
	//Easy 5
	public void index (String []arr, String word) {
		boolean x=false;
		for (int i=0;i<arr.length;i++) {
			if (arr[i].equals (word)) {
				System.out.println(i);
				x=true;
			}
		}
		if (x==false) {
			System.out.println(-1);
		}
	}
	
	//Hard1
	public void common (int[]arr,int []arr1) {
		for (int i=0; i<arr.length;i++) {
			for (int j=0;j<arr1.length;j++) {
				if (arr[i]==arr1[j]) {
					System.out.print(arr[i]+" ");
				}
			}
		}
	}
	
	//Hard2
	public void holdDigit (int x) {
		int [] digits = new int [String.valueOf(x).length()];
		for (int i=digits.length-1;i>=0;i--) {
			digits [i]=x%10;
			x/=10;
		}
		display (digits);
	}
	
	//Hard3
	public void noDuplicates (int []arr) {
		int count=0;
		for (int i=0;i<arr.length;i++) {
			for (int j=i+1;j<arr.length;j++) {
				if (arr[i]==arr[j]) {
					count++;
				}
			}
		}
		
		int [] simplified1 = new int [arr.length];
		for (int i=0;i<arr.length;i++) {
			boolean isNotDuplicate = true; 
			for (int j=i+1;j<arr.length;j++) {
				if (arr [i]== arr[j]) {
					isNotDuplicate=false;
				}
			}
			if (isNotDuplicate) {
				simplified1[i]=arr[i];
			}
		}
		int count2=0;
		int [] simplified2 = new int [arr.length-count];
		for (int j=0;j<arr.length;j++) {
			if (simplified1[j]!=0) {
				simplified2 [count2]=simplified1[j];
				count2++;
			}
		}

		display (simplified2);
	}
	public static void main(String []args) {
		ArrayPractice a = new ArrayPractice();
		double []arr= {1.0,2.0,3.0,4.0};
		int [] arr1= {-1,2,-3,-2,1};
		int [] arr2 = {2,1,9,-1};
		int [] arr3= {5,3,5,7,2,3};
		char [] arr4= {'a','b','c','d'};
		//a.average(arr);
		//a.posNeg(arr1);
		//a.merge(arr1, arr2);
		//a.find(arr4, 'c');
		//a.common(arr1,arr2);
		//a.holdDigit(39782);
		a.noDuplicates (arr3);
		
	}
}
