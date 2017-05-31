package myClient;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import com.lloseng.ocsf.client.ObservableClient;

/**
 * My Second Client.
 * @author Sathira Kittisukmongkol
 */
public class MyClient2 implements Observer {
	
	@Override
	public void update(Observable subject, Object arg) {
		if( subject instanceof MyClient ){
			ObservableClient myClientObject = (ObservableClient)subject;
			Scanner input = new Scanner( System.in );
			System.out.print( "Input : " );
			String ans = input.nextLine();
			try {
				if( ans.equalsIgnoreCase("quit") ) {
					myClientObject.closeConnection();
					System.out.println( "Disconnected." );
				}
				else {
					myClientObject.sendToServer( ans );
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
