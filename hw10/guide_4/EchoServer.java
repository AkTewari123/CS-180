package guide_4;

import java.net.*;
import java.io.*;

public class EchoServer {
    private int connections;
    private final Object LOCK = new Object();
    private boolean running = true;

    public int getConnections() {
        synchronized (LOCK) {
            return connections;
        }
    }

    public void endServer() {
        this.running = false;
    }
    private class ClientHandler implements Runnable {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }
        public void run() {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter pw = new PrintWriter(socket.getOutputStream());
                
                String line = br.readLine();

                while (line != null) {
                    if (line.equals("EXIT")) {
                        synchronized (LOCK) {
                            connections --;
                        }
                        pw.println("EXIT");
                        endServer();
                        break;
                    } else {
                        IO.println("echoing line: " + line);
                        pw.println(line);
                        IO.println("echoed: " + line);
                    }
                    IO.println("waiting on next line from client");
                    line = br.readLine();
                }

                IO.println("closed socket");
                socket.close();

            } catch (IOException e) {
                IO.println("womp womp");
            }
        }
    }
    public void startServer() {
        try {
            ServerSocket listener = new ServerSocket(5050);
            while (running) {
                Socket socket = listener.accept();
                synchronized (LOCK) {
                    connections ++;
                }
                IO.println(this.getConnections());
                IO.println("client accepted!!");
                Thread t1 = new Thread(new ClientHandler(socket));
                IO.println("new client");
                t1.start();
            }

            listener.close();

        } catch (IOException e) {
            e.printStackTrace();
            IO.println("io exception from socket closing?");
        } catch (Exception e) {
            
            IO.println("thread interrupted");
        }
    }

    void main() {
        EchoServer e = new EchoServer();
        try {
            e.startServer();
            IO.println("line");
            Thread.sleep(500);
            IO.println("reny");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Integer.parseInt("asdfads");


    }
}
