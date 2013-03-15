package common;

import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import persistence.AccountManagerProxi;
import persistence.AccountProxi;
import persistence.AccountTypeManagerProxi;
import persistence.Anything;
import persistence.AspectManagerProxi;
import persistence.AssociationManagerProxi;
import persistence.AssociationProxi;
import persistence.CompUnitProxi;
import persistence.CompUnitTypeProxi;
import persistence.ConversionProxi;
import persistence.EnumValueManagerProxi;
import persistence.EnumerationManagerProxi;
import persistence.FractionManagerProxi;
import persistence.FractionWrapperProxi;
import persistence.FunctionProxi;
import persistence.HierarchyProxi;
import persistence.LinkManagerProxi;
import persistence.LinkProxi;
import persistence.MAccountTypeProxi;
import persistence.MAspectProxi;
import persistence.MAtomicTypeProxi;
import persistence.MEmptyTypeDisjunctionProxi;
import persistence.MEnumProxi;
import persistence.MEnumValueProxi;
import persistence.MFalseProxi;
import persistence.MMeasurementTypeProxi;
import persistence.MMixedTypeDisjunctionProxi;
import persistence.MNonEmptyAtomicTypeConjunctionProxi;
import persistence.MObjectProxi;
import persistence.MObservationProxi;
import persistence.MObservationTypeProxi;
import persistence.MSingletonObjectProxi;
import persistence.MTrueProxi;
import persistence.MeasurementProxi;
import persistence.MeasurementTypeManagerProxi;
import persistence.MessageManagerProxi;
import persistence.MessageProxi;
import persistence.NameSchemeManagerProxi;
import persistence.NameSchemeProxi;
import persistence.ObjectManagerProxi;
import persistence.ObsTypeManagerProxi;
import persistence.ObservationManagerProxi;
import persistence.OperationManagerProxi;
import persistence.OperationProxi;
import persistence.QuantityManagerProxi;
import persistence.QuantityProxi;
import persistence.ReferenceProxi;
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

	private static final String DEFAULT_ICON = IconConstants.ICON_BULLET_BALL_GREY;

	private static final String IMAGE_ROOT_PATH = "icons/";

	private static IconResourceManager instance;

	private final HashMap<Integer, String> iconPaths = new HashMap<Integer, String>();

	private IconResourceManager() {
		this.getIconPaths().put(this.getClassImageId(UnitTypeManagerProxi.class), IconConstants.ICON_SHELF);

		this.getIconPaths().put(this.getClassImageId(QuantityManagerProxi.class), IconConstants.ICON_SHOPPINGCART_FULL);
		this.getIconPaths().put(this.getClassImageId(FractionManagerProxi.class), IconConstants.ICON_PIE_CHART);
		this.getIconPaths().put(this.getClassImageId(CompUnitProxi.class), IconConstants.ICON_CUBES_BLUE);
		this.getIconPaths().put(this.getClassImageId(CompUnitTypeProxi.class), IconConstants.ICON_CUBE_MOLECULE);
		this.getIconPaths().put(this.getClassImageId(ConversionProxi.class), IconConstants.ICON_NAV_REFRESH_BLUE);
		this.getIconPaths().put(this.getClassImageId(UnitTypeProxi.class), IconConstants.ICON_BULLET_BALL_RED);
		// this.getIconPaths().put(this.getClassImageId(ReferenceTypeProxi.class), IconConstants.ICON_BULLET_BALL_RED);
		this.getIconPaths().put(this.getClassImageId(UnitProxi.class), IconConstants.ICON_CUBE_BLUE);
		this.getIconPaths().put(this.getClassImageId(AssociationManagerProxi.class), IconConstants.ICON_GRAPHICS_TABLET);
		this.getIconPaths().put(this.getClassImageId(AssociationProxi.class), IconConstants.ICON_GRAPH_EDGE_DIRECTED);
		this.getIconPaths().put(this.getClassImageId(AspectManagerProxi.class), IconConstants.ICON_JAR_BEAN);
		this.getIconPaths().put(this.getClassImageId(MAspectProxi.class), IconConstants.ICON_COFFEEBEAN);
		this.getIconPaths().put(this.getClassImageId(TypeManagerProxi.class), IconConstants.ICON_INDEX);
		this.getIconPaths().put(this.getClassImageId(ReferenceProxi.class) * 10000, IconConstants.ICON_UP_PLUS);
		this.getIconPaths().put(this.getClassImageId(ReferenceProxi.class) * 20000, IconConstants.ICON_DOWN_MINUS);
		this.getIconPaths().put(this.getClassImageId(ReferenceTypeProxi.class), IconConstants.ICON_GRAPH_EDGE_DIRECTED);

		this.getIconPaths().put(this.getClassImageId(MObservationTypeProxi.class), IconConstants.ICON_ELEMENT_FIND);
		this.getIconPaths().put(this.getClassImageId(MObservationProxi.class), IconConstants.ICON_FIND_TEXT);
		this.getIconPaths().put(this.getClassImageId(ObjectManagerProxi.class), IconConstants.ICON_WAR);
		this.getIconPaths().put(this.getClassImageId(MObjectProxi.class), IconConstants.ICON_PLANET);
		this.getIconPaths().put(this.getClassImageId(QuantityProxi.class), IconConstants.ICON_PACKAGE);
		this.getIconPaths().put(this.getClassImageId(FractionWrapperProxi.class), IconConstants.ICON_PERCENT);
		this.getIconPaths().put(this.getClassImageId(MeasurementProxi.class), IconConstants.ICON_SCALES);
		this.getIconPaths().put(this.getClassImageId(AccountManagerProxi.class), IconConstants.ICON_BOOKS);
		this.getIconPaths().put(this.getClassImageId(AccountProxi.class), IconConstants.ICON_BOOK_OPEN2);
		this.getIconPaths().put(this.getClassImageId(AccountTypeManagerProxi.class), IconConstants.ICON_FOLDER2_GREEN);
		this.getIconPaths().put(this.getClassImageId(MAccountTypeProxi.class), IconConstants.ICON_FORM_GREEN);
		this.getIconPaths().put(this.getClassImageId(MAtomicTypeProxi.class), IconConstants.ICON_GRAPH_NODE);
		this.getIconPaths().put(this.getClassImageId(MSingletonObjectProxi.class), IconConstants.ICON_STAR_BLUE);
		this.getIconPaths().put(this.getClassImageId(MeasurementTypeManagerProxi.class), IconConstants.ICON_DICTIONARY);
		this.getIconPaths().put(this.getClassImageId(MMeasurementTypeProxi.class), IconConstants.ICON_DOCUMENT_CERTIFICATE);
		this.getIconPaths().put(this.getClassImageId(MessageManagerProxi.class), IconConstants.ICON_MAIL_SERVER);
		this.getIconPaths().put(this.getClassImageId(MessageProxi.class), IconConstants.ICON_MAIL);
		this.getIconPaths().put(this.getClassImageId(NameSchemeManagerProxi.class), IconConstants.ICON_TEACHER);
		this.getIconPaths().put(this.getClassImageId(NameSchemeProxi.class), IconConstants.ICON_BLACKBOARD);
		this.getIconPaths().put(this.getClassImageId(MTrueProxi.class), IconConstants.ICON_TICKET_GREEN);
		this.getIconPaths().put(this.getClassImageId(MFalseProxi.class), IconConstants.ICON_TICKET_RED);
		this.getIconPaths().put(this.getClassImageId(FunctionProxi.class), IconConstants.ICON_DIE);
		this.getIconPaths().put(this.getClassImageId(LinkProxi.class), IconConstants.ICON_LINK);
		this.getIconPaths().put(this.getClassImageId(LinkManagerProxi.class), IconConstants.ICON_CRUTCH);
		this.getIconPaths().put(this.getClassImageId(OperationManagerProxi.class), IconConstants.ICON_DOCUMENTS_GEAR);
		this.getIconPaths().put(this.getClassImageId(OperationProxi.class), IconConstants.ICON_GEARS);
		this.getIconPaths().put(this.getClassImageId(MEmptyTypeDisjunctionProxi.class), IconConstants.ICON_SELECTION);
		this.getIconPaths().put(this.getClassImageId(ObservationManagerProxi.class), IconConstants.ICON_SPY);
		this.getIconPaths().put(this.getClassImageId(ObsTypeManagerProxi.class), IconConstants.ICON_ENVIRONMENT_VIEW);

		this.getIconPaths().put(this.getClassImageId(MMixedTypeDisjunctionProxi.class), IconConstants.ICON_LOGIC_OR);
		this.getIconPaths().put(this.getClassImageId(MNonEmptyAtomicTypeConjunctionProxi.class), IconConstants.ICON_LOGIC_AND);
		this.getIconPaths().put(this.getClassImageId(HierarchyProxi.class), IconConstants.ICON_TEXT_TREE);

		this.getIconPaths().put(this.getClassImageId(EnumerationManagerProxi.class), IconConstants.ICON_TABLE_SQL);
		this.getIconPaths().put(this.getClassImageId(EnumValueManagerProxi.class), IconConstants.ICON_TABLE);
		this.getIconPaths().put(this.getClassImageId(MEnumProxi.class), IconConstants.ICON_TABLE_SQL_VIEW);
		this.getIconPaths().put(this.getClassImageId(MEnumValueProxi.class), IconConstants.ICON_TABLE_VIEW);
		// ...
	}

	public static IconResourceManager getInstance() {
		if (instance == null) {
			instance = new IconResourceManager();
		}
		return instance;
	}

	public int getClassImageId(final Class<? extends Anything> clazz) {
		return clazz.getName().hashCode();
	}

	public Icon getIcon(final int iconInfo) {
		final String path;
		if (this.getIconPaths().containsKey(iconInfo)) {
			path = this.getIconPaths().get(iconInfo);
		} else {
			path = DEFAULT_ICON;
		}
		return this.getIconFromPath(path);
	}

	private Icon getIconFromPath(final String path) {
		return new ImageIcon(IMAGE_ROOT_PATH + path);
	}

	private HashMap<Integer, String> getIconPaths() {
		return this.iconPaths;
	}

}
