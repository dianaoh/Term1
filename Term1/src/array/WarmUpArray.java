package array;

public class WarmUpArray {
	public void indexmultiply(double [] arr) {
		double sum=0;
		for (int i=0;i<arr.length;i++) {
			arr[i]=arr[i]*i;
			sum+=arr[i];
		}
		System.out.println(sum);
	}
	
	public void mergestring (char[] letters) {
		String a="";
		for (int i=0;i<letters.length;i++) {
			if (letters[i]>='a' && letters[i]<='z') {
				a+=letters[i];

			}
		}
		System.out.println(a);
	}
	//Extra Credit 
	public void count (char []arr) {
		int max=Integer.MIN_VALUE;
		for (int i=0;i<arr.length;i++) {
			if (max<arr[i]) {
				max=arr[i];
			}
		}
		
		int []count=new int [max+1];
		for (int i=0;i<arr.length;i++) {
			count[arr[i]]+=1;
		}
		
		int max1=Integer.MIN_VALUE;
		int letter = 0;
		
		for (int i=0;i<count.length;i++) {
			if (max1<count[i]) {
				max1=count[i];
				letter=i;
			}
		}
		System.out.println((char)letter);
	}
	
	public static void main(String [] args) {
		WarmUpArray a = new WarmUpArray ();
		double []arr1 = {1,2,3,4};
		char [] letters = {'h', 'i', '!', 'H', 'e', 'l', 'L', 'o', '?'};
		char [] characters= {'h', 'k', 'h', 'u', 'b', 'e', 'k', 'u', 'u'};
		//a.indexmultiply(arr1);
		//a.mergestring(letters);
		a.count (characters);
	}
}
