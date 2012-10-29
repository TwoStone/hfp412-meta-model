package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class MAspectProxi extends ViewProxi implements MAspectView{
    
    public MAspectProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public MAspectView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        java.util.Vector<String> types_string = (java.util.Vector<String>)resultTable.get("types");
        java.util.Vector<MAtomicTypeView> types = ViewProxi.getProxiVector(types_string, connectionKey);
        MAspectView result$$ = new MAspect((String)name,types, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getTypes().size()) return new TypesMAspectWrapper(this, originalIndex, (ViewRoot)this.getTypes().get(index));
        index = index - this.getTypes().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getTypes().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getTypes().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getTypesIterator = this.getTypes().iterator();
        while(getTypesIterator.hasNext()){
            if(getTypesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public String getName() throws ModelException {
        return ((MAspect)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((MAspect)this.getTheObject()).setName(newValue);
    }
    public java.util.Vector<MAtomicTypeView> getTypes() throws ModelException {
        return ((MAspect)this.getTheObject()).getTypes();
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMAspect(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMAspect(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMAspect(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMAspect(this);
    }
    
    public boolean hasTransientFields(){
        return true;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
