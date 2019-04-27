package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;

import Model.UploadItem;
import Model.UserItem;
import Util.JDBCUtil;

// uid,text,location,time,type,url
// 查询 executeQuery(sql)   ResultSet
// 插入 insert 删除 delete 更新 update executeUpdate(); 
//实现 增删查改
public class UploadDao {
	private static Connection connection=null;//连接
	private static PreparedStatement statement=null;//预处理
	private static ResultSet set=null;//结果
	private static ArrayList<UploadItem> list=new ArrayList<UploadItem>();
	
	//增
	public static boolean insert(UploadItem item) {
		try {
			connection=JDBCUtil.getConnection();
			String sql="insert into uploadinfo(uid,text,location,time,type,url) values(?,?,?,?,?,?)";
			statement=connection.prepareStatement(sql);
			statement.setString(1, item.getUid());
			statement.setString(2, item.getText());
			statement.setString(3, item.getLoaction());
			statement.setString(4, item.getTime());
			statement.setString(5,item.getType());
			statement.setString(6, item.getUrl());
			
			statement.executeUpdate();
			System.out.println("文件 上传成功");
			return true;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			JDBCUtil.Close();
		}

		System.out.println("未上传 相应文件");
		return false;
	}
	
	//删 // uid,text,location,time,type,url
	public static boolean delete(String uid,String time) {
		
		try {
			connection=JDBCUtil.getConnection();
			String sql="delete from uploadinfo where uid=? and time=?";
			statement=connection.prepareStatement(sql);
			statement.setString(1, uid);
			statement.setString(2, time);
			
			statement.executeUpdate();
			System.out.println("文件 删除成功");
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.Close();
		}
		
		System.out.println("未删除 相应文件");
		return false;
	}
	
	//查 根据用户名 和 上传时间
	public static boolean query(String uid,String condition) {
		
		try {
			connection=JDBCUtil.getConnection();
			String sql="select * from uploadinfo where uid="+uid+" and text="+condition;
			statement=connection.prepareStatement(sql);
			set=statement.executeQuery(sql);
			while(set.next()) {
				String t_uid=set.getString(1);
				String t_text=set.getString(2);
				String t_location=set.getString(3);
				String t_time=set.getString(4);
				String t_type=set.getString(5);
				String t_url=set.getString(6);
				
				UploadItem item=new UploadItem(t_uid, t_text, t_location, t_time, t_type, t_url);
				list.add(item);
			}
			System.out.println("Size: " +list.size());
			if(list.size()>0) {
				System.out.println("文件 查询成功");
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.Close();
		}

		System.out.println("未查询 相应文件");
		return true;
	}
	
	//改 根据 用户名  原文本 和修改内容修改 文本
	public static boolean Update(String uid,String oldtext ,String newtext) {

		try {
			connection=JDBCUtil.getConnection();
			String sql="Update  uploadinfo set text=? where uid=? and text=?";
			statement=connection.prepareStatement(sql);
			statement.setString(1, newtext);
			statement.setString(2, uid);
			statement.setString(3, oldtext);
			
			statement.executeUpdate();
			
			System.out.println("文件 更新成功");
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCUtil.Close();
		}
		
		System.out.println("未更新 相应文件");
		return false;
	}
	

}

//String sql="update users set age=20 where id=1 ";//生成一条mysql语句
//Statement stmt=conn.createStatement();//创建一个Statement对象
//stmt.executeUpdate(sql);//执行SQL语句

//Class.forName("com.mysql.jdbc.Driver");
//        // 2获取连接
//        Connection conn = DriverManager.getConnection(
//              "jdbc:mysql://localhost:3306/mybase", "root", "root");
//        // 3获得预处理对象中
//        String sql = "update sort set sname=? where sid=?";
//         PreparedStatement stat = conn.prepareStatement(sql);
//        // 4 SQL语句占位符设置实际参数
//        stat.setString(1, "数码产品");
//        stat.setInt(2, 1);// 后面这个1是指sid
//        // 5执行SQL语句
//        int line = stat.executeUpdate();

