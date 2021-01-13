package strings;

public class StringIntro {
	
	public void half (String str) {
		System.out.println(str.substring(str.length ()/2));
	}
	
	public void frontGone (String str1, String str2) {
		System.out.println(str1.substring(1)+str2.substring(1));
	}
	
	public void endLy (String str) {
		if (str.substring(str.length ()-2,str.length ()).equals("ly")) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}		
	}
	
	public void contains (String str1, String str2) {
		if (str1.contains(str2)) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
	}
	
	public void backwards (String str) {
		for (int i=str.length()-1;i>=0;i--) {
			System.out.print(str.charAt(i));
		}
	}
	
	public void jumbled (String str) {
		for (int i=0;i<str.length();i++) {
			for (int j=i;j<str.length ();j++) {
				System.out.print(str.charAt(j));
			}
			for (int j=0;j<i;j++) {
				System.out.print(str.charAt(j));
			}
			System.out.println();
		}
	}
	
	public static void main (String [] args) {
		StringIntro a = new StringIntro ();
//		a.half("hi there");
//		a.frontGone ("hello", "there");
//		a.endLy("fast");
//		a.contains("hippo","hit");
//		a.backwards("hello");
		a.jumbled ("hello");
		
	}
}
