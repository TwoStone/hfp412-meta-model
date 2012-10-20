package view.objects;

import view.*;
import viewClient.*;

public class AkteurManagerProxi extends ViewProxi implements AkteurManagerView{
    
    public AkteurManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public AkteurManagerView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> akteure_string = (java.util.Vector<String>)resultTable.get("akteure");
        java.util.Vector<AkteurView> akteure = ViewProxi.getProxiVector(akteure_string, connectionKey);
        AkteurManagerView result$$ = new AkteurManager(akteure, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getAkteure().size()) return new AkteureAkteurManagerWrapper(this, originalIndex, (ViewRoot)this.getAkteure().get(index));
        index = index - this.getAkteure().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAkteure().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getAkteure().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getAkteureIterator = this.getAkteure().iterator();
        while(getAkteureIterator.hasNext()){
            if(getAkteureIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<AkteurView> getAkteure() throws ModelException {
        return ((AkteurManager)this.getTheObject()).getAkteure();
    }
    public void setAkteure(java.util.Vector<AkteurView> newValue) throws ModelException {
        ((AkteurManager)this.getTheObject()).setAkteure(newValue);
    }
    
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleAkteurManager(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAkteurManager(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAkteurManager(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAkteurManager(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class AkteurManager
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
