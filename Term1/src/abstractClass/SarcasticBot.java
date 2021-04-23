package abstractClass;

public class SarcasticBot extends ChatBot{
	public void sayHi() {
		System.out.println("Hi ._.");
	}
	
	public void sayBye() {
		System.out.println("Bye. It was really really really nice talking to you :|");
	}
	
	public void startConversation() {
		System.out.println("My name is Sarcastic Bot. Yours?");
	}
	
	public void askFirstQuestion() {
		System.out.println("Do you like comedy?(-_-)");
	}
	
	public void askSecondQuestion() {
		System.out.println("How old are you? I dont think I want to tell you mine.");
	}
	
	public void askThirdQuestion() {
		System.out.println("What food do you like? Its not that I'm very interested, but still");
	}
}
