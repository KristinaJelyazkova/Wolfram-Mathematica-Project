import java.io.*;
import java.net.*;
import java.util.*;


public class Server {
	
	private static TreeMap<String, PrintStream> all= new TreeMap<String, PrintStream>();

	public static void printToAll(String w){
		Collection<PrintStream> a= all.values();
		for(PrintStream p : a){
			p.println(w);
			p.flush();
		}
	}
	
	public static void delete(String name){
		all.remove(name);
		
	}
	
	public static void registrate(String name, PrintStream out){
		all.put(name, out);
	}
	
	public static void main(String[] args) {
		System.out.println("Server started ...");
		int port= 2000;
		
		ServerSocket ss;
		try {
			ss = new ServerSocket(port);
			
			
			while(true){
				Socket s= ss.accept();
				
				ServerThread t= new ServerThread(s);
				t.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}

class ServerThread extends Thread{
	Socket s;
	BufferedReader in;
	PrintStream out;
	
	public ServerThread(Socket s){
		this.s= s;
		try {
			in= new BufferedReader(
					new InputStreamReader(s.getInputStream()));		
			out= new PrintStream(s.getOutputStream());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}				
	}
			
	public void run(){
		String w;

		try{		
			String name= in.readLine();
			Server.registrate(name, out);  // registrirane na nov klient
			System.out.println("new client: " + name);
			do {
				w = in.readLine();
				System.out.println(name+ ": " + w);
				
				if(w.equals("end")){
					out.println(w);
				}else{
					Server.printToAll(w);
				}
				
			} while (!w.equals("end"));	
			
			Server.delete(name);
			System.out.println("REMOVED: " + name);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
