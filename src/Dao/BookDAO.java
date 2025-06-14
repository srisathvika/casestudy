package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Utility.Books;

public class BookDAO {
	
	public enum Status{
		A,
		I
	}
	public enum Availability{
		A,
		I
	}

	
	private static String url="jdbc:mysql://localhost:3306/example_DB";
	private static String username="user1";
	private static String password="Pandu2002@";
	
	public BookDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("MySQL JDBC Driver registered!");
		}catch(ClassNotFoundException e) {
			System.err.println("MySQL JDBC Driver not found. Make sure the connector JAR is in your classpath.")
		}
		initializeDatabase();
	}
	
	public void initializeDatabase() {
			
			try(Connection con= DriverManager.getConnection(url,username,password);
					Statement st=con.createStatement()){
				String createTableSql ="CREATE TABLE IF NOT EXISTS BOOKS("+
										"bookId INT AUTO_INCREMENT PRIMARY KEY,"+
										"title VARCHAR(255) NOT NULL,"+
										"author VARCHAR(255) NOT NULL,"+
										"category VARCHAR(255) NOT NULL,"+
										"status CHAR(1) NOT NULL,"+
										"availability CHAR(1) NOT NULL )";
				st.execute(createTableSql);
				System.out.println("Database initialized: 'Books' table ensured.");
				
			}catch(SQLException e) {
				System.err.println("Error initializing database: "+e.getMessage());
				e.printStackTrace();
			}
					
		}

	public boolean addMember(Books book) throws SQLException {
		String SQL="INSERT INTO Books (title, author, "
				+ "category,status,availability) values (?, ?, ?, ?, ?)";
		
		try(Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement pstmt =con.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS)){
			pstmt.setString(1,book.getTitle());
			pstmt.setString(2,book.getAuthor());
			pstmt.setString(3,book.getCategory());
			pstmt.setString(4,String.valueOf(book.getStatus()));
			pstmt.setString(5,String.valueOf(book.getAvailability()));
	
			int affectedRows=pstmt.executeUpdate();
			
			if(affectedRows>0) {
				try(ResultSet generatedKeys= pstmt.getGeneratedKeys()){
					if(generatedKeys.next()) {
						book.getBookId();
					}
				}System.out.println("Book added: "+ book.getTitle()+" with ID: "+book.getBookId());
				return true;
			}
		
		}catch(SQLException e) {
			System.err.println("Error adding member: "+e.getMessage());
			e.printStackTrace();
		}
		return false;			
	}
	

	public List<Books> getAllBooks(){
		List<Books> booksList= new ArrayList<>();
		
		String SQL = "SELECT * from Books";
		
		try(Connection con = DriverManager.getConnection(url,username,password);
				Statement stmt= con.createStatement();
				ResultSet rs= stmt.executeQuery(SQL)){
			
			while(rs.next()) {
				int bookId=rs.getInt("bookId");
				String title=rs.getString("title");
				String author=rs.getString("author");
				String category=rs.getString("category");
				//String status=rs.getString("status");
				//String availability=rs.getString("availability");
				booksList.add(new Books(bookId,title,author,category,Status.A,Availability.A));			
				
			}
			
		}catch(SQLException e) {
			System.err.println("Error retrieving all members: "+e.getMessage());
			e.printStackTrace();
		}
		return membersList;		
		
	}

}
