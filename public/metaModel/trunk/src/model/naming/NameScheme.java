package model.naming;

import java.util.regex.Pattern;

import model.UserException;
import model.basic.MBoolean;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MModelItemExceptionVisitor;
import model.visitor.MModelItemReturnExceptionVisitor;
import model.visitor.MModelItemReturnVisitor;
import model.visitor.MModelItemVisitor;
import persistence.*;
import utils.SearchLists;

/* Additional import section end */

public class NameScheme extends PersistentObject implements PersistentNameScheme {

	/** Throws persistence exception if the object with the given id does not exist. */
	public static PersistentNameScheme getById(final long objectId) throws PersistenceException {
		final long classId = ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade.getClass(objectId);
		return (PersistentNameScheme) PersistentProxi.createProxi(objectId, classId);
	}

	public static PersistentNameScheme createNameScheme(final String regExpPattern, final String name, final PersistentMBoolean isIterable)
			throws PersistenceException {
		return createNameScheme(regExpPattern, name, isIterable, false);
	}

	public static PersistentNameScheme createNameScheme(final String regExpPattern, final String name, final PersistentMBoolean isIterable,
			final boolean delayed$Persistence) throws PersistenceException {
		if (regExpPattern == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		if (name == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		PersistentNameScheme result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade.newDelayedNameScheme(regExpPattern, name);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade.newNameScheme(regExpPattern, name, -1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("regExpPattern", regExpPattern);
		final$$Fields.put("name", name);
		final$$Fields.put("isIterable", isIterable);
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentNameScheme createNameScheme(final String regExpPattern, final String name, final PersistentMBoolean isIterable,
			final boolean delayed$Persistence, final PersistentNameScheme This) throws PersistenceException {
		if (regExpPattern == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		if (name == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		PersistentNameScheme result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade.newDelayedNameScheme(regExpPattern, name);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade.newNameScheme(regExpPattern, name, -1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("regExpPattern", regExpPattern);
		final$$Fields.put("name", name);
		final$$Fields.put("isIterable", isIterable);
		result.initialize(This, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults, final int depth,
			final int essentialLevel, final boolean forGUI, final boolean leaf, final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put("regExpPattern", this.getRegExpPattern());
			result.put("name", this.getName());
			final AbstractPersistentRoot isIterable = this.getIsIterable();
			if (isIterable != null) {
				result.put("isIterable", isIterable.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					isIterable.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && isIterable.hasEssentialFields())
						isIterable.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			result.put(
					"names",
					this.getNames().getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver, false,
							essentialLevel == 0));
			final AbstractPersistentRoot myCONCMModelItem = this.getMyCONCMModelItem();
			if (myCONCMModelItem != null) {
				result.put("myCONCMModelItem", myCONCMModelItem.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					myCONCMModelItem.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					myCONCMModelItem.toHashtable(allResults, depth, essentialLevel + 1, forGUI, true, tdObserver);
				}
			}
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	public static NameSchemeSearchList getNameSchemeByName(final String name) throws PersistenceException {
		return ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade.getNameSchemeByName(name);
	}

	@Override
	public NameScheme provideCopy() throws PersistenceException {
		NameScheme result = this;
		result = new NameScheme(this.regExpPattern, this.name, this.isIterable, this.This, this.myCONCMModelItem, this.getId());
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return true;
	}

	protected String regExpPattern;
	protected String name;
	protected PersistentMBoolean isIterable;
	protected PersistentNameScheme This;
	protected PersistentMModelItem myCONCMModelItem;

	public NameScheme(final String regExpPattern, final String name, final PersistentMBoolean isIterable, final PersistentNameScheme This,
			final PersistentMModelItem myCONCMModelItem, final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		this.regExpPattern = regExpPattern;
		this.name = name;
		this.isIterable = isIterable;
		if (This != null && !(this.equals(This)))
			this.This = This;
		this.myCONCMModelItem = myCONCMModelItem;
	}

	static public long getTypeId() {
		return 244;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 244)
			ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade.newNameScheme(regExpPattern, name, this.getId());
		super.store();
		if (this.getIsIterable() != null) {
			this.getIsIterable().store();
			ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade.isIterableSet(this.getId(), getIsIterable());
		}
		if (!this.equals(this.getThis())) {
			this.getThis().store();
			ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade.ThisSet(this.getId(), getThis());
		}
		if (this.getMyCONCMModelItem() != null) {
			this.getMyCONCMModelItem().store();
			ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade.myCONCMModelItemSet(this.getId(), getMyCONCMModelItem());
		}

	}

	@Override
	public String getRegExpPattern() throws PersistenceException {
		return this.regExpPattern;
	}

	@Override
	public void setRegExpPattern(final String newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		if (!this.isDelayed$Persistence())
			ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade.regExpPatternSet(this.getId(), newValue);
		this.regExpPattern = newValue;
	}

	@Override
	public String getName() throws PersistenceException {
		return this.name;
	}

	@Override
	public void setName(final String newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		if (!this.isDelayed$Persistence())
			ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade.nameSet(this.getId(), newValue);
		this.name = newValue;
	}

	@Override
	public PersistentMBoolean getIsIterable() throws PersistenceException {
		return this.isIterable;
	}

	@Override
	public void setIsIterable(final PersistentMBoolean newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.isIterable))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.isIterable = (PersistentMBoolean) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade.isIterableSet(this.getId(), newValue);
		}
	}

	protected void setThis(final PersistentNameScheme newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this)) {
			this.This = null;
			return;
		}
		if (newValue.equals(this.This))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.This = (PersistentNameScheme) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade.ThisSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentMModelItem getMyCONCMModelItem() throws PersistenceException {
		return this.myCONCMModelItem;
	}

	@Override
	public void setMyCONCMModelItem(final PersistentMModelItem newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.myCONCMModelItem))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.myCONCMModelItem = (PersistentMModelItem) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theNameSchemeFacade.myCONCMModelItemSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentNameScheme getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentNameScheme result = new NameSchemeProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return this.This;
	}

	@Override
	public void delete$Me() throws PersistenceException {
		super.delete$Me();
		this.getMyCONCMModelItem().delete$Me();
	}

	@Override
	public void accept(final MModelItemVisitor visitor) throws PersistenceException {
		visitor.handleNameScheme(this);
	}

	@Override
	public <R> R accept(final MModelItemReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleNameScheme(this);
	}

	@Override
	public <E extends UserException> void accept(final MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleNameScheme(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MModelItemReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleNameScheme(this);
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleNameScheme(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleNameScheme(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleNameScheme(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleNameScheme(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getIsIterable() != null)
			return 1;
		if (this.getNames().getLength() > 0)
			return 1;
		return 0;
	}

	@Override
	public NameSchemeInstanceSearchList getNames() throws PersistenceException {
		NameSchemeInstanceSearchList result = null;
		if (result == null)
			result = ConnectionHandler.getTheConnectionHandler().theNameSchemeInstanceFacade.inverseGetType(this.getId(), this.getClassId());
		return result;
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields) throws PersistenceException {
		this.setThis((PersistentNameScheme) This);
		if (this.equals(This)) {
			final PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(),
					(PersistentNameScheme) This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setRegExpPattern((String) final$$Fields.get("regExpPattern"));
			this.setName((String) final$$Fields.get("name"));
			this.setIsIterable((PersistentMBoolean) final$$Fields.get("isIterable"));
		}
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public void delete() throws model.ConsistencyException, PersistenceException {
		// TODO Check delegation to abstract class and overwrite if necessary!
		this.getMyCONCMModelItem().delete();
	}

	@Override
	public MModelItemSearchList fetchDependentItems() throws PersistenceException {
		final MModelItemSearchList result = new MModelItemSearchList();
		SearchLists.addSecondToFirst(result, getThis().getNames());

		return result;
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public PersistentMBoolean match(final String name) throws PersistenceException {
		return MBoolean.createFromBoolean(Pattern.matches(getThis().getRegExpPattern(), name));
	}

	@Override
	public void prepareForDeletion() throws model.ConsistencyException, PersistenceException {
	}

	// Start of section that contains overridden operations only.

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}
