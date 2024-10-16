package sms;

import java.util.Scanner;

public class Teacherprofile 
{
   static int id=0;// id of the teacher currently operating until logout.It start working from login

public Teacherprofile(int id) {
	super();
	this.id = id;
}

static void display()
{
	
	Staff str=DBOperation.teacherdetails(id);
	System.out.println("WELCOME\n ");
	System.out.println("Name  "+str.getTeacher_name());
	System.out.println("DOB   "+str.getTeacher_dob());
	System.out.println("GENDER  "+str.getTeacher_gender());
	System.out.println("email  "+str.getTeacher_email());
	
	Scanner S=new Scanner(System.in);	
	System.out.println("\n1.ADD STUDENT\n2.VIEW STUDENT BY ID\n3.VIEW ALL STUDENT\n4.ADD MARKLIST\n5.EXIT\nPLEASE ENTER ANY OPTION");
	int value=S.nextInt();
	switch(value)
	{
	case 1:
		DBOperation.createStudent();
		break;
	case 2:
		System.out.println("Enter the id ");
		displayStudent(S.nextInt());
		break;
	case 3:
		DBOperation.teacheraddviewall();
	
		break;
	case 4:
		
		DBOperation.marklistDetails();
		break;
		default:
			System.out.println("Exited");
			break;
	}
}
static void displayStudent(int n)
{
	DBOperation t=new DBOperation();
	Studentprofile sp=t.viewByid(n);
	System.out.println("Admission number "+sp.getAdm_no());
	System.out.println("Student name "+sp.getStudent_name());
	System.out.println("Student date of birth "+sp.getStudent_dob());
	System.out.println("Guardian name "+sp.getGuardian_name());
	System.out.println("Role "+sp.getRole());
	System.out.println("Emale "+sp.getEmail());
	System.out.println("\n");
	}

  
}
