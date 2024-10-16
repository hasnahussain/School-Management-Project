package sms;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DBOperation 
{
	//This method is for inserting value to teacher table
public static void addStaff(Staff obj)
{
try
{
	int id=0;
	Statement stmt=DBConnection.createstmt();
	//Inserting value to teacher table
	String sql="insert into teacher(Teacher_name,Teacher_dob,Teacher_gender,Teacher_email,Teacher_course,Role,Password)values ('"+obj.getTeacher_name()+"','"+obj.getTeacher_dob()+"','"+obj.getTeacher_gender()+"','"+obj.getTeacher_email()+"','"+obj.getTeacher_course()+"','"+obj.getRole()+"','"+obj.getPassword()+"')";
	int resultCount=stmt.executeUpdate(sql);
	if(resultCount==1)
	{
		System.out.println("INSERTED TEACHER SQL SUCCESS");
		System.out.println("\n*********************************\n");
        sql="select max(teacher_id) from teacher";
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next())
        {
        	id=rs.getInt("max(teacher_id)");
        }
        if(id>0)
        {
        	//insertion to login table only the required columns
        	sql="insert into login (id,username,password,role)value("+id+",'"+obj.getTeacher_email()+"','"+obj.getPassword()+"','"+obj.getRole()+"')";
        	if(stmt.executeUpdate(sql)==1);
        	{
        		System.out.println("\n******LOGIN CREATED SUCCESSFULLY******\n");
        	}
        }
	}
	    else
	  {
		System.out.println("SQL ERROR");
	}
}
catch(Exception e)
{
	System.out.println(e);
}
}
public static void checkLogin(String un,String ps)
{
	int id=0;
	String role="";
	try
	{
		Statement stmt=DBConnection.createstmt();
		String sql="select id,role from login where password='"+ps+"' and username='"+un+"'";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			id=rs.getInt("id");
			role=rs.getString("role");
		}
		if(id>-1)
		{
			switch(role)// used to identify teacher and student based on role
			{
			case "teacher":
			     Teacherprofile t=new Teacherprofile(id);
			     Teacherprofile.display();
				break;
			case "student":
				Student s=new Student(id);
				s.displayS();
				break;
			case "admin":
				Admin.profileView();
				break;
				
			}
		}
		else
			
		{
			System.out.println("invalid username,password");
		}
		
	}
	catch(Exception e )
	{
		System.out.println(e);
	}
}
     public static Staff teacherdetails(int id)
{
Staff sf=new Staff();
try
{
	Statement stmt=DBConnection.createstmt();
	//fetching details based on id of teacher
	String sql="select * from teacher where teacher_id="+id;
	ResultSet rs=stmt.executeQuery(sql);
	while(rs.next())
	{
	sf.setTeacher_name(rs.getString("teacher_name"));
    sf.setTeacher_dob(rs.getString("teacher_dob"));
	sf.setTeacher_gender(rs.getString("teacher_gender"));
	sf.setTeacher_email(rs.getString("teacher_email"));
	}
}
catch(Exception e)
{
	System.out.println(e);
}
return sf;
}
     static void createStudent()
     {
    	 //collecting details of student
    	 Studentprofile p=new Studentprofile(); 
    	 Scanner c=new Scanner(System.in);
    	 System.out.println("Enter Admission Number");
    	 p.setAdm_no(c.nextInt());
    	 System.out.println("Enter Student Name");
    	 p.setStudent_name(c.next());
    	 System.out.println("Enter Student date of birth");
    	 p.setStudent_dob(c.next());
    	 System.out.println("Enter Guardian Number");
    	 p.setGuardian_name(c.next());
    	 System.out.println("Enter Role");
    	 p.setRole(c.next());
    	 System.out.println("Enter Email");
    	 p.setEmail(c.next());
    	 addStudent(p);
     }
     static void addStudent(Studentprofile p)
     {
    	 try
    	 {
    	int id=0;
    	Statement stmt=DBConnection.createstmt();
    	// Adding value to student table
    	String sql="insert into student(adm_no,student_name,student_dob,guardian_name,role,email,teacher_id)values("+p.getAdm_no()+",'"+p.getStudent_name()+"','"+p.getStudent_dob()+"','"+p.getGuardian_name()+"','"+p.getRole()+"','"+p.getEmail()+"',"+Teacherprofile.id+")";//taking id 
    	int resultCount=stmt.executeUpdate(sql);
    	if(resultCount==1)
    	{
    		System.out.println("INSERTED STUDENT SUCCESS");
    		System.out.println("\n*********************************\n");
            sql="select max(adm_no) from student";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
            	id=rs.getInt("max(adm_no)");
            }
            if(id>0)
            {
            	sql="insert into login (id,username,password,role,adm_no)value("+id+",'"+p.getEmail()+"','"+p.getStudent_dob()+"','"+p.getRole()+"',"+p.getAdm_no()+")";
            	if(stmt.executeUpdate(sql)==1);
            	{
            		System.out.println("******LOGIN CREATED SUCCESSFULLY******\n");
            	}
            }
    	}
    	else
    	{
    		System.out.println("sql error");
    	}
    	 }
    	 catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }
     }
     
     static void checkStudentlogin(String un,String ps)
     {
    	 int id=0;
    		String role="";
    		try {
    		Statement stmt=DBConnection.createstmt();
    		String sql="select id,role from login where password='"+ps+"' and username='"+un+"'";
    		ResultSet rs=stmt.executeQuery(sql);
    		while(rs.next())
    		{
    			id=rs.getInt("id");
    			role=rs.getString("role");
    		}
     }
    		catch(Exception e)
    		{
    			System.out.println(e);
    		}
     
     }
     static Studentprofile viewByid(int id)
     {
    	 Studentprofile sp=new Studentprofile();
    	 try
    	 {
    		 Statement stmt=DBConnection.createstmt();
    		 String sql="select *from student where adm_no= "+id;
    		 ResultSet rs=stmt.executeQuery(sql);
    		 while(rs.next())
    		 {
    			sp.setAdm_no(rs.getInt("adm_no"));
    			sp.setStudent_name(rs.getString("student_name"));
    			sp.setStudent_dob(rs.getString("student_dob"));
    			sp.setGuardian_name(rs.getString("guardian_name"));
    			sp.setRole(rs.getString("role"));
    			sp.setEmail(rs.getString("email"));
    		 }
    	 }
    	 catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }
    	 return sp;
     }
     static void marklistDetails()
     {
    	 Marklist m=new Marklist();
    	 Scanner sc=new Scanner(System.in);
    	 System.out.println("Enter Admission Number: ");
    	 m.setAdm_no(sc.nextInt());
    	 System.out.println("Enter Malayalam Mark: ");
    	 m.setMalayalam(sc.next());
    	 System.out.println("Enter Malayalam2 Mark: ");
    	 m.setMalayalam2(sc.next());
    	 System.out.println("Enter English Mark: ");
    	 m.setEnglish(sc.next());
    	 System.out.println("Enter Maths Mark: ");
    	 m.setMaths(sc.next());
    	 System.out.println("Enter Hindi Mark:");
    	 m.setHindi(sc.next());
    	 System.out.println("Enter CS Mark: "); 
    	 m.setCS(sc.next());
    	 System.out.println("Enter SS Mark: ");
    	 m.setSS(sc.next());
    	 System.out.println("Enter Physics Mark: ");
    	 m.setPhysics(sc.next());
    	 System.out.println("Enter Chemistry Mark: ");
    	 m.setChemistry(sc.next());
    	 System.out.println("Enter Biology Mark: ");
    	 m.setBiology(sc.next());
    	 addMarklistdetails(m);
     }
     static void addMarklistdetails(Marklist m)
     {
    	 try
    	 {
    	 int id=0;
    		 Statement stmt=DBConnection.createstmt();
    		 String sql="insert into marklist(adm_no,Malayalam,Malayalam2,English,Maths,Hindi,CS,SS,Physics,Chemistry,Biology)values("+m.getAdm_no()+",'"+m.getMalayalam()+"','"+m.getMalayalam2()+"','"+m.getEnglish()+"','"+m.getMaths()+"','"+m.getHindi()+"','"+m.getCS()+"','"+m.getSS()+"','"+m.getPhysics()+"','"+m.getChemistry()+"','"+m.getBiology()+"')";
    		 int resultCount=stmt.executeUpdate(sql);
    		 if(resultCount==1)
    	    	{
    	    		System.out.println("MARK INSERTED SUCCESSFULLY\n");
    	            
    	 }
    	 }
    	 catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }
    	 
     }
     static void teacheraddviewall()
	 {
    	 Studentprofile sp=new Studentprofile();
		try {
			 Statement stmt=DBConnection.createstmt();
			 String sql="select adm_no from student where teacher_id= "+Teacherprofile.id;
			 ResultSet rs=stmt.executeQuery(sql);
			 while(rs.next())
			 {
				    Teacherprofile.displayStudent(rs.getInt("adm_no")); 
			 }
			
		} 
		catch (Exception e)
		{
		System.out.println(e);	
		} 
	 }
}
