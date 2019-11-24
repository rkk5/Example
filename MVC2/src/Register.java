

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String un=req.getParameter("un");
		String pw=req.getParameter("pw");
		
		Model m=new Model();
		m.setName(name);
		m.setUn(un);
		m.setPw(pw);
		int x=m.register();
		if(x==1)
		{
			res.sendRedirect("/MVC2/success.html");
		}
		else
		{
			res.sendRedirect("/MVC2/failure.html");
		}
		
	}
	
}