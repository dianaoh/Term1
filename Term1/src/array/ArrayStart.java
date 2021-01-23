package array;

import java.util.Scanner;

public class ArrayStart {
	public void display (int []arr) {
		
		for (int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public void oneToN (int n) {
		int []arr= new int [n];
		
		for (int i=0;i<arr.length;i++) {
			arr[i]=i+1;
		}
		display (arr);
	}
	
	public void swap(int []arr) {
		int first=arr[0];
		arr[0]= arr[arr.length-1];
		arr[arr.length-1]=first;
		display (arr);
	}
	
	public void userArray () {
		Scanner scanner= new Scanner (System.in);
		int [] b= new int [7];
		System.out.println("Enter 7 numbers");
		for (int i=0;i<7;i++) {
			b[i]=scanner.nextInt ();
		}
		display (b);
	}
	public void reverse(int []arr) {
		//int [] neww = new int [arr.length];
		//for (int i=0;i<arr.length;i++) {
		//	neww[i]= arr [arr.length-i-1];
		//}
		//for (int i=0;i<neww.length;i++) {
		//	System.out.print(neww[i]+" ");
		//}
		
		for (int i=0,j=arr.length-1;i<arr.length/2;i++,j--) {
			int first= arr[i];
			arr[i]= arr[j];
			arr[j]=first;
			}
		display (arr);
	}
	
	public static void main(String args[]) {
		ArrayStart a= new ArrayStart ();
		int [] b= {2,3,4,5};
		//a.display(b);
		//a.oneToN(5);
		//a.swap(b);
		//a.userArray();
		a.reverse(b);
	}
}
