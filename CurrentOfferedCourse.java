package assignment04;
import java.util.ArrayList;
import java.util.Iterator;

public final class CurrentOfferedCourse implements Iterable<Course> {

		private static ArrayList<Course> cList;
		private static CurrentOfferedCourse instance=null;
		
		private CurrentOfferedCourse() { //private due to Singleton class
			cList = new ArrayList<Course>();
		}
		
		//Use this to create CurrentOfferedCourse class object
		public static CurrentOfferedCourse getInstance() {
			 
			if(instance==null) {
				 instance= new CurrentOfferedCourse();
			 }
			 
			return instance;
		}
		
		
		//adds course to list
		public void addCourse(Course course) {
			
			cList.add(course);
		}
		
		//To get a course by comparing objects
		public Course getCourse(Course course) {
			
			for(Course temp : cList) {
				if(temp==course)
					return course;	
			}
			
			return course=null;
		}
		
		//returns ArrayList object that holds courses
		public ArrayList<Course> getCourseList() {
			
			return cList;
		}
		
		@Override
		public Iterator<Course> iterator(){
			
			return CurrentOfferedCourse.cList.iterator();
		}


}
