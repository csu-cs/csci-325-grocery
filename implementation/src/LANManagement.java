
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by merrellblack on 11/24/15.
 */
public class LANManagement {
    final int timeout = 200;
    LANServers[] serverArray = new LANServers[254];
    int subnet = 14;
    int port = 130001;
    int numServers = 0;

    public void startServer(int myPort){
        ServerSocket serverSocket = null;
       try {
            serverSocket = new ServerSocket(myPort);
            System.out.println("Server started -- listening on port: " + myPort);
       }catch (IOException e) {
            System.err.println("Could not listen on port: "+myPort);
       }

        Socket clientSocket = null;
        System.out.println("Server waiting for connection........");

        if(serverSocket != null) {
            try {
                clientSocket = serverSocket.accept();
                System.out.println("Accepted connection : " + clientSocket);
            } catch (IOException e) {
                System.err.println("Could not connect to " + clientSocket);
            }
        } else {
            System.err.println("Unable to accept clients: "+serverSocket+" not started");
        }
    }

    /****Search for listening servers ****/
    public int searchServers(String hostnet){
        Socket searchSocket;
        for (int i = 0; i <= subnet; i++) {
            String hosting = hostnet+"."+i;
            try {
                searchSocket = checkSocket(hosting);
                serverArray[i] = new LANServers(searchSocket);
                numServers++;
                System.out.println(hosting + " Active");
                System.out.println(serverArray[i].getName());
            }catch (Exception e){

            }
        }
        return numServers;
    }

    /**** Disconnects all servers ****/
    public void disconnectServers(){
        for(LANServers server:serverArray){
            server.closeServer();
        }
    }

    /**** Displays available servers: we can use
     * this method to return a list/(object)
     * of listening servers to the UI****/
    public void availableServers(){
        for(int i = 0; i <= numServers;i++){
            System.out.println(serverArray[i].getName()+ "available");
        }

    }

    /**** Check to see if server is listening ****/
    public Socket checkSocket(String hostServer)throws Exception{
        Socket socket = new Socket();
        InetSocketAddress host = new InetSocketAddress(hostServer, 10007);
        socket.connect(host, timeout);
        return(socket);
    }

    /**** Getters & Setters ****/
    public void setPort(int port){
        this.port = port;
    }

    public void setSubnet(int subnet){
        this.subnet = subnet;
    }

}
