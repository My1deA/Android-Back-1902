package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonArray;

import Model.UserItem;
import Util.JDBCUtil;

public class StatsDao {
	private static Connection connection=null;
	private static PreparedStatement statement=null;
	private static ResultSet set=null;
	private static int picsum=0;
	private static int videosum=0;
	private static JSONObject jsonObject=null;
	
	public static String Query(UserItem item) {
		try {
			connection=JDBCUtil.getConnection();
			String sql="select * from statsinfo";
			statement=connection.prepareStatement(sql);
			set=statement.executeQuery(sql);
			jsonObject=new JSONObject();
			while(set.next()) {
				int ids=set.getInt(1);
				picsum=set.getInt(2);
				videosum=set.getInt(3);
				jsonObject.put("picsum", picsum);
				jsonObject.put("videosum",videosum);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.Close();
		}
		String jsonStr=jsonObject.toString();
		return jsonStr;
	}
	
	public static void updatePic() {
		try {
			connection=JDBCUtil.getConnection();
			String sql="select * from statsinfo";
			statement=connection.prepareStatement(sql);
			set=statement.executeQuery(sql);
			while(set.next()) {
				int ids=set.getInt(1);
				picsum=set.getInt(2);
				videosum=set.getInt(3);
			}
			
			
			picsum=picsum+1;
			sql="update statsinfo set picsum="+picsum;
			statement=connection.prepareStatement(sql);
			statement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.Close();
		}
	}
	
	public static void updateVideo() {
		try {
			connection=JDBCUtil.getConnection();
			String sql="select * from statsinfo";
			statement=connection.prepareStatement(sql);
			set=statement.executeQuery(sql);
			while(set.next()) {
				int ids=set.getInt(1);
				picsum=set.getInt(2);
				videosum=set.getInt(3);
			}
			
			videosum=videosum+1;
			sql="update statsinfo set videosum="+videosum;
			statement=connection.prepareStatement(sql);
			statement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.Close();
		}
	}
	
	
	
}
