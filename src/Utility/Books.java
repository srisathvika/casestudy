package Utility;

import Dao.BookDAO.Availability;
import Dao.BookDAO.Status;

public class Books {
	
	
	private int bookId;
	private String title;
	private String author;
	private String category;
	private Status status;
	private Availability availability;
	
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Availability getAvailability() {
		return availability;
	}
	public void setAvailability(Availability availability) {
		this.availability = availability;
	}
	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", title=" + title + ", author=" + author + ", category=" + category + "]";
	}
	public Books(int bookId, String title, String author, String category, Status status, Availability availability) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.category = category;
		this.status = status;
		this.availability = availability;
	}
	public Books(String title, String author, String category, Status status, Availability availability) {
	
		this.title = title;
		this.author = author;
		this.category = category;
		this.status = status;
		this.availability = availability;
	}
	
	
	

}
