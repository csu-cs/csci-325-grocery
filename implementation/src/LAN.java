import java.net.InetAddress;

public class LAN extends LANManagement{

    InetAddress ip;
    String hostname;
    String ipAddr;
    final int myPort = 13001;

    public LAN(){
        startServer(myPort);
    }

    /**** attempt to automatically pull the local ip address and host name ****/
    public void autoAssign() {
        try {
            ip = InetAddress.getLocalHost();
            ipAddr = ip.getHostAddress();
            hostname = ip.getHostName();
           // System.out.println("Your current IP address : " + ip);
           // System.out.println("Your current Hostname : " + hostname);
        } catch (Exception e) {
            System.out.println("Error auto assigning host");
          //  e.printStackTrace();
        }
    }


    public void setMyIp(String ip){

        ipAddr = ip;
    }

    public String getIp(){

        return ipAddr;
    }

    public void setMyHostname(String hostname){

        this.hostname = hostname;
    }

    public String getMyHostname(){

        return hostname;
    }

}
