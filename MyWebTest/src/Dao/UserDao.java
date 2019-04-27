package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.UserItem;
import Util.JDBCUtil;

//0 登录 1注册 5#返回信息

public class UserDao {
	
	private static Connection con=null;
	private static PreparedStatement statement=null;
	private static ResultSet set=null;
	private static UserItem tempUser=null;
	
	public static boolean login(UserItem user) {
		if(query(user)==true) {
			if(user.getPassword().equals(tempUser.getPassword())) {
				System.out.println("登录成功");
				return true;
			}else {
				System.out.println("密码错误");
				return false;
			}
		}else {
			System.out.println("没有该用户信息");
			return false;
		}
	}
	
	public static boolean  register(UserItem user) {
		if(query(user)==false) {
			con=JDBCUtil.getConnection();
			String sql="insert into userinfo(uid,upw) values(?,?)";
			try {
				statement=con.prepareStatement(sql);
				statement.setString(1,user.getUsername());
				statement.setString(2, user.getPassword());
				//插入
				statement.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.Close();
			}
			return true;
		}else {
			System.out.println("我也不知道什么错误了");
			return false;
		}
	}
	
	public static boolean  query(UserItem user) {
	
		boolean flag=false;
		
		con=JDBCUtil.getConnection();
		String uid=user.getUsername();
		String sql="select * from userinfo where uid="+uid;
		
		try {
			statement=con.prepareStatement(sql);
			//查询
			set=statement.executeQuery(sql);
			while(set.next()) {
				flag=true;
				int ids=set.getInt(1);
				String username=set.getString(2);
				String password=set.getString(3);
				System.out.println("id：   "+ids+"  username: "+username+"  password:  "+password);
				tempUser=new UserItem(username,password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.Close();
		}
		return flag;
	}
	
	public static void show() {
		Connection con=JDBCUtil.getConnection();
		PreparedStatement statement=null;
		ResultSet rSet;
		
		if(con!=null){
			System.out.println("数据库连接成功");
			try {
				String condition="select * from userinfo";
				statement=con.prepareStatement(condition);
				rSet=statement.executeQuery(condition);
				while(rSet.next()) {
					int ids=rSet.getInt(1);
					String uid=rSet.getString(2);
					String upw=rSet.getString(3);
					System.out.println("id：   "+ids+"  username: "+uid+"  password:  "+upw);
				}
				
				JDBCUtil.Close();
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else{
			System.out.println("数据库连接失败");
		}
	}
	

//	public static void main(String[] args) {
//		UserItem item=new UserItem("1","12");
//		if(UserDao.login(item)) {
//			System.out.println("登录成功");
//		}
//	}
	
}
