import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;

@SuppressWarnings("serial")
public class DatabaseMonitor extends JFrame implements Runnable{

	private JPanel jContentPane = null;

	private JScrollPane jScrollPane = null;

	private JList connectionList = null;

	/**
	 * This is the default constructor
	 */
	public DatabaseMonitor() {
		super();
		initialize();
	}
	public void start(){
		new Thread(this).start();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("Database Monitor");
		this.setFocusableWindowState(false);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJScrollPane(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getConnectionList());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes connectionList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getConnectionList() {
		if (connectionList == null) {
			connectionList = new JList();
			connectionList.setModel(this.getConnectionListModel());
		}
		return connectionList;
	}

	private DefaultListModel connectionListModel = null;
	private DefaultListModel getConnectionListModel() {
		if (this.connectionListModel == null){
			this.connectionListModel = new DefaultListModel();
		}
		return this.connectionListModel;
	}

	public void run() {
		synchronized(this){
			try {
				this.wait(5000);
			} catch (InterruptedException e) {
				this.dispose();
				return;
			}
		}
		this.dispose();
		return;
	}


}
