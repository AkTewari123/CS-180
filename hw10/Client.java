import java.io.*;
import java.net.Socket;

class GreetingClient {
    public static String connect() throws Exception {
        Socket socket = null;
        try {  
            socket = new Socket("localhost", 5050);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            
            
            

            pw.println("Hello Server");
            String ret = br.readLine();

            socket.close();

            return ret;
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}