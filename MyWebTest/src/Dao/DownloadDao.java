package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import Model.UploadItem;
import Util.JDBCUtil;

//ali size() org length()

public class DownloadDao {
//	private static ArrayList<UploadItem> arraylist=new ArrayList<UploadItem>();
	private static Connection connection=null;
	private static PreparedStatement statement=null;
	private static ResultSet set=null;
	//ali
//	private static JSONObject jsonObject=new JSONObject();
	private static JSONArray jsonArray=null;
	private static int count=0;
	private static String jsonStr=null;
	
	
	
	public static String query(int count) {
		try {
			connection=JDBCUtil.getConnection();
			String sql="select * from uploadinfo order by time desc limit "+count;
			statement=connection.prepareStatement(sql);
			set=statement.executeQuery(sql);
			
			jsonArray=new JSONArray();
			
			while(set.next()) {
				
				JSONObject jsonObject=new JSONObject();
				
				int ids=set.getInt(1);
				jsonObject.put("uid",set.getString(2));
				jsonObject.put("time",set.getString(3));
				jsonObject.put("url",set.getString(4));
				jsonObject.put("text",set.getString(5));
				jsonObject.put("location",set.getString(6));
				jsonObject.put("type",set.getString(7));
				
				jsonArray.add(jsonObject);
			}
			
			jsonStr=jsonArray.toString();
			
		}catch(Exception e) {
			e.printStackTrace();
			JDBCUtil.Close();
		}
		
		if(jsonStr==null) {
			System.out.println("没有相应的记录");
		}else {
			System.out.println("查询 "+jsonArray.size()+" 条记录 \n text:\n ");
		}
		
		return jsonStr;
	}
	
	public static String query(){
		
		try {
			connection=JDBCUtil.getConnection();
			String sql="select * from uploadinfo order by time desc limit 3";
			statement=connection.prepareStatement(sql);
			set=statement.executeQuery(sql);
			jsonArray=new JSONArray();
			while(set.next()) {
				JSONObject jsonObject=new JSONObject();
	
				int ids=set.getInt(1);
				jsonObject.put("uid",set.getString(2));
				jsonObject.put("time",set.getString(3));
				jsonObject.put("url",set.getString(4));
				jsonObject.put("text",set.getString(5));
				jsonObject.put("location",set.getString(6));
				jsonObject.put("type",set.getString(7));
				
				jsonArray.add(jsonObject);
				
			}
			jsonStr=jsonArray.toString();
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.Close();
			
		}
		
		if(jsonStr==null) {
			System.out.println("没有相应的记录");
		}else {
			System.out.println("查询 "+jsonArray.size()+" 条记录 \n text:\n ");
			 for(int i=0;i<jsonArray.size();i++) {
				JSONObject obj2=jsonArray.getJSONObject(i);
				 System.out.println(obj2.getString("text"));
			
			 }

		}
		System.out.println(jsonStr);
		return jsonStr;
	}
	
	public static void main(String[] args) {
		DownloadDao.query();
	}

}



//UploadItem item=new UploadItem();
//int ids=set.getInt(1);
//item.setUid(set.getString(2));
//item.setTime(set.getString(3));
//item.setUrl(set.getString(4));
//item.setText(set.getString(5));
//item.setLoaction(set.getString(6));
//item.setType(set.getString(7));
//arraylist.add(item);

//JSONObject obj=new JSONObject();
//obj.put("uid", item.getUid());
//obj.put("url", item.getUrl());
//obj.put("text", item.getText());
//
//jsonArray.put(obj);




//System.out.println();
//jsonStr=jsonArray.toString();
//System.out.println("jsonStr"+jsonStr);
////JSONObject temp=JSON.parseObject(jsonStr);
//com.alibaba.fastjson.JSONArray A=JSON.parseArray(jsonStr);
//for(int i=0;i<3;i++) {
////	 JSONObject tobj=(JSONObject) temp.get("item"+i);
//	 JSONObject tobj=A.getJSONObject(i);
//	 System.out.println(tobj.get("uid"));
//	 System.out.println(tobj.get("url"));
//	 System.out.println(tobj.get("text"));
//}
