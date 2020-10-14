package assignment04;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

public class Registration implements Iterable<Course>  {
	
	private ArrayList<Course> courseList;
	private IExtraFeeCalculator eFeeCalculator;
	private ArrayList<IDiscountStrategy> applicableDiscounts;
	private LocalDateTime date;
	
	public Registration() {
		courseList = new ArrayList<Course>();
		applicableDiscounts = new ArrayList<IDiscountStrategy>();
		date = LocalDateTime.now();
	}
	
	//returns date & time of registration
	public String getLocalDateTime() {
		
		return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
	
	//registers course for student
	public void addCourse(Course course) {
		
		courseList.add(course);
	}
	
	//removes course for student
	public void deleteCourse(Course course) {
		
		Iterator<Course> listIterator = courseList.iterator();
		
		while(listIterator.hasNext()) {
			
			Course temp = listIterator.next();
			
			if(temp.equals(course)) {
				listIterator.remove();
			}
		}
	}
	
	//returns list of registered courses
	public ArrayList<Course> getCourseList() {
		
		return courseList;
	}
	
	//sets instances of discounts
	public void setApplicableDiscounts(IDiscountStrategy discountStrategy) {
		
		applicableDiscounts.add(discountStrategy);
	}
	
	//Returns total amount based on registered courses
	public double getTotal() {
		
		double totalCourseFee=0;
		Iterator<Course> listIterator = courseList.iterator();
		
		for(Course temp : courseList) {
			
			temp = listIterator.next();
			totalCourseFee+= (temp.getSubTotal());
		}
		return totalCourseFee;
	}
	
	//returns extra fee 
	public int getExtraFeeAmount() {
		
		eFeeCalculator = (Admin.getInstance()).getExtraFeeCalculator();
		
		return eFeeCalculator.getExtraAmount(((int)getTotal()));
	}
	
	//returns total fees (course fee + extra fee)
	public int getGrandTotal() {
		
		return ((int)getTotal())+getExtraFeeAmount();
	}
	
	//returns the highest applicable discount
	public int getDiscountAmount() {
		
		int academicExcellenceDiscount=0;
		int freedomFighterDiscount=0;
		int minorityGroupDiscount=0;
		
		for(IDiscountStrategy temp : applicableDiscounts) {
			
			if(temp instanceof AcademicExcellenceDiscount) { 
				academicExcellenceDiscount=temp.getTotal(this);
			}
			if(temp instanceof FreedomFighterDiscount) { 
				freedomFighterDiscount=temp.getTotal(this);
			}
			if(temp instanceof MinorityGroupDiscount) { 
				minorityGroupDiscount=temp.getTotal(this);
			}
		}
		
		return Math.max(minorityGroupDiscount, Math.max(academicExcellenceDiscount, freedomFighterDiscount));
	}
	
	//returns total fee - discount
	public int getPayableAmount() {
		
		return getGrandTotal()-getDiscountAmount();
	}
	
	//To get a course by comparing objects
	public Course getCourse(Course course) {
		
		for(Course temp : courseList) {
			if(temp==course)
				return course;	
		}
		
		return course=null;
	}
	
	
	@Override
	public Iterator<Course> iterator(){
		return this.courseList.iterator();
	}
	
	@Override
	public String toString() {
		
		String details="";
		
		for(Course c : courseList) {
			details += "\nID: "+c.getId()+
			"\nTitle: "+c.getTitle()+
			"\nCredit: "+c.getCredit()+
			"\nTuition per credit: "+c.getTuitionPerCredit()+
			"\nNumber of students: "+c.getNumOfStudent()+
			"\nSeat capacity: "+c.getSeatCapacity();
		}
		
		return details;
	}

}
