package myClient;

import com.lloseng.ocsf.client.ObservableClient;

import java.io.IOException;
import java.util.Scanner;

/**
 * My First Client.
 * @author Sathira Kittisukmongkol
 */
public class MyClient extends ObservableClient {

	Object msg;

	public MyClient(String host, int port) {
		super(host, port);
	}

		@Override
		protected void handleMessageFromServer(Object msg) {
			Scanner input = new Scanner(System.in);
			System.out.println( msg );
			System.out.print( "Input : " );
			String keyboard = input.nextLine();
			try {
				if( !keyboard.equalsIgnoreCase("quit") ) {
					sendToServer(keyboard);
				}
				else {
					closeConnection();
					System.out.println( "Disconnected." );
				}
			} catch (IOException e) {
				System.out.println( e.getMessage() );
			}
				
		}

		protected void connectionEstablished() {
			System.out.println( "Connected to server "+getHost() );
		}

//	@Override
//	protected void handleMessageFromServer(Object msg) {
//		System.out.println( msg );
//		String message = (String)msg;
//		if( message.contains("send") || message.contains("What") || message.contains("Sorry") ) {
//			setChanged();
//			notifyObservers();
//		}		
//	}
//
//	protected void connectionClosed() {
//
//	}
//
//	protected void connectionEstablished() {
//		System.out.println( "Connected to server "+getHost() );
//	}

}
