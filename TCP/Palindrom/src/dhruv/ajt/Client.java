package dhruv.ajt;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client
{
	public static void main(String args[]) throws Exception
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Client Started...!!");
		Socket s=new Socket("localhost",7777);
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		DataInputStream dis=new DataInputStream(s.getInputStream());
		String msg;
		System.out.println("!--------------------------------------------------------------!");
		System.out.println("Client Start Messaging...!");
		msg=scan.next();
		dos.writeUTF(msg);
		System.out.println("!...Message Successfully Send...!");
		String str=dis.readUTF();
		if(msg.equalsIgnoreCase(str))
		{	
			System.out.println(msg+" is palindrom.");
		}
		else
		{
			System.out.println(msg+" is not palindrom.");
		}
		s.close();	
	}
}
