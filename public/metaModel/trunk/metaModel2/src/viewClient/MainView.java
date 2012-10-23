package viewClient;

import javax.swing.JFrame;
import javax.swing.JLabel;

import view.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class MainView extends JFrame implements ExceptionAndEventHandler{

	ConnectionMaster connection;

	Thread statusbarResetter = new Thread();

	private javax.swing.JPanel jContentPane = null;

	private javax.swing.JLabel statusBar = null;

	/**
	 * This is the default constructor
	 */
	public MainView() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(1200, 800);
		this.setContentPane(getJContentPane());
		this.setTitle("MainView: ");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				getConnection().refresherStop();
			}
		});
	}
	public void setConnection(ConnectionMaster connection){
		ServerView server = (ServerView) connection.getServer();
		jContentPane.add(getServerClientView(server), BorderLayout.CENTER);
		this.getServerClientView().setConnection(connection);
		ConnectionIndex.getTheConnectionIndex().setConnection(this.getServerClientView(), connection);
		ConnectionIndex.getTheConnectionIndex().setConnection(this, connection);
	}
	public ServerConnection getConnection(){
        	return this.getServerClientView().getConnection();
	}
	protected void setStatusbar(ModelException exception) {
		this.setStatusbar(Long.toString(exception.getErrorNumber()) + ": " + exception.getMessage());
	}
	protected void setStatusbar(String message) {
		this.statusBar.setText(message);
		if (this.statusbarResetter.isAlive()) this.statusbarResetter.interrupt();
		this.statusbarResetter = new Thread(new StatusBarResetter(this.statusBar));
		statusbarResetter.start();
	}
	public void handleException(ModelException e){
		this.getStatusBar().setForeground(Color.RED);
		this.getStatusBar().setFont(this.getStatusBar().getFont().deriveFont(Font.BOLD));
		this.setStatusbar(e);
	}
	public void handleUserException(UserException exception) {
		this.getStatusBar().setForeground(Color.RED);
		this.getStatusBar().setFont(this.getStatusBar().getFont().deriveFont(Font.PLAIN));
		this.setStatusbar(exception.getMessage());
	}
	public void handleOKMessage(String message){
		this.getStatusBar().setForeground(Color.BLACK);
		this.getStatusBar().setFont(this.getStatusBar().getFont().deriveFont(Font.PLAIN));
		this.setStatusbar(message);
	}
	public void handleRefresh(){
		this.getServerClientView().handleRefresh();
	}
	public void initializeConnection(){
		this.getServerClientView().initializeConnection();
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new java.awt.BorderLayout());
			jContentPane.add(getStatusBar(), java.awt.BorderLayout.SOUTH);
		}
		return jContentPane;
	}
	
	private ServerClientView serverClientView = null;
	private ServerClientView getServerClientView(ServerView server) {
		if (serverClientView == null){
			serverClientView = new ServerClientView(this,server);
		}
		return serverClientView;
	}
	private ServerClientView getServerClientView(){
		return this.serverClientView;
	}
	private javax.swing.JLabel getStatusBar() {
		if(statusBar == null) {
			statusBar = new javax.swing.JLabel();
			statusBar.setText("   ");
		}
		return statusBar;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"

class StatusBarResetter implements Runnable{

  private static final long Delay = 10000;

  private JLabel statusBar;

  public StatusBarResetter(JLabel statusBar) {
	this.statusBar = statusBar;
  }

  public void run() {
	synchronized(this){
	  try{
		this.wait(Delay);
		this.statusBar.setText("   ");
	  }catch(InterruptedException ie){
		return;
	  }
	}
  }

}
