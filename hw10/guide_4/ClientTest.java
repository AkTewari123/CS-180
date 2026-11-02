package guide_4;

import java.io.*;
import java.net.Socket;

class ClientTest {
    public static String connect() throws Exception {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 5050);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            IO.println("we good");
            
            
            String input = IO.readln("new line: ");
            while (input != null) {
                pw.println(input);
                IO.println("wrote output");
                input = IO.readln("new line: ");
                // IO.println("res: " + br.readLine());
            }
            IO.println("closed socket");
            socket.close();

            return "";
            
        } catch (IOException e) {
            IO.println("womp womp");
        }
        return "";
    }
    void main() {
        try {
            
            ClientTest.connect();

            // ClientTest.connect();
        } catch (Exception e) {}
    }
}