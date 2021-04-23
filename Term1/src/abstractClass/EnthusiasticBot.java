package abstractClass;

public class EnthusiasticBot extends ChatBot{
	public void sayHi() {
		System.out.println("Hello!!!!");
	}
	
	public void sayBye() {
		System.out.println("Byeee! I hope to see you again!!!");
	}
	
	public void startConversation() {
		System.out.println("My name is the Enthusiastic Bot! What is your name?");
	}
	
	public void askFirstQuestion() {
		System.out.println("What shows do you like to watch?? I love to watch Victorious and Stranger Things!!!");
	}
	
	public void askSecondQuestion() {
		System.out.println("I love your shirt so much!! Where did you get it from??");
	}
	
	public void askThirdQuestion() {
		System.out.println("Do you like food! I love love love food!!! I hope we can eat food together sometime soon!");
	}
}
