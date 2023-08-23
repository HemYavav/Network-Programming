package Lab7.Server_Client_Multithreaded_Chat_App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class Server{
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(1234);
            server.setReuseAddress(true);
            while(true){
                Socket client = server.accept();
                System.out.println("New client connect "+ client.getInetAddress().getHostAddress());
                ClientHandler clientSock = new ClientHandler(client);
                new Thread(clientSock).start();
            }
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            if (server != null){
                try {
                    server.close();
                } catch (IOException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ClientHandler implements Runnable{
        private final Socket clientSocket;
        public ClientHandler(Socket socket){
            this.clientSocket = socket;
        }
        public void run(){
            PrintWriter out = null;
            BufferedReader in = null;
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String line;
                while((line = in.readLine()) != null){
                    System.out.printf("Sent from client: %s%n", line);
                    out.println(line);
                }
            } catch (IOException e) {
                // TODO: handle exception
                e.printStackTrace();
            } finally {
                try {
                    if(out != null){
                        out.close();
                    }
                    if(in != null){
                        in.close();
                        clientSocket.close();
                    }
                } catch (IOException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        }
    }
}
