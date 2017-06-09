
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;



public class DatabaseConnect {
	
	private static  String DB_DRIVER ;
	private static String DB_CONNECTION ;
	private static String DB_USER;
	private static String DB_PASSWORD = "password";
	
	
	public DatabaseConnect() {
		this.DB_DRIVER = "com.mysql.jdbc.Driver";
		this.DB_CONNECTION = "jdbc:mysql:@localhost:3306:Resume";
		this.DB_USER ="user";
		this.DB_PASSWORD = "password";
	}
	

	
	
public static String getDB_DRIVER() {
		return DB_DRIVER;
	}


	public static void setDB_DRIVER(String dB_DRIVER) {
		DB_DRIVER = dB_DRIVER;
	}


	public static String getDB_CONNECTION() {
		return DB_CONNECTION;
	}


	public static void setDB_CONNECTION(String dB_CONNECTION) {
		DB_CONNECTION = dB_CONNECTION;
	}

	public static String getDB_USER() {
		return DB_USER;
	}

	public static void setDB_USER(String dB_USER) {
		DB_USER = dB_USER;
	}

	public static String getDB_PASSWORD() {
		return DB_PASSWORD;
	}

	public static void setDB_PASSWORD(String dB_PASSWORD) {
		DB_PASSWORD = dB_PASSWORD;
	}



private static java.sql.Timestamp getCurrentTimeStamp() {
		
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}
	

	

}
