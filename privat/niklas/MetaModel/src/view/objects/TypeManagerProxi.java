package view.objects;

import view.*;
import viewClient.*;

public class TypeManagerProxi extends ViewProxi implements TypeManagerView{
    
    public TypeManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public TypeManagerView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> allTypes_string = (java.util.Vector<String>)resultTable.get("allTypes");
        java.util.Vector<AbstractMetaTypeView> allTypes = ViewProxi.getProxiVector(allTypes_string, connectionKey);
        TypeManagerView result$$ = new TypeManager(allTypes, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getAllTypes().size()) return new AllTypesTypeManagerWrapper(this, originalIndex, (ViewRoot)this.getAllTypes().get(index));
        index = index - this.getAllTypes().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAllTypes().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getAllTypes().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getAllTypesIterator = this.getAllTypes().iterator();
        while(getAllTypesIterator.hasNext()){
            if(getAllTypesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<AbstractMetaTypeView> getAllTypes() throws ModelException {
        return ((TypeManager)this.getTheObject()).getAllTypes();
    }
    public void setAllTypes(java.util.Vector<AbstractMetaTypeView> newValue) throws ModelException {
        ((TypeManager)this.getTheObject()).setAllTypes(newValue);
    }
    
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleTypeManager(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTypeManager(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTypeManager(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTypeManager(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class TypeManager
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
