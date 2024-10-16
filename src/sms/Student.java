package sms;

import java.sql.Statement;
import java.util.Scanner;

public class Student 
{
 static int adm_no=0;

public Student(int adm_no) {
	super();
	this.adm_no = adm_no;
}
static void displayS()
{

	StudentDBOperation sd=new StudentDBOperation();
	Studentprofile st=sd.studentDetails();
	System.out.println("WELCOME "+st.getStudent_name());
	Scanner sc=new Scanner(System.in);
	int value=0;
	do {
		System.out.println("1.VIEW PROFILE\n2.VIEW MARKLIST\n3.EXIT\n PLEASE ENTER ANY OPTION");
		 value=sc.nextInt();
		 switch(value)
			{
			case 1:
				viewStudentdetails();
				break;
			case 2:
				viewMark();
				break;
				default:
					System.out.println("YOU ARE EXITED");
					break;
		 
			} 
	}
	while(value!=3);}
	

static void viewStudentdetails()
{
	StudentDBOperation sd=new StudentDBOperation();
	Studentprofile st=sd.studentDetails();
	System.out.println("Name "+st.getStudent_name());
	System.out.println("ADMISSION NUMBER "+st.getAdm_no());
	System.out.println("DATE OF BIRTH "+st.getStudent_dob());
	System.out.println("EMAIL "+st.getEmail());
	System.out.println("GUARDIAN NAME "+st.getGuardian_name());
	
	
}
static void viewMark()
{
	StudentDBOperation sd=new StudentDBOperation();
	Marklist m=sd.mark();
	System.out.println("Malayalam "+m.getMalayalam());
	System.out.println("Malayalam2 "+m.getMalayalam2());
	System.out.println("English "+m.getEnglish());
	System.out.println("Hindi "+m.getHindi());
	System.out.println("CS "+m.getCS());
	System.out.println("SS "+m.getSS());
	System.out.println("Biology "+m.getBiology());
	System.out.println("Chemistry "+m.getChemistry());
	System.out.println("Physics "+m.getPhysics());
	
}

}
