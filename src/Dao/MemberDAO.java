package Dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Utility.Member;
public class MemberDAO {
	public enum Gender{
		M,
		F
	}
	private static String url="jdbc:mysql://localhost:3306/example_DB";
	private static String username="user1";
	private static String password="Pandu2002@";
	
	public MemberDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("MySQL JDBC Driver registered!");
		}catch(ClassNotFoundException e) {
			System.err.println("MySQL JDBC Driver not found. Make sure the connector JAR is in your classpath.");
		}
		initializeDatabase();
	}
	
	public void initializeDatabase() {
		
		try(Connection con= DriverManager.getConnection(url,username,password);
				Statement st=con.createStatement()){
			String createTableSql ="CREATE TABLE IF NOT EXISTS MEMBER ("+
									"memberId INT AUTO_INCREMENT PRIMARY KEY,"+
									"name VARCHAR(255) NOT NULL,"+
									"email VARCHAR(255) NOT NULL UNIQUE,"+
									"mobile INT NOT NULL UNIQUE,"+
									"gender CHAR(1) NOT NULL,"+
									"address VARCHAR(255) NOT NULL )";
			st.execute(createTableSql);
			System.out.println("Database initialized: 'Member' table ensured.");
			
		}catch(SQLException e) {
			System.err.println("Error initializing database: "+e.getMessage());
			e.printStackTrace();
		}
				
	}
	
	
	public boolean addMember(Member member) throws SQLException {
		String SQL="INSERT INTO Member (name, email, "
				+ "mobile, gender, address) values (?, ?, ?, ?, ?)";
		
		try(Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement pstmt =con.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS)){
			pstmt.setString(1,member.getName());
			pstmt.setString(2,member.getEmail());
			pstmt.setInt(3,member.getMobile());
			pstmt.setString(4,String.valueOf(member.getGender()));
			pstmt.setString(5,member.getAddress());
	
			int affectedRows=pstmt.executeUpdate();
			
			if(affectedRows>0) {
				try(ResultSet generatedKeys= pstmt.getGeneratedKeys()){
					if(generatedKeys.next()) {
						member.setMemberId(generatedKeys.getInt(1));
					}
				}System.out.println("Member added: "+ member.getName()+" with ID: "+member.getMemberId());
				return true;
			}
		
		}catch(SQLException e) {
			System.err.println("Error adding member: "+e.getMessage());
			e.printStackTrace();
		}
		return false;
				
	}
	
	
	public List<Member> getAllMembers(){
		List<Member> membersList= new ArrayList<>();
		
		String SQL = "SELECT * from Members";
		
		try(Connection con = DriverManager.getConnection(url,username,password);
				Statement stmt= con.createStatement();
				ResultSet rs= stmt.executeQuery(SQL)){
			
			while(rs.next()) {
				int memberId=rs.getInt("memberId");
				String name=rs.getString("name");
				String email=rs.getString("email");
				int mobile=rs.getInt("mobile");
//				Gender gender=rs.getString("gender").charAt(0);
				String address=rs.getString("address");
				membersList.add(new Member(memberId,email,mobile,Gender.F,name,address));			
				
			}
			
		}catch(SQLException e) {
			System.err.println("Error retrieving all members: "+e.getMessage());
			e.printStackTrace();
		}
		return membersList;		
		
	}
	
	public boolean updateMember(Member member) {
		String SQL ="UPDATE Members SET name= ?,email= ?,mobile= ?,address= ? WHERE memberId= ?";
		try(Connection con =DriverManager.getConnection(url,username,password);
				PreparedStatement pstmt = con.prepareStatement(SQL)){
			
			pstmt.setString(1,member.getName());
			pstmt.setString(2,member.getEmail());
			pstmt.setInt(3,member.getMobile());
			pstmt.setString(4,member.getAddress());
			
			int affectedRows= pstmt.executeUpdate();
			
			if(affectedRows>0) {
				System.out.println("Member updated: "+member.getName()+" with ID: "+member.getMemberId());
				return true;
			}	
		}catch(SQLException e) {
			System.err.println("Error updating member ID: "+member.getMemberId());
			e.printStackTrace();
		}
		System.out.println("Member ID "+member.getMemberId()+ "not found for update or no changes made.");
		return false;
	}

	public Member getMemberById(int memberId) {
		
		String SQL= "SELECT * FROM Members WHERE memberID= ?";
		
		try(Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement pstmt = con.prepareStatement(SQL)){
			
		}
	}
	
	
	

}
