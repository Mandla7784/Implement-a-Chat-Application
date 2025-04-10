package main.java;


import java.io.*;
import java.net.*;

public class Client {
  public static void main(String [] args){
      String serverName = args[0];
      int port =  Integer.parseInt(args[1]);


      try {
          System.out.println("Conneting to " + serverName + "listening on port :" + port);
          // creating a scoket for client object 
          Socket client  = new Socket(serverName , port);
          System.out.println("Just connected to" + client.getRemoteSocketAddress());
          OutputStream outputServer = client.getOutputStream();
          DataOutput output = new DataOutputStream(outputServer);


          output.writeUTF("Hello from" + client.getLocalAddress());



          InputStream inFromServer = client.getInputStream();
          DataInputStream in = new DataInputStream(inFromServer);
          
          System.out.println("Server says " + in.readUTF());
          client.close();


      } catch (IOException e) {
         e.printStackTrace();

      }


  }
    
}
