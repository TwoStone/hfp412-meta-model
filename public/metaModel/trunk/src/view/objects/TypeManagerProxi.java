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
        java.util.Vector<String> atomicTypes_string = (java.util.Vector<String>)resultTable.get("atomicTypes");
        java.util.Vector<MAtomicTypeView> atomicTypes = ViewProxi.getProxiVector(atomicTypes_string, connectionKey);
        java.util.Vector<String> productTypes_string = (java.util.Vector<String>)resultTable.get("productTypes");
        java.util.Vector<MProductTypeView> productTypes = ViewProxi.getProxiVector(productTypes_string, connectionKey);
        java.util.Vector<String> sumTypes_string = (java.util.Vector<String>)resultTable.get("sumTypes");
        java.util.Vector<MSumTypeView> sumTypes = ViewProxi.getProxiVector(sumTypes_string, connectionKey);
        java.util.Vector<String> allTypes_string = (java.util.Vector<String>)resultTable.get("allTypes");
        java.util.Vector<MType> allTypes = ViewProxi.getProxiVector(allTypes_string, connectionKey);
        TypeManagerView result$$ = new TypeManager(atomicTypes,productTypes,sumTypes,allTypes, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getAtomicTypes().size()) return new AtomicTypesTypeManagerWrapper(this, originalIndex, (ViewRoot)this.getAtomicTypes().get(index));
        index = index - this.getAtomicTypes().size();
        if(index < this.getProductTypes().size()) return new ProductTypesTypeManagerWrapper(this, originalIndex, (ViewRoot)this.getProductTypes().get(index));
        index = index - this.getProductTypes().size();
        if(index < this.getSumTypes().size()) return new SumTypesTypeManagerWrapper(this, originalIndex, (ViewRoot)this.getSumTypes().get(index));
        index = index - this.getSumTypes().size();
        if(index < this.getAllTypes().size()) return new AllTypesTypeManagerWrapper(this, originalIndex, (ViewRoot)this.getAllTypes().get(index));
        index = index - this.getAllTypes().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAtomicTypes().size())
            + (this.getProductTypes().size())
            + (this.getSumTypes().size())
            + (this.getAllTypes().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getAtomicTypes().size() == 0)
            && (this.getProductTypes().size() == 0)
            && (this.getSumTypes().size() == 0)
            && (this.getAllTypes().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getAtomicTypesIterator = this.getAtomicTypes().iterator();
        while(getAtomicTypesIterator.hasNext()){
            if(getAtomicTypesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getProductTypesIterator = this.getProductTypes().iterator();
        while(getProductTypesIterator.hasNext()){
            if(getProductTypesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getSumTypesIterator = this.getSumTypes().iterator();
        while(getSumTypesIterator.hasNext()){
            if(getSumTypesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getAllTypesIterator = this.getAllTypes().iterator();
        while(getAllTypesIterator.hasNext()){
            if(getAllTypesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<MAtomicTypeView> getAtomicTypes() throws ModelException {
        return ((TypeManager)this.getTheObject()).getAtomicTypes();
    }
    public void setAtomicTypes(java.util.Vector<MAtomicTypeView> newValue) throws ModelException {
        ((TypeManager)this.getTheObject()).setAtomicTypes(newValue);
    }
    public java.util.Vector<MProductTypeView> getProductTypes() throws ModelException {
        return ((TypeManager)this.getTheObject()).getProductTypes();
    }
    public void setProductTypes(java.util.Vector<MProductTypeView> newValue) throws ModelException {
        ((TypeManager)this.getTheObject()).setProductTypes(newValue);
    }
    public java.util.Vector<MSumTypeView> getSumTypes() throws ModelException {
        return ((TypeManager)this.getTheObject()).getSumTypes();
    }
    public void setSumTypes(java.util.Vector<MSumTypeView> newValue) throws ModelException {
        ((TypeManager)this.getTheObject()).setSumTypes(newValue);
    }
    public java.util.Vector<MType> getAllTypes() throws ModelException {
        return ((TypeManager)this.getTheObject()).getAllTypes();
    }
    public void setAllTypes(java.util.Vector<MType> newValue) throws ModelException {
        ((TypeManager)this.getTheObject()).setAllTypes(newValue);
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
