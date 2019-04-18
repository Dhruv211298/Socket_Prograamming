package dhruv.ajt;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Server 
{
	public static void main(String[] args) throws Exception
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Server Waiting For Client Request..!!");
		ServerSocket ss=new ServerSocket(5555);
		Socket s=ss.accept();
		System.out.println("Connection Sccessfully Done..!!");
		DataInputStream ds=new DataInputStream(s.getInputStream());
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		System.out.println("!!----------------------------------------------------!!");
		String msg=null;
		while(true)
		{
			msg=ds.readUTF();
			if(msg.equalsIgnoreCase("quit"))
			{
				break;
			}
			System.out.println("Client Says:"+msg);
			
			System.out.println("Server Writes Messages:");
			msg=scan.nextLine();
			dos.writeUTF(msg);
		}
		s.close();
		ss.close();
	}
}
