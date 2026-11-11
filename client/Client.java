import java.io.*;
import java.net.*;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 8080;
    
    public static void main(String[] args) {
        try (
            Socket socket = new Socket(HOST, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()))
        ) {
            System.out.println("Connected to server at " + HOST + ":" + PORT);
            
            String name = "ClientUser";
            out.println(name);
            System.out.println("Sent to server: " + name);
            
            String response = in.readLine();
            System.out.println("Server response: " + response);
            
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + HOST);
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}