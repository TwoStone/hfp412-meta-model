import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

import modelServer.ConnectionServer;
import model.DBConnectionConstants;
import persistence.PersistenceException;
import modelServer.ServerReporter;
import modelServer.RemoteServerMaster;

import persistence.*;
import viewClient.ConnectionMaster;
import viewClient.MainView;
import viewClient.ClientReporter;
import view.ModelException;
import viewClient.ServerConnection;

@SuppressWarnings("serial")
public class Main extends JFrame implements ServerReporter, ClientReporter {

	private JScrollPane serverScrollPane;

	private JList serverList;
	private JList clientList;

	private Thread statusbarResetter = new Thread();

	private JPanel jContentPane = null;

	private JRootPane rootPanel = null;
	private JToolBar mainToolBar = null;
	private JSplitPane mainSplitPane = null;
	private JPanel clientPanel = null;
	private JPanel serverPanel = null;
	private JLabel clientLabel = null;
	private JLabel serverLabel = null;
	private JLabel connectionURLLabel = null;
	private JToolBar passwordToolBar = null;
	private JPasswordField DBPasswordInput = null;
	private JLabel passwordLabel = null;
	private JButton startServerCommand = null;
	private JToolBar clientToolBar = null;
	private JLabel connectionNumberLabel = null;
	private JTextField userInput = null;
	private JTextField URLInput = null;
	private JButton clientConnectCommand = null;
	private JScrollPane clientScrollPane = null;
	private JLabel statusBar = null;
	private DefaultListModel servers = new DefaultListModel();
	private DefaultListModel clients = new DefaultListModel();
	private javax.swing.JLabel jLabel = null;
	private javax.swing.JPasswordField ASPasswordInput = null;
	private JCheckBox createUserBox = null;


