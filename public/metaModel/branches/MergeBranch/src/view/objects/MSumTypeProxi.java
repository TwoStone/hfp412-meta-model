package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class MSumTypeProxi extends MComplexTypeProxi implements MSumTypeView{
    
    public MSumTypeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public MSumTypeView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> containedTypes_string = (java.util.Vector<String>)resultTable.get("containedTypes");
        java.util.Vector<MType> containedTypes = ViewProxi.getProxiVector(containedTypes_string, connectionKey);
        String TypeLinkOperator = (String)resultTable.get("TypeLinkOperator");
        MSumTypeView result$$ = new MSumType(containedTypes,(String)TypeLinkOperator, this.getId(), this.getClassId());
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
    
    
    public void accept(MComplexTypeVisitor visitor) throws ModelException {
        visitor.handleMSumType(this);
    }
    public <R> R accept(MComplexTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMSumType(this);
    }
    public <E extends UserException>  void accept(MComplexTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMSumType(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMSumType(this);
    }
    public void accept(MTypeVisitor visitor) throws ModelException {
        visitor.handleMSumType(this);
    }
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMSumType(this);
    }
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMSumType(this);
    }
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMSumType(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMSumType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMSumType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMSumType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMSumType(this);
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
