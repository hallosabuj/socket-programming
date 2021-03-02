import java.net.*;
import java.io.*;

class socket_client{
	DataInputStream dis;
	DataOutputStream dos;
	Socket s;
	socket_client(String IP,int port)throws IOException{
		s=new Socket(IP,port);
		dis=new DataInputStream(s.getInputStream());
		dos=new DataOutputStream(s.getOutputStream());
		System.out.println("Enter two integer separated by space :");
		BufferedReader pr=new BufferedReader(new InputStreamReader(System.in));
		String numbers=pr.readLine();
		dos.writeUTF(numbers);
		String str=dis.readUTF();
		System.out.println("GCD of "+numbers+" is "+str);
		s.close();
	}
	public static void main(String[] ars)throws IOException{
		socket_client client=new socket_client("127.0.0.1",9000);
	}
}


/*
Output
======
admin1@RKMA:~/Sem1/Programs/BG$ java socket_client 
Enter two integer separated by space :
35 21
GCD of 35 21 is 7
*/
 
