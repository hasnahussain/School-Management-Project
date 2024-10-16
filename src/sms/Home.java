package sms;

import java.sql.Statement;
import java.util.Scanner;

public class Home
{
	public static void main(String[] args)
	{
		mainMenu();
	}	
static void mainMenu()
{
	int choice=0;
	
	do {
	  Scanner s=new Scanner(System.in);
	System.out.println("WELCOME TO MOUNT TABOUR SCHOOL PORTAL\n");
	System.out.println("1.CREATE ACCOUNT");
	System.out.println("2.LOGIN");
	System.out.println("3.EXIT");
	System.out.println("PLEASE CHOICE ANY OPTION");
	 choice =s.nextInt();
	switch(choice)
	{
	case 1:
	    createAccount();
		break;
	case 2:
		createLogin();
		break;
	case 3 :
		System.out.println("YOU ARE EXITED");
		break;
	}}
	while(choice!=3);}
	
	public static Scanner sc=new Scanner(System.in);

	static void createAccount()
	{
		Staff obj=new Staff();
		
		System.out.println("Enter Name:");
		obj.setTeacher_name(sc.next());;
		System.out.println("Enter DOB");
		obj.setTeacher_dob(sc.next());;
		System.out.println("Enter Gender");
		obj.setTeacher_gender(sc.next());
		System.out.println("Enter Email");
		obj.setTeacher_email(sc.next());
		System.out.println("Enter Course");
		obj.setTeacher_course(sc.next());
		System.out.println("Enter Role");
		obj.setRole(sc.next());
		System.out.println("Enter Password");
		obj.setPassword(sc.next());
		//Passing values for database operation of teacher	
		DBOperation.addStaff(obj);	
}
	public static void createLogin()
	{
		//Login for teacher and student
		System.out.println("Enter Username");
		String un=sc.next();
		System.out.println("Enter Password");
	    String ps=sc.next();
	    DBOperation.checkLogin(un, ps);
	    DBOperation.checkStudentlogin(un,ps);
	}
}
