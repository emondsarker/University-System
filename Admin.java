package assignment04;

public class Admin {
	
	private static IExtraFeeCalculator eFeeCalculator;
	private static Admin instance=null;
	
	private Admin() { //private due to Singleton class
	     eFeeCalculator= new DevelopmentFeeCalculator();
	}
	
	//Use this to create Admin class object
	public static Admin getInstance() {
		
		if(instance==null) {
			 instance= new Admin();
		 }
		
		 return instance;
	}
	 
	//adds Course to CurrentOfferedCourse
	public void offerCourse(Course course) {
		
		CurrentOfferedCourse.getInstance().addCourse(course);
	}
	
	//prints courseList with course ID
	public void publishOfferedCourse() {
		
		int i=1;
		
		System.out.println("Offered Courses List:");
		
		for	( Course temp: CurrentOfferedCourse.getInstance().getCourseList()) {
				System.out.println(i+". "+temp.getId());
				i++;	   
		}	
	}
	
	//increases seat capacity of a course
	public void increaseSeatCapacity(Course course, int size) {
		
		int newSize = course.getSeatCapacity()+size;
		
		course.setSeatCapacity(newSize);
	}
	
	//prints all offered courses with id, students, capacity
	public void seeCourseStatus() {	
		
		for	( Course temp: CurrentOfferedCourse.getInstance().getCourseList()) {
				
			System.out.println("Course ID: "+temp.getId()+
							" Seat Capacity: "+temp.getSeatCapacity()+
							" Number of students: "+temp.getNumOfStudent());
		}
	}
	
	//sets instance of eFeeCalculator
	public void setExtraFeeCalculator(IExtraFeeCalculator eFeeCalculator) {
		
		Admin.eFeeCalculator=eFeeCalculator;
	}
	
	//gets instance of eFeeCalculator
	public IExtraFeeCalculator getExtraFeeCalculator() {
		
		return eFeeCalculator;
	}
	
}
