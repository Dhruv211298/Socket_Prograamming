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
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		DataInputStream dis=new DataInputStream(s.getInputStream());
		String msg=null;
		System.out.println("!---------------------------------------------!");
		System.out.println("Data Received From Client.");
		msg=dis.readUTF();
		String str="";
		for(int i=msg.length()-1;i>=0;i--)
		{	
			char c=msg.charAt(i);
			if(((int)c)<97)
			{	
				String c1=Character.toString(c);
				str=str+c1.toLowerCase();
			}
			else
			{
				String c1=Character.toString(c);
				str=str+c1.toUpperCase();
			}
		}
		dos.writeUTF(str);
		s.close();
		ss.close();
	}
}
