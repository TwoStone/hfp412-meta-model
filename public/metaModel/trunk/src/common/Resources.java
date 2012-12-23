package common;

import javax.swing.ImageIcon;

import constants.IconConstants;

/**
 * Other resources (e.g. for DetailPanel customization).
 */
public class Resources {

	private static final String path = "icons/";
	
	private static ImageIcon myServerLogo = null;
	private static final String MyServerLogoPath = path + IconConstants.ICON_LARGE_CUBES;
	public static ImageIcon getMyServerLogo() {
		if (myServerLogo == null) myServerLogo = new ImageIcon(MyServerLogoPath);
			return myServerLogo;
	}
	
	// TODO: Large Icons for cutom views.


}
