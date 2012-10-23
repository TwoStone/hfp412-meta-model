package view.objects;

import view.*;
import viewClient.*;

public class MProductTypeProxi extends MComplexTypeProxi implements MProductTypeView{
    
    public MProductTypeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public MProductTypeView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> containedTypes_string = (java.util.Vector<String>)resultTable.get("containedTypes");
        java.util.Vector<MType> containedTypes = ViewProxi.getProxiVector(containedTypes_string, connectionKey);
        String TypeLinkOperator = (String)resultTable.get("TypeLinkOperator");
        MProductTypeView result$$ = new MProductType(containedTypes,(String)TypeLinkOperator, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getContainedTypes().size()) return new ContainedTypesMComplexTypeWrapper(this, originalIndex, (ViewRoot)this.getContainedTypes().get(index));
        index = index - this.getContainedTypes().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getContainedTypes().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getContainedTypes().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getContainedTypesIterator = this.getContainedTypes().iterator();
        while(getContainedTypesIterator.hasNext()){
            if(getContainedTypesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    
    public void accept(view.visitor.MComplexTypeVisitor visitor) throws ModelException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(view.visitor.MComplexTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMProductType(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.MComplexTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMProductType(this);
    }
    public void accept(view.visitor.MTypeVisitor visitor) throws ModelException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(view.visitor.MTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMProductType(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.MTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.MTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMProductType(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMProductType(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMProductType(this);
    }
    
    public boolean hasTransientFields(){
        return true;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class MProductType
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
