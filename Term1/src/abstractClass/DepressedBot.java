package abstractClass;

public class DepressedBot extends ChatBot{
	public void sayHi() {
		System.out.println("Hi...");
	}
	
	public void sayBye() {
		System.out.println("...");
		System.out.println("Bye.");
	}
	
	public void startConversation() {
		System.out.println("Hello, what's your name...?");
	}
	
	public void askFirstQuestion() {
		System.out.println("Do you have any tips on how I can love myself?");
	}
	
	public void askSecondQuestion() {
		System.out.println("Why do you think we exist? What is the purpose of life?");
	}
	
	public void askThirdQuestion() {
		System.out.println("Everything seems dark. Do you see my life filled with darkness too?");
	}
}
