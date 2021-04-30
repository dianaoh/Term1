package lists;

import java.util.ArrayList;

public class MoreList {
	public void randomList (int x, int n){
		ArrayList <Integer> random = new ArrayList<Integer>();
		for (int i=0;i<n;i++) {
			random.add((int)(Math.random()*2*x-x));
		}
		
		ArrayList <Integer> positive = new ArrayList <Integer>();
		ArrayList <Integer> negative = new ArrayList <Integer>();
		for (int i=0;i<n;i++) {
			if (random.get(i)>=0) {
				positive.add(random.get(i));
			}
			else {
				negative.add(random.get(i));
			}
		}
		System.out.println(positive);
		System.out.println(negative);
	}
	
	public void reverse (ArrayList <Double> list) {
		double store=0;
		for (int i=0;i<list.size()/2;i++) {
			store= list.get(i);
			list.set(i, list.get(list.size()-i-1));
			list.set(list.size()-i-1, store);
		}
		System.out.println(list);
	}
	
	public static void main (String []args) {
		MoreList a = new MoreList ();
		ArrayList <Double>list=new ArrayList<Double>();
		list.add(1.0);
		list.add(2.0);
		list.add(3.0);
		list.add(4.0);
		a.randomList(2, 6);
		a.reverse(list);
	}
}
