package assignment04;

public class Main {

	public static void main(String[] args) {
	
		//create objects provided in Objects.txt
		
		Course CSE115 = new Course("CSE115", "Programming Language-I", 3, 6000);
		Course CSE173 = new Course("CSE173", "Discrete Mathematics", 3, 6000);
		Course CSE215= new Course("CSE215", "Programming Language-II", 3, 6000);
		Course CSE225 = new Course("CSE225", "Data Structures and Algorithms", 3, 6000);
		Course CSE231 = new Course("CSE231", "Digital Logic Design", 3, 6000);
		Course CSE311 = new Course("CSE311", "Database Systems", 3, 6000);
		Course CSE323 = new Course("CSE323", "Operating Systems Design", 3, 6000);
		Course CSE373 = new Course("CSE373", "Design and Analysis of Algorithms", 3, 6000);

		Student s1 = new Student("Farhan Islam", 1631728042, 2.70, 'Y', 'N');
		Student s2 = new Student("Sadia Sultana", 1821347042, 3.44, 'N', 'Y');
		Student s3 = new Student("Sanjida Akter", 2021746042, 3.65, 'N', 'N');
		Student s4 = new Student("Farhan Bhuiyan", 1923147042, 3.94, 'N', 'N');
		Student s5 = new Student("Mahmudul Hoque", 1524137042, 2.14, 'Y', 'Y');

		//Tasks from Assignment 3
		//Task 1----------------------
		
		Admin a1 = Admin.getInstance();
		
		a1.offerCourse(CSE115);
		a1.offerCourse(CSE173);
		a1.offerCourse(CSE215);
		a1.offerCourse(CSE225);
		a1.offerCourse(CSE231);
		a1.offerCourse(CSE311);
		a1.offerCourse(CSE323);
		a1.offerCourse(CSE373);
		
		a1.publishOfferedCourse();
		
		System.out.println();
		
		
		//Task 2----------------------
		
		s1.makeNewRegistration();
		s2.makeNewRegistration();
		s3.makeNewRegistration();
		
		s1.addCourse(CSE115);
		s1.addCourse(CSE173);
		
		s2.addCourse(CSE115);
		s2.addCourse(CSE215);
		s2.addCourse(CSE225);
		
		s3.addCourse(CSE115);
		s3.addCourse(CSE225);
		s3.addCourse(CSE311);
		
		a1.seeCourseStatus();
		
		System.out.println();
		
		
		//Task 3----------------------
		
		s4.makeNewRegistration();
		s5.makeNewRegistration();
		
		s4.addCourse(CSE115);
		s4.addCourse(CSE225);
		
		s5.addCourse(CSE115);
		s5.addCourse(CSE173);
		s5.addCourse(CSE215);
		
		System.out.println();
		
		
		//Task 4----------------------
		
		a1.increaseSeatCapacity(CSE115, 2);
		
		s4.addCourse(CSE115);
		s5.addCourse(CSE115);
		
		
		//Task 5----------------------
		
		a1.seeCourseStatus();
		
		System.out.println();
		
		
		//Task 6----------------------
		
		s3.addCourse(CSE173);
		s3.addCourse(CSE215);
		s3.addCourse(CSE231);
		s3.addCourse(CSE323);
		
		s5.addCourse(CSE311);
		s5.addCourse(CSE373);
		
		System.out.println();
		
		
		//Task 7----------------------
		
		a1.seeCourseStatus();
		
		System.out.println();
		
		
		//Task 8----------------------
		
		s3.dropCourse(CSE311);
		
		
		//Task 9----------------------
		
		System.out.print(s3.printRegisteredCourse());
		
		System.out.println();

		
		//----------------------------
		
		
		//Tasks from Assignment 4
		//Task 1----------------------
		
		System.out.println(s1.getBillingInfo());
		
		System.out.println();
		
		
		//Task 2----------------------
		
		System.out.println(s2.getBillingInfo());
		
		System.out.println();
		
		
		//Task 3----------------------
		
		a1.setExtraFeeCalculator(new BDTaxAdapter());
		
		System.out.println();
		
		
		//Task 4----------------------
		
		System.out.println(s3.getBillingInfo());
		
		System.out.println();
		
		
		//Task 5----------------------
		
		System.out.println(s4.getBillingInfo());
		
		System.out.println();
		
		
		//Task 6----------------------
		
		s5.printRegistrationSlip();
		
		
	}
	
	

}
