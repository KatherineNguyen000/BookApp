package bookApp;

public class TrackingHistory {
	public Customer customer;
	public Book book;
	public int borrowID;
	private String borrowDate;
	private String returnDate;
	boolean isReturned;

	public String getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

}
