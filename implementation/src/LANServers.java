import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by merrellblack on 11/29/15.
 */
public class LANServers {
    String name;
    String ip;
    Socket cSocket;

    public LANServers(Socket cSocket){
        this.cSocket = cSocket;
        ip  = String.valueOf(cSocket.getRemoteSocketAddress());
        ip = ip.substring(ip.indexOf("/")+1,ip.indexOf(":"));
        try{
            InetAddress inetIp = InetAddress.getByName(ip);
            name = inetIp.getHostName();
        } catch (UnknownHostException e) {
            System.err.println("Unable to resolve host name for: "+cSocket);

        }
    }

    public void closeServer(){
        try{
            cSocket.close();}
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public void setIp(String ip){
        this.ip = ip;
    }
    public String getIp(){
        return ip;
    }
}
