import java.util.Scanner;

public class Person {
	
	private String FirstName;
	private String LastName;
	private String Email;
	
	public Person(String firstname, String lastname, String email){
	 this.FirstName = firstname;
	 this.LastName = lastname;
	 this.Email = email;

	 }
	 
	 //  trying to use static factory method instead of constructors;
	 /**
	 public static Person setPersonmethod2() {
			Scanner kb = new Scanner(System.in);
			
			System.out.println("Enter your first name");	

			String firstname = kb.nextLine();
			
			System.out.println("Enter your last name");	
			
			String lastname = kb.nextLine();
			
			
			
			System.out.println("Enter your email");	
			
			String email = kb.nextLine();
			

			kb.close();
			
			return new Person(firstname, lastname, email);
		 
	 }
	 **/

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "Person [FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + "]";
	};
	 
	 
	
	

}
