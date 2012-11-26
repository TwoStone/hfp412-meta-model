package viewClient.custom;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import view.ServerView;
import viewClient.ExceptionAndEventHandler;

public class ServerSpecialPanel extends SpecialPanel {

	/**
	 * Start Detail Panel.
	 */
	private static final long serialVersionUID = 1L;

	public ServerSpecialPanel(ExceptionAndEventHandler exceptionHandler, ServerView server) {
		super(exceptionHandler);

		this.setLayout(new GridBagLayout());

		JLabel picture = new JLabel(common.Resources.getMyServerLogo());
		GridBagConstraints picConstr = new GridBagConstraints();
		picConstr.gridx = 0;
		picConstr.weighty = 2.0;
		picConstr.gridy = 0;
		this.add(picture, picConstr);
		/*
		JLabel picture2 = new JLabel(Resources.getServerViewLogoIcon());
		picConstr.gridx = 0;
		picConstr.weighty = 2.0;
		picConstr.gridy = 1;
		this.add(picture2, picConstr);
		
		JLabel picture3 = new JLabel(Resources.ServerViewLogoTextBottom());
		picConstr.gridx = 0;
		picConstr.weighty = 2.0;
		picConstr.gridy = 2;
		this.add(picture3, picConstr);
*/
	}

}
