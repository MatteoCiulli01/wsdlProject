package wsdlproject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WsdlProject {
	public static void main(String[] args) throws IOException {
        int exit = 0;
        do{
        String response = "";
        String output ="";
        String request        = "http://websrv.cs.fsu.edu/~engelen/calcserver.cgi";
        URL    url            = new URL( request );
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        String xmlInput="";
        System.out.println("First value");
        Scanner myObj1 = new Scanner(System.in);
        int value1 = myObj1.nextInt();
        System.out.println("Second value");
        Scanner myObj2 = new Scanner(System.in);
        int value2= myObj2.nextInt();
        System.out.println("Which operation?\n"+".1 add\n"+".2 sub\n"+".3 mul\n"+".4 div\n"+".5 pow\n");
        Scanner myObj3 = new Scanner(System.in);
        exit = myObj3.nextInt();

        
        switch(exit){
            case 0:
                return;
            case 1:
                xmlInput ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
        "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns1=\"urn:calc\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" SOAP-ENV:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
        "  <SOAP-ENV:Body>\n" +
        "    <ns1:add>\n" +
        "      <a xsi:type=\"xsd:double\">"+Integer.toString(value1)+"</a>\n" +
        "      <b xsi:type=\"xsd:double\">"+Integer.toString(value2)+"</b>\n" +
        "    </ns1:add>\n" +
        "  </SOAP-ENV:Body>\n" +
        "</SOAP-ENV:Envelope>";
                break;
            case 2:
                xmlInput= "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
        "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns1=\"urn:calc\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" SOAP-ENV:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
        "  <SOAP-ENV:Body>\n" +
        "    <ns1:sub>\n" +
        "      <a xsi:type=\"xsd:double\">"+Integer.toString(value1)+"</a>\n" +
        "      <b xsi:type=\"xsd:double\">"+Integer.toString(value2)+"</b>\n" +
        "    </ns1:sub>\n" +
        "  </SOAP-ENV:Body>\n" +
        "</SOAP-ENV:Envelope>";
                break;
            case 3:
                xmlInput = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
        "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns1=\"urn:calc\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" SOAP-ENV:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
        "  <SOAP-ENV:Body>\n" +
        "    <ns1:mul>\n" +
        "      <a xsi:type=\"xsd:double\">"+Integer.toString(value1)+"</a>\n" +
        "      <b xsi:type=\"xsd:double\">"+Integer.toString(value2)+"</b>\n" +
        "    </ns1:mul>\n" +
        "  </SOAP-ENV:Body>\n" +
        "</SOAP-ENV:Envelope>";
                break;
            case 4:
                xmlInput = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
        "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns1=\"urn:calc\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" SOAP-ENV:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
        "  <SOAP-ENV:Body>\n" +
        "    <ns1:div>\n" +
        "      <a xsi:type=\"xsd:double\">"+Integer.toString(value1)+"</a>\n" +
        "      <b xsi:type=\"xsd:double\">"+Integer.toString(value2)+"</b>\n" +
        "    </ns1:div>\n" +
        "  </SOAP-ENV:Body>\n" +
        "</SOAP-ENV:Envelope>";
                break;
            case 5:
                xmlInput = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns1=\"urn:calc\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" SOAP-ENV:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
        "  <SOAP-ENV:Body>\n" +
        "    <ns1:pow>\n" +
        "      <a xsi:type=\"xsd:double\">"+Integer.toString(value1)+"</a>\n" +
        "      <b xsi:type=\"xsd:double\">"+Integer.toString(value2)+"</b>\n" +
        "    </ns1:pow>\n" +
        "  </SOAP-ENV:Body>\n" +
        "</SOAP-ENV:Envelope>";
                break;
        }
        byte[] buffer = new byte[xmlInput.length()];
        buffer = xmlInput.getBytes();
        out.write(buffer);
        byte[] b = out.toByteArray();
        
        String SOAPAction= "getUserDetails";
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Host", "websrv.cs.fsu.edu");
        conn.setRequestProperty("Connection", "Keep-Alive");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
        conn.setRequestProperty("charset", "utf-8");
        conn.setRequestProperty("User-Agent","PHP-SOAP/7.2.24-0ubuntu0.18.04.2");
        conn.setRequestProperty("SOAPAction",SOAPAction);
        conn.setRequestProperty( "Content-Length", String.valueOf(b.length));
        conn.setDoInput(true);
        conn.setDoOutput(true);
        OutputStream outt =conn.getOutputStream();
        outt.write(b);
        outt.close();

         InputStreamReader isr = new InputStreamReader (conn.getInputStream());
         BufferedReader in = new BufferedReader(isr);
         while((response = in.readLine()) != null)
         {
             output += response;
         }
         System.out.println(output);
         }while(exit!=0);
    }
}