package array;

public class ArrayStuff {
	public static void printArray (int [] arr) {
		System.out.println("[");
		for (int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		System.out.println("]");
	}
	public static void main (String [] args) {
		int [] myArr= new int [6];
		//array cannot change size
		
		//int []myArr2= {4,2,3,8};
		
		myArr[1]=9;
		printArray (myArr);
	}
	
}
