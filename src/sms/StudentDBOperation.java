package sms;

import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDBOperation 
{
static  Studentprofile studentDetails()
{
	 Studentprofile sp=new Studentprofile();
	try 
	{
		Statement stmt=DBConnection.createstmt();
		String sql="select * from student where adm_no= "+Student.adm_no;
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
	} catch (Exception e) 
	{
		System.out.println(e);
	}
	return sp;
}
static Marklist mark()
{
	Marklist m=new Marklist();
	try
	{
		Statement stmt=DBConnection.createstmt();
		String sql="select * from marklist where adm_no= "+Student.adm_no;
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			m.setMalayalam(rs.getString("Malayalam"));
			m.setMalayalam2(rs.getString("Malayalam2"));
			m.setBiology(rs.getString("English"));
			m.setChemistry(rs.getString("Chemistry"));
			m.setCS(rs.getString("CS"));
			m.setHindi(rs.getString("Hindi"));
			m.setMaths(rs.getString("Maths"));
			m.setPhysics(rs.getString("Physics"));
			m.setSS(rs.getString("SS"));
			m.setBiology(rs.getString("Biology"));
		}
	}
	catch (Exception e) 
	{
		System.out.println(e);
	}
	return m;
}
}

