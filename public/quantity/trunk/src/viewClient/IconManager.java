package viewClient;

import javax.swing.Icon;

import common.IconResourceManager;


public class IconManager {
	
	private IconManager(){}

	public static Icon getIcon(int iconInfo) {
		return IconResourceManager.getInstance().getIcon(iconInfo);
	}

}
