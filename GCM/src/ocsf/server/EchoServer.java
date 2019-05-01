package ocsf.server;
import java.io.*;
import java.sql.SQLException;

import javax.net.ssl.SSLException;

import db.ConnectionDB;
import ocsf.server.*;

/**
 * This class overrides some of the methods in the abstract 
 * superclass in order to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public class EchoServer extends AbstractServer 
{
  //Class variables *************************************************
  
  /**
   * The default port to listen on.
   */
  final public static int DEFAULT_PORT =5555;
  ConnectionDB CDB = new ConnectionDB();

  /**
   * The interface type variable. It allows the implementation of 
   * the display method in the client.
   */

  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the echo server.
   *
   * @param port The port number to connect on.
   */


   /**
   * Constructs an instance of the echo server.
   *
   * @param port The port number to connect on.
   * @param serverUI The interface type variable.
   */
  public EchoServer(int port) throws IOException
  {
    super(port);
	
  }

  
  //Instance methods ************************************************
  
  /**
   * This method handles any messages received from the client.
   *
   * @param msg The message received from the client.
   * @param client The connection from which the message originated.
   */
  public void handleMessageFromClient
    (Object msg, ConnectionToClient client)
  {
	    System.out.println("handleMessageFromClient");
	    CDB.init();
	    System.out.println(msg.toString());
	    String AnsFromUsers = "";
		if (msg.toString().charAt(0)=='@'){
			try {
				AnsFromUsers = CDB.getUserDetails(msg);
			} catch (SSLException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(msg.toString().charAt(0)=='%') {
			try {
				AnsFromUsers = CDB.getCustomerDetails(msg);
			} catch (SSLException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(msg.toString().charAt(0)=='$') {
			try {
				CDB.setCustoerDetail(msg);
				System.out.println("updated");
				AnsFromUsers="1";
			} catch (SSLException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(msg.toString().charAt(0)=='!') {
			System.out.println("inside%again");
			try {
				AnsFromUsers = CDB.getCustomerCardDetails(msg);
			} catch (SSLException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			System.out.println(AnsFromUsers);
			sendToAllClients(AnsFromUsers);

		

//    if (msg.toString().startsWith("#login "))
//    {
//      if (client.getInfo("loginID") != null)
//      {
//        try
//        {
//          client.sendToClient("You are already logged in.");
//        }
//        catch (IOException e)
//        {
//        }
//        return;
//      }
//      client.setInfo("loginID", msg.toString().substring(7));
//    }
//    else 
//    {
//      if (client.getInfo("loginID") == null)
//      {
//        try
//        {
//          client.sendToClient("You need to login before you can chat.");
//          client.close();
//        }
//        catch (IOException e) {}
//        return;
//      }
//      System.out.println("Message received: " + msg + " from \"" + 
//        client.getInfo("loginID") + "\" " + client);
//      this.sendToAllClients(client.getInfo("loginID") + "> " + msg);
//    }
  }

  /**
   * This method handles all data coming from the UI
   *
   * @param message The message from the UI
   */
  public void handleMessageFromServerUI(String message)
  {
    if (message.charAt(0) == '#')
    {
      runCommand(message);
    }
    else
    {
      // send message to clients
      this.sendToAllClients("SERVER MSG> " + message);
    }
  }

  /**
   * This method executes server commands.
   *
   * @param message String from the server console.
   */
  private void runCommand(String message)
  {
    // run commands
    // a series of if statements
	  System.out.println("runCommand");
    if (message.equalsIgnoreCase("#quit"))
    {
      quit();
    }
    else if (message.equalsIgnoreCase("#stop"))
    {
      stopListening();
    }
    else if (message.equalsIgnoreCase("#close"))
    {
      try
      {
        close();
      }
      catch(IOException e) {}
    }
    else if (message.toLowerCase().startsWith("#setport"))
    {
      if (getNumberOfClients() == 0 && !isListening())
      {
        // If there are no connected clients and we are not 
        // listening for new ones, assume server closed.
        // A more exact way to determine this was not obvious and
        // time was limited.
        int newPort = Integer.parseInt(message.substring(9));
        setPort(newPort);
        //error checking should be added
      }
      else
      {
      }
    }
    else if (message.equalsIgnoreCase("#start"))
    {
      if (!isListening())
      {
        try
        {
          listen();
        }
        catch(Exception ex)
        {
        }
      }
      else
      {
      }
    }
    else if (message.equalsIgnoreCase("#getport"))
    {
    }
  }
    
  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
   */
  protected void serverStarted()
  {
    System.out.println
      ("Server listening for connections on port " + getPort());
  }
  
  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
  protected void serverStopped()
  {
    System.out.println
      ("Server has stopped listening for connections.");
  }

  /**
   * Run when new clients are connected. Implemented by Benjamin Bergman,
   * Oct 22, 2009.
   *
   * @param client the connection connected to the client
   */
  protected void clientConnected(ConnectionToClient client) 
  {
    // display on server and clients that the client has connected.
    String msg = "You Are Connected to the server";
    System.out.println("client connected to the server");
    this.sendToAllClients(msg);
  }

  /**
   * Run when clients disconnect. Implemented by Benjamin Bergman,
   * Oct 22, 2009
   *
   * @param client the connection with the client
   */
  synchronized protected void clientDisconnected(
    ConnectionToClient client)
  {
    // display on server and clients when a user disconnects
    String msg = client.getInfo("loginID").toString() + " has disconnected";

    System.out.println(msg);
    this.sendToAllClients(msg);
  }

  /**
   * Run when a client suddenly disconnects. Implemented by Benjamin
   * Bergman, Oct 22, 2009
   *
   * @param client the client that raised the exception
   * @param Throwable the exception thrown
   */
  synchronized protected void clientException(
    ConnectionToClient client, Throwable exception) 
  {
    String msg = client.getInfo("loginID").toString() + " has disconnected";

    System.out.println(msg);
    this.sendToAllClients(msg);
  }

  /**
   * This method terminates the server.
   */
  public void quit()
  {
    try
    {
      close();
    }
    catch(IOException e)
    {
    }
    System.exit(0);
  }


  //Class methods ***************************************************
  
  /**
   * This method is responsible for the creation of 
   * the server instance (there is no UI in this phase).
   *
   * @param args[0] The port number to listen on.  Defaults to 5555 
   *          if no argument is entered.
   */
  public static void Start(String[] args) 
  {
    int port = 0; //Port to listen on

    try
    {
      port = Integer.parseInt(args[0]); //Get port from command line
    }
    catch(Throwable t)
    {
      port = DEFAULT_PORT; //Set port to 5555
    }
	
    EchoServer sv = null;
	try {
		sv = new EchoServer(port);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    try 
    {
      sv.listen(); //Start listening for connections
    } 
    catch (Exception ex) 
    {
      System.out.println("ERROR - Could not listen for clients!");
    }
  }
}
//End of EchoServer class
