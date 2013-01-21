package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ObjectManagerProxi extends ViewProxi implements ObjectManagerView{
    
    public ObjectManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ObjectManagerView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> objects_string = (java.util.Vector<String>)resultTable.get("objects");
        java.util.Vector<MObjectView> objects = ViewProxi.getProxiVector(objects_string, connectionKey);
        ObjectManagerView result$$ = new ObjectManager(objects, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getObjects().size()) return new ObjectsObjectManagerWrapper(this, originalIndex, (ViewRoot)this.getObjects().get(index));
        index = index - this.getObjects().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getObjects().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getObjects().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getObjectsIterator = this.getObjects().iterator();
        while(getObjectsIterator.hasNext()){
            if(getObjectsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<MObjectView> getObjects() throws ModelException {
        return ((ObjectManager)this.getTheObject()).getObjects();
    }
    public void setObjects(java.util.Vector<MObjectView> newValue) throws ModelException {
        ((ObjectManager)this.getTheObject()).setObjects(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleObjectManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleObjectManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleObjectManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleObjectManager(this);
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
