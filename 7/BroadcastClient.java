import java.net.*;

public class BroadcastClient {
  public static final int PORT = 5000;
  public static void main(String args[]) throws Exception { 

    MulticastSocket socket;
    DatagramPacket packet;
    String address = "225.4.5.6";

    socket = new MulticastSocket(BroadcastServer.PORT);

    //join a Multicast group and send the group salutations
    socket.joinGroup(InetAddress.getByName(address));

    byte[] data = new byte[1024];
    packet = new DatagramPacket(data,data.length);

    for(;;){

      // receive the packets
      socket.receive(packet);

      String str = new String(packet.getData());
      System.out.println("Time signal received from"+
          packet.getAddress() + " Time is : " +str);
      
//      System.out.write(packet.getData(),0,packet.getLength());

    } // for
//      socket.leaveGroup(InetAddress.getByName(address));
//      socket.close();

	  
  } // main
} // class Broadcast