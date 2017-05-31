package myClient;

import java.io.IOException;
import java.util.Scanner;

import com.lloseng.ocsf.server.ConnectionToClient;

/**
 * Main class to run all clients.
 * @author Sathira Kittisukmongkol
 */
public class MainClient {

	public static void main(String[]args) throws IOException {
		Scanner input = new Scanner(System.in);
		String host = "127.0.0.1";
		int port = 1112;
		MyClient myClientObject = new MyClient( host , port );
//		MyClient2 myClientObject2 = new MyClient2();
//		myClientObject.addObserver( myClientObject2 );
		myClientObject.openConnection();
	}

}
