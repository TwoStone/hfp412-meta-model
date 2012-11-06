package viewClient;

import view.*;
import java.net.MalformedURLException;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.xmlrpc.XmlRpcException;

public class ServerConnection extends ConnectionMaster {

	public ServerConnection (String url, ExceptionAndEventHandler handler, ClientReporter reporter) throws MalformedURLException {
		super(url, handler, reporter);
	}

	public ServerView getServerView(){
		return (ServerView)super.getServer();
	}


}
