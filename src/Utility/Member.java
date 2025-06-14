package Utility;
import Dao.MemberDAO.Gender;
public class Member {

	
	private String email;
	private int mobile;
	private Gender gender;
	private String address;	
	private int memberId;
	private String name;
	
	
	public Member(int memberId, String email, int mobile, Dao.MemberDAO.Gender f, String name,String address) {
		this.email = email;
		this.mobile = mobile;
		this.gender = f;
		this.address = address;
		this.memberId = memberId;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Member [email=" + email + ", mobile=" + mobile + ", gender=" + gender + ", address=" + address
				+ ", memberId=" + memberId + ", name=" + name + "]";
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}

