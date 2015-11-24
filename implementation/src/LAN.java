import java.net.InetAddress;
import java.net.UnknownHostException;

public class LAN {



    InetAddress ip;
    String hostname;
    String ipAddr;

    public LAN(){

    }

    // attempt to automatically pull the local ip address and host name
    public void autoAssignNet() {
        try {
            ip = InetAddress.getLocalHost();
            ipAddr = ip.getHostAddress();
            hostname = ip.getHostName();
            System.out.println("Your current IP address : " + ip);
            System.out.println("Your current Hostname : " + hostname);

        } catch (UnknownHostException e) {

            e.printStackTrace();
        }
    }

    public void setIp(String ip){
        ipAddr = ip;
    }
    public String getIp(){
        return ipAddr;
    }

    public void setHostname(String hostname){
        this.hostname = hostname;
    }

    public String getHostname(){
        return hostname;
    }

}
