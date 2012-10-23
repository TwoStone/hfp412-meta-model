import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JPasswordField;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import common.FrameWithIcon;

import persistence.Cache;
import persistence.ConnectionHandler;
import persistence.PersistenceException;

import model.DBConnectionConstants;
import modelServer.ConnectionServer;
import modelServer.RemoteServerMaster;
import modelServer.ServerReporter;

public class ServerStarter extends FrameWithIcon implements ServerReporter {

	private static final long serialVersionUID = 1L;
	private JRootPane jContentPane = null;
	private JPanel passwordPanel = null;
	private JLabel passwordLabel = null;
	private JPasswordField passwordField = null;
	private JLabel statusLabel = null;
	private JButton startButton = null;


	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			if (args.length >= 1)
				DBConnectionConstants.DataBaseName = args[0];
			if (args.length >= 2) {
				DBConnectionConstants.UserName = args[1];
				DBConnectionConstants.SchemaName = args[1];
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ServerStarter serverStarter = new ServerStarter();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension viewSize = serverStarter.getSize();
		double leftMargin = (screenSize.getWidth() - viewSize.getWidth())/2;
		double topMargin = (screenSize.getHeight() - viewSize.getHeight())/2;
		serverStarter.setLocation((int)leftMargin,(int)topMargin);

		serverStarter.setVisible(true);
	}
	public ServerStarter() {
		super();
		this.initialize();
	}
	private void initialize() {
		this.setSize(700, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("GOJA-Server");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				stopServer();
			}
		});
	}
	private JRootPane getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JRootPane();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getMainTabPane(),BorderLayout.CENTER);
