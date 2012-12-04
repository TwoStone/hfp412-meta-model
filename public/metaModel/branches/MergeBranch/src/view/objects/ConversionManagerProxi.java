package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ConversionManagerProxi extends ViewProxi implements ConversionManagerView{
    
    public ConversionManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ConversionManagerView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> conversions_string = (java.util.Vector<String>)resultTable.get("conversions");
        java.util.Vector<ConversionView> conversions = ViewProxi.getProxiVector(conversions_string, connectionKey);
        ConversionManagerView result$$ = new ConversionManager(conversions, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getConversions().size()) return new ConversionsConversionManagerWrapper(this, originalIndex, (ViewRoot)this.getConversions().get(index));
        index = index - this.getConversions().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getConversions().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getConversions().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getConversionsIterator = this.getConversions().iterator();
        while(getConversionsIterator.hasNext()){
            if(getConversionsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<ConversionView> getConversions() throws ModelException {
        return ((ConversionManager)this.getTheObject()).getConversions();
    }
    public void setConversions(java.util.Vector<ConversionView> newValue) throws ModelException {
        ((ConversionManager)this.getTheObject()).setConversions(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleConversionManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleConversionManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleConversionManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleConversionManager(this);
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
