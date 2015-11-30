
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by merrellblack on 11/24/15.
 */
public class LANManagement {
    final int timeout = 200;
    int subnet = 14;
    int port = 130001;
    int numServers = 0;
    LANServers[] serverArray = new LANServers[subnet];

    /**** Starts Local Server (Listening services)****/
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
    public String[] searchServers(String hostnet){
        Socket searchSocket;
        String[] aServers;
        System.out.println("Searching for servers....");
        for (int i = 0; i <= subnet; i++) {
            String hosting = hostnet+"."+i;
            try {
                searchSocket = checkSocket(hosting);
                if (searchSocket != null) {
                    serverArray[i] = new LANServers(searchSocket);
                    numServers++;
                    System.out.println("Host: "+ serverArray[i].getName()+" server slot: "+ i);
                }
            }catch (Exception e){
                   // System.err.println( "Host: "+hosting+" NOT AVAILABLE");
            }
        }
        aServers = availableServers();
        return aServers;
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
    public String[] availableServers(){
        System.out.println(numServers + "of" + serverArray.length + "available");
        String[] serverList = new String[numServers];
        int sTracker = 0;
        if(numServers>0) {
            for (int i = 0; i < serverArray.length; i++) {
                if (serverArray[i] != null) {
                    serverList[sTracker] = serverArray[i].getName();
                    sTracker++;
                }
            }
            return serverList;
        }
        return null;
    }

    /**** Check to see if server is listening ****/
    public Socket checkSocket(String hostServer)throws Exception{
        Socket socket = new Socket();
        InetSocketAddress host = new InetSocketAddress(hostServer, port);
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
