package dhruv.ajt.socket;

import java.net.*;
import java.io.*;

public class Server_Side
{
	public static void main(String args[]) throws Exception
	{
		System.out.println("Server Waiting For Client...!");
		ServerSocket ss=new ServerSocket(5555);
		Socket s=ss.accept();
		System.out.println("Connection Sucessfully Esthabilshed...!");
		DataInputStream ds=new DataInputStream(s.getInputStream());
		String str=ds.readUTF();
		System.out.println("Client Says:"+str);
		ss.close();
	}
}