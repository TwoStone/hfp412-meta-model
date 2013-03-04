package model.quantity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.ConsistencyException;
import model.DoubleDefinitionException;
import model.UserException;
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
import persistence.CompUnitTypeSearchList;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentAddReferenceCommand;
import persistence.PersistentAddReferenceTypeCommand;
import persistence.PersistentCompUnit;
import persistence.PersistentCompUnitType;
import persistence.PersistentConversion;
import persistence.PersistentCreateUnitCommand;
import persistence.PersistentCreateUnitTypeCommand;
import persistence.PersistentFetchScalarCommand;
import persistence.PersistentFetchScalarTypeCommand;
import persistence.PersistentGetExistingCUTCommand;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentReferenceType;
import persistence.PersistentRemoveUnitCommand;
import persistence.PersistentRemoveUnitTypeCommand;
import persistence.PersistentSetConversionCommand;
import persistence.PersistentSetDefaultUnitCommand;
import persistence.PersistentUnit;
import persistence.PersistentUnitType;
import persistence.PersistentUnitTypeManager;
import persistence.Predcate;
import persistence.Procdure;
import persistence.ReferenceTypeSearchList;
import persistence.TDObserver;
import persistence.UnitTypeManagerProxi;
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
							proxi = ConnectionHandler.getTheConnectionHandler().theUnitTypeManagerFacade
									.getTheUnitTypeManager();
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
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults,
			final int depth, final int essentialLevel, final boolean forGUI, final boolean leaf,
			final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put(
					"unitTypes",
					this.getUnitTypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false,
							essentialLevel == 0));
			result.put(
					"atomicUnitTypes",
					this.getAtomicUnitTypes(tdObserver).getVector(allResults, (depth > 1 ? depth : depth + 1),
							essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
			result.put(
					"units",
					this.getUnits().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false,
							essentialLevel == 0));
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
		result.units = this.units.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected UnitTypeManager_UnitTypesProxi unitTypes;
	protected UnitTypeManager_UnitsProxi units;
	protected PersistentUnitTypeManager This;

	public UnitTypeManager(final PersistentUnitTypeManager This, final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		this.unitTypes = new UnitTypeManager_UnitTypesProxi(this);
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
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleUnitTypeManager(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
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
	public void addReferenceType(final String name, final PersistentAbsUnitType unitType,
			final PersistentUnitType referenceUnitType, final long exponent, final Invoker invoker)
			throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentAddReferenceTypeCommand command = model.meta.AddReferenceTypeCommand
				.createAddReferenceTypeCommand(name, exponent, now, now);
		command.setUnitType(unitType);
		command.setReferenceUnitType(referenceUnitType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public void addReference(final String name, final PersistentAbsUnit unit, final PersistentUnit referenceUnit,
			final long exponent, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentAddReferenceCommand command = model.meta.AddReferenceCommand.createAddReferenceCommand(name,
				exponent, now, now);
		command.setUnit(unit);
		command.setReferenceUnit(referenceUnit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void createUnitType(final String name, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentCreateUnitTypeCommand command = model.meta.CreateUnitTypeCommand.createCreateUnitTypeCommand(
				name, now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void createUnit(final String name, final PersistentUnitType type, final Invoker invoker)
			throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentCreateUnitCommand command = model.meta.CreateUnitCommand
				.createCreateUnitCommand(name, now, now);
		command.setType(type);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void fetchScalarType(final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentFetchScalarTypeCommand command = model.meta.FetchScalarTypeCommand
				.createFetchScalarTypeCommand(now, now);
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
	public void getExistingCUT(final ReferenceTypeSearchList refTypes, final Invoker invoker)
			throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentGetExistingCUTCommand command = model.meta.GetExistingCUTCommand.createGetExistingCUTCommand(
				now, now);
		final java.util.Iterator<PersistentReferenceType> refTypesIterator = refTypes.iterator();
		while (refTypesIterator.hasNext()) {
			command.getRefTypes().add(refTypesIterator.next());
		}
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentUnitTypeManager) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public void removeUnitType(final PersistentAbsUnitType type, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentRemoveUnitTypeCommand command = model.meta.RemoveUnitTypeCommand.createRemoveUnitTypeCommand(
				now, now);
		command.setType(type);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void removeUnit(final PersistentAbsUnit unit, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentRemoveUnitCommand command = model.meta.RemoveUnitCommand.createRemoveUnitCommand(now, now);
		command.setUnit(unit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void setConversion(final PersistentUnit unit, final common.Fraction factor, final common.Fraction constant,
			final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentSetConversionCommand command = model.meta.SetConversionCommand.createSetConversionCommand(
				factor, constant, now, now);
		command.setUnit(unit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void setDefaultUnit(final PersistentUnitType type, final PersistentUnit unit, final Invoker invoker)
			throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentSetDefaultUnitCommand command = model.meta.SetDefaultUnitCommand.createSetDefaultUnitCommand(
				now, now);
		command.setType(type);
		command.setUnit(unit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public PersistentCompUnitType addReferenceType(final String name, final PersistentAbsUnitType unitType,
			final PersistentUnitType referenceUnitType, final long exponent) throws model.DoubleDefinitionException,
			PersistenceException {

		// Name schon vorhanden?
		final AbsUnitTypeSearchList old = AbsUnitType.getAbsUnitTypeByName(name);
		if (old.iterator().hasNext()) {
			throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_UNIT_TYPE_DEFINITION);
		}

		// CompUnitType erstellen mit Unterscheidung ob auf UnitType oder CompUnitType
		getThis()
				.getUnitTypes()
				.add(unitType
						.accept(new AbsUnitTypeReturnExceptionVisitor<PersistentCompUnitType, DoubleDefinitionException>() {

							@Override
							public PersistentCompUnitType handleCompUnitType(final PersistentCompUnitType compUnitType)
									throws PersistenceException, DoubleDefinitionException {

								// Schon eine Referenz auf referenceUnitType vorhanden?
								PersistentReferenceType reference = compUnitType.getRefs().findFirst(
										new Predcate<PersistentReferenceType>() {

											@Override
											public boolean test(final PersistentReferenceType argument)
													throws PersistenceException {
												if (argument.getRef().equals(unitType)) {
													return true;
												}
												return false;
											}
										});

								// Wenn ja, exponent erhöhen
								if (reference != null) {
									reference.setExponent(reference.getExponent() + exponent);
								}
								// Wenn nein, neue Referenz erstellen
								else {
									reference = ReferenceType.createReferenceType(exponent, referenceUnitType);
								}

								// Liste der Referenzen aus CompUnitType ohne referenceUnitType
								final List<PersistentReferenceType> references = new ArrayList<PersistentReferenceType>();
								final Iterator<PersistentReferenceType> iterator = compUnitType.getRefs().iterator();
								while (iterator.hasNext()) {
									references.add(iterator.next());
								}

								// Prüfen ob CompUnitType schon vorhanden

								final PersistentCompUnitType result = CompUnitType.createCompUnitType(name);
								result.getRefs().add(reference);
								return result;
							}

							@Override
							public PersistentCompUnitType handleUnitType(final PersistentUnitType unitType)
									throws PersistenceException, DoubleDefinitionException {
								PersistentCompUnitType result = null;

								// referenceUnitType und unitType gleich?
								if (referenceUnitType.equals(unitType)) {
									final PersistentReferenceType referenceType = ReferenceType.createReferenceType(
											exponent + 1, unitType);

									// CompUnitType mit den Referenzen schon vorhanden?
									final PersistentCompUnitType type = getCompUnitTypeWithReferenceTypes(referenceType);
									if (type != null) {
										throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_COMP_UNIT_TYPE
												+ referenceType);
									}

									result = CompUnitType.createCompUnitType(name);
									result.getRefs().add(referenceType);

								} else {
									final PersistentReferenceType referenceType = ReferenceType.createReferenceType(
											exponent, referenceUnitType);
									final PersistentReferenceType referenceType2 = ReferenceType.createReferenceType(1,
											unitType);

									// CompUnitType mit den Referenzen schon vorhanden?
									final PersistentCompUnitType type = getCompUnitTypeWithReferenceTypes(
											referenceType, referenceType2);
									if (type != null) {
										throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_COMP_UNIT_TYPE
												+ referenceType + ", " + referenceType2);
									}

									result = CompUnitType.createCompUnitType(name);
									result.getRefs().add(referenceType);
									result.getRefs().add(referenceType2);
								}

								return result;
							}
						}));
		// TODO: return
		return null;

	}

	@Override
	public PersistentCompUnit addReference(final String name, final PersistentAbsUnit unit,
			final PersistentUnit referenceUnit, final long exponent) throws model.DoubleDefinitionException,
			PersistenceException {
		return null;
		// TODO: implement method: addReference

	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {

	}

	@Override
	public void createUnitType(final String name) throws model.DoubleDefinitionException, PersistenceException {
		final AbsUnitTypeSearchList old = AbsUnitType.getAbsUnitTypeByName(name);

		if (old.iterator().hasNext()) {
			throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_UNIT_TYPE_DEFINITION);
		}

		this.getThis().getUnitTypes().add(UnitType.createUnitType(name));

	}

	@Override
	public PersistentUnit createUnit(final String name, final PersistentUnitType type)
			throws model.DoubleDefinitionException, PersistenceException {
		final AbsUnitSearchList old = Unit.getAbsUnitByName(name);
		if (old.iterator().hasNext()) {
			throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_UNIT_DEFINITION + name);
		}
		final PersistentUnit result = Unit.createUnit(type, name);
		getThis().getUnits().add(result);
		return result;

	}

	@Override
	public PersistentCompUnitType fetchScalarType() throws PersistenceException {
		PersistentCompUnitType type = getCompUnitTypeWithReferenceTypes(new PersistentReferenceType[] {});
		if (type == null) {
			type = CompUnitType.createCompUnitType("ScalarType");
			getThis().getUnitTypes().add(type);
		}
		return type;
	}

	@Override
	public PersistentCompUnit fetchScalar() throws PersistenceException {
		// TODO: implement method: fetchScalar
		try {
			throw new java.lang.UnsupportedOperationException("Method \"fetchScalar\" not implemented yet.");
		} catch (final java.lang.UnsupportedOperationException uoe) {
			uoe.printStackTrace();
			throw uoe;
		}
	}

	@Override
	public PersistentAbsUnit fetchUnitByUnitType(final PersistentAbsUnitType ut) throws model.NotFoundException,
			PersistenceException {
		return ut.accept(new AbsUnitTypeReturnVisitor<PersistentAbsUnit>() {

			@Override
			public PersistentAbsUnit handleCompUnitType(final PersistentCompUnitType compUnitType)
					throws PersistenceException {
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
					public void handleCompUnitType(final PersistentCompUnitType compUnitType)
							throws PersistenceException {
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
			// TODO: ScalarType zurückgeben
		}
		final Iterator<PersistentReferenceType> refTypeIterator = refTypes.iterator();
		final PersistentReferenceType firstRefType = refTypeIterator.next();
		final CompUnitTypeSearchList compUnitTypes = firstRefType.inverseGetRefs();
		// TODO compUnitTypes durchgehen und vergleichen
		return null;
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {

	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {

	}

	@Override
	public void removeUnitType(final PersistentAbsUnitType type) throws PersistenceException {
		// TODO: implement method: removeUnitType; schon vorhandene Units zu diesem Typ mit löschen!

	}

	@Override
	public void removeUnit(final PersistentAbsUnit unit) throws PersistenceException {
		// TODO: implement method: removeUnit

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
		// TODO: Conversions ander Units ändern

		// neue DefaultUnit setzen
		type.setDefaultUnit(unit);
		// Conversion für neue Default Unit auf 1 setzen
		try {
			this.getThis().setConversion(unit, Fraction.parse("1"), Fraction.Null);
		} catch (final ConsistencyException e) {
			// Kann nicht passieren, da DefaultUnit zuvor gesetzt wurde
		}
	}

	// Start of section that contains overridden operations only.

	/* Start of protected part that is not overridden by persistence generator */

	/**
	 * Testet ob ein CompoundUnitType mit den übergebenen ReferenceTypes schon vorhanden ist.
	 * 
	 * @param referenceTypes
	 * @return
	 * @throws PersistenceException
	 */
	protected PersistentCompUnitType getCompUnitTypeWithReferenceTypes(final PersistentReferenceType... referenceTypes)
			throws PersistenceException {
		final PersistentReferenceType reference = referenceTypes[0];
		reference.getRef();
		return null;
	}

	/* End of protected part that is not overridden by persistence generator */

}
