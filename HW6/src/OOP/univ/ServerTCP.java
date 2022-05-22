package OOP.univ;

import java.io.*; import java.net.*; 

public class ServerTCP { 
	private BufferedReader in = null; 
	private String str = null; 
	private byte[] buffer; 
	private DatagramPacket packet; 
	private InetAddress address; 
	private DatagramSocket socket; 
	private static FileWriter fileWriter = null;

 
	public ServerTCP() throws IOException {  	
		System.out.println("Sending messages");  	
		socket = new DatagramSocket(); 
		transmit(); 
		} 
	public void transmit() { 
	 	try { 
	 	in = new BufferedReader(new InputStreamReader(System.in));  	 	
	 	while (true) {
	 		String sky, precipitation;
	 		int temperature;
	 		System.out.println("Введите погоду. Нажмите любую клавишу.");
	 		in.readLine();
	 		System.out.println( "Введите состояние неба: ");
	 		sky = in.readLine();
	 		System.out.println( "Введите осадки или их отсуствие: ");
	 		precipitation = in.readLine();
	 		System.out.println( "Введите температуру: ");
	 		temperature = Integer.parseInt(in.readLine());
	 		WeatherMessage message = new WeatherMessage(new Weather(sky, precipitation, temperature));
	 		buffer = message.toString().getBytes();
 	 	 	address = InetAddress.getByName("233.0.0.1");  	 	 	
 	 	 	packet = new DatagramPacket(buffer,  buffer.length,  address,  1502); 
 	 	 	socket.send(packet); 
	 	 	} 
	 	} catch (Exception e) { 
	 	 	e.printStackTrace(); 
	 	} finally { 
	 	 	try { 
 	 	 	in.close(); 
	 	 	 	socket.close(); 
	 	 	} catch (Exception e) { 
	 	 	 	e.printStackTrace(); 
	 	 	} 
	 	} 
	}
	public static void main(String arg[]) throws Exception { 
		new ServerTCP(); 
	}
}
