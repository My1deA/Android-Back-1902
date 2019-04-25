package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBTool.DBUtil;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ID = request.getParameter("ID"); 
        String PW= request.getParameter("PW");
        boolean type=false;
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
//        	Connection con=DBUtil.getConnection();
//        	Statement stmt=con.createStatement();
//			String sql="select * from demodatabase.demotable where uid="+ID+" and pwd="+PW;
//			ResultSet rs=stmt.executeQuery(sql);
//		    while(rs.next())
//		    {
//		    	type=true;
//		    }
        	type=true;
        }
        catch(Exception ex)
        {
        	ex.printStackTrace();
        }
        finally
        {
//        	DBUtil.Close();
        	out.print(type);
        	out.flush();
        	out.close();
        }
	}

}
