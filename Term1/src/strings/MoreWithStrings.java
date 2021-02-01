package strings;

public class MoreWithStrings {
	//Question 1
	 public void firstLast (String str) {
		 if (str.substring (0,2).equals (str.substring (str.length()-2))==true){
			 System.out.println("yes");
		 }
		 else {
			 System.out.println("no");
		 }
	 }
	 
	 //Question 3
	 public int countWords (String str) {
		 int count=0;
		 for (int i=0;i<str.length ();i++) {
			 if (str.charAt(i)==' ') {
				 count++;
			 }
		 }
		 System.out.println(count+1);
		 return count+1;
	 }
	 
	 //Question 4
	 public void intoArray (String str){
		String []arr=new String [countWords (str)];
		for (int i=0;i<arr.length;i++) {
			arr[i]="";
		}
		
		int count=0;
		for (int i=0;i<str.length();i++) {
			if (str.charAt(i)!=' ') {
				arr[count]+=str.charAt(i);
			}
			else {
				count++;
			}
		}
		for (int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	 }
	 //Question 5
	 public void removeE (String str) {
		 for (int i=0;i<str.length ();i++) {
			 if (str.charAt(i)=='e') str= str.substring(0,i)+ str.substring(i+1,str.length());
		 }
		 System.out.println(str);
	 }
	 
	 //Question 7
	 public void palindrome (String str) {
		 boolean pali= true;
		 for (int i=0;i<str.length();i++) {
			 if (str.charAt(i)!=str.charAt(str.length()-i-1)) {
				 pali= false;
			 }
		 }
		 if (pali==false) {
			 System.out.println("Not a Palindrome");
		 }
		 else {
			 System.out.println("Palindrome");
		 }
	 }
	 
	 public static void main (String []args) {
		 MoreWithStrings a= new MoreWithStrings ();
		 //a.firstLast("edited");
		 //a.countWords("I love me");
		 //a.intoArray("AP CS is for nerds");
		 //a.removeE("let's eat there");
		 a.palindrome("abcba");
	 }
}
