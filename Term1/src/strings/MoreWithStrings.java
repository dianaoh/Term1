package strings;

public class MoreWithStrings {
	 public void firstLast (String str) {
		 if (str.substring (0,2).equals (str.substring (str.length()-2))==true){
			 System.out.println("yes");
		 }
		 else {
			 System.out.println("no");
		 }
	 }
	 
	 public void countWords (String str) {
		 int count=0;
		 for (int i=0;i<str.length ();i++) {
			 if (str.charAt(i)==' ') {
				 count++;
			 }
		 }
		 System.out.println(count+1);
	 }
	 
	 public static void main (String []args) {
		 MoreWithStrings a= new MoreWithStrings ();
		 a.firstLast("edited");
		 a.countWords("I love me");
	 }
}
