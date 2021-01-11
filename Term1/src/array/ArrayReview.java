package array;

public class ArrayReview {
	//Easy1
	public void printString (String []arr) {
		for (int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
	}
	
	//Easy2
	public void toN (int n) {
		int [] arr= new int [n];
		for (int i=0;i<arr.length;i++) {
			arr[i]=i+1;
		}
		print (arr);
	}
	
	//Easy3
	public void average (int arr[]) {
		double sum=0;
		for (int i=0;i<arr.length;i++) {
			sum= sum + arr[i];
		}
		System.out.println(sum/arr.length);
	}
	
	public void doubles (int [] arr) {
		for (int i=0;i<arr.length;i++) {
			arr[i]*=2;
		}
		print (arr);
	}
	
	//Medium1
	public void takeaway(int arr[]) {
		int max= Integer.MIN_VALUE;
		int min= Integer.MAX_VALUE;
		int []trim= new int [arr.length-2];
		for (int i=0;i<arr.length;i++) {
			if (max<arr[i]) {
				max= arr[i];
			}
			if (min>arr[i]) {
				min= arr[i];
			}
		}
		int j=0;
		for (int i=0;i<arr.length;i++) {
			if (arr[i]!=max && arr[i]!=min) {
				trim[j]=arr[i];
				j++;
			}
		}
		print (trim);
	}
	
	//Medium2
	public void fibonacci (int n) {
		int [] arr = new int [n];
		arr[0]= 1;
		arr[1]=1;
		for (int i=2;i<n;i++) {
			arr[i]= arr[i-1]+ arr[i-2];
		}
		print (arr);
	}
	
	//Medium3
	public void divisible (int []arr) {
		for (int i=1;i<arr.length;i++) {
			if (arr[i]%arr[i-1]==0) {
				System.out.print("yes ");
			}
			else {
				System.out.print("no ");
			}
		}
	}
	
	//Hard1
	public void specialAverage (int [] arr) {
		int [] average= new int [arr.length];
		int sum=0;
		for (int i=0;i<average.length;i++) {
			sum+=arr[i];
			average[i]=sum/(i+1);
		}
		
		print (average);
	}
	
	//Hard2
	public void duplicates (int[]arr1, int[]arr2) {
		int count=0;
		for (int i=0;i<arr1.length;i++) {
			for (int j=0;j<arr2.length;j++) {
				if (arr1[i]==arr2[j]) {
					count++;
				}
			}
		}
		int []duplicate = new int [count];
		int z=0;
		for (int i=0;i<arr1.length;i++) {
			for (int j=0;j<arr2.length;j++) {
				if (arr1[i]==arr2[j]) {
					duplicate[z]=arr1[i];
					z++;
				}
			}
		}	
		print (duplicate);
	}
	
	//Hard3
	public void dotProduct (int [] arr1, int[]arr2) {
		int sum=0;
		for (int i=0;i<arr1.length;i++) {
			sum+=arr1[i]*arr2[i];
		}
		System.out.println(sum);
	}
	
	
	
	//public void 
	//print array
	public void print (int arr[]) {
		for (int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
	}
	
	public static void main (String args[]) {
		ArrayReview a = new ArrayReview ();
		String []arrS= {"Hi","Hello","Greetings"};
		int []arr = {4,2,6};
		int []arr2= {8, 3, 12, 5, 15, 45};
		int []arr3= {4, 6, 2, 12};
		int []arr4 = {5, 3, 1};
		int []arr5 = {8, 4, 7};
		int []arr6 = {8, 4, 9, 0, 2};
		int []arr7= {7, 2, 3, 9, 6};
	
		//a.printString(arrS);
		//a.toN(3);
		//a.average(arr);
		//a.doubles(arr);
		//a.takeaway(arr);
		//a.fibonacci(7);
		//a.divisible(arr2);
		//a.specialAverage(arr3);
		//a.dotProduct(arr4, arr5);
		a.duplicates(arr6, arr7);
	}
}
