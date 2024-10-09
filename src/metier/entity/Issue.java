package metier.entity;

public class Issue {

	private int student, book;
	public int getStudent() {
		return student;
	}

	public void setStudent(int student) {
		this.student = student;
	}

	public int getBook() {
		return book;
	}

	public void setBook(int book) {
		this.book = book;
	}

	private String returndate;
	
	
	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}


	public Issue(int student, int book, String returndate) {
		super();
		this.student = student;
		this.book = book;
		this.returndate = returndate;
	}

	public Issue() {
		super();
	}

	
}
