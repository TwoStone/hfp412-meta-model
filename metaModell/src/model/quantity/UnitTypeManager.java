package model.quantity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import model.ConsistencyException;
import model.DoubleDefinitionException;
import model.UserException;
import model.visitor.AbsUnitReturnExceptionVisitor;
import model.visitor.AbsUnitTypeReturnExceptionVisitor;
import model.visitor.AbsUnitTypeReturnVisitor;
import model.visitor.AbsUnitTypeVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.AbsUnitSearchList;
import persistence.AbsUnitTypeSearchList;
import persistence.Anything;
import persistence.CompUnitSearchList;
import persistence.CompUnitTypeSearchList;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentAddReferenceCommand;
import persistence.PersistentAddReferenceTypeCommand;
import persistence.PersistentChangeUNameCommand;
import persistence.PersistentChangeUTNameCommand;
import persistence.PersistentCompUnit;
import persistence.PersistentCompUnitType;
import persistence.PersistentConversion;
import persistence.PersistentCreateUnitCommand;
import persistence.PersistentCreateUnitTypeCommand;
import persistence.PersistentFetchCUCommand;
import persistence.PersistentFetchCUTCommand;
import persistence.PersistentFetchReferenceCommand;
import persistence.PersistentFetchReferenceTypeCommand;
import persistence.PersistentFetchScalarCommand;
import persistence.PersistentFetchScalarTypeCommand;
import persistence.PersistentFunction;
import persistence.PersistentGetExistingCUCommand;
import persistence.PersistentGetExistingCUTCommand;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentReference;
import persistence.PersistentReferenceType;
import persistence.PersistentSetConversionCommand;
import persistence.PersistentSetDefaultUnitCommand;
import persistence.PersistentUnit;
import persistence.PersistentUnitType;
import persistence.PersistentUnitTypeManager;
import persistence.Predcate;
import persistence.Procdure;
import persistence.ReferenceSearchList;
import persistence.ReferenceTypeSearchList;
import persistence.TDObserver;
import persistence.UnitTypeManagerProxi;
import persistence.UnitTypeManager_RefTypesProxi;
import persistence.UnitTypeManager_RefsProxi;
import persistence.UnitTypeManager_UnitTypesProxi;
import persistence.UnitTypeManager_UnitsProxi;
import persistence.UnitTypeSearchList;

import common.Fraction;

import constants.ExceptionConstants;

/* Additional import section end */

public class UnitTypeManager extends PersistentObject implements PersistentUnitTypeManager {

	private static PersistentUnitTypeManager theUnitTypeManager = null;
	public static boolean reset$For$Test = false;
	private static final Object $$lock = new Object();

