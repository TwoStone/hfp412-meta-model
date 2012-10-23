import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;

import view.ModelException;
import viewClient.MainView;
import viewClient.ServerConnection;


public class ClientConnect extends JFrame {

	private static final long serialVersionUID = 1L;
	private JRootPane jContentPane = null;
	private JPanel inputPanel = null;
	private JPanel namePanel = null;
	private JPanel passwordPanel = null;
	private JLabel nameLabel = null;
	private JTextField nameTextField = null;
	private JLabel passwordLabel = null;
	private JPasswordField passwordTextField = null;
	private JPanel fill1Panel = null;
	private JPanel connectPanel = null;
	private JButton connectButton = null;
	private JLabel statusLabel = null;
	private JPanel fillhPanel = null;
	private String url;
	private JLabel fhdwLabel = null;
	private JPanel logoPanel = null;
	private JPanel fill2Panel = null;

	private static String asString (char[] pw) {
		  String result = "";
		  for (int i = 0; i < pw.length; i++) {
			result = result + pw[i];
		  }
		  return result;
	}
	private JPanel getLogoPanel() {
		if (logoPanel == null) {
			fhdwLabel = new JLabel();
			fhdwLabel.setText("");
			//fhdwLabel.setIcon(new ImageIcon(getClass().getResource("/fileName.jpg")));
			logoPanel = new JPanel();
			logoPanel.setLayout(new BoxLayout(getLogoPanel(), BoxLayout.X_AXIS));
			logoPanel.add(fhdwLabel, null);
			logoPanel.add(getInputPanel(), null);
		}
		return logoPanel;
	}
	private JPanel getFill2Panel() {
		if (fill2Panel == null) {
			fill2Panel = new JPanel();
			fill2Panel.setLayout(new BorderLayout());
			fill2Panel.setPreferredSize(new Dimension(100, 100));
		}
		return fill2Panel;
	}
	public static void main(String[] args) {
		try {
		  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
		  e.printStackTrace();
		}
		ClientConnect clientConnect = new ClientConnect(args.length>= 1 ? args[0]:"http://localhost");

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension viewSize = clientConnect.getSize();
		double leftMargin = (screenSize.getWidth() - viewSize.getWidth())/2;
		double topMargin = (screenSize.getHeight() - viewSize.getHeight())/2;
		clientConnect.setLocation((int)leftMargin,(int)topMargin);

		
		clientConnect.setVisible(true);
	}
	
	public ClientConnect(String url) {
		super();
		this.url = url;
		initialize();
	}

	private void initialize() {
		this.setSize(700, 115);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/fileName.jpg")));
		this.setContentPane(getJContentPane());
		this.setTitle("GOJA Client Connect");
	}

	private JRootPane getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JRootPane();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getLogoPanel(), BorderLayout.CENTER);
			jContentPane.setDefaultButton(getConnectButton());
		}
		return jContentPane;
	}
	private JPanel getInputPanel() {
		if (inputPanel == null) {
			inputPanel = new JPanel();
			inputPanel.setLayout(new BoxLayout(getInputPanel(), BoxLayout.Y_AXIS));
			inputPanel.add(getFill1Panel(), null);
			inputPanel.add(getNamePanel(), null);
			inputPanel.add(getPasswordPanel(), null);
			inputPanel.add(getConnectPanel(), null);
			inputPanel.add(getFill2Panel(), null);
		}
		return inputPanel;
	}
	private JPanel getNamePanel() {
		if (namePanel == null) {
			nameLabel = new JLabel();
			nameLabel.setText(" Benutzername: ");
			namePanel = new JPanel();
			namePanel.setLayout(new BoxLayout(getNamePanel(), BoxLayout.X_AXIS));
			namePanel.add(nameLabel, null);
			namePanel.add(getNameTextField(), null);
		}
		return namePanel;
	}
	private JPanel getPasswordPanel() {
		if (passwordPanel == null) {
			passwordLabel = new JLabel();
			passwordLabel.setText(" Passwort: ");
			passwordPanel = new JPanel();
			passwordPanel.setLayout(new BoxLayout(getPasswordPanel(), BoxLayout.X_AXIS));
			passwordPanel.add(passwordLabel, null);
			passwordPanel.add(getPasswordTextField(), null);
		}
		return passwordPanel;
	}
	private JTextField getNameTextField() {
		if (nameTextField == null) {
			nameTextField = new JTextField();
		}
		return nameTextField;
	}
	private JPasswordField getPasswordTextField() {
		if (passwordTextField == null) {
			passwordTextField = new JPasswordField();
		}
		return passwordTextField;
	}
	private JPanel getFill1Panel() {
		if (fill1Panel == null) {
			fill1Panel = new JPanel();
			fill1Panel.setLayout(new BorderLayout());
			fill1Panel.setPreferredSize(new Dimension(1000,100));
		}
		return fill1Panel;
	}
	private JPanel getConnectPanel() {
		if (connectPanel == null) {
			statusLabel = new JLabel();
			statusLabel.setText("    ");
			connectPanel = new JPanel();
			connectPanel.setLayout(new BoxLayout(getConnectPanel(), BoxLayout.X_AXIS));
			connectPanel.add(getConnectButton(), null);
			connectPanel.add(getFillConnectPanel(), null);
			connectPanel.add(statusLabel, null);
		}
		return connectPanel;
	}
	private JButton getConnectButton() {
		if (connectButton == null) {
			connectButton = new JButton();
			connectButton.setText("Login");
			connectButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					connectClient();
				}
			});
		}
		return connectButton;
	}
	protected void connectClient() {
		MainView view = new MainView();
		ServerConnection connection;
		try {
			connection = new ServerConnection(this.url, view, null);
			connection.connect(this.nameTextField.getText(), 
								asString(this.getPasswordTextField().getPassword()),
								false);
		}catch(ModelException me){
			this.statusLabel.setText(me.getMessage());
			return;
		} catch (java.net.MalformedURLException me) {
			this.statusLabel.setText(me.getMessage());
			return;
		}
		view.setConnection(connection);
		view.setTitle(view.getTitle() + connection.getServerView().toString());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension viewSize = view.getSize();
		if (viewSize.getWidth() > screenSize.getWidth()) viewSize.setSize(screenSize.getWidth() - 20, viewSize.getHeight());
		if (viewSize.getHeight() > screenSize.getHeight()) viewSize.setSize(viewSize.getWidth(), screenSize.getHeight() - 20);
		view.setSize(viewSize);
		double leftMargin = (screenSize.getWidth() - viewSize.getWidth())/2;
		double topMargin = (screenSize.getHeight() - viewSize.getHeight())/2;
		view.setLocation((int)leftMargin,(int)topMargin);
		view.setVisible(true);
		view.initializeConnection();
		this.setVisible(false);
		this.dispose();
	}

	private JPanel getFillConnectPanel() {
		if (fillhPanel == null) {
			fillhPanel = new JPanel();
			fillhPanel.setLayout(new GridBagLayout());
		}
		return fillhPanel;
	}

}