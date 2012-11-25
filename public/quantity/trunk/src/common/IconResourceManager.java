package common;

import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import persistence.Anything;
import persistence.ConversionManagerProxi;
import persistence.FractionManagerProxi;
import persistence.QuantityManagerProxi;
import persistence.UnitTypeManagerProxi;
import constants.IconConstants;

/**
 * Manages icons. 
 *
 */
public class IconResourceManager {

	private static final String DEFAULT_ICON = IconConstants.ICON_BUG_RED;
	
	private static final String IMAGE_ROOT_PATH = "icons/";
	
	private static IconResourceManager instance;
	
	private final HashMap<Integer, String> iconPaths = new HashMap<Integer, String>();
	
	private IconResourceManager() {
		this.getIconPaths().put(this.getClassImageId(UnitTypeManagerProxi.class), IconConstants.ICON_BULLET_BALL_GLASS_BLUE);
		this.getIconPaths().put(this.getClassImageId(ConversionManagerProxi.class), IconConstants.ICON_BULLET_BALL_GLASS_GREEN);
		this.getIconPaths().put(this.getClassImageId(QuantityManagerProxi.class), IconConstants.ICON_BULLET_BALL_GLASS_YELLOW);
		this.getIconPaths().put(this.getClassImageId(FractionManagerProxi.class), IconConstants.ICON_BULLET_BALL_GLASS_GREY);
		// ...
	}
	
	public static IconResourceManager getInstance() {
		if (instance == null) {
			instance = new IconResourceManager();
		}
		return instance;
	}

	public int getClassImageId(Class<? extends Anything> clazz) {
		return clazz.getName().hashCode();
	}

	public Icon getIcon(int iconInfo) {
		final String path;
		if (this.getIconPaths().containsKey(iconInfo)) {
			path = this.getIconPaths().get(iconInfo);
		} else {
			path = DEFAULT_ICON;
		}
		return this.getIconFromPath(path);
	}
	
	private Icon getIconFromPath(String path) {
		return new ImageIcon(IMAGE_ROOT_PATH+path);
	}
	
	private HashMap<Integer, String> getIconPaths() {
		return this.iconPaths;
	}
	
}
