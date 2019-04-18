package dhruv.ajt;

import java.net.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Server 
{
	public static void main(String[] args) throws Exception
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Server Waiting For Client Request...!!");
		ServerSocket ss=new ServerSocket(7777);
		Socket s=ss.accept();
		System.out.println("Connection Successfully Done...!!");
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		DataInputStream dis=new DataInputStream(s.getInputStream());
		System.out.println("!---------------------------------------------------!");
		int n=dis.readInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=dis.readInt();
		}
		System.out.println("Data Received...!!");
		System.out.println("Data Sorting...!!");
		Arrays.sort(a);
		System.out.println("Data Sorted...!!");
		for(int i=n-1;i>=0;i--)
		{
			dos.writeInt(a[i]);
		}
		System.out.println("Data Successfully Sent To Client...!!");
		s.close();
		ss.close();
		
	}
}
