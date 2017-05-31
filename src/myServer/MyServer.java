package myServer;

import java.util.Arrays;

import com.lloseng.ocsf.server.ConnectionToClient;
import com.lloseng.ocsf.server.ObservableServer;

/**
 * My First Server.
 * @author Sathira Kittisukmongkol
 */
public class MyServer extends ObservableServer {

	public MyServer(int port) {
		super(port);
	}

	@Override
	protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
		String sentence = (String)msg;
		if( sentence.contains(",") ) {
			String[] arg = sentence.split(",");
			client.setInfo( arg[0].trim() , arg[1].trim() );
			sendToAllClients("Hello "+arg[1].trim()+" , How are you today?");
		}
		else {
			sendToAllClients("Okay , I understand you.");
		}
	}

	@Override
	protected synchronized void clientConnected(ConnectionToClient client) {
		super.clientConnected(client);
		String x = client.getInetAddress().getHostAddress();
		System.out.println("Client with host : "+client.getInfo("nongjamie")+" has connected to the server");
		sendToAllClients("Username? , Cientname? [Ex. jamie , jamie ]");
//		clientConnected(client);
	}
}
