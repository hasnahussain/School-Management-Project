package sms;

import java.sql.ResultSet;
import java.sql.Statement;

public class ADminOperation 
{
	static void studentoperationbyadmin()
	{
		try
		{
			Statement stmt=DBConnection.createstmt();
			String sql="select student.student_name,student.student_dob,student.guardian_name,marklist.Malayalam,marklist.Malayalam2,marklist.English,marklist.Maths,marklist.Hindi,marklist.CS,marklist.SS,marklist.Physics,marklist.Chemistry,marklist.biology from student inner join marklist on student.adm_no=marklist.adm_no  ";
			ResultSet rs=stmt.executeQuery(sql);
			
			 while(rs.next())
		{
				System.out.println("Name"+rs.getString("student_name"));
				System.out.println("DOB"+rs.getString("student_dob"));
				System.out.println("Guardian"+rs.getString("guardian_name"));
				System.out.println("Malayalam= "+rs.getString("Malayalam")+" Malayalam2= "+rs.getString("Malayalam2")+" English= "+rs.getString("English")+" Maths ="+rs.getString("Maths")+" Hindi= "+rs.getString("Hindi")+" CS= "+rs.getString("CS")+" SS= "+rs.getString("SS")+" Physics= "+rs.getString("Physics")+" Chemistry= "+rs.getString("Chemistry")+" biology= "+rs.getString("biology"));
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	static void teacheroperationbyadmin()
	{
		try
		{
			Statement stmt=DBConnection.createstmt();
			String sql="select teacher.teacher_name,teacher.teacher_course,student.student_name,student.student_dob,guardian_name from teacher inner join student on teacher.teacher_id=student.teacher_id";
			ResultSet rs=stmt.executeQuery(sql);
			 while(rs.next())
			 {
				 System.out.println("Teacher Name: "+rs.getString("teacher_name"));
				 System.out.println("Teacher Course: "+rs.getString("teacher_course"));
				 System.out.println("Student Name: "+rs.getString("student_name"));
				 System.out.println("Student DOB: "+rs.getString("student_dob"));
				 System.out.println("Guardian Name: "+rs.getString("guardian_name"));
			 }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}

}
