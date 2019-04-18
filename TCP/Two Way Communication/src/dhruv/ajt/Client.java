package dhruv.ajt;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client 
{
	public static void main(String[] args) throws Exception
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Client Started...!!");
		Socket s=new Socket("localhost",5555);
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		DataInputStream ds=new DataInputStream(s.getInputStream());
		String msg=null;
		while(true)
		{
			System.out.println("Client Writes Messages:");
			msg=scan.nextLine();
			dos.writeUTF(msg);
			if(msg.equalsIgnoreCase("quit"))
			{
				break;
			}
			msg=ds.readUTF();
			if(msg.equalsIgnoreCase("quit"))
			{
				break;
			}
			System.out.println("Server Says:"+msg);
		}
		s.close();
	}

}
