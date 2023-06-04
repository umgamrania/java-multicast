import java.net.*;

public class MulticastServer {
    public static void main(String[] args) {
        try {
            int port = 8888; // Choose a suitable port number
            String groupAddress = "224.0.0.1"; // Choose a multicast group address
            
            MulticastSocket socket = new MulticastSocket();
            
            String message = "Hello, everyone!"; // The message to multicast
            byte[] sendData = message.getBytes();
            
            InetAddress group = InetAddress.getByName(groupAddress);
            DatagramPacket packet = new DatagramPacket(sendData, sendData.length, group, port);
            socket.send(packet);
            
            System.out.println("Message multicast successfully.");
            
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
