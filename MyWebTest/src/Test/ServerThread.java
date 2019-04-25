package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
	
	private Socket socket;
	public ServerThread(Socket socket) {
		super();
		this.socket=socket;
	}
	
	public void run() {
		try {
			//读取信息
			System.out.println("客户端连接成功...");
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String row=bufferedReader.readLine();
			String [] infos=row.split("#");
			
			//发送信息
			OutputStream outputStream=socket.getOutputStream();
			PrintWriter printWriter=new PrintWriter(outputStream,true);
			
			System.out.println("用户名:"+infos[1]+"  密码："+infos[2]);
			
			if(infos[1].equals(infos[2])) {
				printWriter.println("fail");
				System.out.println("login fail");
			}else {
				printWriter.println("SUCC");
				System.out.println("login succ");
			}
			
			
		}catch(Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
			
		
		
		
		
		
	}
	
}