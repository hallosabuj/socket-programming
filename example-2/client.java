import java.net.*;
import java.io.*;
import java.util.*;
class student implements Serializable{
	int roll;
	String name;
	float marks;
	student(int roll,String name,float marks){
		this.roll=roll;
		this.name=name;	
		this.marks=marks;
	}
	public String toString(){
		return (roll+" "+name+" "+marks);
	}
}
class client{
	ObjectInputStream dis;
	ObjectOutputStream dos;
	Socket s;
	client(String IP,int port)throws Exception{
		s=new Socket(IP,port);
		dos=new ObjectOutputStream(s.getOutputStream());
		dis=new ObjectInputStream(s.getInputStream());
		System.out.println("Enter number of students :");
		BufferedReader pr=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(pr.readLine());
		ArrayList a=new ArrayList();
		student ob;
		for(int i=0;i<n;i++){
			System.out.println("Enter details of "+(i+1)+" student:");
			String str=pr.readLine();
			ob=new student(Integer.parseInt(str.split(" ")[0]),str.split(" ")[1],Float.parseFloat(str.split(" ")[2]));
			a.add(ob);
		}
		dos.writeObject(a);
		System.out.println("Studnet information are :");
		Iterator iterator=a.iterator();
		while(iterator.hasNext())
			System.out.println(iterator.next());
		System.out.println("");
		System.out.println("Student with highest marks is :");
		System.out.println((student)dis.readObject());
		s.close();
	}
	public static void main(String[] ars)throws Exception{
		client client=new client("127.0.0.1",9000);
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

 
