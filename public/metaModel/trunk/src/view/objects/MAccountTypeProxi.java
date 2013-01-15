package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class MAccountTypeProxi extends MQuantiObjectTypeProxi implements MAccountTypeView{
    
    public MAccountTypeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public MAccountTypeView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi type = null;
        String type$String = (String)resultTable.get("type");
        if (type$String != null) {
            common.ProxiInformation type$Info = common.RPCConstantsAndServices.createProxiInformation(type$String);
            type = ViewProxi.createProxi(type$Info,connectionKey);
            type.setToString(type$Info.getToString());
        }
        ViewProxi unitType = null;
        String unitType$String = (String)resultTable.get("unitType");
        if (unitType$String != null) {
            common.ProxiInformation unitType$Info = common.RPCConstantsAndServices.createProxiInformation(unitType$String);
            unitType = ViewProxi.createProxi(unitType$Info,connectionKey);
            unitType.setToString(unitType$Info.getToString());
        }
        java.util.Vector<String> subAccountTypes_string = (java.util.Vector<String>)resultTable.get("subAccountTypes");
        java.util.Vector<MAccountTypeView> subAccountTypes = ViewProxi.getProxiVector(subAccountTypes_string, connectionKey);
        MAccountTypeView result$$ = new MAccountType((MTypeView)type,(AbsUnitTypeView)unitType,subAccountTypes, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getType() != null) return new TypeMQuantiObjectTypeWrapper(this, originalIndex, (ViewRoot)this.getType());
        if(this.getType() != null) index = index - 1;
        if(index == 0 && this.getUnitType() != null) return new UnitTypeMQuantiObjectTypeWrapper(this, originalIndex, (ViewRoot)this.getUnitType());
        if(this.getUnitType() != null) index = index - 1;
        if(index < this.getSubAccountTypes().size()) return new SubAccountTypesMAccountTypeWrapper(this, originalIndex, (ViewRoot)this.getSubAccountTypes().get(index));
        index = index - this.getSubAccountTypes().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getType() == null ? 0 : 1)
            + (this.getUnitType() == null ? 0 : 1)
            + (this.getSubAccountTypes().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getType() == null ? true : false)
            && (this.getUnitType() == null ? true : false)
            && (this.getSubAccountTypes().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getType() != null && this.getType().equals(child)) return result;
        if(this.getType() != null) result = result + 1;
        if(this.getUnitType() != null && this.getUnitType().equals(child)) return result;
        if(this.getUnitType() != null) result = result + 1;
        java.util.Iterator<?> getSubAccountTypesIterator = this.getSubAccountTypes().iterator();
        while(getSubAccountTypesIterator.hasNext()){
            if(getSubAccountTypesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<MAccountTypeView> getSubAccountTypes() throws ModelException {
        return ((MAccountType)this.getTheObject()).getSubAccountTypes();
    }
    public void setSubAccountTypes(java.util.Vector<MAccountTypeView> newValue) throws ModelException {
        ((MAccountType)this.getTheObject()).setSubAccountTypes(newValue);
    }
    
    public void accept(MQuantiObjectTypeVisitor visitor) throws ModelException {
        visitor.handleMAccountType(this);
    }
    public <R> R accept(MQuantiObjectTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMAccountType(this);
    }
    public <E extends UserException>  void accept(MQuantiObjectTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMAccountType(this);
    }
    public <R, E extends UserException> R accept(MQuantiObjectTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMAccountType(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMAccountType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMAccountType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMAccountType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMAccountType(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