//			jContentPane.add(getCompletePanel(), BorderLayout.CENTER);
			jContentPane.setDefaultButton(getStartButton());
		}
		return jContentPane;
	}
	private JTabbedPane mainTabPane = null;
	private JTabbedPane getMainTabPane() {
		if (mainTabPane == null){
			this.mainTabPane = new JTabbedPane();
			this.mainTabPane.add(getCompletePanel(), "Connection");
			this.mainTabPane.add(getCachePanel(), "Cache");
			this.mainTabPane.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
				}
				public void focusGained(FocusEvent e) {
					getPasswordField().requestFocus();
				}
			});
		}
		return this.mainTabPane;
	}
	private JPanel cachePanel = null;
	private JPanel getCachePanel() {
		if (this.cachePanel == null){
			this.cachePanel = new JPanel();
			this.cachePanel.setLayout(new BorderLayout());
			this.cachePanel.add(getCacheFilterPanel(),BorderLayout.NORTH);
			this.cachePanel.add(getCacheEntryListScrollPane(),BorderLayout.CENTER);
			this.cachePanel.add(getCacheToolBar(),BorderLayout.SOUTH);
		}
		return this.cachePanel;
	}
	private JPanel cacheFilterPanel = null;
	private JPanel getCacheFilterPanel() {
		if (this.cacheFilterPanel == null){
			this.cacheFilterPanel = new JPanel();
			this.cacheFilterPanel.setLayout(new BoxLayout(this.cacheFilterPanel, BoxLayout.X_AXIS));
			this.cacheFilterPanel.add(new JLabel("Filter: "));
			this.cacheFilterPanel.add(getFilterTextPane());
		}
		return this.cacheFilterPanel;
	}
	private JTextField filterTextPane = null;
	private JTextField getFilterTextPane() {
		if (this.filterTextPane == null){
			this.filterTextPane = new JTextField();
			this.filterTextPane.addKeyListener(new  KeyListener() {
				public void keyTyped(KeyEvent e) {}
				public void keyReleased(KeyEvent e) {
					filter();
				}
				public void keyPressed(KeyEvent e) {
				}
			});
		}
		return this.filterTextPane;
	}
	private JToolBar cacheToolBar = null;
	private JToolBar getCacheToolBar() {
		if (this.cacheToolBar == null){
			this.cacheToolBar = new JToolBar();
			this.cacheToolBar.add(getCacheReportButton());
		}
		return cacheToolBar;
	}
	private JButton cacheReportButton = null;
	@SuppressWarnings("rawtypes")
	private java.util.Vector backup = new java.util.Vector();
	private JButton getCacheReportButton() {
		if (cacheReportButton == null){
			this.cacheReportButton = new JButton();
			this.cacheReportButton.setText("Show cache report!");
			this.cacheReportButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					backup = Cache.getTheCache().getCacheReportList();
					filter();
				}
			});
		}
		return this.cacheReportButton;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void filter() {
		java.util.Vector show = new java.util.Vector();
		for (Object current : this.backup) {
			if (current.toString().contains(getFilterTextPane().getText())) show.add(current);
		}
		getCacheEntryList().setListData(show);
	}
	private JScrollPane cacheEntryListScrollPane = null;
	private JScrollPane getCacheEntryListScrollPane() {
		if (this.cacheEntryListScrollPane == null){
			this.cacheEntryListScrollPane = new JScrollPane();
			this.cacheEntryListScrollPane.setViewportView(getCacheEntryList());
		}
		return this.cacheEntryListScrollPane;
	}
	private JList cacheEntryList = null;
	private JList getCacheEntryList() {
		if (cacheEntryList == null) {
			this.cacheEntryList = new JList();
		}
		return cacheEntryList;
	}
	private JPanel completePanel = null;
	private Component getCompletePanel() {
		if(this.completePanel == null){
			completePanel = new JPanel();
			completePanel.setLayout(new BoxLayout(completePanel,BoxLayout.Y_AXIS));
			completePanel.add(getLogoPanel());
			completePanel.add(getConnectionPanel());
		}
		return completePanel;
	}
	private JPanel connectionPanel = null;
	private Component getConnectionPanel() {
		if(connectionPanel == null){
			connectionPanel = new JPanel();
			connectionPanel.setPreferredSize(new Dimension(700,700));
			connectionPanel.setLayout(new BorderLayout());
			connectionPanel.setBorder(new TitledBorder("Connections:"));
			connectionPanel.add(getConnectionScrollPane(),BorderLayout.CENTER);
			connectionPanel.add(getCacheSizePanel(),BorderLayout.SOUTH);
		}
		return connectionPanel;
	}
	private JPanel cacheSizePanel = null;
	private Component getCacheSizePanel() {
		if(cacheSizePanel == null){
			cacheSizePanel = new JPanel();
			cacheSizePanel.setLayout(new BoxLayout(cacheSizePanel,BoxLayout.X_AXIS));
			cacheSizePanel.add(new JLabel(" Current Cache Size: "));
			cacheSizePanel.add(getCacheSizeLabel());
			cacheSizePanel.add(new JLabel(" Maximal Cache Size: "));
			cacheSizePanel.add(getMaximalCacheSizeLabel());
			cacheSizePanel.add(new JPanel());
		}
		return cacheSizePanel;
	}
	private JLabel maximalCacheSizeLabel = null;
	private JLabel getMaximalCacheSizeLabel() {
		if(maximalCacheSizeLabel == null)maximalCacheSizeLabel = new JLabel("0");
		return maximalCacheSizeLabel;
	}
	private JScrollPane connectionScrollPane = null;
	private Component getConnectionScrollPane() {
		if(connectionScrollPane == null){
			connectionScrollPane = new JScrollPane();
			connectionScrollPane.setViewportView(getConnectionList());
		}
		return connectionScrollPane;
	}
	private JList connectionList = null;
	private Component getConnectionList() {
		if (connectionList == null){
			connectionList = new JList();
			connectionList.setModel(getConnectionListModel());
		}
		return connectionList;
	}
	private DefaultListModel connectionListModel = null;
	private DefaultListModel getConnectionListModel() {
		if (connectionListModel == null){
			connectionListModel = new DefaultListModel();
		}
		return connectionListModel;
	}
	private JPanel logoPanel = null;
	private JPanel getLogoPanel() {
		if(logoPanel == null){
			JLabel logoLabel = new JLabel();
//			logoLabel.setIcon(new ImageIcon(getClass().getResource("/common/logo.jpg")));
			logoPanel = new JPanel();
			logoPanel.setPreferredSize(new Dimension(700,90));
			logoPanel.setLayout(new BoxLayout(logoPanel,BoxLayout.X_AXIS));
			logoPanel.add(logoLabel);
			logoPanel.add(getPasswordContextPanel());
		}
		return logoPanel;
	}
	private JPanel passwordContextPanel = null;
	private JPanel getPasswordContextPanel() {
		if(passwordContextPanel == null){
			passwordContextPanel = new JPanel();
			passwordContextPanel.setLayout(new BoxLayout(passwordContextPanel,BoxLayout.Y_AXIS));
			JPanel fill1 = new JPanel();
			fill1.setPreferredSize(new Dimension(100,200));
			passwordContextPanel.add(fill1);
			passwordContextPanel.add(getPasswordPanel());
			JPanel fill2 = new JPanel();
			fill2.setLayout(new BorderLayout());
			fill2.setPreferredSize(new Dimension(100,200));
			statusLabel = new JLabel();
			statusLabel.setText("    ");
			fill2.add(statusLabel,BorderLayout.SOUTH);
			passwordContextPanel.add(fill2);
		}
		return passwordContextPanel;
	}

	private JPanel getPasswordPanel() {
		if (passwordPanel == null) {
			passwordLabel = new JLabel();
			passwordLabel.setText(" Password for Database: ");
			passwordPanel = new JPanel();
			passwordPanel.setLayout(new BoxLayout(getPasswordPanel(),
					BoxLayout.X_AXIS));
			passwordPanel.add(passwordLabel, null);
			passwordPanel.add(getPasswordField(), null);
			passwordPanel.add(getStartButton(), null);
			passwordPanel.add(getStopButton(), null);
		}
		return passwordPanel;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
		}
		return passwordField;
	}
	private JButton getStartButton() {
		if (startButton == null) {
			startButton = new JButton();
			startButton.setText("Start");
			startButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					startServer();
				}
			});
		}
		return startButton;
	}

	protected synchronized void startServer() {
		this.statusLabel.setText("");
		try {
			DBConnectionConstants.Password = this.getPasswordField().getPassword();
			ConnectionHandler connection = ConnectionHandler.getTheConnectionHandler();
			connection.connect(DBConnectionConstants.DataBaseName,
				DBConnectionConstants.SchemaName,
				DBConnectionConstants.UserName,
				DBConnectionConstants.Password,
				true);
			ConnectionHandler.initializeMapsForMappedFields();
			Cache.setReporter(this);
			ConnectionServer.startTheConnectionServer(this);
			this.statusLabel.setForeground(Color.BLACK);
			this.statusLabel.setText("Server started!");
			this.getStartButton().setEnabled(false);
			this.getStopButton().setEnabled(true);
		}catch(PersistenceException pe){
			this.statusLabel.setForeground(Color.RED);
			this.statusLabel.setText(pe.getMessage());
		}
	}
	private JButton stopButton = null;
	private JComponent getStopButton() {
		if(stopButton == null){
			stopButton = new JButton();
			stopButton.setText("Stop");
			stopButton.setEnabled(false);
			stopButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					stopServer();
				}
			});
		}
		return stopButton;
	}

	protected void stopServer() {
		try {
			ConnectionServer.stopTheConnectionServer();
			ConnectionHandler.disconnect();
			this.statusLabel.setText("Server terminated!");
			this.getStopButton().setEnabled(false);
			this.getStartButton().setEnabled(true);
		} catch (PersistenceException e) {
			this.statusLabel.setForeground(Color.RED);
			this.statusLabel.setText(e.getMessage());
		}
	}

	public void reportCancelledConnection(final RemoteServerMaster server) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				getConnectionListModel().removeElement(server);			
			}
		});
	}

	public void reportNewConnection(final RemoteServerMaster server) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				getConnectionListModel().addElement(server);
			}
		});
	}

	public void reportCurrentCacheSize(final int size) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				int currentMaximum = Integer.parseInt(getMaximalCacheSizeLabel().getText());
				if (size > currentMaximum)getMaximalCacheSizeLabel().setText(new Integer(size).toString());
				getCacheSizeLabel().setText(new Integer(size).toString());
			}
		});
	}

	private JLabel cacheSizeLabel = null;
	private JLabel getCacheSizeLabel() {
		if(cacheSizeLabel == null)cacheSizeLabel = new JLabel("0");
		return cacheSizeLabel;
	}

}