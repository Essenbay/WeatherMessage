package OOP.univ;
import java.io.ObjectInputStream;
import java.net.Socket;
public class ClientTCP {
    public static void main(String arg[]) {
    	try {
            while(true) {
                @SuppressWarnings("resource")
				Socket clientSocket = new Socket("localhost", 1502);
	            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
	            String messages = (String) in.readObject();
	            System.out.println(messages.trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}    