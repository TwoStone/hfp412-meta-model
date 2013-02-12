package common;

import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import persistence.Anything;
import persistence.AspectManagerProxi;
import persistence.AssociationManagerProxi;
import persistence.CompUnitProxi;
import persistence.CompUnitTypeProxi;
import persistence.ConversionProxi;
import persistence.FractionManagerProxi;
import persistence.QuantityManagerProxi;
import persistence.ReferenceTypeProxi;
import persistence.TypeManagerProxi;
import persistence.UnitProxi;
import persistence.UnitTypeManagerProxi;
import persistence.UnitTypeProxi;
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
		this.getIconPaths().put(this.getClassImageId(UnitTypeManagerProxi.class), IconConstants.ICON_SHELF);
		// this.getIconPaths().put(this.getClassImageId(ConversionManagerProxi.class), IconConstants.ICON_SCALES);
		this.getIconPaths().put(this.getClassImageId(QuantityManagerProxi.class), IconConstants.ICON_SHOPPINGCART_FULL);
		this.getIconPaths().put(this.getClassImageId(FractionManagerProxi.class), IconConstants.ICON_PIE_CHART);
		this.getIconPaths().put(this.getClassImageId(CompUnitProxi.class), IconConstants.ICON_CUBES_BLUE);
		this.getIconPaths().put(this.getClassImageId(CompUnitTypeProxi.class), IconConstants.ICON_CUBE_MOLECULE);
		this.getIconPaths().put(this.getClassImageId(ConversionProxi.class), IconConstants.ICON_NAV_REFRESH_BLUE);
		this.getIconPaths().put(this.getClassImageId(UnitTypeProxi.class), IconConstants.ICON_BULLET_BALL_RED);
		this.getIconPaths().put(this.getClassImageId(ReferenceTypeProxi.class), IconConstants.ICON_BULLET_BALL_RED);
		this.getIconPaths().put(this.getClassImageId(UnitProxi.class), IconConstants.ICON_CUBE_BLUE);
		this.getIconPaths().put(this.getClassImageId(AssociationManagerProxi.class),
				IconConstants.ICON_GRAPH_EDGE_DIRECTED);
		this.getIconPaths().put(this.getClassImageId(AspectManagerProxi.class), IconConstants.ICON_COOKIES);
		this.getIconPaths().put(this.getClassImageId(TypeManagerProxi.class), IconConstants.ICON_INDEX);
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
		return new ImageIcon(IMAGE_ROOT_PATH + path);
	}

	private HashMap<Integer, String> getIconPaths() {
		return this.iconPaths;
	}

}
