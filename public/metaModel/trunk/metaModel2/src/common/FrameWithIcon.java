package common;

import java.net.URL;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FrameWithIcon extends JFrame {
	
	private static final String Icon = "common/logo.jpg";

	public FrameWithIcon(){
		URL iconUrl = FrameWithIcon.class.getClassLoader().getResource(Icon);
		if (iconUrl != null) this.setIconImage(getToolkit().getImage(iconUrl));
	}

}
