
package model;

import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.OrMetaTypeProxi;
import persistence.PersistenceException;
import persistence.PersistentAbstractMetaType;
import persistence.PersistentOrMetaType;
import persistence.TDObserver;


/* Additional import section end */

public class OrMetaType extends model.ComposedMetaType implements PersistentOrMetaType{


	public static PersistentOrMetaType createOrMetaType() throws PersistenceException {
		PersistentOrMetaType result = ConnectionHandler.getTheConnectionHandler().theOrMetaTypeFacade
				.newOrMetaType();
		java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentOrMetaType createOrMetaType(final PersistentOrMetaType This) throws PersistenceException {
		PersistentOrMetaType result = ConnectionHandler.getTheConnectionHandler().theOrMetaTypeFacade
				.newOrMetaType();
		java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
		result.initialize(This, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	@Override
	public java.util.Hashtable<String,Object> toHashtable(final java.util.Hashtable<String,Object> allResults, final int depth, final int essentialLevel, final boolean forGUI, final boolean leaf, final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String,Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey)) {
				allResults.put(uniqueKey, result);
			}
		}
		return result;
	}

	@Override
	public OrMetaType provideCopy() throws PersistenceException{
		OrMetaType result = this;
		result = new OrMetaType(this.This,
				this.getId());
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException{
		return false;
	}

	public OrMetaType(final PersistentAbstractMetaType This,final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(This,id);
	}

	static public long getTypeId() {
		return 117;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public PersistentOrMetaType getThis() throws PersistenceException {
		if(this.This == null){
			PersistentOrMetaType result = new OrMetaTypeProxi(this.getId());
			result.getTheObject();
			return result;
		}return (PersistentOrMetaType)this.This;
	}

	@Override
	public void accept(final model.visitor.ComposedMetaTypeVisitor visitor) throws PersistenceException {
		visitor.handleOrMetaType(this);
	}
	@Override
	public <R> R accept(final model.visitor.ComposedMetaTypeReturnVisitor<R>  visitor) throws PersistenceException {
		return visitor.handleOrMetaType(this);
	}
	@Override
	public <E extends model.UserException>  void accept(final model.visitor.ComposedMetaTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleOrMetaType(this);
	}
	@Override
	public <R, E extends model.UserException> R accept(final model.visitor.ComposedMetaTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
		return visitor.handleOrMetaType(this);
	}
	@Override
	public void accept(final model.visitor.AbstractMetaTypeVisitor visitor) throws PersistenceException {
		visitor.handleOrMetaType(this);
	}
	@Override
	public <R> R accept(final model.visitor.AbstractMetaTypeReturnVisitor<R>  visitor) throws PersistenceException {
		return visitor.handleOrMetaType(this);
	}
	@Override
	public <E extends model.UserException>  void accept(final model.visitor.AbstractMetaTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleOrMetaType(this);
	}
	@Override
	public <R, E extends model.UserException> R accept(final model.visitor.AbstractMetaTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
		return visitor.handleOrMetaType(this);
	}
	@Override
	public void accept(final model.visitor.AnythingVisitor visitor) throws PersistenceException {
		visitor.handleOrMetaType(this);
	}
	@Override
	public <R> R accept(final model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
		return visitor.handleOrMetaType(this);
	}
	@Override
	public <E extends model.UserException>  void accept(final model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleOrMetaType(this);
	}
	@Override
	public <R, E extends model.UserException> R accept(final model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
		return visitor.handleOrMetaType(this);
	}
	@Override
	public int getLeafInfo() throws PersistenceException{
		return (int) (0
				+ this.getComponents().getLength());
	}


	@Override
	public void initializeOnInstantiation()
			throws PersistenceException{
		//TODO: implement method: initializeOnInstantiation

	}
	@Override
	public void copyingPrivateUserAttributes(final Anything copy)
			throws PersistenceException{
		//TODO: implement method: copyingPrivateUserAttributes

	}
	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields)
			throws PersistenceException{
		this.setThis((PersistentOrMetaType)This);
		if(this.equals(This)){
		}
	}
	@Override
	public void initializeOnCreation()
			throws PersistenceException{
		//TODO: implement method: initializeOnCreation

	}

	@Override
	public Boolean specializes(final PersistentAbstractMetaType metaType)
			throws PersistenceException {
		// TODO implement specializes!!!
		return Boolean.FALSE;
	}

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}
