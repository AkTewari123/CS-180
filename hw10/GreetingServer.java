import java.net.*;
import java.io.*;

public class GreetingServer {
    public static void start() throws Exception {
        ServerSocket listener = new ServerSocket(5050);

        while (true) {
            Socket socket = listener.accept();

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            String line = br.readLine();

            if (line != null) {
                pw.println("Hello " + line);
            }

            socket.close();
            listener.close();
            
            break;
        }

    }
}
