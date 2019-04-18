package dhruv.ajt;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server 
{
	public static void main(String args[]) throws Exception
	{	System.out.println("Server Started..!!");
		DatagramSocket ds=new DatagramSocket(7777);
		byte[] b=new byte[1024];
		DatagramPacket dp=new DatagramPacket(b,b.length);
		ds.receive(dp);
		String msg=new String(dp.getData());
		int l=msg.length();
		String str="";
		String[] s=new String[l];
		int j=0;
		for(int i=l-1;i>=0;i--)
		{
			s[j]=Character.toString(msg.charAt(i));
			j++;
		}
		for(int i=0;i<l;i++)
		{
			System.out.println(s[i]);
			str=str+s[i];
		}
		System.out.println("Message:"+str);
		byte[] b1=String.valueOf(str).getBytes();
		InetAddress ip=InetAddress.getLocalHost();
		DatagramPacket dp1=new DatagramPacket(b1,b1.length,ip,dp.getPort());
		ds.send(dp1);
	}
}
