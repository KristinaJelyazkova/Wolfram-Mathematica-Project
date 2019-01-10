import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;


public class Client {

	public static boolean term= false;
	
	public static void main(String[] args) {
		System.out.println("Client started ...");
		
		String host= "127.0.0.1";
		int port = 2000;
		
		try {
			Socket s= new Socket(host, port);
			
			BufferedReader in= new BufferedReader(
					new InputStreamReader(s.getInputStream()));
			
			PrintStream out= new PrintStream(s.getOutputStream());
			
			BufferedReader cons= new BufferedReader(
					new InputStreamReader(System.in));
			
			ClientThread ct= new ClientThread(in);
			
			term= false;
			String v= "";
			
			System.out.print("name: ");			// registracia na imeto na klienta
			String name= cons.readLine();
			out.println(name);
			
			do {
				System.out.print("duma: ");
				v= cons.readLine();
				out.println(v);	
				out.flush();
			} while (!v.equals("end"));
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}

class ClientThread extends Thread{
	BufferedReader in;
	public boolean term= false;
	
	public ClientThread(BufferedReader in){
		this.in= in;
		this.start();
	}

	public void run(){
		
		String w= "";
		do {
			try {
				w = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(w);
		} while (!w.equals("end"));
		System.out.println("E-E-E-E-End");
		this.term= true;
		
	}
 		
}
