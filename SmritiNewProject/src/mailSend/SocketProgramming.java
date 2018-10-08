package mailSend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.net.SocketTimeoutException;

import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.mysql.jdbc.log.Log;

/**
 *
 * @author Smriti
 */
public class SocketProgramming {

        public int packetWrite(String... args) {
                Socket s = null;
                BufferedWriter w = null;
                BufferedReader r = null;
                int retval = -1;
                String systemIP = "192.168.1.57";
                String Host_name = "root";
                String UserAccountName= "root";
                
               //// final Logger LOGGER = LoggerFactory.getLogger(IndexProcessor.class);
                try {
                        String line = null;
                        s = new Socket(args[0], 5038);
                        s.setSoTimeout(1000);
                        w = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                        r = new BufferedReader(new InputStreamReader(s.getInputStream()));
                        int blank_read_count = 0;
                        while (true) {

                                try {
                                        line = r.readLine();

                                        if (line  == null) {
                                        	//Log.log("SocketPort5038: break from here : Size of the packet: \n"+line.length());
                                        	//LOGGER.log(line);
                                        	System.out.println("SocketPort5038: break from here : Size of the packet: \n"+line.length());
                                                break;
                                        }

                                } catch (SocketTimeoutException ex) {
                                       
                                }
                                System.out.println("SocketPort5038 : Size of the packet: \n"+line.length() +" " +args[1]);
                                //Log.log("SocketPort5038 : Size of the packet: \n"+line.length() +" " +args[1]);
                                //LOGGER.log(line);
                                if (line.contains("Asterisk Call")) {
                                        w.write("Action: Login\r\n");
                                        w.write("Username: Dial\r\n");
                                        w.write("Secret: 1234\r\n");
                                        w.write("Events: off\r\n\r\n");
                                        w.flush();
                                }
                                if (line.contains("Authentication accepted")) {
                                        System.out.println("SocketPort5038:Authentication accepted");
                                        //Log.log("SocketPort5038:Authentication accepted");

                                        if (args[1].equalsIgnoreCase("SRecStart")) {
                                                w.write("action: SRecStart\r\n");
                                                w.write("agent_id: " + args[2] + "\r\n");
                                                w.write("Session: " + args[3] + "\r\n");
                                                w.write("campaign_name: " + args[4] + "\r\n");
                                                w.write("Rec_start_time: " + args[5] + "\r\n");
                                                w.write("RecDrivePath: " + args[6] + "\r\n");
                                                w.write("file_name: " + args[7] + "\r\n");
                                                w.write("System_ip: "+ SystemProperty.BROWSER_BINARY + "\r\n" );
                                                w.write("Host_name: "+ SystemProperty.BROWSER_BINARY + "\r\n");
                                                w.write("UserAccountName: "+ SystemProperty.BROWSER_BINARY + "\r\n\r\n");
                                                w.flush();
                                                retval = 0 ;
                                                break;
                                        }
                                        if (args[1].equalsIgnoreCase("SRecStop")) {
                                                w.write("action: SRecStop\r\n");
                                                w.write("agent_id: " + args[2] + "\r\n");
                                                w.write("Session: " + args[3] + "\r\n");
                                                w.write("campaign_name: " + args[4] + "\r\n");
                                                w.write("Rec_start_time: " + args[5] + "\r\n");
                                                w.write("Rec_stop_time: " + System.currentTimeMillis() / 1000L + "\r\n");
                                                w.write("file_location: " + args[6] + "\r\n");
                                                w.write("file_name: " + args[7] + "\r\n");
                                                w.write("System_ip: "+ SystemProperty.BROWSER_BINARY + "\r\n" );
                                                w.write("Host_name: "+ SystemProperty.BROWSER_BINARY + "\r\n");
                                                w.write("UserAccountName: "+ SystemProperty.BROWSER_BINARY + "\r\n\r\n");
                                                w.flush();
                                                retval = 0;
                                                break;
                                        }
                                        if (args[1].equalsIgnoreCase("FtpUpdateComplete")) {
                                                w.write("action: FtpUpdateComplete\r\n");
                                                w.write("filename: " + args[2] + "\r\n");
                                                w.write("Session: " + args[3] + "\r\n\r\n");
                                                w.flush();
                                                retval = 0;
                                                break;
                                        }
                                        if (args[1].equalsIgnoreCase("SR_healthcheck")) {
                                                if (System.getProperty("os.name").toLowerCase().startsWith(
                                                                        "windows")) {
                                                        //InetAddress thisIp1 = InetAddress.getLocalHost();

                                                        long currentUnixTime=System.currentTimeMillis()/1000L;
                                                        //long uptime = currentUnixTime - SystemProperty.programStartTime;
                                                        w.write("Action: SR_healthcheck\r\n");
                                                        w.write("System_ip: "
                                                                        + SystemProperty.BROWSER_BINARY + "\r\n");
                                                        w.write("host_name: " + SystemProperty.BROWSER_BINARY + "\r\n");
                                                        w.write("time_stamp: " + currentUnixTime + "\r\n");
                                                        w.write("agent_id: " + args[4] + "\r\n");
                                                        int index = args[2].indexOf(":");
                                                        w.write("driveName: " + args[2].substring(0, index) + "\r\n");
                                                        w.write("driveSpace: " + args[3] + "\r\n");
                                                        w.write("UserAccountName: " + SystemProperty.BROWSER_BINARY + "\r\n");
                                                       // w.write("ProgReStarttime: " + SystemProperty.programStartTime + "\r\n");
                                                        //w.write("Uptime: " + uptime + "\r\n");
                                                        //w.write("Version: "+Log.version + "\r\n\r\n");
                                                        w.flush();
                                                     
                                                } else {

                                                        //Log.log("SocketPort5038 : HealthCheck packet fired");

                                                        Enumeration<NetworkInterface> nets = NetworkInterface
                                                                .getNetworkInterfaces();
                                                        String ipAdress = null;
                                                        for (NetworkInterface netint : Collections.list(nets)) {
                                                                ipAdress = displayInterfaceInformation(netint);
                                                        }
                                                        InetAddress thisIp1 = InetAddress.getLocalHost();
                                                        w.write("Action: SR_healthcheck\r\n");
                                                        w.write("System_ip: " + ipAdress + "\r\n");
                                                        w.write("host_name: " + thisIp1.getCanonicalHostName()
                                                                        .replaceAll("[\\-\\+\\.\\^:,]", "_") + "\r\n");
                                                        w.write("time_stamp: " + System.currentTimeMillis() / 1000L + "\r\n");
                                                        w.write("agent_id: " + args[4] + "\r\n");
                                                        w.write("driveName: " + args[2] + "\r\n");
                                                        w.write("driveSpace: " + args[3] + "\r\n\r\n");
                                                        w.flush();
                                                }
                                                retval = 0;
                                                break;
                                        }
                                }
                        }

                       // Log.log("SocketPort5038 : came here after while loop \n");
                } catch (Exception e) {
                        //Log.log("SocketPort5038 Exception  "+e);
                } finally {
                        try {
                                if (w != null) {
                                        w.close();
                                }
                                if (r != null) {
                                        r.close();
                                }
                                if (s != null) {
                                        s.close();
                                }
                        } catch (IOException ex) {
                                //Log.log("SocketPort5038 IOException "+ex);
                        }
                        //Log.log("SocketPort5038 : connection closed with return value = "+ retval);
                }
        return retval;
        }

        public String displayInterfaceInformation(NetworkInterface netint)
                throws SocketException {
                        String s = netint.getDisplayName();
                        String ipAddress = "";
                        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
                        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
                                InetAddress line = inetAddress;
                                String s1 = line.toString();
                                if (s.contains("eth")) {
                                        if (s1.contains("/")) {
                                                int j1 = s1.lastIndexOf("/");
                                                int j2 = s1.lastIndexOf("");
                                                ipAddress = s1.substring(j1 + 1, j2);
                                                break;
                                        }
                                }
                        }
                        return ipAddress;
                }
}

	
