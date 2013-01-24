
package model.measurement;

import persistence.*;
import model.UserException;
import model.visitor.*;


/* Additional import section end */

public class Measurement extends model.measurement.QuantifObject implements PersistentMeasurement{
    
    
    public static PersistentMeasurement createMeasurement(PersistentInstanceObject object,PersistentMMeasurementType type,PersistentAbsQuantity quantity) throws PersistenceException{
        return createMeasurement(object,type,quantity,false);
    }
    
    public static PersistentMeasurement createMeasurement(PersistentInstanceObject object,PersistentMMeasurementType type,PersistentAbsQuantity quantity,boolean delayed$Persistence) throws PersistenceException {
        PersistentMeasurement result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMeasurementFacade
                .newDelayedMeasurement();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMeasurementFacade
                .newMeasurement(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("object", object);
        final$$Fields.put("type", type);
        final$$Fields.put("quantity", quantity);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMeasurement createMeasurement(PersistentInstanceObject object,PersistentMMeasurementType type,PersistentAbsQuantity quantity,boolean delayed$Persistence,PersistentMeasurement This) throws PersistenceException {
        PersistentMeasurement result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMeasurementFacade
                .newDelayedMeasurement();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMeasurementFacade
                .newMeasurement(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("object", object);
        final$$Fields.put("type", type);
        final$$Fields.put("quantity", quantity);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot type = (AbstractPersistentRoot)this.getType();
            if (type != null) {
                result.put("type", type.createProxiInformation(false));
                if(depth > 1) {
                    type.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && type.hasEssentialFields())type.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot quantity = (AbstractPersistentRoot)this.getQuantity();
            if (quantity != null) {
                result.put("quantity", quantity.createProxiInformation(false));
                if(depth > 1) {
                    quantity.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && quantity.hasEssentialFields())quantity.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Measurement provideCopy() throws PersistenceException{
        Measurement result = this;
        result = new Measurement(this.object, 
                                 this.This, 
                                 this.type, 
                                 this.quantity, 
                                 this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentMMeasurementType type;
    protected PersistentAbsQuantity quantity;
    
    public Measurement(PersistentInstanceObject object,PersistentQuantifObject This,PersistentMMeasurementType type,PersistentAbsQuantity quantity,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentInstanceObject)object,(PersistentQuantifObject)This,id);
        this.type = type;
        this.quantity = quantity;        
    }
    
    static public long getTypeId() {
        return 115;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 115) ConnectionHandler.getTheConnectionHandler().theMeasurementFacade
            .newMeasurement(this.getId());
        super.store();
        if(this.getType() != null){
            this.getType().store();
            ConnectionHandler.getTheConnectionHandler().theMeasurementFacade.typeSet(this.getId(), getType());
        }
        if(this.getQuantity() != null){
            this.getQuantity().store();
            ConnectionHandler.getTheConnectionHandler().theMeasurementFacade.quantitySet(this.getId(), getQuantity());
        }
        
    }
    
    public PersistentMMeasurementType getType() throws PersistenceException {
        return this.type;
    }
    public void setType(PersistentMMeasurementType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.type)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.type = (PersistentMMeasurementType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMeasurementFacade.typeSet(this.getId(), newValue);
        }
    }
    public PersistentAbsQuantity getQuantity() throws PersistenceException {
        return this.quantity;
    }
    public void setQuantity(PersistentAbsQuantity newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.quantity)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.quantity = (PersistentAbsQuantity)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMeasurementFacade.quantitySet(this.getId(), newValue);
        }
    }
    public PersistentMeasurement getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMeasurement result = new MeasurementProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMeasurement)this.This;
    }
    
    public void accept(QuantifObjectVisitor visitor) throws PersistenceException {
        visitor.handleMeasurement(this);
    }
    public <R> R accept(QuantifObjectReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMeasurement(this);
    }
    public <E extends UserException>  void accept(QuantifObjectExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMeasurement(this);
    }
    public <R, E extends UserException> R accept(QuantifObjectReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMeasurement(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMeasurement(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMeasurement(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMeasurement(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMeasurement(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getObject() == null ? 0 : 1)
            + (this.getType() == null ? 0 : 1)
            + (this.getQuantity() == null ? 0 : 1));
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMeasurement)This);
		if(this.equals(This)){
			this.setObject((PersistentInstanceObject)final$$Fields.get("object"));
			this.setType((PersistentMMeasurementType)final$$Fields.get("type"));
			this.setQuantity((PersistentAbsQuantity)final$$Fields.get("quantity"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
