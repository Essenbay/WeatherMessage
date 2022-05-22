package OOP.univ;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket; 
import java.net.Socket;
import java.io.IOException;
import java.io.ObjectOutputStream;
public class InterClient{
	private static InetAddress address;  	
	private static byte[] buffer;  	
	private static DatagramPacket packet;  	
	private static MulticastSocket socket;
	private static String str = "";
	private static int numOfMessages = 0;
	private static ServerSocket serverSocket = null;
	private static String textMessages = "";
	public static void main(String arg[]) throws Exception{   
		System.out.println("Ожидание сообщения от сервера"); 
 	 	try {
 	 	 	socket = new MulticastSocket(1502); 
 	 	 	address = InetAddress.getByName("233.0.0.1"); 
 	 	 	socket.joinGroup(address);
	 	    serverSocket = new ServerSocket(1502); 
 	 	 	while (true) {	 	 		
 	 	 		buffer = new byte[256]; 
 	 	 	 	packet = new DatagramPacket(buffer, buffer.length); 
 	 	 	 	socket.receive(packet);  	 	 		 	 	 
 	 	 	 	String strNew = new String(packet.getData());
 	 	 	 	if(str != strNew) {
 	 	 	 		numOfMessages++;
 	 	 	 		str = strNew;
 	 	 	 		textMessages = textMessages + str + '\n';
 	 	 	 		System.out.println( "Получено новое сообщение: " + str.trim() + " " + numOfMessages);
 	 	 	 		System.out.println(textMessages);
 	 	 	 	}
 	 	 	 	if(numOfMessages % 5 == 0 && numOfMessages != 0) {
 	 	 	 		textMessages = "";
 	 	 	    	Socket clientSocket = serverSocket.accept();  
 	 	 	 	 	System.out.println("Connection accepted from " + clientSocket.getInetAddress().getHostAddress());
 	 	 	 	 	ObjectOutputStream out =  new ObjectOutputStream( clientSocket.getOutputStream()); 
 	 	 	 	 	out.writeObject(textMessages); 
 	 	 	 	 	out.close(); 
 	 	 	 	}
 	 	 	}
 	 	} 
 	 	catch (Exception e) { 
	 	 	e.printStackTrace();} 
 	 	finally {  	 	 	
 	 		try {
 	 	 	 	socket.leaveGroup(address); 
 	 	 	 	socket.close(); 
 	 	 	 	
 	 	 	 	System.out.println("Выход"); 
 	 	 	}
 	 		catch (IOException e) {
 	            e.printStackTrace();
 	        }
 	 		catch (Exception e) { 
 	 	 	 	e.printStackTrace(); 
 	 	 	}
 	 		
 	 	}
 	 }
} 


