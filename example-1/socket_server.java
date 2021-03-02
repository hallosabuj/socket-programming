import java.net.*;
import java.io.*;

class socket_server{
	DataInputStream dis;
	DataOutputStream dos;
	ServerSocket ss;
	Socket s;
	int gcd(int a,int b){
		if(a%b==0)
			return b;
		else
			return gcd(b,a%b);
	}
	socket_server(int port)throws IOException{
		ss=new ServerSocket(port);
		System.out.println("Waiting for client...");
		s=ss.accept();
		System.out.println("Client connected...");
		dis=new DataInputStream(s.getInputStream());
		dos=new DataOutputStream(s.getOutputStream());
		String str=dis.readUTF();
		int n1=Integer.parseInt(str.split(" ")[0]);
		int n2=Integer.parseInt(str.split(" ")[1]);
		System.out.println("Calculating Greatest common divisor...");
		int g_c_d=gcd(n1,n2);
		dos.writeUTF(String.valueOf(g_c_d));
		System.out.println("GCD sent to client");
		s.close();
		ss.close();
	}
	public static void main(String[] ars)throws IOException{
		socket_server server=new socket_server(9000);
	}	
}


/*
Output
======
admin1@RKMA:~/Sem1/Programs/BG$ java socket_server
Waiting for client...
Client connected...
Calculating Greatest common divisor...
GCD sent to client
*/
