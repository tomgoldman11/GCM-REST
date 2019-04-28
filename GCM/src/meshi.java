import java.io.IOException;

import javax.net.ssl.SSLException;

import db.ConnectionDB;
import ocsf.server.EchoServer;

public class meshi {
	public static void main(String[] args) {
		try {	
			EchoServer es = new EchoServer(5555);
			es.listen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

