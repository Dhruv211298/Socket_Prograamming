package dhruv.ajt;

import java.net.*;
import java.io.*;
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
		String msg=null;
		System.out.println("!--------------------------------------------------------!");
		System.out.println("Enter Msg:");
		msg=scan.nextLine();
		dos.writeUTF(msg);
		System.out.println("Message Successfully Send To Server.");
		System.out.println("Server Response To Client:");
		msg=dis.readUTF();
		System.out.println("Server Says:"+msg);
		s.close();
	}
}
