
package model;

import persistence.*;


/* Additional import section end */

public class MetaType extends model.AbstractMetaType implements PersistentMetaType{


	public static PersistentMetaType createMetaType(final PersistentMetaAspect myAspect,final String name) throws PersistenceException {
		PersistentMetaType result = ConnectionHandler.getTheConnectionHandler().theMetaTypeFacade
				.newMetaType();
		java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
		final$$Fields.put("myAspect", myAspect);
		final$$Fields.put("name", name);
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentMetaType createMetaType(final PersistentMetaAspect myAspect,final String name,final PersistentMetaType This) throws PersistenceException {
		PersistentMetaType result = ConnectionHandler.getTheConnectionHandler().theMetaTypeFacade
				.newMetaType();
		java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
		final$$Fields.put("myAspect", myAspect);
		final$$Fields.put("name", name);
		result.initialize(This, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	@Override
	public java.util.Hashtable<String,Object> toHashtable(final java.util.Hashtable<String,Object> allResults, final int depth, final int essentialLevel, final boolean forGUI, final boolean leaf, final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String,Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put("subtypes", this.getSubtypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver));
			AbstractPersistentRoot myAspect = this.getMyAspect();
			if (myAspect != null) {
				result.put("myAspect", myAspect.createProxiInformation());
				if(depth > 1) {
					myAspect.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
				}else{
					if(forGUI && myAspect.hasEssentialFields()) {
						myAspect.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
					}
				}
			}
			AbstractPersistentRoot myCONCNamedEntity = this.getMyCONCNamedEntity();
			if (myCONCNamedEntity != null) {
				result.put("myCONCNamedEntity", myCONCNamedEntity.createProxiInformation());
				if(depth > 1) {
					myCONCNamedEntity.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
				}else{
					myCONCNamedEntity.toHashtable(allResults, depth, essentialLevel + 1, forGUI, true, tdObserver);
				}
			}
			String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey)) {
				allResults.put(uniqueKey, result);
			}
		}
		return result;
	}

	@Override
	public MetaType provideCopy() throws PersistenceException{
		MetaType result = this;
		result = new MetaType(this.This,
				this.myAspect,
				this.myCONCNamedEntity,
				this.getId());
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException{
		return true;
	}
	protected MetaType_SubtypesProxi subtypes;
	protected PersistentMetaAspect myAspect;
	protected PersistentNamedEntity myCONCNamedEntity;

	public MetaType(final PersistentAbstractMetaType This,final PersistentMetaAspect myAspect,final PersistentNamedEntity myCONCNamedEntity,final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(This,id);
		this.subtypes = new MetaType_SubtypesProxi(this);
		this.myAspect = myAspect;
		this.myCONCNamedEntity = myCONCNamedEntity;
	}

	static public long getTypeId() {
		return 122;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public MetaType_SubtypesProxi getSubtypes() throws PersistenceException {
		return this.subtypes;
	}
	@Override
	public PersistentMetaAspect getMyAspect() throws PersistenceException {
		return this.myAspect;
	}
	@Override
	public void setMyAspect(final PersistentMetaAspect newValue) throws PersistenceException {
		if (newValue == null) {
			throw new PersistenceException("Null values not allowed!", 0);
		}
		if(newValue.equals(this.myAspect)) {
			return;
		}
		long objectId = newValue.getId();
		long classId = newValue.getClassId();
		this.myAspect = (PersistentMetaAspect)PersistentProxi.createProxi(objectId, classId);
		ConnectionHandler.getTheConnectionHandler().theMetaTypeFacade.myAspectSet(this.getId(), newValue);
	}
	@Override
	public PersistentNamedEntity getMyCONCNamedEntity() throws PersistenceException {
		return this.myCONCNamedEntity;
	}
	@Override
	public void setMyCONCNamedEntity(final PersistentNamedEntity newValue) throws PersistenceException {
		if (newValue == null) {
			throw new PersistenceException("Null values not allowed!", 0);
		}
		if(newValue.equals(this.myCONCNamedEntity)) {
			return;
		}
		long objectId = newValue.getId();
		long classId = newValue.getClassId();
		this.myCONCNamedEntity = (PersistentNamedEntity)PersistentProxi.createProxi(objectId, classId);
		ConnectionHandler.getTheConnectionHandler().theMetaTypeFacade.myCONCNamedEntitySet(this.getId(), newValue);
	}
	@Override
	public PersistentMetaType getThis() throws PersistenceException {
		if(this.This == null){
			PersistentMetaType result = new MetaTypeProxi(this.getId());
			result.getTheObject();
			return result;
		}return (PersistentMetaType)this.This;
	}
	@Override
	public String getName() throws PersistenceException {
		return this.getMyCONCNamedEntity().getName();
	}
	@Override
	public void setName(final String newValue) throws PersistenceException {
		this.getMyCONCNamedEntity().setName(newValue);
	}
	@Override
	public void delete$Me() throws PersistenceException{
		super.delete$Me();
		this.getMyCONCNamedEntity().delete$Me();
	}

	@Override
	public void accept(final model.visitor.AbstractMetaTypeVisitor visitor) throws PersistenceException {
		visitor.handleMetaType(this);
	}
	@Override
	public <R> R accept(final model.visitor.AbstractMetaTypeReturnVisitor<R>  visitor) throws PersistenceException {
		return visitor.handleMetaType(this);
	}
	@Override
	public <E extends model.UserException>  void accept(final model.visitor.AbstractMetaTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMetaType(this);
	}
	@Override
	public <R, E extends model.UserException> R accept(final model.visitor.AbstractMetaTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
		return visitor.handleMetaType(this);
	}
	@Override
	public void accept(final model.visitor.AnythingVisitor visitor) throws PersistenceException {
		visitor.handleMetaType(this);
	}
	@Override
	public <R> R accept(final model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
		return visitor.handleMetaType(this);
	}
	@Override
	public <E extends model.UserException>  void accept(final model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMetaType(this);
	}
	@Override
	public <R, E extends model.UserException> R accept(final model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
		return visitor.handleMetaType(this);
	}
	@Override
	public void accept(final model.visitor.NamedEntityVisitor visitor) throws PersistenceException {
		visitor.handleMetaType(this);
	}
	@Override
	public <R> R accept(final model.visitor.NamedEntityReturnVisitor<R>  visitor) throws PersistenceException {
		return visitor.handleMetaType(this);
	}
	@Override
	public <E extends model.UserException>  void accept(final model.visitor.NamedEntityExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMetaType(this);
	}
	@Override
	public <R, E extends model.UserException> R accept(final model.visitor.NamedEntityReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
		return visitor.handleMetaType(this);
	}
	@Override
	public int getLeafInfo() throws PersistenceException{
		return (int) (0
				+ this.getSubtypes().getLength()
				+ (this.getMyAspect() == null ? 0 : 1));
	}


	@Override
	public MetaTypeSearchList inverseGetSubtypes()
			throws PersistenceException{
		MetaTypeSearchList result = null;
		if (result == null) {
			result = ConnectionHandler.getTheConnectionHandler().theMetaTypeFacade
					.inverseGetSubtypes(this.getId(), this.getClassId());
		}
		return result;
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
		this.setThis((PersistentMetaType)This);
		if(this.equals(This)){
			PersistentCONCNamedEntity myCONCNamedEntity = model.CONCNamedEntity.createCONCNamedEntity("", (PersistentMetaType)This);
			this.setMyCONCNamedEntity(myCONCNamedEntity);
			this.setMyAspect((PersistentMetaAspect)final$$Fields.get("myAspect"));
			this.setName((String)final$$Fields.get("name"));
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
