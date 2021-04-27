package lists;

import java.util.ArrayList;

public class List {
	public static int sum (ArrayList <Integer> nums) {
		int count=0;
		
		for (int i:nums) {
			count+=i;
		}
//		for (int i=0;i<nums.size();i++) {
//			count+=nums.get(i);
//		}

		return count;
	}
	
	public static int average (ArrayList <Integer> nums) {
		return (sum (nums))/nums.size();
	}
	
	public static ArrayList <Integer> factors (int n){
		ArrayList<Integer> factors= new ArrayList<Integer> ();
		for (int i=1;i<=n;i++) {
			if (n%i==0) {
				factors.add(i);
			}
		}
		return factors;
	}
	
	public static void removeAll (ArrayList <String> words) {
		while (words.size()>0) {
			words.remove(0);
		}
	}
	
	public static void main (String []args) {
		ArrayList<String> l= new ArrayList<String> ();
		l.add("hi");
		l.add("sdjf");
		l.add("sdklfj");
		removeAll(l);
		
		ArrayList<Integer> n= new ArrayList<Integer> ();
		n.add(1);
		n.add(2);
		n.add(3);
		System.out.println(factors (50));
	}
}
