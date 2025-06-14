package Utility;

import java.time.LocalDate;

public class IssueRecordsLog {
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

}
