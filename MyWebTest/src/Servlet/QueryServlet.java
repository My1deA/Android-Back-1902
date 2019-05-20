package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.QueryDao;

@WebServlet("/queryServlet")
public class QueryServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
		resp.setContentType("text=html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter printWriter=resp.getWriter();
		
		String name=req.getParameter("username");
		String jsonStr=QueryDao.query(name);
		if(jsonStr==null) {
			System.out.println("获取失败");
			printWriter.write("fail");
			printWriter.flush();
			
		}else {
			System.out.println("获取成功");
			printWriter.write(jsonStr);
			printWriter.flush();
		}
		printWriter.close();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
