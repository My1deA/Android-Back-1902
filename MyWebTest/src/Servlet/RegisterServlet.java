package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import org.json.JSONObject;

import com.alibaba.fastjson.JSON;

import Dao.UserDao;
import Model.UserItem;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private String username;
	private String password;
	private UserItem item;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
		
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter printWriter=resp.getWriter();
		
		username=req.getParameter("username");
		password=req.getParameter("password");
		item=new UserItem(username, password);
		System.out.println("Username: "+username+"  password:"+password );
		
		String jsonStr=req.getParameter("jsonStr");
		JSONObject obj=new JSONObject(jsonStr);
		String uname=obj.getString("username");
		String upass=obj.getString("password");
		System.out.println("Org.Json sername: "+uname+"  password:"+upass);
		
		
//		com.alibaba.fastjson.JSONObject ob3=new com.alibaba.fastjson.JSONObject();
//		ob3.pu
		com.alibaba.fastjson.JSONObject obj2=(com.alibaba.fastjson.JSONObject) JSON.parseObject(jsonStr);
		uname=obj2.getString("username");
		upass=obj2.getString("password");
		System.out.println("FastJson sername: "+uname+"  password:"+upass);
		
		
		if(UserDao.register(item)) {
			System.out.println("注册成功");
			printWriter.write("2#SUCC");
		}else {
			System.out.println("注册失败");
			printWriter.write("2#FAIL");
		}
		
		printWriter.flush();
		printWriter.close();
		
		
		
		
	}
	
}

//doGet(req, resp);
//
////设置请求格式
//resp.setContentType("text/html,charset=utf-8");
//resp.setCharacterEncoding("utf-8");
//
////获得信息
//username=req.getParameter("username");
//password=req.getParameter("password");
//item=new UserItem(username,password);
//
////获得输出流
//OutputStream outputStream=resp.getOutputStream();
//PrintWriter printWriter=new PrintWriter(outputStream,true);
//if(UserDao.register(item)) {
//	System.out.println("注册成功");
//	printWriter.println("2#SUCC");
//	
//}else {
//	System.out.println("注册失败");
//	printWriter.println("2#FAIL");
//}