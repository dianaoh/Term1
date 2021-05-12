package lists;

import java.util.ArrayList;

public class WarmUpLists {
	public ArrayList <Integer> squares (int n){
		ArrayList <Integer> list = new ArrayList<Integer> ();
		for (int i=1;i<=n;i++) {
			list.add(i*i);
		}
		return list;
	}
	
	public int [] frequency (ArrayList <String> words){
		int [] alphabet= new int[26];
		for (int i=0;i<words.size();i++) {
			for (int j=0;j<words.get(i).length();j++) {
				char letter = words.get(i).charAt(j);
				if (letter>='a' && letter<='z') {
					alphabet [letter-97]++;
				}
				if (letter>='A' && letter<='Z') {
					alphabet[letter-65]++;
				}
			}
		}
		return alphabet;

	}
	
	public static void main (String []args) {
		WarmUpLists a = new WarmUpLists ();
		ArrayList <String> words = new ArrayList <String> ();
		words.add("Abcde");
		words.add("fg");
		//System.out.println(a.squares(6));
		
		for (int i=0;i<a.frequency(words).length;i++) {
			System.out.println(a.frequency(words)[i]);
		}
		
		
	}
}
