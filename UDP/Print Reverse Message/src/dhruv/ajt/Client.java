package dhruv.ajt;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client 
{
	public static void main(String args[]) throws Exception
	{
		System.out.println("Client Started...!!");
		Scanner scan=new Scanner(System.in);
		DatagramSocket ds=new DatagramSocket();
		System.out.println("Client Enter Message:");
		String msg=scan.nextLine();
		byte[] b=new byte[1024];
		b=msg.getBytes();
		InetAddress ip=InetAddress.getLocalHost();
		DatagramPacket dp=new DatagramPacket(b,b.length,ip,7777);
		ds.send(dp);
		System.out.println("DataPacket Send Suessfully...!!");
		
		byte[] b1=new byte[1024];
		DatagramPacket dp1=new DatagramPacket(b1,b1.length);
		ds.receive(dp1);
		
		String str=new String(dp1.getData());
		System.out.println("Message:"+str);
	}
}
