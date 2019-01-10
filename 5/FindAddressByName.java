import java.net.*;

public class FindAddressByName {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

		      InetAddress address = InetAddress.getByName("www.dir.bg");

		      System.out.println(address);
		      
		      InetAddress[] addresses = InetAddress.getAllByName("www.microsoft.com");

		         for (int i = 0; i < addresses.length; i++) {

		           System.out.println(addresses[i]);

		         }
		         
		      address = InetAddress.getLocalHost( );

		      System.out.println(address);

		      System.out.println("hostname: " + address.getHostName() + " address: " + address.getHostAddress());


		    } catch (UnknownHostException ex) {

		    		System.out.println("Could not find!");

		    }
	} // end of main()

}
