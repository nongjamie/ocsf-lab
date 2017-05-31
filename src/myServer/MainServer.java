package myServer;

import java.io.IOException;
import java.util.Scanner;
import myClient.MyClient;

/**
 * Main class to run the server.
 * @author Sathira Kittisukmongkol
 */
public class MainServer {

	public static void main(String[]args) throws IOException {
		Scanner input = new Scanner(System.in);
		int port = 1112;
		MyServer myServer = new MyServer( port );
		myServer.listen();	
	}
	
}
