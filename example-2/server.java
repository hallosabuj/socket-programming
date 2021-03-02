import java.net.*;
import java.io.*;
import java.util.*;
class server{
	ObjectInputStream dis;
	ObjectOutputStream dos;
	ServerSocket ss;
	Socket s;
	student find_max(ArrayList a){
		Iterator iterator=a.iterator();
		student ob=(student)iterator.next();
		student MAX;
		float max=ob.marks;
		MAX=ob;
		while(iterator.hasNext()){
			ob=(student)iterator.next();
			if(max<ob.marks){
				MAX=ob;
				max=MAX.marks;
			}
		}
		return MAX;
	}
	server(int port)throws Exception{
		ss=new ServerSocket(port);
		System.out.println("Waiting for client...");
		s=ss.accept();
		System.out.println("Client connected...");
		dis=new ObjectInputStream(s.getInputStream());
		dos=new ObjectOutputStream(s.getOutputStream());
		ArrayList a=(ArrayList)dis.readObject();
		System.out.println("Finding student with highest marks...");
		dos.writeObject(find_max(a));
		s.close();
		ss.close();
	}
	public static void main(String[] ars)throws Exception{
		server server=new server(9000);
	}	
}

/*
Output
======
admin1@RKMA:~/Sem1/Programs/BG$ java server
Waiting for client...
Client connected...
Finding student with highest marks...
*/
