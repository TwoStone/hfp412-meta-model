package model.basic;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MBooleanExceptionVisitor;
import model.visitor.MBooleanReturnExceptionVisitor;
import model.visitor.MBooleanReturnVisitor;
import model.visitor.MBooleanVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MFalseProxi;
import persistence.PersistenceException;
import persistence.PersistentMBoolean;
import persistence.PersistentMFalse;
import persistence.TDObserver;

/* Additional import section end */

public class MFalse extends model.basic.MBoolean implements PersistentMFalse {

	private static PersistentMFalse theMFalse = null;
	public static boolean reset$For$Test = false;
	private static final Object $$lock = new Object();

	public static PersistentMFalse getTheMFalse() throws PersistenceException {
		if (theMFalse == null || reset$For$Test) {
			class Initializer implements Runnable {
				PersistenceException exception = null;

				@Override
				public void run() {
					try {
						MFalseProxi proxi = null;
						synchronized ($$lock) {
							proxi = ConnectionHandler.getTheConnectionHandler().theMFalseFacade.getTheMFalse();
							theMFalse = proxi;
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

				PersistentMFalse getResult() throws PersistenceException {
					if (exception != null)
						throw exception;
					return theMFalse;
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
		return theMFalse;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults,
			final int depth, final int essentialLevel, final boolean forGUI, final boolean leaf,
			final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public MFalse provideCopy() throws PersistenceException {
		MFalse result = this;
		result = new MFalse(this.This, this.getId());
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	public MFalse(final PersistentMBoolean This, final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(This, id);
	}

	static public long getTypeId() {
		return 185;
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
	public PersistentMFalse getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentMFalse result = new MFalseProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentMFalse) this.This;
	}

	@Override
	public void accept(final MBooleanVisitor visitor) throws PersistenceException {
		visitor.handleMFalse(this);
	}

	@Override
	public <R> R accept(final MBooleanReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMFalse(this);
	}

	@Override
	public <E extends UserException> void accept(final MBooleanExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMFalse(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MBooleanReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMFalse(this);
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleMFalse(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMFalse(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMFalse(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMFalse(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		return 0;
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentMFalse) This);
		if (this.equals(This)) {
		}
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	// Start of section that contains overridden operations only.

	@Override
	public PersistentMBoolean invert() throws PersistenceException {
		return MTrue.getTheMTrue();
	}

	@Override
	public boolean toBoolean() throws PersistenceException {
		return false;
	}

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}
