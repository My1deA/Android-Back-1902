package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.alibaba.fastjson.JSONObject;

import Dao.DownloadDao;
import Model.UploadItem;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet{
	
	private static  ArrayList<UploadItem> array=new ArrayList<UploadItem>();
	private static String jsonStr=null;
	private JSONObject jsonObject=null;
	private JSONArray jsonArray=null;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter printWriter=resp.getWriter();
		
		String conditon=req.getParameter("download");
		String countStr=req.getParameter("count");
		int count=Integer.parseInt(countStr);
		
		
		if(count>3) {
			jsonStr=DownloadDao.query(count);
		}else {
			jsonStr=DownloadDao.query();
		}
		
		
		if(jsonStr==null) {
			System.out.println("JsonStr 为空");
		}else {
			System.out.println("转化jsonstr输出");
			System.out.println(jsonStr);
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



//for(int i=0;i<array.size();i++) {
//JSONObject temp=new JSONObject();
//
//temp.put("uid", array.get(i).getUid());
//temp.put("time", array.get(i).getTime());
//temp.put("url", array.get(i).getUrl());
//temp.put("text", array.get(i).getText());
//temp.put("location", array.get(i).getLoaction());
//temp.put("type", array.get(i).getType());
//
//jsonObject.put("item"+i, temp);
//}
//
//jsonStr=jsonObject.toJSONString();
