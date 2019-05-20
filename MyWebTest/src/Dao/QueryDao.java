package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonArray;

import Model.UserItem;
import Util.JDBCUtil;

public class QueryDao {
	private static Connection connection=null;
	private static PreparedStatement statement=null;
	private static ResultSet set=null;
	private static int count=0;
	private static JSONArray jsonArray=null;
	private static String jsonStr=null;
	
	public static String query(String name) {
		try {
			connection=JDBCUtil.getConnection();
			String sql="select * from uploadinfo where uid='"+name+"' order by time desc";
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
				count++;
				if(count>=2) {
					break;
				}
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
}
