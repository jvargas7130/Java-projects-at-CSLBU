import java.net.*;
import java.io.*;
public class Client {
	public static void main( String [] args){
		try{
			Socket s = new Socket("localhost", 1025);
			//send message to server
			PrintStream out = new PrintStream(s.getOutputStream());
			System.out.println("Sending Data....");
			out.println("1,2,3,4,5");
			//get massage from server
			BufferedReader in = new BufferedReader(new InputStreamReader( s.getInputStream()));
			System.out.println("Receiving Result:");
			System.out.println("sum = " + in.readLine());
			//close connection
			s.close();
		}catch( IOException e){
			e.printStackTrace();
		}
	}
	

}
