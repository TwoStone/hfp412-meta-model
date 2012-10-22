import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;

import persistence.Connection;
import persistence.ConnectionHandler;

@SuppressWarnings("serial")
public class DatabaseMonitor extends JFrame implements Runnable{

	private JPanel jContentPane = null;

	private JScrollPane jScrollPane = null;

	private JList connectionList = null;

	public DatabaseMonitor() {
		super();
		initialize();
	}
	public void start(){
		new Thread(this, "Database Monitor").start();
	}
	private void initialize() {
		this.setSize(400, 300);
		this.setContentPane(getJContentPane());
		this.setTitle("Database Monitor");
		this.setFocusableWindowState(false);
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJScrollPane(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getConnectionList());
		}
		return jScrollPane;
	}
	private JList getConnectionList() {
		if (connectionList == null) {
			connectionList = new JList();
			connectionList.setModel(this.getConnectionListModel());
			connectionList.addMouseListener(new MouseListener() {
				public void mouseReleased(MouseEvent e) {
					showDetails();
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mouseClicked(MouseEvent e) {}
			});
		}
		return connectionList;
	}

	protected void showDetails() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				getJScrollPane().setViewportView(getDetailPanel((ConnectionManagerWrapper) getConnectionList().getSelectedValue()));
			}
		});
	}
	private JPanel detailPanel = null;
	private JPanel getDetailPanel(ConnectionManagerWrapper wrapper){
		if (this.detailPanel == null){
			this.detailPanel = new JPanel();
			this.detailPanel.setLayout(new BorderLayout());
			this.detailPanel.add(this.getDetailList(),BorderLayout.CENTER);
			this.detailPanel.add(this.getCloseButton(),BorderLayout.NORTH);
		}
		this.setInfo(wrapper.manager.getConnection());
		return this.detailPanel;
	}
	private void setInfo(Connection connection) {
		this.getDetailList().setListData(connection.getOperationCounterInfos());
	}
	private JButton closeButton = null;
	private JButton getCloseButton(){
		if (this.closeButton == null){
			this.closeButton = new JButton();
			this.closeButton.setText("Close");
			this.closeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							getJScrollPane().setViewportView(getConnectionList());
						}
					});
				}
			});
		}
		return this.closeButton;
	}
	private JList detailList = null;
	private JList getDetailList(){
		if (this.detailList == null){
			this.detailList = new JList();
		}
		return this.detailList;
	}
	private DefaultListModel connectionListModel = null;
	private DefaultListModel getConnectionListModel() {
		if (this.connectionListModel == null){
			this.connectionListModel = new DefaultListModel();
		}
		return this.connectionListModel;
	}
	final Object waiter = new Object();
	public void run() {
		while (this.isShowing()){
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					getConnectionListModel().clear();
					Iterator<ConnectionHandler> cons = ConnectionHandler.getConnections().iterator();
					if(!cons.hasNext()){
						dispose();
						return;
					}
					while (cons.hasNext()){
						ConnectionHandler current = cons.next();
						getConnectionListModel().addElement(new ConnectionManagerWrapper(current));
					}
				}
			});
			synchronized(waiter){
				try {
					waiter.wait(3000);
				} catch (InterruptedException e) {
					dispose();
					return;
				}
			}
		}
	}
	class ConnectionManagerWrapper {

		private ConnectionHandler manager;

		public ConnectionManagerWrapper(ConnectionHandler manager) {
			this.manager = manager;
		}
		public String toString(){
			return this.manager.getName() + ": " + new Long(this.manager.getConnection().getCommandCounter()).toString();
		}
	}
}
