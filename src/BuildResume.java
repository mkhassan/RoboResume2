import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BuildResume {
	
	public Person person;
	public Education education;
	public Experience experience;
	public Skills skills;
	
	public static DatabaseConnect dc;
	
	
	public BuildResume(){
		
		};
	
	Scanner kb = new Scanner(System.in);
	
	
 public void setPerson() {
	 
		
		
		System.out.println("Enter your first name");	

		String firstname = kb.nextLine();
		
		System.out.println("Enter your last name");	
		
		String lastname = kb.nextLine();
		
		
		
		System.out.println("Enter your email");	
		
		String email = kb.nextLine();
		

		
		
		this.person = new Person(firstname, lastname, email);
	 
		
		

 }
 
 public void setEducation() {
	 System.out.println("Enter your educational achievements or quit when done");
	 
		String edu = null;
		String toQuit = "quit";
		int educount = 1;
		
		ArrayList<String> educationarray = new ArrayList<String>();
		
		do {
			
			

			  System.out.println("Enter your University");
			  
			    
				String University = kb.nextLine();
				educationarray.add(University);
				
				System.out.println("Enter your Degree");
				String Degree = kb.nextLine();
				educationarray.add(Degree);
				
				System.out.println("Enter your Year of Graduation");
				
				String GraduationYear = kb.nextLine();
				
				educationarray.add(GraduationYear);

				this.education = new Education(University, Degree, GraduationYear);
			   
				
				
				educount++;
			   
			   
		} while((educount <= 10 && !(toQuit.equalsIgnoreCase(edu))) );
		
		
			
 }
	
public void setExperience() {
	

	ArrayList<String> experiencearr = new ArrayList<String>();
	String toQuit = "quit";

	int expcount =0;

	
	System.out.println("Enter your Experiences or quit:");

	 String exp = null;
	 
	 while(expcount < 10 && !(toQuit.equalsIgnoreCase(exp))){
		 
		  System.out.println("Enter your JobTitle");
		  
		    
			String jobtitle= kb.nextLine();
			experiencearr.add(jobtitle);
			
			System.out.println("Enter Company");
			String company = kb.nextLine();
			experiencearr.add(company);
			
			System.out.println("Enter your start date ");
			
			String startdate = kb.nextLine();
			
			experiencearr.add(startdate);
			
			System.out.println("Enter your end date ");
			
			String enddate = kb.nextLine();
			
			experiencearr.add(enddate);
			
			System.out.println("Enter first duty ");
			
			String duty1 = kb.nextLine();
			
			experiencearr.add(duty1);
			
			System.out.println("Enter second duty ");
			
			String duty2 = kb.nextLine();
			
			experiencearr.add(duty2);

			this.experience = new Experience(jobtitle,company, startdate, enddate, duty1,duty2);
		   
	
		 expcount++;
	 }
	
	
}

public void setSkills() {
	System.out.println("Enter your skills:");
	ArrayList<String> skillsarr = new ArrayList<String>();
	String ski = null;
	String toQuit = "quit";

    int skillscount = 1;
	
    do {
    	System.out.println("Enter a skill:");
    	String skill = kb.nextLine();
    	skillsarr.add(skill);
    	
    	System.out.println("Enter the skill level:");
    	String skillevel = kb.nextLine();
    	skillsarr.add(skillevel);
    	
    	this.skills = new Skills(skill, skillevel);
    	
    	skillscount++;
    } while(skillscount <20 && !(toQuit.equalsIgnoreCase(ski)));

	
	
}
 
 
 private void insertRecordIntoPerson() throws SQLException {
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		String insertIntoPerson = "INSERT INTO Person"
				          +"(FirstName, LastName, Email) VALUES"
				          +"(?,?,?)";
		
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertIntoPerson);
			
			preparedStatement.setString(1,person.getFirstName());
			preparedStatement.setString(2,person.getLastName());
			preparedStatement.setString(3,person.getEmail());
			
			//execute insert SQL statement
			
			preparedStatement.executeUpdate();
			
			System.out.println("Record is inserted into Person Table!");
		} catch(SQLException e) {
			
			System.out.println(e.getMessage());
		
	} finally {
		if (preparedStatement !=null) {
			preparedStatement.close();
		}
		
		if (dbConnection != null) {
			dbConnection.close();
		}
	}
	
	}
 
 private  void insertRecordIntoEducation() throws SQLException {
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		String insertIntoPerson = "INSERT INTO Education"
				          +"(University, Degree, GraduationYear) VALUES"
				          +"(?,?,?)";
		
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertIntoPerson);
			
			preparedStatement.setString(1,education.getUniversity());
			preparedStatement.setString(2,education.getDegree());
			preparedStatement.setString(3,education.getGraduationYear());
			
			//execute insert SQL statement
			
			preparedStatement.executeUpdate();
			
			System.out.println("Record is inserted into Education Table!");
		} catch(SQLException e) {
			
			System.out.println(e.getMessage());
		
	} finally {
		if (preparedStatement !=null) {
			preparedStatement.close();
		}
		
		if (dbConnection != null) {
			dbConnection.close();
		}
	}
	
	}
 
 
 private  void insertRecordExperience() throws SQLException {
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		String insertIntoPerson = "INSERT INTO Experience"
				          +"(JobTitle, Company, StartDate, EndDate, Duty1, Duty2) VALUES"
				          +"(?,?,?,?,?)";
		
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertIntoPerson);
			
			preparedStatement.setString(1,experience.getJobTitle());
			preparedStatement.setString(2,experience.getCompany());
			preparedStatement.setString(3,experience.getStartDate());
			preparedStatement.setString(4,experience.getEndDate());
			preparedStatement.setString(5,experience.getDuty1());
			preparedStatement.setString(6,experience.getDuty2());		
					
					
					
		//execute insert SQL statement
			
	preparedStatement.executeUpdate();
			
			System.out.println("Record is inserted into Experience Table!");
		} catch(SQLException e) {
			
			System.out.println(e.getMessage());
		
	} finally {
		if (preparedStatement !=null) {
			preparedStatement.close();
		}
		
		if (dbConnection != null) {
			dbConnection.close();
		}
	}
	
	}

 
 private  void insertRecordSkills() throws SQLException {
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		String insertIntoPerson = "INSERT INTO Skills"
				          +"(Skill,SkillLevel) VALUES"
				          +"(?,?)";
		
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertIntoPerson);
			
			preparedStatement.setString(1,skills.getSkill());
			preparedStatement.setString(2,skills.getSkillLevel());
				
					
					
					
		//execute insert SQL statement
			
	preparedStatement.executeUpdate();
			
			System.out.println("Record is inserted into Experience Table!");
		} catch(SQLException e) {
			
			System.out.println(e.getMessage());
		
	} finally {
		if (preparedStatement !=null) {
			preparedStatement.close();
		}
		
		if (dbConnection != null) {
			dbConnection.close();
		}
	}
	
	}
 
 
 
 
	
 private static Connection getDBConnection() {
		
		Connection dbConnection = null;
		
		try {
			Class.forName(dc.getDB_DRIVER());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dbConnection = DriverManager.getConnection(dc.getDB_CONNECTION(),dc.getDB_USER(),dc.getDB_PASSWORD());
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return dbConnection;
	}
 
 
	

}
