package main.java;


import java.io.*;
import java.net.*;

import javax.imageio.IIOException;
import javax.print.attribute.standard.Severity;


public class Server extends Thread {
    
    private static  ServerSocket serverSocket ;
    private static int port = 9876;

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        // creating the socket server object 
           ServerSocket serverSocket = new ServerSocket(port);
           boolean isClientConnecting = true;

           while(isClientConnecting){
              try {
                System.out.println("Waiting for the client to request " + serverSocket.getLocalPort() + "....");

                // we will create a socket to wait for a client
                Socket server = serverSocket.accept();
 
 
                System.out.println("Just connected to " + server.getRemoteSocketAddress());
                DataInputStream in =  new DataInputStream(server.getInputStream());
                DataOutputStream  output = new DataOutputStream(server.getOutputStream());
                output.writeUTF("Thanks" + server.getLocalSocketAddress());
                server.close();

               

                System.out.println(in.readUTF());
 
              } catch (SocketTimeoutException e) {
                   System.out.println(e.getMessage());
              }catch(IOException e){
                  e.printStackTrace();
                  break;
                  

              }finally{
                  System.out.println("Say hi!!!!");
              }

           }
       
    }




} 
