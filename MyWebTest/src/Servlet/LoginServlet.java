package Servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;
import Model.UserItem;
import Util.JDBCUtil;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private static UserItem item;
//	private static Connection connection=null;
//	private static PreparedStatement statement=null;
//	private static ResultSet set=null;
	
	public LoginServlet() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		doGet(req, resp);
		//设置相应格式
		resp.setContentType("text/html;charset=utf-8");
		//译码字符
		resp.setCharacterEncoding("UTF-8");
		//创建输出流
		PrintWriter printWriter=resp.getWriter();
		
		username=req.getParameter("username");
		password=req.getParameter("password");
		System.out.println("username:" +username+" password:" +password);
		item=new UserItem(username,password);
//		输出流
		String result="";
		if(UserDao.login(item)) {
			result="1#SUCC";
			System.out.println("登录成功");
		}else {
			result="1#FAIL";
			System.out.println("登录失败");
		}
		printWriter.write(result);
		printWriter.flush();
		printWriter.close();
		

	}	
}		
	
//try {
//	connection=JDBCUtil.getConnection();
//	String sql="select * from userinfo where uid="+username;
//	statement=connection.prepareStatement(sql);
//	set=statement.executeQuery(sql);
//	while(set.next()) {
//		int id =set.getInt(1);
//		String uid=set.getString(2);
//		String upw=set.getString(3);
//		System.out.println("id: "+id+"  username: "+uid+"  password: "+upw);
//		tempItem=new UserItem(uid,upw);
//	}
//	
//	
//	
//	if(tempItem.getPassword().equals(password)) {
//		printWriter.write("1#SUCC");
//		System.out.println("登录成功");
//	}else {
//		printWriter.write("1#FAIL");
//		System.out.println("登录失败");
//	}
//	
//	
//}catch(Exception e) {
//	e.printStackTrace();
//}finally {
//	printWriter.flush();
//	printWriter.close();
//	JDBCUtil.Close();
//}

//String username = req.getParameter("ID"); 
//String password= req.getParameter("PW");
//
//输出流
//PrintWriter printWriter=resp.getWriter();
//String result="";
//if(UserDao.login(item)) {
//	result="1#SUCC";
//	System.out.println("登录成功");
//}else {
//	result="1#FAIL";
//	System.out.println("登录失败");
//}
//printWriter.write(result);
//printWriter.flush();
//printWriter.close();
		
		
		//源
//		String result;
//		PrintWriter out=resp.getWriter();
//		if(UserDao.login(item)) {
//			result="SUCC";
//		}else {
//			result="FAIL";
//		}
//		System.out.println(result);
//		out.write(result);
//		out.flush();
//		out.close();



//try {
//	//输出流
//	OutputStream outputStream=resp.getOutputStream();
//	PrintWriter printWriter=new PrintWriter(outputStream,true);
//	
//	if(UserDao.login(item)) {
//		printWriter.println("5#SUCC");
//		System.out.println("登录成功");
//	}else {
//		printWriter.println("5#FAIL");
//		System.out.println("登录失败");
//	}
//}catch (Exception e) {
//	// TODO: handle exception
//	e.printStackTrace();
//}


// <servlet>
//	<servlet-name>LoginServlet</servlet-name>
//	<servlet-class>Servlet.LoginServlet</servlet-class>
//</servlet>
//<servlet-mapping>
//	<servlet-name>LoginServlet</servlet-name>
//<url-pattern>/loginServlet</url-pattern>
//</servlet-mapping>
//<servlet>
//	<servlet-name>RegisterServlet</servlet-name>
//	<servlet-class>Servlet.RegisterServlet</servlet-class>
//</servlet>
//<servlet-mapping>
//	<servlet-name>RegisterServlet</servlet-name>
//<url-pattern>/registerServlet</url-pattern>
//</servlet-mapping>



