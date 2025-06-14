package Service;
import java.time.LocalDate;

public class IssueRecords {
	private enum Status{
		I,
		R
	}
	
	private int issueId;
	private int bookId;
	private int memberId;
	private Status status;
	private LocalDate issueDate;
	private LocalDate returnDate;
	public IssueRecords(int issueId, int bookId, int memberId, Status status, LocalDate issueDate,
			LocalDate returnDate) {
		super();
		this.issueId = issueId;
		this.bookId = bookId;
		this.memberId = memberId;
		this.status = status;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
	}
	public IssueRecords(int bookId, int memberId, Status status, LocalDate issueDate, LocalDate returnDate) {
		super();
		this.bookId = bookId;
		this.memberId = memberId;
		this.status = status;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
	}
	@Override
	public String toString() {
		return "IssueRecords [issueId=" + issueId + ", bookId=" + bookId + ", memberId=" + memberId + ", status="
				+ status + ", issueDate=" + issueDate + ", returnDate=" + returnDate + "]";
	}
	public int getIssueId() {
		return issueId;
	}
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	
	

}