	private static String asString (char[] pw) {
	  String result = "";
	  for (int i = 0; i < pw.length; i++) {
		result = result + pw[i];
	  }
	  return result;
	}
	public static void main(String[] args) {
	try {
	  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	  if (args.length >= 1) DBConnectionConstants.DataBaseName = args[0];
	  if (args.length >= 2) {
		  DBConnectionConstants.UserName = args[1];
		  DBConnectionConstants.SchemaName = args[1];
	  }
	}
	catch(Exception e) {
	  e.printStackTrace();
	}
	Main theMain = new Main(args.length>= 3 ? args[2]:"http://localhost");
	theMain.setVisible(true);
  }
	public Main(String serverURL) {
		super();
		Cache.setReporter(this);
		initialize();
		getURLInput().setText(serverURL);
	}
	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(517, 297);
		this.setContentPane(getJContentPane());
		this.setTitle("Test Application Panel");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				ConnectionServer.stopTheConnectionServer();
			}
		});
	}
	public void reportNewConnection(final RemoteServerMaster server){
		java.awt.EventQueue.invokeLater(new Runnable(){
			public void run() {
				servers.addElement(server);
			}
		});
	}
	public void reportCancelledConnection(final RemoteServerMaster server) {
		java.awt.EventQueue.invokeLater(new Runnable(){
			public void run() {
				servers.removeElement(server);
			}
		});
	}
	public void reportNewClient(final ConnectionMaster master) {
		java.awt.EventQueue.invokeLater(new Runnable(){
			public void run() {
				clients.addElement(master);
			}
		});
	}
	public void reportLostClient(final ConnectionMaster master) {
		java.awt.EventQueue.invokeLater(new Runnable(){
			public void run() {
				clients.removeElement(master);			
			}
		});
	}
	private void startServerAction(){
		try {
			DBConnectionConstants.Password = this.DBPasswordInput.getPassword();
			ConnectionHandler connection = ConnectionHandler.getTheConnectionHandler();
			connection.connect(DBConnectionConstants.DataBaseName,
				DBConnectionConstants.SchemaName,
				DBConnectionConstants.UserName,
				DBConnectionConstants.Password,
				true);
			ConnectionHandler.initializeMapsForMappedFields();
			ConnectionServer.startTheConnectionServer(this);
			this.passwordToolBar.setVisible(false);
			this.getUserInput().grabFocus();
			this.rootPanel.setDefaultButton(this.getClientConnectCommand());
			this.monitorStartAction();
		}catch(PersistenceException pe){
			this.setStatusbar(pe);
			this.getDBPasswordInput().setText("");
			this.getDBPasswordInput().grabFocus();
		}
	}
	private void connectClientAction() {
		MainView view = new MainView();
		ServerConnection connection;
		try {
			connection = new ServerConnection(this.URLInput.getText(), view, this);
			connection.connect(this.getUserInput().getText(), 
								asString(this.getASPasswordInput().getPassword()),
								this.getCreateUserCheckBox().isSelected());
		}catch(ModelException me){
			this.setStatusbar(me);
			return;
		}catch(java.net.MalformedURLException me){
			this.setStatusbar(me.getMessage());
			return;
		}
		view.setConnection(connection);
		try {
			view.setTitle(view.getTitle() + connection.getServerView().getUser());
		} catch (ModelException me) {
			this.setStatusbar(me.getMessage());
			return;
		}
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension viewSize = view.getSize();
		double leftMargin = (screenSize.getWidth() - viewSize.getWidth())/2;
		double topMargin = (screenSize.getHeight() - viewSize.getHeight())/2;
		view.setLocation((int)leftMargin,(int)topMargin);
		view.setVisible(true);
		view.initializeConnection();
	}


	protected void setStatusbar(ModelException exception) {
		this.setStatusbar(Long.toString(exception.getErrorNumber()) + ": " + exception.getMessage());
	}
	protected void setStatusbar(PersistenceException exception) {
		this.setStatusbar(Long.toString(exception.getErrorNumber()) + ": " + exception.getMessage());
	}
	protected void setStatusbar(String message) {
		this.statusBar.setText(message);
		if (this.statusbarResetter.isAlive()) this.statusbarResetter.interrupt();
		this.statusbarResetter = new Thread(new StatusBarResetter(this.statusBar));
		statusbarResetter.start();
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new java.awt.BorderLayout());
			jContentPane.add(getRootPanel(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
	}
	private JRootPane getRootPanel(){
		if (rootPanel == null) {
			rootPanel = new JRootPane();
			rootPanel.setLayout(new java.awt.BorderLayout());
			rootPanel.add(getMainSplitPane(),java.awt.BorderLayout.CENTER);
			rootPanel.add(getMainToolBar(), java.awt.BorderLayout.SOUTH);
			rootPanel.setDefaultButton(getStartServerCommand());
		}
		return rootPanel;
	}
	private JToolBar getMainToolBar() {
		if(mainToolBar == null) {
			mainToolBar = new JToolBar();
			mainToolBar.add(new JLabel("Cache Size: "));
			mainToolBar.add(getCacheSizeLabel());
			mainToolBar.add(new JLabel("   "));
			mainToolBar.add(getStatusBar());
		}
		return mainToolBar;
	}
	private JSplitPane getMainSplitPane() {
		if(mainSplitPane == null) {
			mainSplitPane = new JSplitPane();
			mainSplitPane.setTopComponent(getClientPanel());
			mainSplitPane.setBottomComponent(getServerPanel());
			mainSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			mainSplitPane.setDividerLocation(125);
		}
		return mainSplitPane;
	}
	private JPanel getClientPanel() {
		if(clientPanel == null) {
			clientPanel = new JPanel();
			clientPanel.setLayout(new java.awt.BorderLayout());
			clientPanel.add(getClientLabel(), java.awt.BorderLayout.NORTH);
			clientPanel.add(getClientToolBar(), java.awt.BorderLayout.SOUTH);
			clientPanel.add(getClientScrollPane(), java.awt.BorderLayout.CENTER);
		}
		return clientPanel;
	}
	private JPanel getServerPanel() {
		if(serverPanel == null) {
			serverPanel = new JPanel();
			serverPanel.setLayout(new java.awt.BorderLayout());
			serverPanel.add(getServerLabelBar(), java.awt.BorderLayout.NORTH);
			serverPanel.add(getPasswordToolBar(), java.awt.BorderLayout.SOUTH);
			serverPanel.add(getServerScrollPane(), java.awt.BorderLayout.CENTER);
		}
		return serverPanel;
	}
	private JToolBar serverLabelBar = null;
	private JToolBar getServerLabelBar() {
		if (this.serverLabelBar == null){
			this.serverLabelBar = new JToolBar();
			this.serverLabelBar.add(getServerLabel());
		}
		return this.serverLabelBar;
	}
	private JLabel getClientLabel() {
		if(clientLabel == null) {
			clientLabel = new JLabel();
			clientLabel.setText("  Clients");
		}
		return clientLabel;
	}
	private JLabel getServerLabel() {
		if(serverLabel == null) {
			serverLabel = new JLabel();
			serverLabel.setText("  Server  ");
		}
		return serverLabel;
	}
	private JToolBar getPasswordToolBar() {
		if(passwordToolBar == null) {
			passwordToolBar = new JToolBar();
			passwordToolBar.add(getPasswordLabel());
			passwordToolBar.add(getDBPasswordInput());
			passwordToolBar.add(getStartServerCommand());
		}
		return passwordToolBar;
	}

	private void monitorStartAction() {
		DatabaseMonitor monitor = new DatabaseMonitor();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension viewSize = monitor.getSize();
		double leftMargin = (screenSize.getWidth() - viewSize.getWidth());
		double topMargin = (screenSize.getHeight() - viewSize.getHeight());
		monitor.setLocation((int)leftMargin,(int)topMargin);
		monitor.setVisible(true);
		monitor.transferFocus();
		monitor.start();
	}
	private JPasswordField getDBPasswordInput() {
		if(DBPasswordInput == null) {
			DBPasswordInput = new JPasswordField();
			DBPasswordInput.setText("pg");
		}
		return DBPasswordInput;
	}
	private JLabel getPasswordLabel() {
		if(passwordLabel == null) {
			passwordLabel = new JLabel();
			passwordLabel.setText(" Password: ");
		}
		return passwordLabel;
	}
	private JButton getStartServerCommand() {
		if(startServerCommand == null) {
			startServerCommand = new JButton();
			startServerCommand.setText("Start");
			startServerCommand.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					startServerAction();
				}
			});
		}
		return startServerCommand;
	}
	private JToolBar getClientToolBar() {
		if(clientToolBar == null) {
			clientToolBar = new JToolBar();
			clientToolBar.add(getConnectionURLLabel());
			clientToolBar.add(getURLInput());
			clientToolBar.add(getConnectionNumberLabel());
			clientToolBar.add(getUserInput());
			clientToolBar.add(getJLabel());
			clientToolBar.add(getASPasswordInput());
			clientToolBar.add(getCreateUserCheckBox());
			clientToolBar.add(getClientConnectCommand());
		}
		return clientToolBar;
	}
	private JCheckBox getCreateUserCheckBox() {
		if(this.createUserBox == null){
			this.createUserBox = new JCheckBox();
			createUserBox.setText("Create User");
			createUserBox.setSelected(true);
		}
		return this.createUserBox;
	}
	private JLabel getConnectionURLLabel() {
		if(connectionURLLabel == null) {
			connectionURLLabel = new JLabel();
			connectionURLLabel.setText(" URL: ");
		}
		return connectionURLLabel;
	}
	private JLabel getConnectionNumberLabel() {
		if(connectionNumberLabel == null) {
			connectionNumberLabel = new JLabel();
			connectionNumberLabel.setText(" User: ");
		}
		return connectionNumberLabel;
	}
	private JTextField getUserInput() {
		if(userInput == null) {
			userInput = new JTextField();
			userInput.setText("hugo");
		}
		return userInput;
	}
	private JTextField getURLInput() {
		if(URLInput == null) {
			URLInput = new JTextField();
		}
		return URLInput;
	}
	private JButton getClientConnectCommand() {
		if(clientConnectCommand == null) {
			clientConnectCommand = new JButton();
			clientConnectCommand.setText("Connect");
			clientConnectCommand.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					connectClientAction();
				}
			});
		}
		return clientConnectCommand;
	}
	private JScrollPane getClientScrollPane() {
		if(clientScrollPane == null) {
			clientScrollPane = new JScrollPane();
			clientScrollPane.setViewportView(getClientList());
		}
		return clientScrollPane;
	}
	private JScrollPane getServerScrollPane() {
		if(serverScrollPane == null) {
			serverScrollPane = new JScrollPane();
			serverScrollPane.setViewportView(getServerList());
		}
		return serverScrollPane;
	}
	private JList getClientList() {
		if(clientList == null) {
			clientList = new JList();
			clientList.setModel(this.clients);
		}
		return clientList;
	}
	private JList getServerList() {
		if(serverList == null) {
			serverList = new JList();
			serverList.setModel(this.servers);
		}
		return serverList;
	}
	private JLabel getStatusBar() {
		if(statusBar == null) {
			statusBar = new JLabel();
			statusBar.setText("   ");
		}
		return statusBar;
	}
	/**
	 * This method initializes jLabel
	 *
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel() {
		if(jLabel == null) {
			jLabel = new javax.swing.JLabel();
			jLabel.setText("  Password: ");
		}
		return jLabel;
	}
	/**
	 * This method initializes ASPasswordInput
	 *
	 * @return javax.swing.JPasswordField
	 */
	private javax.swing.JPasswordField getASPasswordInput() {
		if(ASPasswordInput == null) {
			ASPasswordInput = new javax.swing.JPasswordField();
			ASPasswordInput.setText("hugo");
		}
		return ASPasswordInput;
	}
	public void reportCurrentCacheSize(final int size) {
		java.awt.EventQueue.invokeLater(new Runnable(){
			public void run() {
				getCacheSizeLabel().setText(new Integer(size).toString());
			}
		});
	}
	JLabel cacheSizeLabel = null;
	private JLabel getCacheSizeLabel() {
		if (cacheSizeLabel == null)cacheSizeLabel = new JLabel("0");
		return cacheSizeLabel;
	}

}  //  @jve:visual-info  decl-index=0 visual-constraint="10,10"

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


