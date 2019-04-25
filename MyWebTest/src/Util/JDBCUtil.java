package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;

//0 登录 1注册 5#返回信息

public class JDBCUtil {
	
	private static String url="jdbc:mysql://localhost:3306/demodatabase?serverTimezone=UTC";
//	private static String url="jdbc:mysql://172.16.86.194:3306/demodatabase?serverTimezone=UTC";
	private static String driverClass="com.mysql.cj.jdbc.Driver";
	private static String username="root";
	private static String password="Password";
	private static Connection con;
	
	static {
		try {
			Class.forName(driverClass);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			con=DriverManager.getConnection(url,username,password);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
	
	public static void Close() {
		if(con!=null) {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
				
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
}
