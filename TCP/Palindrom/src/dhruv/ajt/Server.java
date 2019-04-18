package dhruv.ajt;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server 
{
	public static void main(String args[]) throws Exception
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Server Waiting For Client Request...!");
		ServerSocket ss=new ServerSocket(7777);
		Socket s=ss.accept();
		System.out.println("!!...Connection Successfully Done...!!");
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		DataInputStream dis=new DataInputStream(s.getInputStream());
		String msg,str="";
		System.out.println("!----------------------------------------------------!");
		msg=dis.readUTF();
		for(int i=msg.length()-1;i>=0;i--)
		{
			str=str+msg.charAt(i);
		}
		System.out.println(str);
		dos.writeUTF(str);
		s.close();
		ss.close();
	}
}
