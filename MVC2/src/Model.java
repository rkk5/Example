import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class Model {
	String name;
	String un;
	String pw;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUn() {
		return un;
	}
	public void setUn(String un) {
		this.un = un;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	String url="jdbc:oracle:thin:@//localhost:1521/xe";
	String username="system";
	String pwd="skd24680";
	Connection con;
	PreparedStatement pstmt;
	ResultSet resultset;
	Model()
	{   try
	   {
		DriverManager.registerDriver(new OracleDriver());
		con=DriverManager.getConnection(url,username,pwd);
	   }
	catch (SQLException e) {
		
		e.printStackTrace();
	}
		
	}
	int register()
	{
		try
		{
			String s="INSERT INTO MVCDATA2 VALUES(?,?,?)";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1, name);
			pstmt.setString(2, un);
			pstmt.setString(3, pw);
			
			int x=pstmt.executeUpdate();
			return x;
				
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
}


	

