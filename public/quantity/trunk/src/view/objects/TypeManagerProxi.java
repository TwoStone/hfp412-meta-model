package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class TypeManagerProxi extends ViewProxi implements TypeManagerView{
    
    public TypeManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public TypeManagerView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> unitTypes_string = (java.util.Vector<String>)resultTable.get("unitTypes");
        java.util.Vector<AbsUnitTypeView> unitTypes = ViewProxi.getProxiVector(unitTypes_string, connectionKey);
        TypeManagerView result$$ = new TypeManager(unitTypes, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getUnitTypes().size()) return new UnitTypesTypeManagerWrapper(this, originalIndex, (ViewRoot)this.getUnitTypes().get(index));
        index = index - this.getUnitTypes().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getUnitTypes().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getUnitTypes().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getUnitTypesIterator = this.getUnitTypes().iterator();
        while(getUnitTypesIterator.hasNext()){
            if(getUnitTypesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<AbsUnitTypeView> getUnitTypes() throws ModelException {
        return ((TypeManager)this.getTheObject()).getUnitTypes();
    }
    public void setUnitTypes(java.util.Vector<AbsUnitTypeView> newValue) throws ModelException {
        ((TypeManager)this.getTheObject()).setUnitTypes(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleTypeManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTypeManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTypeManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTypeManager(this);
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
