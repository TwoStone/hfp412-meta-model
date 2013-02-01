package model.typeSystem;

import java.util.Set;

import model.CycleException;
import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MObjectProxi;
import persistence.MObject_TypesProxi;
import persistence.NameInstanceSearchList;
import persistence.NameSearchList;
import persistence.PersistenceException;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMObject;
import persistence.PersistentMSumType;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.Procdure;
import persistence.TDObserver;
import utils.Lists;
import utils.Sets;

/* Additional import section end */

public class MObject extends PersistentObject implements PersistentMObject {

	/** Throws persistence exception if the object with the given id does not exist. */
	public static PersistentMObject getById(long objectId) throws PersistenceException {
		long classId = ConnectionHandler.getTheConnectionHandler().theMObjectFacade.getClass(objectId);
		return (PersistentMObject) PersistentProxi.createProxi(objectId, classId);
	}

	public static PersistentMObject createMObject() throws PersistenceException {
		return createMObject(false);
	}

	public static PersistentMObject createMObject(boolean delayed$Persistence) throws PersistenceException {
		PersistentMObject result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMObjectFacade.newDelayedMObject();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMObjectFacade.newMObject(-1);
		}
		java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentMObject createMObject(boolean delayed$Persistence, PersistentMObject This)
			throws PersistenceException {
		PersistentMObject result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMObjectFacade.newDelayedMObject();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMObjectFacade.newMObject(-1);
		}
		java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		result.initialize(This, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(java.util.Hashtable<String, Object> allResults, int depth,
			int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put("types", this.getTypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
			result.put(
					"possibleNames",
					this.getPossibleNames(tdObserver).getVector(allResults, (depth > 1 ? depth : depth + 1),
							essentialLevel, forGUI, tdObserver, false));
			AbstractPersistentRoot sumType = this.getSumType(tdObserver);
			if (sumType != null) {
				result.put("sumType", sumType.createProxiInformation(false));
				if (depth > 1) {
					sumType.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && sumType.hasEssentialFields())
						sumType.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			result.put(
					"names",
					this.getNames().getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI,
							tdObserver, false));
			String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public MObject provideCopy() throws PersistenceException {
		MObject result = this;
		result = new MObject(this.This, this.getId());
		result.types = this.types.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected MObject_TypesProxi types;
	protected PersistentMObject This;

	public MObject(PersistentMObject This, long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		this.types = new MObject_TypesProxi(this);
		if (This != null && !(this.equals(This)))
			this.This = This;
	}

	static public long getTypeId() {
		return 130;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 130)
			ConnectionHandler.getTheConnectionHandler().theMObjectFacade.newMObject(this.getId());
		super.store();
		this.getTypes().store();
		if (!this.equals(this.getThis())) {
			this.getThis().store();
			ConnectionHandler.getTheConnectionHandler().theMObjectFacade.ThisSet(this.getId(), getThis());
		}

	}

	@Override
	public MObject_TypesProxi getTypes() throws PersistenceException {
		return this.types;
	}

	protected void setThis(PersistentMObject newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this)) {
			this.This = null;
			return;
		}
		if (newValue.equals(this.This))
			return;
		long objectId = newValue.getId();
		long classId = newValue.getClassId();
		this.This = (PersistentMObject) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theMObjectFacade.ThisSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentMObject getThis() throws PersistenceException {
		if (this.This == null) {
			PersistentMObject result = new MObjectProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return this.This;
	}

	@Override
	public void accept(AnythingVisitor visitor) throws PersistenceException {
		visitor.handleMObject(this);
	}

	@Override
	public <R> R accept(AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMObject(this);
	}

	@Override
	public <E extends UserException> void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMObject(this);
	}

	@Override
	public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMObject(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		return (int) (0 + this.getTypes().getLength() + this.getPossibleNames().getLength()
				+ (this.getSumType() == null ? 0 : 1) + this.getNames().getLength());
	}

	@Override
	public NameSearchList getPossibleNames(final TDObserver observer) throws PersistenceException {
		NameSearchList result = getThis().getPossibleNames();
		observer.updateTransientDerived(getThis(), "possibleNames", result);
		return result;
	}

	@Override
	public NameSearchList getPossibleNames() throws PersistenceException {
		final NameSearchList list = new NameSearchList();

		this.getThis().getTypes().applyToAll(new Procdure<PersistentMAtomicType>() {

			@Override
			public void doItTo(PersistentMAtomicType argument) throws PersistenceException {
				list.add(argument.getPossibleNames());
			}
		});

		return list;

	}

	@Override
	public PersistentMSumType getSumType(final TDObserver observer) throws PersistenceException {
		// TODO ?! ProductType?!
		PersistentMSumType result = getThis().getSumType();
		observer.updateTransientDerived(getThis(), "sumType", result);
		return result;
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
		// TODO: implement method: copyingPrivateUserAttributes

	}

	@Override
	public PersistentMSumType getSumType() throws PersistenceException {
		final PersistentMSumType newSumType = MSumType.createMSumType(true);

		this.getThis().getTypes().applyToAll(new Procdure<PersistentMAtomicType>() {

			@Override
			public void doItTo(PersistentMAtomicType argument) throws PersistenceException {
				try {
					newSumType.getContainedTypes().add(argument);
				} catch (CycleException e) {
					// THIS SHOULD NEVER HAPPEN BECAUSE OF CONSISTENCY CHECK AT #addType()
				}
			}
		});

		return newSumType;
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentMObject) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public void replaceType(final PersistentMAtomicType oldType, final PersistentMAtomicType newType)
			throws model.ConsistencyException, PersistenceException {
		// TODO: implement method: replaceType

	}

	@Override
	public void addType(final PersistentMAtomicType newType) throws model.ConsistencyException, PersistenceException {
		// TODO: implement method: addType

	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public void removeType(final PersistentMAtomicType oldType) throws model.ConsistencyException, PersistenceException {
		// TODO: implement method: removeType

	}

	@Override
	public NameInstanceSearchList getNames() throws PersistenceException {
		NameInstanceSearchList result = null;
		if (result == null)
			result = ConnectionHandler.getTheConnectionHandler().theNameInstanceFacade.inverseGetFromObject(
					this.getId(), this.getClassId());
		return result;
	}

	/* Start of protected part that is not overridden by persistence generator */
	private Set<PersistentMAspect> getAspects() throws PersistenceException {
		return Sets.transform(this.getThis().getTypes().getList(),
				new Lists.FunctionWithResult<PersistentMAtomicType, PersistentMAspect>() {

					@Override
					public PersistentMAspect apply(PersistentMAtomicType element) {
						try {
							return element.getAspect();
						} catch (PersistenceException e) {
							throw new RuntimeException(e);
						}
					}
				});
	}
	/* End of protected part that is not overridden by persistence generator */

}
