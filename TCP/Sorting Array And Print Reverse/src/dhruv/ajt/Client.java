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
		Socket s=new Socket("localhost",7777);
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		DataInputStream dis=new DataInputStream(s.getInputStream());
		System.out.println("!----------------------------------------------------------!");
		System.out.println("Enter Total Number Of Element:");
		int n=scan.nextInt();
		dos.writeInt(n);
		int a[]=new int[n];
		System.out.println("Enter Element Of Array:");
		for(int i=0;i<n;i++)
		{
			a[i]=scan.nextInt();
			dos.writeInt(a[i]);
		}
		System.out.println("Element Successfull Sent To Server...!");
		System.out.println("!----------------------------------------------------------!");
		System.out.println("Revers Sorted Array:");
		int r;
		for(int i=0;i<n;i++)
		{
			r=dis.readInt();
			System.out.println("a["+i+"]:"+r);
		}
		s.close();
	}

}
