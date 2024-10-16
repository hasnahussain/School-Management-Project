package sms;

import java.util.Scanner;

public class Admin 
{
public static void profileView()
{
	int value=0;
	System.out.println("**********Welcome Admin***********");
	Scanner sc=new Scanner(System.in);
	do 
	{
	System.out.println("1.View All Studentss\n2.View All Teachers\n3.Logout\n Please enter any option");
    value=sc.nextInt();
	switch(value)
	{
	case 1:
		ADminOperation.studentoperationbyadmin(); 
		break;
	case 2:
		ADminOperation.teacheroperationbyadmin();
		break;
	default:
		System.out.println("YOU ARE LOGOUT");
		break;

	}
	}
	while(value!=3);}

}



