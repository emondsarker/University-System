package assignment04;
import java.util.ArrayList;

public class Student {
	
	private String name;
	private int id;
	private double cgpa;
	private char freedomFighterStatus;
	private char minorityGroupStatus;
	private Registration reg;
	private int currentCredit; //tracks credits taken
	private int maxCreditPossible;//max credit based on CGPA
	
	public Student(String name, int id, double cgpa, char FFStatus, char MGStatus) {
		this.name=name;
		this.id=id;
		this.cgpa=cgpa;
		this.freedomFighterStatus=FFStatus;
		this.minorityGroupStatus=MGStatus;
		this.currentCredit=0;
		this.maxCreditPossible=findCreditLimit(cgpa);
	}
	
	//getters
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public double getCgpa() {
		return cgpa;
	}
	public char getFreedomFighterStatus() {
		return freedomFighterStatus;
	}
	public char getMinorityGroupStatus() {
		return minorityGroupStatus;
	}
	public int getMaxCreditPossible() {
		return maxCreditPossible;
	}
	public int getCurrentCredit() {
		return currentCredit;
	}
	
	//setters
	public void setName(String name) {
		this.name=name;
	}
	public void setId(int id) {
		this.id=id;
	}
	public void setCgpa(double cgpa) {
		this.cgpa=cgpa;
		this.maxCreditPossible=findCreditLimit(cgpa);
	}
	public void setFreedomFighterStatus(char FFStatus) {
		freedomFighterStatus=FFStatus;
	}
	public void setMinorityGroupStatus(char MGStatus) {
		minorityGroupStatus=MGStatus;
	}
		
		
	//creates instance of registration
	public void makeNewRegistration() {
		reg = new Registration();
		this.setDiscounts();
	}

	
	//assigns course to student
	public void addCourse(Course course) {	
		
		boolean seatAvailable = course.getNumOfStudent()<course.getSeatCapacity();
		boolean creditAvailable = this.currentCredit<this.maxCreditPossible; 
	
		if(seatAvailable && creditAvailable) {
			
			//increases student count
			course.setNumOfStudent(course.getNumOfStudent()+1);
			
			//increases credit taken
			this.currentCredit+=course.getCredit();
			
			//adds course
			reg.addCourse(course);
		}
		
		if(!seatAvailable) //no seats
			System.out.println(course.getId()+" can not be added. Seat is full!");
		
		if(!creditAvailable)//student reached max credit
			System.out.println(this.getName()+": You cannot take "+course.getId()
			+". You exceed the "+ this.getMaxCreditPossible()+" credits limit");
	
	}
	
	
	//removes course from student
	public void dropCourse(Course course) {
		
		//reduces student count
		course.setNumOfStudent(course.getNumOfStudent()-1);
		
		//removes course
		reg.deleteCourse(course);
	}
	
	//returns registration object
	public Registration getRegistration() {
		
		return reg;
	}
	
	//Sets applicable discounts to student
	public void setDiscounts() {
		
		if(cgpa>3.5) {
			reg.setApplicableDiscounts(new AcademicExcellenceDiscount());
		}
		if(freedomFighterStatus=='Y') {
			reg.setApplicableDiscounts(new FreedomFighterDiscount());
		}
		if(minorityGroupStatus=='Y') {
			reg.setApplicableDiscounts(new MinorityGroupDiscount());
		}
	}
	
	
	//concatenates id and title of registered courses
	//then returns string
	public String printRegisteredCourse() {
		
		ArrayList<Course> courseList= reg.getCourseList();
		
		String finalString="Course ID \tCourse Title\n"+
				"================================================";
		
		for(Course course: courseList) {
			String tempString = "\n"+course.getId()+"\t\t"+course.getTitle();
			 finalString += tempString;
		}
		
		finalString+="\n================================================";
		
		return finalString;
	}
	
	//Concatenates breakdown of bill and returns String
	public String getBillingInfo() {
		
		return "Billing Info: (ID: "+id+")"+
				"\n------------------------------------"+
				"\nTotal Course Fee: "+(int)reg.getTotal()+
				"\nExtra Fee:       +"+reg.getExtraFeeAmount()+
				"\n------------------------------------"+
				"\nGrand total:      "+reg.getGrandTotal()+
				"\nDiscount:        -"+reg.getDiscountAmount()+
				"\n------------------------------------"+
				"\nPayable Amount:   "+reg.getPayableAmount();
	}
	
	//Prints all basic info 
	//Student info+ Registered Courses+ Billing info
	public void printRegistrationSlip() {
		
		String studentData ="Registration Time: "+reg.getLocalDateTime()+ 
				"\n----------------------------------------------"+ 
				"\nName: "+name+", ID: "+id+", CGPA: "+cgpa+
				"\n----------------------------------------------";
		
		System.out.println(studentData);
		System.out.println(printRegisteredCourse());
		System.out.println(getBillingInfo());
	}
	
	//calculates max credit based on cgpa
	public static int findCreditLimit(double cgpa) {
		if(cgpa>=3.5)
			return 18;
		else
			return 12;
	}
	
	
	@Override
	public String toString() {
		return "\nName: "+name+
				"\nID: "+id+
				"\nCGPA: "+cgpa+
				"\nRegistered courses: "+reg;
	}
}
