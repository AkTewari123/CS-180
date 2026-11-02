package guide_3;
import java.io.*;
import java.net.*;

public class PacketServer {
    public static void start() {
        try {
            ServerSocket listener = new ServerSocket(5050);
            while (true) {
                Socket socket = listener.accept();
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

                Packet p = (Packet) ois.readObject();

                while (p != null) {
                    if (p.COMMAND == 1) {
                        oos.writeObject(new Packet(1, "Valid"));
                    } else if (p.COMMAND == 2) {
                        oos.writeObject(p);
                    } else if (p.COMMAND == 3) {
                        oos.writeObject(new Packet(3, "Shut down"));
                        break;
                    } else {
                        oos.writeObject(new Packet(0, "Invalid"));
                    }
                    p = (Packet) ois.readObject();
                }

                socket.close();
                listener.close();

                break;
    
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
