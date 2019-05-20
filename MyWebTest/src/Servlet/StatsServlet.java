package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.QueryDao;
import Dao.StatsDao;

@WebServlet("/statsServlet")
public class StatsServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
		resp.setContentType("text=html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter printWriter=resp.getWriter();
		
		String name=req.getParameter("check");
		String jsonStr=StatsDao.Query();
		if(jsonStr==null) {
			System.out.println("获取失败");
			printWriter.write("fail");
			
		}else {
			System.out.println("获取成功");
			printWriter.write(jsonStr);
		}
		printWriter.flush();
		printWriter.close();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
