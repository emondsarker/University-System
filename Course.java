package assignment04;

public class Course {

	private String id;
	private String title;
	private int credit;
	private int tuitionPerCredit;
	private int numOfStudent;
	private int seatCapacity;
	
	public Course(String id, String title, int credit, int tuitionPerCredit) {
		this.id=id;
		this.title=title;
		this.credit=credit;
		this.tuitionPerCredit=tuitionPerCredit;
		seatCapacity=3; //default capacity for tasks
	}
	
	//setters
	public void setId(String input) {
		id=input;
	}
	public void setTitle(String input) {
		title=input;
	}
	public void setCredit(int input) {
		credit=input;
	}
	public void setTuitionPerCredit(int input) {
		tuitionPerCredit=input;
	}
	public void setNumOfStudent(int input) {
		numOfStudent=input;
	}
	public void setSeatCapacity(int input) {
		seatCapacity=input;
	}
	
	//getters
	public String getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public int getCredit() {
		return credit;
	}
	public int getTuitionPerCredit() {
		return tuitionPerCredit;
	}
	public int getNumOfStudent() {
		return numOfStudent;
	}
	public int getSeatCapacity() {
		return seatCapacity;
	}
	
	//calculates specific course fee
	public int getSubTotal() {
		return credit *tuitionPerCredit;
	}
	
	@Override
	public String toString() {
		return "\nID: "+id+
				"\nTitle: "+title+
				"\nCredit: "+credit+
				"\nTuition per credit: "+tuitionPerCredit+
				"\nNumber of students: "+numOfStudent+
				"\nSeat capacity: "+seatCapacity;
	}

}
