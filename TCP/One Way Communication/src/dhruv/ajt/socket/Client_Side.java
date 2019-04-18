package dhruv.ajt.socket;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client_Side
{
	public static void main(String args[]) throws Exception
	{
		System.out.println("Client Stated...!");
		Socket s=new Socket("localhost",5555);
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		Scanner scan=new Scanner(System.in);
		System.out.println("Convertion Started:");
		String str=scan.nextLine();
		dos.writeUTF(str);
		s.close();
	}
}