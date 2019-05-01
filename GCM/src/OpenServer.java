import java.io.IOException;
import ocsf.server.EchoServer;

public class OpenServer {
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

