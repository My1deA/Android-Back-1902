package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ScoketTest {
	
	private static String port="8888";
	
	public static void main(String[] args) {
		
		try {
			ServerSocket server=new ServerSocket(8888);
			while(true) {
				//等待客户端连接
				System.out.println("等待连接...");
				Socket socket=server.accept();
				
				
				ServerThread t=new ServerThread(socket);
				t.start();
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}


////得到客户端 的信息
//BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
//String row=bufferedReader.readLine();
//String[] info=row.split("#");
//System.out.println("用户名:"+info[1]+"  密码："+info[2]);
//
//
////返回客户端信息
//OutputStream outputStream=socket.getOutputStream();
//PrintWriter printWriter=new PrintWriter(outputStream,true);
//
//
//if(info[1].equals(info[2])) {
//	printWriter.println("fail");
//}
//
//printWriter.println("SUCC");
