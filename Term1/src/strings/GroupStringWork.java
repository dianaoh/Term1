package strings;

public class GroupStringWork {
	public void pigLatin (String str) {
		str = str.substring(1)+str.substring(0,1)+"ay";
		System.out.println(str);
	}
	
	public void dollar (String str, char c) {
		for (int i=0;i<str.length();i++) {
			if (str.charAt(i)==c) {
				System.out.print("$");
			}
			else {
				System.out.print(str.charAt(i));
			}
		}
		System.out.println();
	}
	
	public void longest (String [] arr) {
		String max = "";
		for (int i=0;i<arr.length;i++) {
			if ((arr[i]).length ()>max.length ()) {
				max = arr[i];
			}
		}
		System.out.println(max);
	}
	
	public static void main (String []args) {
		GroupStringWork a = new GroupStringWork ();
		String []arr = {"hi", "hello", "bye"};
		a.pigLatin("pig");
		a.dollar("hello", 'l');
		a.longest(arr);
	}
}
