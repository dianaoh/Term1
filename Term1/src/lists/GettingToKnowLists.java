package lists;

import java.util.ArrayList;

public class GettingToKnowLists {
	public ArrayList <Character> removeSecond (ArrayList <Character> characters){
		for (int i=0;i<characters.size ();i++) {
			characters.remove(i);
		}
				
		return characters;
	}
	
	public ArrayList <String> reverse (ArrayList <String> list){
		for (int i=0;i<list.size ();i++) {
			list.add (i,list.remove (list.size ()-1));
		}
		
		return list;
	}
	
	public ArrayList <Double> doubleElement (ArrayList <Double> l){
		for (int i=0;i<l.size ();i++) {
			l.set(i, l.get(i)*2);
		}
		return l;
	}
	
	public ArrayList <Character> snake (int n){
		ArrayList <Character> l = new ArrayList <Character> ();
		for (int i=0;i<n;i++) {
			if (i%2==0) {
				l.add(0, (char)(i+97));
			}
			else {
				l.add((char)(i+97));
			}
		}
		return l;
	}
	
	public static void main (String []args) {
		GettingToKnowLists a = new GettingToKnowLists ();
		ArrayList <Character> l1= new ArrayList <Character> ();
		l1.add('d');
		l1.add('k');
		l1.add('e');
		l1.add('p');
		l1.add('w');
		l1.add('s');
		l1.add('t');
		ArrayList <String> l2= new ArrayList <String> ();
		l2.add("Hi");
		l2.add("Talk");
		l2.add("Bye");
		ArrayList <Double> l3= new ArrayList <Double> ();
		l3.add (1.0);
		l3.add(2.0);
		l3.add(3.0);
		
		//System.out.println(a.removeSecond(l1));
		//System.out.println(a.reverse(l2));
		//System.out.println(a.doubleElement (l3));
		System.out.println(a.snake(5));
	}
}
