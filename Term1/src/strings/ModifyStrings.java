package strings;

public class ModifyStrings {
	//Simple 1
	public void adverb (String str) {
		str =str.substring(0,str.length()-2)+"er";
		System.out.println(str);

	}
	
	//Simple 2
	public void prefix (String str) {
		str= "un"+str.substring(3);
		System.out.println(str);
	}
	
	//Simple 3
	public void suffix (String str, String suff) {
		if (str.substring (str.length()-suff.length()-1)==suff) {
			str =str.substring(str.length()-suff.length()-1)+"ine";
		}
		else {
			str =str+suff;
		}
		System.out.println(str);
	}
	
	//Medium 1
	public void changeLetter (String str, char l1, char l2) {
		for (int i=0;i<str.length();i++) {
			if (str.charAt(i)==l1) {
				str=str.substring (0,i)+l2+str.substring(i+1);
			}
		}
		System.out.println(str);
	}
	
	//Medium 2
	public void intoArray (String str) {
		int count1=0;
		for (int i=0;i<str.length();i++) {
			if (str.charAt(i)==' ') {
				count1++;
			}
		}
		String [] arr= new String[count1+1];
		for (int i=0;i<arr.length;i++) {
			arr[i]="";
		}
		
		int count2=0;
		for (int i=0;i<str.length();i++) {
			if (str.charAt(i)!=' ') {
				arr[count2]+=str.charAt(i);
			}
			else {
				count2++;
			}
		}
		for (int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
	
	public static void main (String [] args) {
		ModifyStrings a= new ModifyStrings ();
		a.adverb("quickly");
		a.prefix("predisposed");
		a.suffix("safer", "er");
		a.changeLetter("david",'d', 'm');
		a.intoArray("I like CS");
	}
}
