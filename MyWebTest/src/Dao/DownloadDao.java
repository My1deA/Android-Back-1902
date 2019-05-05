package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import org.json.JSONArray;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import Model.UploadItem;
import Util.JDBCUtil;

public class DownloadDao {
	private static ArrayList<UploadItem> array=new ArrayList<UploadItem>();
	private static Connection connection=null;
	private static PreparedStatement statement=null;
	private static ResultSet set=null;
	//ali
	private static JSONObject jsonObject=new JSONObject();
	private static JSONArray jsonArray=new JSONArray();
	private static int count=0;
	private static String jsonStr;
	
	public static ArrayList<UploadItem> query(){
		
		try {
			connection=JDBCUtil.getConnection();
			String sql="select * from uploadinfo order by ids desc limit 3";
			statement=connection.prepareStatement(sql);
			set=statement.executeQuery(sql);
			while(set.next()) {
				UploadItem item=new UploadItem();
				int ids=set.getInt(1);
				item.setUid(set.getString(2));
				item.setTime(set.getString(3));
				item.setUrl(set.getString(4));
				item.setText(set.getString(5));
				item.setLoaction(set.getString(6));
				item.setType(set.getString(7));
				array.add(item);
				
//				JSONObject obj=new JSONObject();
//				obj.put("uid", item.getUid());
//				obj.put("url", item.getUrl());
//				obj.put("text", item.getText());
//				
//				jsonArray.put(obj);
			}
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.Close();
			
		}
		
		if(array==null) {
			System.out.println("没有相应的记录");
		}else {
			System.out.println("查询 "+array.size()+" 条记录");
			 for(int i=0;i<array.size();i++) {
				 UploadItem it=array.get(i);
				 System.out.println(it.getText());
			
			 }
			 
//			 System.out.println();
//			 jsonStr=jsonArray.toString();
//			 System.out.println("jsonStr"+jsonStr);
////			 JSONObject temp=JSON.parseObject(jsonStr);
//			 com.alibaba.fastjson.JSONArray A=JSON.parseArray(jsonStr);
//			 for(int i=0;i<3;i++) {
////				 JSONObject tobj=(JSONObject) temp.get("item"+i);
//				 JSONObject tobj=A.getJSONObject(i);
//				 System.out.println(tobj.get("uid"));
//				 System.out.println(tobj.get("url"));
//				 System.out.println(tobj.get("text"));
//			 }
			 
			 
			 
		}
		return array;
	}
	
	public static void main(String[] args) {
		DownloadDao.query();
	}

}
