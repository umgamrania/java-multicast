import java.net.*;

public class MulticastClient {
    public static void main(String[] args) {
        try {
            int port = 8888; // Same port number used in the server
            String groupAddress = "224.0.0.1"; // Same multicast group address used in the server
            
            MulticastSocket socket = new MulticastSocket(port);
            
            InetAddress group = InetAddress.getByName(groupAddress);
            socket.joinGroup(group);
            
            byte[] receiveData = new byte[1024];
            
            System.out.println("Listening for multicast messages...");
            
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                
                String message = new String(receivePacket.getData()).trim();
                System.out.println("Received message: " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