	public static PersistentUnitTypeManager getTheUnitTypeManager() throws PersistenceException {
		if (theUnitTypeManager == null || reset$For$Test) {
			class Initializer implements Runnable {
				PersistenceException exception = null;

				@Override
				public void run() {
					try {
						UnitTypeManagerProxi proxi = null;
						synchronized ($$lock) {
							proxi = ConnectionHandler.getTheConnectionHandler().theUnitTypeManagerFacade.getTheUnitTypeManager();
							theUnitTypeManager = proxi;
						}
						if (proxi.getId() < 0) {
							proxi.setId(proxi.getId() * -1);
							proxi.initialize(proxi, new java.util.Hashtable<String, Object>());
							proxi.initializeOnCreation();
						}
					} catch (final PersistenceException e) {
						exception = e;
					}
					synchronized ($$lock) {
						$$lock.notify();
					}
				}

				PersistentUnitTypeManager getResult() throws PersistenceException {
					if (exception != null)
						throw exception;
					return theUnitTypeManager;
				}
			}
			synchronized ($$lock) {
				reset$For$Test = false;
				final Initializer initializer = new Initializer();
				new Thread(initializer).start();
				try {
					$$lock.wait();
				} catch (final InterruptedException e) {
				} // Need not to be interrupted
				return initializer.getResult();
			}
		}
		return theUnitTypeManager;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults, final int depth,
			final int essentialLevel, final boolean forGUI, final boolean leaf, final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put("unitTypes", this.getUnitTypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
			result.put(
					"atomicUnitTypes",
					this.getAtomicUnitTypes(tdObserver).getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver,
							false, essentialLevel == 0));
			result.put("refTypes", this.getRefTypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
			result.put("refs", this.getRefs().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
			result.put("units", this.getUnits().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public UnitTypeManager provideCopy() throws PersistenceException {
		UnitTypeManager result = this;
		result = new UnitTypeManager(this.This, this.getId());
		result.unitTypes = this.unitTypes.copy(result);
		result.refTypes = this.refTypes.copy(result);
		result.refs = this.refs.copy(result);
		result.units = this.units.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected UnitTypeManager_UnitTypesProxi unitTypes;
	protected UnitTypeManager_RefTypesProxi refTypes;
	protected UnitTypeManager_RefsProxi refs;
	protected UnitTypeManager_UnitsProxi units;
	protected PersistentUnitTypeManager This;

	public UnitTypeManager(final PersistentUnitTypeManager This, final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		this.unitTypes = new UnitTypeManager_UnitTypesProxi(this);
		this.refTypes = new UnitTypeManager_RefTypesProxi(this);
		this.refs = new UnitTypeManager_RefsProxi(this);
		this.units = new UnitTypeManager_UnitsProxi(this);
		if (This != null && !(this.equals(This)))
			this.This = This;
	}

	static public long getTypeId() {
		return 171;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		// Singletons cannot be delayed!
	}

	@Override
	public UnitTypeManager_UnitTypesProxi getUnitTypes() throws PersistenceException {
		return this.unitTypes;
	}

	@Override
	public UnitTypeManager_RefTypesProxi getRefTypes() throws PersistenceException {
		return this.refTypes;
	}

	@Override
	public UnitTypeManager_RefsProxi getRefs() throws PersistenceException {
		return this.refs;
	}

	@Override
	public UnitTypeManager_UnitsProxi getUnits() throws PersistenceException {
		return this.units;
	}

	protected void setThis(final PersistentUnitTypeManager newValue) throws PersistenceException {
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
		this.This = (PersistentUnitTypeManager) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theUnitTypeManagerFacade.ThisSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentUnitTypeManager getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentUnitTypeManager result = new UnitTypeManagerProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return this.This;
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleUnitTypeManager(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleUnitTypeManager(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleUnitTypeManager(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleUnitTypeManager(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getUnitTypes().getLength() > 0)
			return 1;
		if (this.getUnits().getLength() > 0)
			return 1;
		return 0;
	}

	@Override
	public void addReferenceType(final String name, final PersistentAbsUnitType unitType, final PersistentUnitType referenceUnitType,
			final long exponent, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentAddReferenceTypeCommand command = model.meta.AddReferenceTypeCommand.createAddReferenceTypeCommand(name, exponent, now, now);
		command.setUnitType(unitType);
		command.setReferenceUnitType(referenceUnitType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public void addReference(final String name, final PersistentAbsUnit unit, final PersistentUnit referenceUnit, final long exponent,
			final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentAddReferenceCommand command = model.meta.AddReferenceCommand.createAddReferenceCommand(name, exponent, now, now);
		command.setUnit(unit);
		command.setReferenceUnit(referenceUnit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void changeUName(final PersistentAbsUnit unit, final String name, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentChangeUNameCommand command = model.meta.ChangeUNameCommand.createChangeUNameCommand(name, now, now);
		command.setUnit(unit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void changeUTName(final PersistentAbsUnitType unitType, final String name, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentChangeUTNameCommand command = model.meta.ChangeUTNameCommand.createChangeUTNameCommand(name, now, now);
		command.setUnitType(unitType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void createUnitType(final String name, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentCreateUnitTypeCommand command = model.meta.CreateUnitTypeCommand.createCreateUnitTypeCommand(name, now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void createUnit(final String name, final PersistentUnitType type, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentCreateUnitCommand command = model.meta.CreateUnitCommand.createCreateUnitCommand(name, now, now);
		command.setType(type);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void fetchCUT(final String name, final ReferenceTypeSearchList refTypes, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentFetchCUTCommand command = model.meta.FetchCUTCommand.createFetchCUTCommand(name, now, now);
		final java.util.Iterator<PersistentReferenceType> refTypesIterator = refTypes.iterator();
		while (refTypesIterator.hasNext()) {
			command.getRefTypes().add(refTypesIterator.next());
		}
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void fetchCU(final String name, final ReferenceSearchList refs, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentFetchCUCommand command = model.meta.FetchCUCommand.createFetchCUCommand(name, now, now);
		final java.util.Iterator<PersistentReference> refsIterator = refs.iterator();
		while (refsIterator.hasNext()) {
			command.getRefs().add(refsIterator.next());
		}
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void fetchReferenceType(final PersistentUnitType unitType, final long exponent, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentFetchReferenceTypeCommand command = model.meta.FetchReferenceTypeCommand.createFetchReferenceTypeCommand(exponent, now, now);
		command.setUnitType(unitType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void fetchReference(final PersistentUnit unit, final long exponent, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentFetchReferenceCommand command = model.meta.FetchReferenceCommand.createFetchReferenceCommand(exponent, now, now);
		command.setUnit(unit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void fetchScalarType(final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentFetchScalarTypeCommand command = model.meta.FetchScalarTypeCommand.createFetchScalarTypeCommand(now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void fetchScalar(final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentFetchScalarCommand command = model.meta.FetchScalarCommand.createFetchScalarCommand(now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void getExistingCUT(final ReferenceTypeSearchList refTypes, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentGetExistingCUTCommand command = model.meta.GetExistingCUTCommand.createGetExistingCUTCommand(now, now);
		final java.util.Iterator<PersistentReferenceType> refTypesIterator = refTypes.iterator();
		while (refTypesIterator.hasNext()) {
			command.getRefTypes().add(refTypesIterator.next());
		}
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void getExistingCU(final ReferenceSearchList refs, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentGetExistingCUCommand command = model.meta.GetExistingCUCommand.createGetExistingCUCommand(now, now);
		final java.util.Iterator<PersistentReference> refsIterator = refs.iterator();
		while (refsIterator.hasNext()) {
			command.getRefs().add(refsIterator.next());
		}
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields) throws PersistenceException {
		this.setThis((PersistentUnitTypeManager) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public void setConversion(final PersistentUnit unit, final common.Fraction factor, final common.Fraction constant, final Invoker invoker)
			throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentSetConversionCommand command = model.meta.SetConversionCommand.createSetConversionCommand(factor, constant, now, now);
		command.setUnit(unit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void setDefaultUnit(final PersistentUnitType type, final PersistentUnit unit, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentSetDefaultUnitCommand command = model.meta.SetDefaultUnitCommand.createSetDefaultUnitCommand(now, now);
		command.setType(type);
		command.setUnit(unit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public PersistentAbsUnitType addReferenceType(final String name, final PersistentAbsUnitType unitType,
			final PersistentUnitType referenceUnitType, final long exponent) throws model.DoubleDefinitionException, PersistenceException {

		final PersistentAbsUnitType cut = unitType.accept(new AbsUnitTypeReturnExceptionVisitor<PersistentAbsUnitType, DoubleDefinitionException>() {

			@Override
			public PersistentAbsUnitType handleCompUnitType(final PersistentCompUnitType compUnitType) throws PersistenceException,
					DoubleDefinitionException {
				// Referenzen von compUnitType auf referenceUnitType überprüfen
				PersistentReferenceType refType = null;
				final ReferenceTypeSearchList refTypeList = new ReferenceTypeSearchList();
				final Iterator<PersistentReferenceType> i = compUnitType.getRefs().iterator();
				while (i.hasNext()) {
					final PersistentReferenceType next = i.next();
					if (next.getRef().equals(referenceUnitType)) {
						refType = next;
					} else {
						refTypeList.add(next);
					}
				}

				if (refType == null) {
					refType = fetchReferenceType(referenceUnitType, exponent);
					refTypeList.add(refType);
				} else {
					final long exp = refType.getExponent() + exponent;
					if (refTypeList.getLength() == 0 && exp == 1) {

						return referenceUnitType;
					}
					if (exponent + refType.getExponent() != 0) {
						refType = fetchReferenceType(referenceUnitType, exponent + refType.getExponent());
						refTypeList.add(refType);
					}
				}

				return fetchCUT(name, refTypeList);

			}

			@Override
			public PersistentAbsUnitType handleUnitType(final PersistentUnitType unitType) throws PersistenceException, DoubleDefinitionException {
				// ReferenceType mit unitType laden bzw. erstellen
				final ReferenceTypeSearchList refTypeList = new ReferenceTypeSearchList();
				if (referenceUnitType.equals(unitType)) {
					if (exponent + 1 == 1) {
						return unitType;
					}
					if (exponent + 1 != 0) {
						refTypeList.add(fetchReferenceType(unitType, exponent + 1));
						return fetchCUT(name, refTypeList);
					}
					return fetchScalarType();
				} else {
					final PersistentReferenceType refType = fetchReferenceType(referenceUnitType, exponent);
					final PersistentReferenceType refType2 = fetchReferenceType(unitType, 1);
					refTypeList.add(refType2);
					refTypeList.add(refType);
					return fetchCUT(name, refTypeList);
				}
			}

		});

		return cut;

	}

	@Override
	public PersistentAbsUnit addReference(final String name, final PersistentAbsUnit unit, final PersistentUnit referenceUnit, final long exponent)
			throws model.DoubleDefinitionException, PersistenceException {
		final PersistentAbsUnit ret = unit.accept(new AbsUnitReturnExceptionVisitor<PersistentAbsUnit, DoubleDefinitionException>() {

			@Override
			public PersistentAbsUnit handleUnit(final PersistentUnit unit) throws PersistenceException, DoubleDefinitionException {
				// Reference mit unit laden bzw. erstellen
				final ReferenceSearchList refList = new ReferenceSearchList();
				if (referenceUnit.equals(unit)) {
					if (exponent + 1 != 0) {
						refList.add(fetchReference(unit, exponent + 1));
						return fetchCU(name, refList);
					}
					return fetchScalar();
				} else {
					final PersistentReference ref1 = fetchReference(unit, 1);
					final PersistentReference ref2 = fetchReference(referenceUnit, exponent);
					refList.add(ref1);
					refList.add(ref2);
					return fetchCU(name, refList);
				}
			}

			@Override
			public PersistentAbsUnit handleCompUnit(final PersistentCompUnit compUnit) throws PersistenceException, DoubleDefinitionException {
				PersistentReference ref = null;
				final ReferenceSearchList refList = new ReferenceSearchList();
				final Iterator<PersistentReference> i = compUnit.getRefs().iterator();
				while (i.hasNext()) {
					final PersistentReference next = i.next();
					if (next.getRef().equals(referenceUnit)) {
						ref = next;
					} else {
						refList.add(next);
					}
				}

				if (ref == null) {
					if (refList.getLength() == 0 && exponent == 1) {
						return referenceUnit;
					}
					ref = fetchReference(referenceUnit, exponent);
					refList.add(ref);
				} else {
					final long exp = ref.getExponent() + exponent;
					if (refList.getLength() == 0 && exp == 1) {
						return referenceUnit;
					}

					if (exp != 0) {
						ref = fetchReference(referenceUnit, exponent + ref.getExponent());
						refList.add(ref);
					} else if (refList.getLength() == 1 && refList.iterator().next().getExponent() == 1) {
						return refList.iterator().next().getRef();
					}
				}

				return fetchCU(name, refList);
			}

		});

		return ret;

	}

	@Override
	public void changeUName(final PersistentAbsUnit unit, final String name) throws model.DoubleDefinitionException, PersistenceException {
		final AbsUnitSearchList old = Unit.getAbsUnitByName(name);
		if (old.iterator().hasNext()) {
			throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_UNIT_DEFINITION + name);
		} else {
			unit.setName(name);
		}

	}

	@Override
	public void changeUTName(final PersistentAbsUnitType unitType, final String name) throws model.DoubleDefinitionException, PersistenceException {
		final AbsUnitTypeSearchList old = AbsUnitType.getAbsUnitTypeByName(name);

		if (old.iterator().hasNext()) {
			throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_UNIT_TYPE_DEFINITION + name);
		} else {
			unitType.setName(name);
		}

	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {

	}

	@Override
	public PersistentUnitType createUnitType(final String name) throws model.DoubleDefinitionException, PersistenceException {
		final AbsUnitTypeSearchList old = AbsUnitType.getAbsUnitTypeByName(name);
		if (old.iterator().hasNext()) {
			throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_UNIT_TYPE_DEFINITION + name);
		}

		final PersistentUnitType result = UnitType.createUnitType(name);
		this.getThis().getUnitTypes().add(result);
		return result;
	}

	@Override
	public PersistentUnit createUnit(final String name, final PersistentUnitType type) throws model.DoubleDefinitionException, PersistenceException {
		final AbsUnitSearchList old = Unit.getAbsUnitByName(name);
		if (old.iterator().hasNext()) {
			throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_UNIT_DEFINITION + name);
		}
		final PersistentUnit result = Unit.createUnit(type, name);
		getThis().getUnits().add(result);
		return result;

	}

	@Override
	public PersistentCompUnitType fetchCUT(final String name, final ReferenceTypeSearchList refTypes) throws model.DoubleDefinitionException,
			PersistenceException {
		PersistentCompUnitType result = getExistingCUT(refTypes);
		if (result == null) {

			// Name schon vorhanden?
			final AbsUnitTypeSearchList old = AbsUnitType.getAbsUnitTypeByName(name);
			if (old.iterator().hasNext()) {
				throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_UNIT_TYPE_DEFINITION + name);
			}

			String newUTName = name;
			if (name.equals("")) {
				newUTName = this.getNameForCompoundUnitType(refTypes);
			}
			result = CompUnitType.createCompUnitType(newUTName);
			try {
				result.getRefs().add(refTypes);
			} catch (final UserException e) {
				e.printStackTrace();
			}
			getThis().getUnitTypes().add(result);
		}

		return result;
	}

	@Override
	public PersistentCompUnit fetchCU(final String name, final ReferenceSearchList refs) throws model.DoubleDefinitionException, PersistenceException {
		PersistentCompUnit result = getExistingCU(refs);
		if (result == null) {

			// Name schon vorhanden?
			final AbsUnitSearchList old = AbsUnit.getAbsUnitByName(name);
			if (old.iterator().hasNext()) {
				throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_UNIT_DEFINITION + name);
			}

			String newUnitName = name;
			if (name.equals("")) {
				newUnitName = this.getNameForCompoundUnit(refs);
			}

			// Exponenten in Abhängigkeit zum UT aggregieren
			final Iterator<PersistentReference> i = refs.iterator();

			final Map<PersistentUnitType, Long> collectedRefTypes = new HashMap<PersistentUnitType, Long>();
			while (i.hasNext()) {
				final PersistentReference next = i.next();
				final PersistentUnitType curUTForRef = (PersistentUnitType) next.getRef().getType();
				final Long aggregatedExpForUT = collectedRefTypes.get(curUTForRef);
				if (aggregatedExpForUT == null) {
					collectedRefTypes.put(curUTForRef, next.getExponent());
				} else {
					collectedRefTypes.put(curUTForRef, next.getExponent() + aggregatedExpForUT);
				}
			}
			// Prüfen, ob exponenten 0 sind

			// RefTypes anhand der aggregierten Exponenten auf der Exemplarebene holen
			final ReferenceTypeSearchList refTypeList = new ReferenceTypeSearchList();
			for (final Map.Entry<PersistentUnitType, Long> entry : collectedRefTypes.entrySet()) {
				final Long exponent = entry.getValue();
				if (exponent != 0) {
					refTypeList.add(fetchReferenceType(entry.getKey(), exponent));
				}
			}

			// refTypeList.add(next.getType());
			result = CompUnit.createCompUnit(fetchCUT("", refTypeList), newUnitName);
			try {
				result.getRefs().add(refs);
			} catch (final UserException e) {
				e.printStackTrace();
			}
			getThis().getUnits().add(result);
		}

		return result;
	}

	@Override
	public PersistentReferenceType fetchReferenceType(final PersistentUnitType unitType, final long exponent) throws PersistenceException {
		PersistentReferenceType refType = getThis().getRefTypes().findFirst(new Predcate<PersistentReferenceType>() {
			@Override
			public boolean test(final PersistentReferenceType argument) throws PersistenceException {
				return argument.getRef().equals(unitType) && argument.getExponent() == exponent;
			}
		});
		if (refType == null) {
			refType = ReferenceType.createReferenceType(exponent, unitType);
			getThis().getRefTypes().add(refType);
		}
		return refType;
	}

	@Override
	public PersistentReference fetchReference(final PersistentUnit unit, final long exponent) throws PersistenceException {
		PersistentReference ref = getThis().getRefs().findFirst(new Predcate<PersistentReference>() {
			@Override
			public boolean test(final PersistentReference argument) throws PersistenceException {
				return argument.getRef().equals(unit) && argument.getExponent() == exponent;
			}
		});
		if (ref == null) {
			ref = Reference.createReference(exponent, unit);
			// ref.setExponent(exponent);
			// ref.setRef(unit);
			// ref.setType(this.getReferenceType((PersistentUnitType) unit.getType(), exponent));
			getThis().getRefs().add(ref);
		}
		return ref;
	}

	@Override
	public PersistentCompUnitType fetchScalarType() throws PersistenceException {
		PersistentCompUnitType type = (PersistentCompUnitType) getThis().getUnitTypes().findFirst(new Predcate<PersistentAbsUnitType>() {

			@Override
			public boolean test(final PersistentAbsUnitType argument) throws PersistenceException {
				return argument instanceof PersistentCompUnitType && ((PersistentCompUnitType) argument).getRefs().getLength() == 0;
			}
		});

		if (type == null) {
			type = CompUnitType.createCompUnitType("ScalarType");
			getThis().getUnitTypes().add(type);
		}
		return type;
	}

	@Override
	public PersistentCompUnit fetchScalar() throws PersistenceException {
		PersistentCompUnit unit = (PersistentCompUnit) getThis().getUnits().findFirst(new Predcate<PersistentAbsUnit>() {

			@Override
			public boolean test(final PersistentAbsUnit argument) throws PersistenceException {
				return argument instanceof PersistentCompUnit && ((PersistentCompUnit) argument).getRefs().getLength() == 0;
			}
		});

		if (unit == null) {
			unit = CompUnit.createCompUnit(getThis().fetchScalarType(), "Scalar");
			getThis().getUnits().add(unit);
		}
		return unit;
	}

	@Override
	public PersistentAbsUnit fetchUnitByUnitType(final PersistentAbsUnitType ut) throws model.NotFoundException, PersistenceException {
		return ut.accept(new AbsUnitTypeReturnVisitor<PersistentAbsUnit>() {

			@Override
			public PersistentAbsUnit handleCompUnitType(final PersistentCompUnitType compUnitType) throws PersistenceException {
				if (compUnitType.inverseGetType() == null) {
					return null;
				} else {
					return compUnitType.inverseGetType().iterator().next();
				}
			}

			@Override
			public PersistentAbsUnit handleUnitType(final PersistentUnitType unitType) throws PersistenceException {
				// nimm default oder den erstbesten
				final PersistentUnit defaultU = unitType.getDefaultUnit();
				if (!(defaultU == null)) {
					if (unitType.inverseGetType() == null) {
						return null;
					} else {
						return unitType.inverseGetType().iterator().next();
					}
				} else {
					return defaultU;
				}
			}
		});
	}

	@Override
	public UnitTypeSearchList getAtomicUnitTypes() throws PersistenceException {
		final UnitTypeSearchList result = new UnitTypeSearchList();

		this.getThis().getUnitTypes().applyToAll(new Procdure<PersistentAbsUnitType>() {
			@Override
			public void doItTo(final PersistentAbsUnitType argument) throws PersistenceException {
				argument.accept(new AbsUnitTypeVisitor() {
					@Override
					public void handleUnitType(final PersistentUnitType unitType) throws PersistenceException {
						result.add(unitType);
					}

					@Override
					public void handleCompUnitType(final PersistentCompUnitType compUnitType) throws PersistenceException {
					}
				});
			}
		});

		return result;
	}

	@Override
	public UnitTypeSearchList getAtomicUnitTypes(final TDObserver observer) throws PersistenceException {
		final UnitTypeSearchList result = getThis().getAtomicUnitTypes();
		observer.updateTransientDerived(getThis(), "atomicUnitTypes", result);
		return result;
	}

	@Override
	public PersistentCompUnitType getExistingCUT(final ReferenceTypeSearchList refTypes) throws PersistenceException {
		if (refTypes.getLength() == 0) {
			return this.getThis().fetchScalarType();
		} else {

			final Iterator<PersistentReferenceType> refTypeIterator = refTypes.iterator();
			final PersistentReferenceType firstRefType = refTypeIterator.next();
			final CompUnitTypeSearchList compUnitTypes = firstRefType.inverseGetRefs();
			// compUnitTypes durchgehen und vergleichen
			final Iterator<PersistentCompUnitType> cutIterator = compUnitTypes.iterator();
			while (cutIterator.hasNext()) {
				final PersistentCompUnitType cut = cutIterator.next();
				if (cut.getRefs().getLength() == refTypes.getLength() && cut.hasReferences(refTypes).toBoolean()) {
					return cut;
				}
			}
			return null;
		}

	}

	@Override
	public PersistentCompUnit getExistingCU(final ReferenceSearchList refs) throws PersistenceException {
		if (refs.getLength() == 0) {
			return this.getThis().fetchScalar();
		} else {

			final Iterator<PersistentReference> refIterator = refs.iterator();
			final PersistentReference firstRef = refIterator.next();
			final CompUnitSearchList compUnits = firstRef.inverseGetRefs();
			// compUnits durchgehen und vergleichen
			final Iterator<PersistentCompUnit> cutIterator = compUnits.iterator();
			while (cutIterator.hasNext()) {
				final PersistentCompUnit cu = cutIterator.next();
				if (cu.getRefs().getLength() == refs.getLength() && cu.hasReferences(refs).toBoolean()) {
					return cu;
				}
			}
			return null;
		}
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {

	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {

	}

	@Override
	public void setConversion(final PersistentUnit unit, final common.Fraction factor, final common.Fraction constant)
			throws model.ConsistencyException, PersistenceException {
		// Auf DefaultUnit prüfen
		if (((PersistentUnitType) unit.getType()).getDefaultUnit() == null) {
			throw new ConsistencyException(ExceptionConstants.NO_DEFAULT_UNIT_FOR_CONVERSION);
		}

		// Conversion ??ndern, wenn schon vorhanden
		final PersistentConversion conversion = unit.getMyConversion();
		if (conversion != null) {
			conversion.setMyFunction(Function.createFunction(factor, constant));
		}
		// neue Conversion erstellen
		else {
			Conversion.createConversion(unit, Function.createFunction(factor, constant));
		}

		// TODO: Doppelte Functions?
	}

	@Override
	public void setDefaultUnit(final PersistentUnitType type, final PersistentUnit unit) throws PersistenceException {
		final AbsUnitSearchList allUnitsForType = type.inverseGetType();
		if (unit.getMyConversion() == null || unit.getMyConversion().getMyFunction() == null) {
			// Falls die neue Unit keine Conversion kennt, können andere Units das auch nicht mehr.
			for (final PersistentAbsUnit absUnit : allUnitsForType) {
				final PersistentUnit curUnit = (PersistentUnit) absUnit;

				if (curUnit.getMyConversion() != null) {
					// curUnit.getMyConversion().setSource(null);
					// curUnit.getMyConversion().store();
					curUnit.getMyConversion().delete$Me(); // TODO Das löschen aus dem Cache scheint nicht zu
															// funktionieren?!
					// TODO MIT DB JA, sonst nein!
				}
			}
		} else {
			// Alle Units zum type anpassen an die neue DefaultUnit
			final Fraction calcFactor = unit.getMyConversion().getMyFunction().getFactor();
			final Fraction calcConstant = unit.getMyConversion().getMyFunction().getConstant();

			for (final PersistentAbsUnit absUnit : allUnitsForType) {
				final PersistentUnit curUnit = (PersistentUnit) absUnit;

				if (curUnit.getMyConversion() != null && curUnit.getMyConversion().getMyFunction() != null) {
					final PersistentFunction curFunction = curUnit.getMyConversion().getMyFunction();
					try {
						curFunction.setFactor(curFunction.getFactor().div(calcFactor));
						curFunction.setConstant(curFunction.getConstant().sub(calcConstant).div(calcFactor));
					} catch (final Throwable e) {
						e.printStackTrace();
					}
				}

			}
		}

		// DefaultUnit setzen
		type.setDefaultUnit(unit);
		try {
			getThis().setConversion(unit, Fraction.parse("1"), Fraction.Null);
		} catch (final ConsistencyException e) {
			// defaultUnit ist gesetzt, kein Stress!
		}
	}

	// Start of section that contains overridden operations only.

	/* Start of protected part that is not overridden by persistence generator */

	private String getNameForCompoundUnitType(final ReferenceTypeSearchList refTypeList) throws PersistenceException {
		String ret = "";
		final Iterator<PersistentReferenceType> i = refTypeList.iterator();
		while (i.hasNext()) {
			final PersistentReferenceType next = i.next();
			if (ret != "") {
				ret += " * ";
			}
			ret += next.getRef().toString() + "^" + next.getExponent();
		}
		return ret;
	}

	private String getNameForCompoundUnit(final ReferenceSearchList refList) throws PersistenceException {
		String ret = "";
		final Iterator<PersistentReference> i = refList.iterator();
		while (i.hasNext()) {
			final PersistentReference next = i.next();
			if (ret != "") {
				ret += " * ";
			}
			ret += next.getRef().toString() + "^" + next.getExponent();
		}
		return ret;
	}

	/* End of protected part that is not overridden by persistence generator */

}
